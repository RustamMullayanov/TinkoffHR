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

import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.domain.entities.Worker
import com.example.tinkoff_hr.views.ProfileView
import moxy.MvpAppCompatActivity


class ProfileSettingsActivity : MvpAppCompatActivity(), ProfileView{

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
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun showSuccess() {
        TODO("Not yet implemented")
    }
}