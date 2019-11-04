package id.co.iconpln.smartcity.ui.base

import androidx.fragment.app.Fragment


/**
 * Created by Rizki Maulana on 21/02/19.
 * email : rizmaulana@live.com
 * Mobile App Developer
 */

abstract class BaseFragment : Fragment(), BaseViewHelper {
    private fun getBaseActivity() = activity as BaseActivity


    override fun showProgress() {
        getBaseActivity().showProgress()
    }

    override fun hideProgress() {
        getBaseActivity().hideProgress()
    }

    override fun showSnackbarMessage(message: String?) {
        getBaseActivity().showSnackbarMessage(message)
    }

    override fun showSnackbarError(message: String?) {
        getBaseActivity().showSnackbarError(message)
    }

    override fun onUnexpectedError() {
        getBaseActivity().onUnexpectedError()
    }

    override fun showAlertDialog(message: String?) {
        getBaseActivity().showAlertDialog(message)
    }
}