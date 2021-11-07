package com.example.tinkoff_hr.actionbar

import android.R.attr
import android.app.AlertDialog
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.tinkoff_hr.databinding.ActivityProfileSettingsBinding
import com.example.tinkoff_hr.databinding.ProfileDialogBinding
import android.R.attr.label

import android.content.ClipData




class ProfileSettings : AppCompatActivity() {

    private val binding: ActivityProfileSettingsBinding by lazy {
        ActivityProfileSettingsBinding.inflate(layoutInflater)
    }

    private var selectedId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.title = "Профиль"
        binding.fieldDialog.setOnClickListener {

            val dialogBinding = ProfileDialogBinding.inflate(
                layoutInflater, binding.root, false
            )

            dialogBinding.apply {

                val dialog = AlertDialog.Builder(this@ProfileSettings).setTitle("Ачивки")
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
        binding.textMail.setEndIconOnClickListener{
            val clipboard: ClipboardManager = this.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copied Text",binding.fieldMail.text.toString())
            clipboard.setPrimaryClip(clip)
        }
    }
}