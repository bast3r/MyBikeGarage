package by.dazerty.mybikegarage.presentation.ui.garage.addnew

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddNewBikeViewModel : ViewModel() {

    private val _bikeName = MutableLiveData<String>()
    val bikeName: LiveData<String> = _bikeName

    private val _bikeBrand = MutableLiveData<String>()
    val bikeBrand: LiveData<String> = _bikeBrand

    private val _bikeModel = MutableLiveData<String>()
    val bikeModel: LiveData<String> = _bikeModel

    private val _bikeIsElectric = MutableLiveData<Boolean>()
    val bikeIsElectric: LiveData<Boolean> = _bikeIsElectric

    private val _bikeYear = MutableLiveData<String?>()
    val bikeYear: LiveData<String?> = _bikeYear

    private val _bikeOdometer = MutableLiveData<Double>()
    val bikeOdometer: LiveData<Double> = _bikeOdometer

    private val _bikeDescription = MutableLiveData<String>()
    val bikeDescription: LiveData<String> = _bikeDescription


}
