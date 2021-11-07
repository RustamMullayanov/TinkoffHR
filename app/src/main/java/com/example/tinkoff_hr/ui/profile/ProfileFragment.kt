package com.example.tinkoff_hr.ui.profile

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.get
import androidx.core.view.iterator
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.FragmentProfileBinding
import com.example.tinkoff_hr.databinding.ProfileDialogBinding


class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var selectedId = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)


        binding.fieldDialog.setOnClickListener {

            val dialogBinding = ProfileDialogBinding.inflate(inflater, container, false)
            dialogBinding.apply {

                val dialog = AlertDialog.Builder(requireContext()).setTitle("Ачивки")
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

        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}