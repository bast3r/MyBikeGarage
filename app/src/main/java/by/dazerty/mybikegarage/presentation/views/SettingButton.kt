package by.dazerty.mybikegarage.presentation.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.isVisible
import by.dazerty.mybikegarage.R
import by.dazerty.mybikegarage.databinding.SettingButtonBinding
import by.dazerty.mybikegarage.utils.getBoolXmlAttribute
import by.dazerty.mybikegarage.utils.getStringXmlAttribute

/**
 * Кастом вью для пункта настроек "Текст >"
 */
class SettingButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

//    var model: TrustManagementOrderModel? = null

    private val b by lazy {
        SettingButtonBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }

    init {
        checkAttr(context, attrs)
    }

    fun populate() {
        b.titleTextView.text = "Settings one"
        b.endIconImageView.visibility = View.VISIBLE
    }

    private fun checkAttr(context: Context, attrs: AttributeSet?) {
        with(context.obtainStyledAttributes(attrs, R.styleable.SettingButton)) {
            getStringXmlAttribute(R.styleable.SettingButton_buttonText)?.let {
                b.titleTextView.text = it
            }
            getBoolXmlAttribute(R.styleable.SettingButton_showEndArrow)?.let {
                b.endIconImageView.isVisible = it
            }
            recycle()
        }
    }

//    fun populate(model: TrustManagementOrderModel) {
//        this.model = model
//        b.trustManagementOrderStatus.populate(model.status.displayStatus)
//        b.trustManagementOrderDate.text = model.date
//        b.trustManagementOrderNumber.text = model.number.textValue
//        b.trustManagementOrderAccount.populate(model.account)
//        b.trustManagementOrderDirection.populate(model.type)
//        b.trustManagementOrderTicker.populate(model.tickerIsin)
//        b.trustManagementOrderPrice.populate(model.securityPrice)
//        (model.dealPrice ?: model.amount)?.let {
//            b.trustManagementOrderAmount.populate(it)
//        }
//    }
}