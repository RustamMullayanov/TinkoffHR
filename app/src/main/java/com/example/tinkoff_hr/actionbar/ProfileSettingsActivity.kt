package com.example.tinkoff_hr.actionbar

import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.Toast
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.databinding.ActivityProfileSettingsBinding
import com.example.tinkoff_hr.databinding.ProfileDialogBinding
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.entities.worker.WorkerStatus
import com.example.tinkoff_hr.presentation.ProfilePresenter
import com.example.tinkoff_hr.views.ProfileView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider


class ProfileSettingsActivity : MvpAppCompatActivity(), ProfileView{

    @Inject
    lateinit var presenterProvider: Provider<ProfilePresenter>

    private val profilePresenter by moxyPresenter { presenterProvider.get() }


    private val binding: ActivityProfileSettingsBinding by lazy {
        ActivityProfileSettingsBinding.inflate(layoutInflater)
    }

    private var selectedId = 0

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

        // Сохранение данных пользователя
        val buttonSave = binding.buttonSave
        buttonSave.setOnClickListener {
            val fullName = binding.fieldFullName.text.toString().split(" ")
            val worker = Worker(
                1,
                binding.fieldMail.text.toString(),
                fullName[1],
                fullName[0],
                fullName[2],
                "", // хардкод
                binding.fieldProject.text.toString().toInt(),
                1,
                binding.fieldFunction.text.toString(),
                binding.fieldAbout.text.toString(),
                WorkerStatus.ACTIVE
            )
            profilePresenter.onSaveWorkerClicked(worker)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> this.finish()
        }

        return super.onOptionsItemSelected(item)
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
            fieldProject.setText(worker.project.toString())
        }
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}