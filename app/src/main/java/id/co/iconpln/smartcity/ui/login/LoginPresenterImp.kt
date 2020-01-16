package id.co.iconpln.smartcity.ui.login

import id.co.iconpln.smartcity.data.model.api.request.LoginRequest
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.rx.SchedulerProvider
import id.co.iconpln.pengaduansubsidi.ui.base.BasePresenterImp
import javax.inject.Inject

/**
 * rizmaulana@live.com 2019-06-16.
 */
class LoginPresenterImp
@Inject constructor(
        val userRepository: UserRepository, provider: SchedulerProvider
) : BasePresenterImp<LoginViewHelper>(provider), LoginPresenter {

    override fun login(username: String, password: String) {
        val loginRequest = LoginRequest(username, password)
        compositeDisposable.add(userRepository.login(loginRequest)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe {
                    viewHelper.showButtonProgress()
                }.subscribe({response ->
                    viewHelper.hideButtonProgress()
                    response?.let {
                        //TODO: do Action
                    }
                }, {
                    viewHelper.hideButtonProgress()
                }))
    }

}