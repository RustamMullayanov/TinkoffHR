package com.example.tinkoff_hr.ui.authentication

import android.os.Bundle
import android.view.View
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.FragmentCodeBinding
import com.example.tinkoff_hr.presentation.authentication.CodePresenter
import com.example.tinkoff_hr.views.authentication.CodeView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class CodeFragment : MvpAppCompatFragment(R.layout.fragment_code), CodeView {

    @Inject
    lateinit var presenterProvider: Provider<CodePresenter>

    private val codePresenter by moxyPresenter { presenterProvider.get() }

    private lateinit var binging: FragmentCodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binging = FragmentCodeBinding.bind(view)

        with(binging) {
            buttonSendCode.setOnClickListener {
                codePresenter.checkCode(codeField.text.toString())
            }

            buttonCheckCode.setOnClickListener {
                codePresenter.sendCode()
            }
        }
    }

    override fun startCodeTimer() {
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun showSuccess(message: String) {
        TODO("Not yet implemented")
    }
}