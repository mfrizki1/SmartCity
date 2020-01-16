package id.co.iconpln.smartcity.widget

import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import id.co.iconpln.smartcity.R
import kotlinx.android.synthetic.main.view_loading_button.view.*

/**
 * Created by Rizki Maulana on 21/02/19.
 * email : rizmaulana@live.com
 * Mobile App Developer
 */

class ButtonLoading(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    var text: String
        get() = txt_label.text.toString()
        set(value) {
            txt_label.text = value
        }

    var subText: String
        get() = txt_sub_label.text.toString()
        set(value) {
            txt_sub_label.text = value

            txt_sub_label.visibility = if (value.isNotEmpty()) View.VISIBLE else View.GONE

        }

    var isLoading: Boolean
        get() = pb_loading.visibility == View.VISIBLE
        set(value) {
            if (value) {
                txt_label.visibility = View.GONE
                txt_sub_label.visibility = View.GONE
                pb_loading.visibility = View.VISIBLE
                layout_main.isClickable = false
            } else {
                isClickable = true
                txt_label.visibility = View.VISIBLE
                txt_sub_label.visibility = View.VISIBLE
                pb_loading.visibility = View.GONE
                layout_main.isClickable = true
            }
        }

    var style: Int = 1
        set(value) {
            when (value) {
                2 -> {
                    layout_main.setBackgroundResource(R.drawable.bg_button_oval_primary)
                    txt_label.setTextColor(ContextCompat.getColor(context, R.color.onyx))
                    pb_loading.indeterminateDrawable.setColorFilter(
                        ContextCompat.getColor(context, R.color.onyx),
                        PorterDuff.Mode.SRC_IN
                    )
                }
                3 -> {
                    layout_main.setBackgroundResource(R.drawable.bg_button_oval_primary)
                    txt_label.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.white
                        )
                    )
                    pb_loading.indeterminateDrawable.setColorFilter(
                        ContextCompat.getColor(context, R.color.white),
                        PorterDuff.Mode.SRC_IN
                    )
                }
                else -> {
                    layout_main.setBackgroundResource(R.drawable.bg_button_oval_primary)
                    txt_label.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.white
                        )
                    )
                    pb_loading.indeterminateDrawable.setColorFilter(
                        ContextCompat.getColor(context, R.color.white),
                        PorterDuff.Mode.SRC_IN
                    )
                }
            }
        }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        txt_label.isEnabled = enabled
        if (enabled) {
            isLoading = isLoading
        } else {
            pb_loading.visibility = View.GONE
        }
    }

    private var listener: View.OnClickListener? = null

    override fun setOnClickListener(l: OnClickListener?) {
        listener = l
    }

    init {
        View.inflate(context, R.layout.view_loading_button, this)
        isLoading = false
        attrs?.let {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.ButtonLoading)

            text = ta.getString(R.styleable.ButtonLoading_android_text) ?: ""
            subText = ""
            isLoading = ta.getBoolean(R.styleable.ButtonLoading_isLoading, false)
            style = ta.getInt(R.styleable.ButtonLoading_ietStyle, 1)

            layout_main.setOnClickListener { listener?.onClick(this) }

            ta.recycle()
        }
    }

}