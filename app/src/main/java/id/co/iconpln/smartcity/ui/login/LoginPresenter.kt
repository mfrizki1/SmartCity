package id.co.iconpln.smartcity.ui.login

import id.co.iconpln.smartcity.ui.base.BasePresenter

/**
 * rizmaulana@live.com 2019-06-16.
 */
interface LoginPresenter: BasePresenter<LoginViewHelper> {

    fun login(user_id: String, city_id: String, password: String)
}