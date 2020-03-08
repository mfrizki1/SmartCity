package id.co.iconpln.smartcity.ui.publicservices

import android.util.Log
import id.co.iconpln.pengaduansubsidi.ui.base.BasePresenterImp
import id.co.iconpln.smartcity.data.model.api.request.DataPengaduanRequest
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.NetworkStatus
import id.co.iconpln.smartcity.util.rx.SchedulerProvider
import javax.inject.Inject

class PengaduanPresenterImpl
@Inject constructor(
    val userRepository: UserRepository, provider: SchedulerProvider
) : BasePresenterImp<PengaduanViewHelper>(provider), PengaduanPresenter {


    override fun pengaduan(city_id: String, year: String) {
        val pengaduanRequest = DataPengaduanRequest(city_id, year)
        compositeDisposable.add(userRepository.getDataPengaduan(pengaduanRequest)
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
}