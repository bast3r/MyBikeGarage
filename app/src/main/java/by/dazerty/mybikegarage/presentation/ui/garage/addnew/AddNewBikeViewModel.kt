package by.dazerty.mybikegarage.presentation.ui.garage.addnew

import androidx.lifecycle.ViewModel
import by.dazerty.mybikegarage.data.repository.BikeRepositoryTest
import by.dazerty.mybikegarage.domain.model.BikeModel
import by.dazerty.mybikegarage.domain.repository.BikeRepository
import by.dazerty.mybikegarage.utils.getDateFromString
import java.util.UUID

class AddNewBikeViewModel : ViewModel() {

    private val bikeRepository: BikeRepository = BikeRepositoryTest

    fun saveData() {
        bikeRepository.addNewBike(
            BikeModel(
                id = UUID.randomUUID(),
                name = bikeName,
                brand = bikeBrand,
                model = bikeModel,
                isElectric = bikeIsElectric,
                produceDate = getDateFromString(bikeYear),
                currentOdometer = bikeOdometer,
                description = bikeDescription
            )
        )
    }

    var bikeName: String = ""
    var bikeBrand: String = ""
    var bikeModel: String = ""
    var bikeIsElectric: Boolean = false
    var bikeYear: String? = null
    var bikeOdometer: Double = 0.0
    var bikeDescription: String? = null


}
