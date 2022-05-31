package com.example.tinkoff_hr.presentation

import com.example.tinkoff_hr.base.BasePresenter
import com.example.tinkoff_hr.data.UserCacheManager
import com.example.tinkoff_hr.domain.entities.worker.UpdatedWorkerInfo
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.usecases.GetWorkerInfoByIdUseCase
import com.example.tinkoff_hr.domain.usecases.GetWorkerInfoByTokenUseCase
import com.example.tinkoff_hr.domain.usecases.SaveUserCacheUseCase
import com.example.tinkoff_hr.domain.usecases.UpdateWorkerByIdUseCase
import com.example.tinkoff_hr.domain.usecases.authentication.UserRegisteringUseCase
import com.example.tinkoff_hr.views.ProfileView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class ProfilePresenter @Inject constructor(
    private val getWorkerInfoByToken: GetWorkerInfoByTokenUseCase,
    private val updateWorkerById: UpdateWorkerByIdUseCase,
    private val saveUserCacheUseCase: SaveUserCacheUseCase,
    private val userRegisteringUseCase: UserRegisteringUseCase
) : BasePresenter<ProfileView>() {

    fun onAppearing(token: String) {
        getWorkerInfoByToken(token)
            .doOnSuccess { worker -> saveUserCache(worker) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ worker ->
                viewState.showWorkerInfo(worker)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }

    fun onSaveWorkerClicked(worker: UpdatedWorkerInfo) {
        updateWorkerById(worker)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { viewState.showSuccess("Данные успешно сохранены") },
                { error ->
                    viewState.showError("Не удалось обновить данные, повторите попытку позже")
                    Timber.e(error)
                })
            .disposeOnFinish()
    }

    fun onUserRegisterClicked(token: String, worker: UpdatedWorkerInfo) {
        userRegisteringUseCase(token, worker)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showSuccess("Регистрация прошла успешно")
                    viewState.openContentActivity()
                },
                { error ->
                    viewState.showError("Не удалось зарегистрироваться, повторите попытку позже")
                    Timber.e(error)
                })
            .disposeOnFinish()
    }

    private fun saveUserCache(user: Worker) {
        saveUserCacheUseCase(user)
    }
}