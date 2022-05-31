package com.example.tinkoff_hr.presentation.authentication

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.domain.usecases.authentication.CheckUserCodeUseCase
import com.example.tinkoff_hr.domain.usecases.authentication.SendCodeToEmailUseCase
import com.example.tinkoff_hr.views.authentication.CodeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import timber.log.Timber
import javax.inject.Inject

class CodePresenter @Inject constructor(
    private val sendCodeToEmailUseCase: SendCodeToEmailUseCase,
    private val checkUserCodeUseCase: CheckUserCodeUseCase
) : BasePresenter<CodeView>() {

    fun sendCode(email: String) {
        sendCodeToEmailUseCase(email)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showSuccess("Код отравлен письмом на указанную вами почту")
                    viewState.startCodeTimer()
                },
                { error ->
                    viewState.showError("Ошибка сервера")
                    Timber.e(error)
                })
            .disposeOnFinish()

    }

    fun checkCode(email: String, code: Int) {
        checkUserCodeUseCase(email, code)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ token ->
                viewState.saveUserToken(token.token)
                if (token.isRegistered)
                    viewState.openContentActivity()
                else
                    viewState.openProfileSettingsActivity()
            }, { error ->
                viewState.showError("Неверный код")
                Timber.e(error)
            }).disposeOnFinish()
    }

}