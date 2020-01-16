package id.co.iconpln.smartcity.ui.base

/**
 * rizmaulana@live.com 2019-06-14.
 */
interface BaseViewHelper {

    fun showProgress()

    fun hideProgress()

    fun showSnackbarMessage(message: String?)

    fun showSnackbarError(message: String?)

    fun onUnexpectedError()

    fun showAlertDialog(message: String?)

    fun onAuthFailed()
}