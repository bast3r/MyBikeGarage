package by.dazerty.mybikegarage.presentation.ui.garage.addnew

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.dazerty.mybikegarage.R
import by.dazerty.mybikegarage.databinding.FragmentAddNewBikeBinding

class AddNewBikeFragment : Fragment() {

    private var _binding: FragmentAddNewBikeBinding? = null
    private val binding get() = _binding!!

    private val newBikeViewModel by lazy {
        ViewModelProvider(this)[AddNewBikeViewModel::class.java]
    }

    private val requiredFields by lazy {
        listOf(binding.addNewBikeName, binding.addNewBikeBrand, binding.addNewBikeModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddNewBikeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setObservers()
        setListeners()

        binding.addNewBikeBrand.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, resources.getStringArray(R.array.bike_brands)))

        return binding.root
    }

    private fun setListeners() {
        binding.addNewBikeSave.setOnClickListener {
            if (validateScreenData()) {
                collectDataToModel()
                newBikeViewModel.saveData()
                Toast.makeText(context, "Data saved", Toast.LENGTH_LONG).show()
                findNavController().navigateUp()
            } else {
                Toast.makeText(context, "Data is incorrect", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun collectDataToModel() {
        newBikeViewModel.bikeName = binding.addNewBikeName.text.toString()
        newBikeViewModel.bikeBrand = binding.addNewBikeBrand.text.toString()
        newBikeViewModel.bikeModel = binding.addNewBikeModel.text.toString()
        newBikeViewModel.bikeIsElectric = binding.addNewBikeIsElectric.isChecked
        newBikeViewModel.bikeYear = binding.addNewBikeYear.text.toString()
        newBikeViewModel.bikeOdometer = binding.addNewBikeOdometer.text.toString().toDouble()
        newBikeViewModel.bikeDescription = binding.addNewBikeDescription.text.toString()
    }

    private fun setObservers() {

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun validateScreenData(): Boolean {
        var isValid = true

        requiredFields.forEach {
            if (it.text.isEmpty()) {
                isValid = false
                it.error = "Should be set"
            } else {
                it.error = null
            }
        }

        if (binding.addNewBikeYear.text.isNullOrBlank()) {
            binding.addNewBikeYear.setText("2023")
        }

        if (binding.addNewBikeOdometer.text.isNullOrEmpty()) {
            binding.addNewBikeOdometer.setText("0")
        }

        return isValid
    }
}