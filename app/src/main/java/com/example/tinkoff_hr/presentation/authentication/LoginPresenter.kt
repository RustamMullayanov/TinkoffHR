package com.example.tinkoff_hr.presentation.authentication

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.domain.usecases.authentication.CheckUserEmailUseCase
import com.example.tinkoff_hr.views.authentication.LoginView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val checkUserEmailUseCase: CheckUserEmailUseCase
) : BasePresenter<LoginView>() {

    fun checkEmail(email: String) {
        checkUserEmailUseCase(email)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { viewState.openCodeActivity() },
                { error ->
                    viewState.showError("Некорректный email")
                    Timber.e(error)
                })
            .disposeOnFinish()
    }
}