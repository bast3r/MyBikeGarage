package by.dazerty.mybikegarage.data.entity

import java.math.BigDecimal
import java.util.Date
import java.util.UUID

data class PartEntity(
    val id: UUID,
    val name: String,
    val price: BigDecimal?,
    val state: PartState,
    val currentOdometer: Double,
    val possibleOdometer: Double,
    val setupDate: Date?
) {

    enum class PartState {
        NEW, USED
    }
}