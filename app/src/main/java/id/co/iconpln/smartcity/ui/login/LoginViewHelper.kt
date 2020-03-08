package id.co.iconpln.smartcity.ui.login

import id.co.iconpln.smartcity.data.model.local.LoginDto
import id.co.iconpln.smartcity.ui.base.BaseViewHelper

/**
 * rizmaulana@live.com 2019-06-16.
 */
interface LoginViewHelper: BaseViewHelper {

    fun doLogin(loginDto: ArrayList<LoginDto>)

    fun loginFailed()
}