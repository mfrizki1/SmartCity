package id.co.iconpln.smartcity.ui.login

import id.co.iconpln.smartcity.ui.base.BasePresenter

/**
 * rizmaulana@live.com 2019-06-16.
 */
interface LoginPresenter: BasePresenter<LoginViewHelper> {

    fun login(username: String, password: String)
}