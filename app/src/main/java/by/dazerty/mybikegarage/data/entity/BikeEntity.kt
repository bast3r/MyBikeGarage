package by.dazerty.mybikegarage.data.entity

import java.util.Date
import java.util.UUID

data class BikeEntity(
    val id: UUID,
    val name: String,
    val brand: String,
    val model: String?,
    val isElectric: Boolean,
    val produceDate: Date?,
    val currentOdometer: Double,
    val description: String?,

)