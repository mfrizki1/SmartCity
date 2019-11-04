package id.co.iconpln.smartcity.util

import android.content.Context

/**
 * Created by Rizki Maulana on 21/02/19.
 * email : rizmaulana@live.com
 * Mobile App Developer
 */
class StringUtils constructor(val context: Context) {

    fun getString(string: Int) = context.resources.getString(string)

}