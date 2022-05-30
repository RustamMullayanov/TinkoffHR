package com.example.tinkoff_hr.ui.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.ActivityLoginBinding
import com.example.tinkoff_hr.presentation.authentication.LoginPresenter
import com.example.tinkoff_hr.views.authentication.LoginView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class LoginActivity: MvpAppCompatActivity(R.layout.activity_login), LoginView {

    @Inject
    lateinit var presenterProvider: Provider<LoginPresenter>

    private val loginPresenter by moxyPresenter { presenterProvider.get() }

    private val binging: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binging.root)

        with(binging){
            buttonLogin.setOnClickListener{
                loginPresenter.checkEmail(editMail.text.toString())
                openCodeActivity()
            }
        }
    }

    override fun openCodeActivity() {
        startActivity(Intent(this, CodeActivity::class.java))
        finish()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}