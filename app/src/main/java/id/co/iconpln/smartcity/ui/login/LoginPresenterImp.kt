package id.co.iconpln.smartcity.ui.login

import android.util.Log
import id.co.iconpln.smartcity.data.model.api.request.LoginRequest
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.rx.SchedulerProvider
import id.co.iconpln.pengaduansubsidi.ui.base.BasePresenterImp
import id.co.iconpln.smartcity.util.NetworkStatus
import javax.inject.Inject

class LoginPresenterImp
@Inject constructor(
        val userRepository: UserRepository, provider: SchedulerProvider
) : BasePresenterImp<LoginViewHelper>(provider), LoginPresenter {

    //hardcode
    val user_id1: String ="admintest"
    val city_id1: String = "3307"
    val password1: String = "123456"

    override fun login(user_id: String, city_id: String, password: String) {
        val loginRequest = LoginRequest(user_id, city_id, password)
        compositeDisposable.add(userRepository.login(loginRequest)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnError {
                Log.e("onEror", it.message)
                it.printStackTrace()
            }
            .subscribe({ response ->
                when (response.status) {
                    NetworkStatus.SUCCESS -> {
                        viewHelper.doLogin(response.data.user)
                    }
                    else -> viewHelper.showSnackbarError(response.message)
                }
            }, {
                it.printStackTrace()
                viewHelper.hideButtonProgress()
            })
        )


    }


}