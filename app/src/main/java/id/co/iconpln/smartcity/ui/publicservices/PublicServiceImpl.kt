package id.co.iconpln.smartcity.ui.publicservices

import android.util.Log
import id.co.iconpln.pengaduansubsidi.ui.base.BasePresenterImp
import id.co.iconpln.smartcity.data.model.api.request.DemograpiReq
import id.co.iconpln.smartcity.data.model.api.request.PerijinanReq
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.NetworkStatus
import id.co.iconpln.smartcity.util.rx.SchedulerProvider
import javax.inject.Inject


class PublicServiceImpl
@Inject constructor(
    val userRepository: UserRepository, provider: SchedulerProvider
): BasePresenterImp<PublicServiceViewHelper>(provider), PublicServicePresenter{

    override fun perijinan(city_id: String, year: String) {

        val perijinanReq = PerijinanReq(city_id, year)
        compositeDisposable.add(userRepository.getPerijinan(perijinanReq)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnError {
                Log.e("onEror", it.message)
                it.printStackTrace()
            }
            .subscribe({ response ->
                when (response.status) {
                    NetworkStatus.SUCCESS -> {
                        viewHelper.showPerijinan(response.data.perizinanL)
                    }
                    else -> viewHelper.showSnackbarError(response.message)
                }
            }, {
                it.printStackTrace()
                viewHelper.hideData()
            })
        )

    }

    override fun demograpi(city_id: String, year: String) {

        val demograpiReq = DemograpiReq(city_id, year)
        compositeDisposable.add(userRepository.getDemograpi(demograpiReq)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnError {
                Log.e("onEror", it.message)
                it.printStackTrace()
            }
            .subscribe({ response ->
                when (response.status) {
                    NetworkStatus.SUCCESS -> {
                        viewHelper.showDemograpi(response.data.demografis)
                    }
                    else -> viewHelper.showSnackbarError(response.message)
                }
            }, {
                it.printStackTrace()
                viewHelper.hideData()
            })
        )
    }


}
