package by.dazerty.mybikegarage.domain.model

import java.util.Date
import java.util.UUID

data class BikeModel(
    val id: UUID,
    val name: String,
    val brand: String,
    val model: String? = null,
    val isElectric: Boolean = false,
    val produceDate: Date? = null,
    val currentOdometer: Double = 0.0,
    val description: String? = null,
)