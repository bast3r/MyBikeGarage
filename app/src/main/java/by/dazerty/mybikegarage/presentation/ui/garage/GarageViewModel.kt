package by.dazerty.mybikegarage.presentation.ui.garage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.dazerty.mybikegarage.data.repository.BikeRepositoryTest
import by.dazerty.mybikegarage.domain.model.BikeModel
import by.dazerty.mybikegarage.domain.repository.BikeRepository

class GarageViewModel : ViewModel() {

    private val bikeRepository: BikeRepository = BikeRepositoryTest

    private val _bikes: MutableLiveData<List<BikeModel>> = bikeRepository.getBikes()
    val bikes: LiveData<List<BikeModel>> = _bikes
}