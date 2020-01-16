package id.co.iconpln.smartcity.util.ext

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * rizmaulana@live.com 2019-06-16.
 */

fun EditText.onFocusChanged(hasFocus: (Boolean) -> Unit) {
    this.setOnFocusChangeListener { _, b -> hasFocus(b) }
}

fun EditText.OnTextChangedListener(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {}

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            p0?.let {
                afterTextChanged(editableText.toString())
            }
        }

    })
}