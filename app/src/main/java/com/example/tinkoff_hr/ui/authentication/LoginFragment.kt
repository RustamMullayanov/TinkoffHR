package com.example.tinkoff_hr.ui.authentication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.R
import com.example.tinkoff_hr.databinding.FragmentLoginBinding
import com.example.tinkoff_hr.presentation.authentication.LoginPresenter
import com.example.tinkoff_hr.views.authentication.LoginView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class LoginFragment: MvpAppCompatFragment(R.layout.fragment_login), LoginView {

    @Inject
    lateinit var presenterProvider: Provider<LoginPresenter>

    private val loginPresenter by moxyPresenter { presenterProvider.get() }

    private lateinit var binging: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binging = FragmentLoginBinding.bind(view)

        with(binging){
            buttonLogin.setOnClickListener{
                loginPresenter.checkEmail(editMail.text.toString())
            }
        }
    }

    override fun openCodeFragment() {
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}