package com.example.tinkoff_hr.ui.authentication

import android.os.Bundle
import android.widget.Toast
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ActivityCodeBinding
import com.example.tinkoff_hr.presentation.authentication.CodePresenter
import com.example.tinkoff_hr.views.authentication.CodeView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class CodeActivity : MvpAppCompatActivity(R.layout.activity_code), CodeView {

    @Inject
    lateinit var presenterProvider: Provider<CodePresenter>

    private val codePresenter by moxyPresenter { presenterProvider.get() }

    private val binging: ActivityCodeBinding by lazy {
        ActivityCodeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binging.root)

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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}