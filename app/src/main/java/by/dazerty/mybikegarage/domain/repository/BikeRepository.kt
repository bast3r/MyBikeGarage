package by.dazerty.mybikegarage.domain.repository

import androidx.lifecycle.MutableLiveData
import by.dazerty.mybikegarage.domain.model.BikeModel
import java.util.UUID

interface BikeRepository {

    fun getBikes(): MutableLiveData<List<BikeModel>>

    fun getBikeById(id: UUID): MutableLiveData<BikeModel>

    fun addNewBike(bike: BikeModel)

    fun removeBike(id: UUID)

    fun saveChanges(bike: BikeModel)
}