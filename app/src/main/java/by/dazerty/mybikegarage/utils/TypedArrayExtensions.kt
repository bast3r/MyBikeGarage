package by.dazerty.mybikegarage.utils

import android.content.res.TypedArray
import androidx.annotation.StyleableRes

fun TypedArray.getBoolXmlAttribute(@StyleableRes attrId: Int) =
    if (hasValue(attrId)) getBoolean(attrId, false) else null

fun TypedArray.getStringXmlAttribute(@StyleableRes attrId: Int) =
    if (hasValue(attrId)) getString(attrId) else null

fun TypedArray.getResourceXmlAttribute(@StyleableRes attrId: Int) =
    if (hasValue(attrId)) getResourceId(attrId, -1) else null

fun TypedArray.getIntXmlAttribute(@StyleableRes attrId: Int, defValue: Int = -1) =
    if (hasValue(attrId)) getInt(attrId, defValue) else null

fun TypedArray.getIntegerXmlAttribute(@StyleableRes attrId: Int, defValue: Int = -1) =
    if (hasValue(attrId)) getInteger(attrId, defValue) else null

fun TypedArray.getDimensionXmlAttribute(@StyleableRes attrId: Int, defValue: Float = -1f) =
    if (hasValue(attrId)) getDimension(attrId, defValue) else null