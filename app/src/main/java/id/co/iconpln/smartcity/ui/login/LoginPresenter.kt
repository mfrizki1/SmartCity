package id.co.iconpln.smartcity.ui.login

import id.co.iconpln.smartcity.ui.base.BasePresenter

interface LoginPresenter: BasePresenter<LoginViewHelper> {

    fun login(user_id: String, city_id: String, password: String)
}