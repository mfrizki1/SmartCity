package id.co.iconpln.smartcity.ui.base

import id.co.iconpln.smartcity.util.StringUtils

/**
 * rizmaulana@live.com 2019-06-14.
 */
interface BasePresenter<V : BaseViewHelper> {

    fun setView(viewHelper : V)

    fun inflateStringUtils(stringUtils: StringUtils)

    fun onDestroy()

    fun userUnauthorized()
}