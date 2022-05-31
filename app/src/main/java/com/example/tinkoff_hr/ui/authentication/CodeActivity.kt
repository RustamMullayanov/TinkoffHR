package com.example.tinkoff_hr.ui.authentication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.ContentActivity
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.actionbar.ProfileSettingsActivity
import com.example.tinkoff_hr.data.UserTokenStorage
import com.example.tinkoff_hr.databinding.ActivityCodeBinding
import com.example.tinkoff_hr.presentation.authentication.CodePresenter
import com.example.tinkoff_hr.views.authentication.CodeView
import kotlinx.serialization.descriptors.StructureKind
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

    private lateinit var tokenStorage: UserTokenStorage
    private lateinit var timer: CountDownTimer
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

        tokenStorage = UserTokenStorage(applicationContext)
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }

    override fun startCodeTimer() {
        with(binging) {
            buttonSendCode.isEnabled = false
            countDownTimer.visibility = View.VISIBLE
            timer = object : CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    countDownTimer.text = "Осталось: ${millisUntilFinished / 1000} с"
                }

                override fun onFinish() {
                    countDownTimer.text = "Можете запросить код еще раз"
                    buttonSendCode.isEnabled = true
                }
            }.start()
        }

    }

    override fun openContentActivity() {
        startActivity(Intent(this, ContentActivity::class.java))
        finish()
    }

    override fun openProfileSettingsActivity() {
        startActivity(ProfileSettingsActivity.createIntent(this, false))
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