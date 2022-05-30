package com.example.tinkoff_hr.ui.authentication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.ContentActivity
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.actionbar.ProfileSettingsActivity
import com.example.tinkoff_hr.data.UserTokenStorage
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

    private val tokenStorage: UserTokenStorage = UserTokenStorage(applicationContext)
    private val userEmail: String by lazy { intent.getStringExtra(EXTRA_USER_EMAIL)!! }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binging.root)

        with(binging) {
            buttonSendCode.setOnClickListener {
                codePresenter.sendCode(userEmail)
            }

            buttonCheckCode.setOnClickListener {
                codePresenter.checkCode(userEmail, codeField.text.toString().toInt())
            }
        }
    }

    override fun startCodeTimer() {
        TODO("Not yet implemented")
    }

    override fun openContentActivity() {
        startActivity(Intent(this, ContentActivity::class.java))
        finish()
    }

    override fun openProfileSettingsActivity() {
        startActivity(Intent(this, ContentActivity::class.java))
        startActivity(Intent(this, ProfileSettingsActivity::class.java))
        finish()
    }

    override fun saveUserToken(token: String) {
        tokenStorage.saveUserToken(token)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {

        private const val EXTRA_USER_EMAIL = "extra_user_email"

        fun createIntent(context: Context, userEmail: String): Intent {
            return Intent(context, CodeActivity::class.java).apply {
                putExtra(EXTRA_USER_EMAIL, userEmail)
            }
        }
    }
}