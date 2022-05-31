package com.example.tinkoff_hr.actionbar

import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.ContentActivity
import com.example.tinkoff_hr.data.UserCacheManager
import com.example.tinkoff_hr.data.UserTokenStorage
import com.example.tinkoff_hr.databinding.ActivityProfileSettingsBinding
import com.example.tinkoff_hr.databinding.ProfileDialogBinding
import com.example.tinkoff_hr.domain.entities.worker.UpdatedWorkerInfo
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.entities.worker.WorkerStatus
import com.example.tinkoff_hr.presentation.ProfilePresenter
import com.example.tinkoff_hr.ui.authentication.CodeActivity
import com.example.tinkoff_hr.views.ProfileView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class ProfileSettingsActivity : MvpAppCompatActivity(), ProfileView {

    @Inject
    lateinit var presenterProvider: Provider<ProfilePresenter>

    private val profilePresenter by moxyPresenter { presenterProvider.get() }

    private lateinit var tokenStorage: UserTokenStorage
    private val binding: ActivityProfileSettingsBinding by lazy {
        ActivityProfileSettingsBinding.inflate(layoutInflater)
    }

    private var selectedId = 0
    private val isRegistered: Boolean by lazy {
        intent.getBooleanExtra(
            EXTRA_FLAG_REGISTERED,
            true
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Профиль"

        binding.fieldDialog.setOnClickListener {
            createDialog()
        }
        binding.textMail.setEndIconOnClickListener {
            val clipboard: ClipboardManager =
                this.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copied Text", binding.fieldMail.text.toString())
            clipboard.setPrimaryClip(clip)
        }

        tokenStorage = UserTokenStorage(applicationContext)

        // Кнопка сохранения данных пользователя
        val buttonSave = binding.buttonSave
        buttonSave.setOnClickListener {
            profilePresenter.onSaveWorkerClicked(
                UserCacheManager.getUserId(),
                getUpdateWorkerInfo()
            )
        }

        // Кнопка регистрации пользователя
        val buttonRegister = binding.buttonRegister
        buttonRegister.setOnClickListener {
            profilePresenter.onUserRegisterClicked(
                tokenStorage.getUserToken(),
                getUpdateWorkerInfo()
            )
        }

        profilePresenter.onAppearing(tokenStorage.getUserToken())

        if (!isRegistered) {
            buttonSave.visibility = View.INVISIBLE
            buttonRegister.visibility = View.VISIBLE
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> this.finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun getUpdateWorkerInfo(): UpdatedWorkerInfo {
        with(binding) {
            return UpdatedWorkerInfo(
                fieldAbout.text.toString(),
                fieldFunction.text.toString(),
                fieldProject.text.toString()
            )
        }
    }

    private fun createDialog() {

        val dialogBinding = ProfileDialogBinding.inflate(
            layoutInflater, binding.root, false
        )

        dialogBinding.apply {

            val dialog = AlertDialog.Builder(this@ProfileSettingsActivity).setTitle("Ачивки")
                .setNegativeButton("Cancel") { d, _ ->
                    d.dismiss()
                }
                .setView(dialogLayout)
                .create()

            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                radioGroup.findViewById<RadioButton>(checkedId)?.apply {
                    selectedId = checkedId
                    binding.fieldDialog.setText(this.text)

                }
            }

            if (selectedId != 0)
                radioGroup.check(selectedId)

            dialog.show()
        }
    }

    override fun showWorkerInfo(worker: Worker) {
        with(binding) {
            fieldFullName.setText("${worker.surname} ${worker.name} ${worker.patronymic ?: ""}")
            fieldMail.setText(worker.email)
            fieldAbout.setText(worker.about)
            fieldFunction.setText(worker.function)
            fieldProject.setText(worker.project)
        }
    }

    override fun openContentActivity() {
        startActivity(Intent(this, ContentActivity::class.java))
        finish()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {

        private const val EXTRA_FLAG_REGISTERED = "extra_flag_registered"

        fun createIntent(context: Context, isRegistered: Boolean): Intent {
            return Intent(context, ProfileSettingsActivity::class.java).apply {
                putExtra(EXTRA_FLAG_REGISTERED, isRegistered)
            }
        }
    }
}