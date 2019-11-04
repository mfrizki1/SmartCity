package id.co.iconpln.pengaduansubsidi.ui.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import id.co.iconpln.smartcity.ui.base.BasePresenter
import id.co.iconpln.smartcity.ui.base.BaseViewHelper
import id.co.iconpln.smartcity.util.StringUtils
import id.co.iconpln.smartcity.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Rizki Maulana on 21/02/19.
 * email : rizmaulana@live.com
 * Mobile App Developer
 */
abstract class BasePresenterImp<V : BaseViewHelper>(val schedulerProvider: SchedulerProvider) : BasePresenter<V>,
    LifecycleObserver {

    protected val TAG = javaClass.simpleName
    lateinit var viewHelper: V
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()
    protected lateinit var stringUtils: StringUtils

    override fun setView(viewHelper: V) {
        this.viewHelper = viewHelper
        if (viewHelper is LifecycleOwner) {
            viewHelper.lifecycle.addObserver(this)
        }
    }

    override fun inflateStringUtils(stringUtils: StringUtils) {
        this.stringUtils = stringUtils
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

    override fun userUnauthorized() {
        viewHelper.onAuthFailed()
    }

    /*TODO: Tambahkan network error handling*/
    protected fun onNetworkErrorHandling(error: Throwable) {
        viewHelper.hideProgress()
        viewHelper.onUnexpectedError()

    }

}