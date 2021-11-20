package com.example.tinkoff_hr.actionbar

import android.app.AlertDialog
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.tinkoff_hr.databinding.ActivityProfileSettingsBinding
import com.example.tinkoff_hr.databinding.ProfileDialogBinding

import android.content.ClipData
import android.content.Intent
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.presentation.ProfilePresenter
import com.example.tinkoff_hr.views.ProfileView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class ProfileSettingsActivity : MvpAppCompatActivity(), ProfileView{

    @InjectPresenter
    lateinit var profilePresenter: ProfilePresenter

    @ProvidePresenter
    fun provideProfilePresenter() : ProfilePresenter{
        //хардкодный email
        return ProfilePresenter("test2@tin.koff")
    }

    private val binding: ActivityProfileSettingsBinding by lazy {
        ActivityProfileSettingsBinding.inflate(layoutInflater)
    }

    private var selectedId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
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
                binding.fieldMail.text.toString(),
                fullName[1],
                fullName[0],
                fullName[2],
                "", // хардкод
                binding.fieldProject.text.toString(),
                1,
                binding.fieldFunction.text.toString(),
                binding.fieldAbout.text.toString(),
                ""
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
            fieldFullName.setText("${worker.surname} ${worker.name} ${worker.patronymic}")
            fieldMail.setText(worker.email)
            fieldAbout.setText(worker.about)
            fieldFunction.setText(worker.function)
            fieldProject.setText(worker.project)
        }
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}