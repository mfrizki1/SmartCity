package id.co.iconpln.smartcity.ui.provinsi

import android.util.Log
import id.co.iconpln.pengaduansubsidi.ui.base.BasePresenterImp
import id.co.iconpln.smartcity.data.repository.UserRepository
import id.co.iconpln.smartcity.util.NetworkStatus
import id.co.iconpln.smartcity.util.rx.SchedulerProvider
import javax.inject.Inject

class ProvinsiPresenterImpl
@Inject constructor(
    val userRepository: UserRepository, provider: SchedulerProvider
) : BasePresenterImp<ProvinsiViewHelper>(provider), ProvinsiPresenter {

    override fun province() {
        compositeDisposable.add(userRepository.province()
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
                        viewHelper.showProvince(response.data.province)
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