package by.dazerty.mybikegarage.presentation.ui.garage.addnew

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import by.dazerty.mybikegarage.R
import by.dazerty.mybikegarage.databinding.FragmentAddNewBikeBinding
import by.dazerty.mybikegarage.databinding.FragmentGarageBinding
import by.dazerty.mybikegarage.presentation.ui.garage.GarageViewModel
import by.dazerty.mybikegarage.utils.TextWatcherAdapter

class AddNewBikeFragment : Fragment() {

    private var _binding: FragmentAddNewBikeBinding? = null
    private val binding get() = _binding!!

    private val newBikeViewModel by lazy {
        ViewModelProvider(this)[AddNewBikeViewModel::class.java]
    }

    private val requiredFields by lazy {
        listOf(
            newBikeViewModel.bikeName.value to binding.addNewBikeName,
            newBikeViewModel.bikeBrand.value to binding.addNewBikeBrand,
            newBikeViewModel.bikeModel.value to binding.addNewBikeModel
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddNewBikeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setObservers()

        binding.addNewBikeBrand.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, resources.getStringArray(R.array.bike_brands)))

        binding.addNewBikeSave.setOnClickListener {
            if (validateScreenData()) {
                Toast.makeText(context, "Data saved", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

    private fun setListeners() {
        binding.addNewBikeName.addTextChangedListener(object : TextWatcherAdapter() {

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                super.onTextChanged(s, start, before, count)
            }
        })
    }

    private fun setObservers() {
        with(newBikeViewModel) {
            bikeName.observe(viewLifecycleOwner) {
                binding.addNewBikeName.setText(it)
            }
            bikeBrand.observe(viewLifecycleOwner) {
                binding.addNewBikeBrand.setText(it)
            }
            bikeModel.observe(viewLifecycleOwner) {
                binding.addNewBikeModel.setText(it)
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun validateScreenData(): Boolean {
        var isValid = true

        requiredFields.forEach {
            if (it.first.isNullOrEmpty()) {
                isValid = false
                it.second.error = "Should be set"
            } else {
                it.second.error = null
            }
        }

        return isValid
    }
}