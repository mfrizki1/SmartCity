package id.co.iconpln.smartcity.ui.splash

import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.rx.SchedulerProvider
import id.co.iconpln.pengaduansubsidi.ui.base.BasePresenterImp
import javax.inject.Inject

/**
 * rizmaulana@live.com 2019-06-16.
 */
class SplashPresenterImp @Inject
constructor(
    userRepository: UserRepository, provider: SchedulerProvider
) : BasePresenterImp<SplashViewHelper>(provider), SplashPresenter {

    /*TODO: Call validate token API*/
    override fun validateToken() {
        viewHelper.navigateWelcomePage()
    }

}