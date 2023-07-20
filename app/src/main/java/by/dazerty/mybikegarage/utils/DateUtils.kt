package by.dazerty.mybikegarage.utils

import java.text.SimpleDateFormat
import java.util.Date

private val DATE_YEAR_FORMAT = SimpleDateFormat("yyyy")

fun getDateFromString(date: String?): Date? {
    date?.let {
        return DATE_YEAR_FORMAT.parse(date)
    }
    return Date()
}