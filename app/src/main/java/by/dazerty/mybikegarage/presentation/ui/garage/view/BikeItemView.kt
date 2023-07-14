package by.dazerty.mybikegarage.presentation.ui.garage.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import by.dazerty.mybikegarage.databinding.LayoutBikeItemBinding

class BikeItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val b by lazy {
        LayoutBikeItemBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }

    init {

    }

    var bikeName: String = ""
        set(value: String) {
            field = value
            b.bikeItemName.text = value
        }

    var bikeBrand: String = ""
        set(value: String) {
            field = value
            b.bikeItemBrand.text = value
        }

    var bikeOdometer: String = ""
        set(value: String) {
            field = value
            b.bikeItemOdometer.text = value
        }
}