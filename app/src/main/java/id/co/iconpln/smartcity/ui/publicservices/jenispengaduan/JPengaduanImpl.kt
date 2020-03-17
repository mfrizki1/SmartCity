package id.co.iconpln.smartcity.ui.publicservices.jenispengaduan

import android.util.Log
import id.co.iconpln.pengaduansubsidi.ui.base.BasePresenterImp
import id.co.iconpln.smartcity.data.model.api.request.JPengaduanReq
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.NetworkStatus
import id.co.iconpln.smartcity.util.rx.SchedulerProvider
import javax.inject.Inject

class JPengaduanImpl
@Inject constructor(
    val userRepository: UserRepository, provider: SchedulerProvider
) : BasePresenterImp<JPengaduanViewHelper>(provider),
    JPengaduanPresenter {

    override fun JPengaduan(city_id: String, year: String) {
        val jPengaduanReq = JPengaduanReq(city_id, year)
        compositeDisposable.add(userRepository.getJPengaduan(jPengaduanReq)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnError {
                Log.e("onEror", it.message)
                it.printStackTrace()
            }
            .subscribe({ response ->
                when (response.status) {
                    NetworkStatus.SUCCESS -> {
                        viewHelper.showJPengaduan(response.data.jpengaduanr)
                    }
                    else -> viewHelper.showSnackbarError(response.message)
                }
            }, {
                it.printStackTrace()
                viewHelper.JPFailed()
            })
        )
    }

}
