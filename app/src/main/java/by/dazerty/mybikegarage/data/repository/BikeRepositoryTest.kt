package by.dazerty.mybikegarage.data.repository

import androidx.lifecycle.MutableLiveData
import by.dazerty.mybikegarage.data.entity.BikeEntity
import by.dazerty.mybikegarage.data.mappers.map
import by.dazerty.mybikegarage.domain.model.BikeModel
import by.dazerty.mybikegarage.domain.repository.BikeRepository
import java.util.UUID

object BikeRepositoryTest: BikeRepository {

    private val bikes = arrayListOf<BikeEntity>().apply {
        add(BikeEntity(
            id = UUID.randomUUID(),
            name = "black TREK",
            brand = "TREK",
            model = "3900 disk 2012",
            isElectric = false,
            produceDate = null,
            currentOdometer = 24000.0,
            description = "My lovely bike",
        ))
        add(BikeEntity(
            id = UUID.randomUUID(),
            name = "green Jocker",
            brand = "jocker",
            model = "best jocker",
            isElectric = false,
            produceDate = null,
            currentOdometer = 10000.0,
            description = "My first mtbike",
        ))
        add(BikeEntity(
            id = UUID.randomUUID(),
            name = "black sister bike",
            brand = "Silverback",
            model = "stride 30",
            isElectric = false,
            produceDate = null,
            currentOdometer = 5000.0,
            description = "My sister's bike",
        ))
    }

    override fun getBikes(): MutableLiveData<List<BikeModel>> {
        return MutableLiveData(bikes.map { it.map() })
    }

    override fun getBikeById(id: UUID): MutableLiveData<BikeModel> {
        return MutableLiveData(searchBike(id)?.map())
    }

    private fun searchBike(id: UUID): BikeEntity? {
        return bikes.lastOrNull { it.id == id }
    }

    override fun addNewBike(bike: BikeModel) {
        bikes.add(bike.map())
    }

    override fun removeBike(id: UUID) {
        searchBike(id)?.let {
            bikes.remove(it)
        }
    }

    override fun saveChanges(bike: BikeModel) {
        searchBike(bike.id)?.let {
            bikes.remove(it)
            bikes.add(bike.map())
        }
    }
}