package id.co.iconpln.smartcity.ui.kota

import android.util.Log
import id.co.iconpln.pengaduansubsidi.ui.base.BasePresenterImp
import id.co.iconpln.smartcity.data.model.local.CityDto
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.NetworkStatus
import id.co.iconpln.smartcity.util.rx.SchedulerProvider
import javax.inject.Inject

class KotaPresenterImpl @Inject constructor(
    val userRepository: UserRepository, provider: SchedulerProvider
) : BasePresenterImp<KotaViewHelper>(provider), KotaPresenter {

    override fun getCitybyId(province_id: String) {
        compositeDisposable.add(userRepository.city(province_id)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnError {
                    Log.e("onEror", it.message)
                    it.printStackTrace()
                }
                .subscribe({ response ->
                    viewHelper.hideButtonProgress()
                    when (response.status) {
                        NetworkStatus.SUCCESS -> {
                            viewHelper.showCity(response.data.refCity)
                        }
                        else -> viewHelper.showSnackbarError(response.message)
                    }
                }, {
                    it.printStackTrace()
                    viewHelper.hideButtonProgress()
                })
        )


    }

    override fun setCityId(coba: String) {
        userRepository.setCityId(coba)
    }

}