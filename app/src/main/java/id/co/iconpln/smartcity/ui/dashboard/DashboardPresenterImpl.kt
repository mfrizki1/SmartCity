package id.co.iconpln.smartcity.ui.dashboard

import android.util.Log
import id.co.iconpln.pengaduansubsidi.ui.base.BasePresenterImp
import id.co.iconpln.smartcity.data.model.api.request.DataPengaduanRequest
import id.co.iconpln.smartcity.data.model.api.request.DemograpiReq
import id.co.iconpln.smartcity.data.model.api.request.JPengaduanReq
import id.co.iconpln.smartcity.data.model.api.request.PerijinanReq
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.NetworkStatus
import id.co.iconpln.smartcity.util.rx.SchedulerProvider
import javax.inject.Inject

class DashboardPresenterImpl
@Inject constructor(val userRepository: UserRepository, provider: SchedulerProvider) :
    BasePresenterImp<DashboardViewHelper>(provider), DashboardPresenter {

    override fun DPengaduan(city_id: String, year: String) {
        val pengaduanReq = DataPengaduanRequest(city_id, year)
        compositeDisposable.add(userRepository.getDataPengaduan(pengaduanReq)
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
                        viewHelper.showDPengaduan(response.data.pengaduan)
                    }
                    else -> viewHelper.showSnackbarError(response.message)
                }
            }, {
                it.printStackTrace()
                viewHelper.hideButtonProgress()
            })
        )
    }

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
                viewHelper.hideButtonProgress()
                when (response.status) {
                    NetworkStatus.SUCCESS -> {
                        viewHelper.showJPengaduan(response.data.jpengaduanr)
                    }
                    else -> viewHelper.showSnackbarError(response.message)
                }
            }, {
                it.printStackTrace()
                viewHelper.hideButtonProgress()
            })
        )
    }

    override fun Perijinan(city_id: String, year: String) {
        val perijinanReq = PerijinanReq(city_id, year)
        compositeDisposable.add(userRepository.getPerijinan(perijinanReq)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnError {
                Log.e("onError", it.message)
                it.printStackTrace()
            }
            .subscribe({response ->
                viewHelper.hideButtonProgress()
                when(response.status){
                    NetworkStatus.SUCCESS ->{
                        viewHelper.showPerijinan(response.data.perizinanL)
                    }else -> viewHelper.showSnackbarMessage(response.message)
                }
            }, {
                it.printStackTrace()
                viewHelper.hideButtonProgress()
            })
        )
    }

    override fun Demograpi(city_id: String, year: String) {
        val demograpiReq = DemograpiReq(city_id, year)
        compositeDisposable.add(userRepository.getDemograpi(demograpiReq)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .doOnError {
                Log.e("onEror", it.message)
                it.printStackTrace()
            }
            .subscribe({response ->
                viewHelper.hideButtonProgress()
                when(response.status){
                    NetworkStatus.SUCCESS ->{
                    viewHelper.showDemograpi(response.data.demografis)
                    }else -> viewHelper.showSnackbarMessage(response.message)
                }
            }, {
                it.printStackTrace()
                viewHelper.hideButtonProgress()
            })
        )
    }

}
