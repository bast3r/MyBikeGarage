package by.dazerty.mybikegarage.data.mappers

import by.dazerty.mybikegarage.data.entity.BikeEntity
import by.dazerty.mybikegarage.domain.model.BikeModel

fun BikeEntity.map(): BikeModel {
    return BikeModel(
        id = this.id,
        name = this.name,
        brand = this.brand,
        model = this.model,
        isElectric = this.isElectric,
        produceDate = this.produceDate,
        currentOdometer = this.currentOdometer,
        description = this.description,
    )
}

fun BikeModel.map(): BikeEntity {
    return BikeEntity(
        id = this.id,
        name = this.name,
        brand = this.brand,
        model = this.model,
        isElectric = this.isElectric,
        produceDate = this.produceDate,
        currentOdometer = this.currentOdometer,
        description = this.description,
    )
}