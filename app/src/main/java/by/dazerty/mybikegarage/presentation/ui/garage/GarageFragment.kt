package by.dazerty.mybikegarage.presentation.ui.garage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.dazerty.mybikegarage.databinding.FragmentGarageBinding
import by.dazerty.mybikegarage.presentation.ui.garage.view.BikeItemView

class GarageFragment : Fragment() {

    private var _binding: FragmentGarageBinding? = null
    private val binding get() = _binding!!

    private val garageViewModel by lazy {
        ViewModelProvider(this)[GarageViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGarageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setObservers()

//        binding.garageCreateNewBike.setOnClickListener {
//            binding.garageCreateNewBike.isVisible = false
//            binding.garageCycleList.isVisible = true
//            binding.garageEmptyReminders.isVisible = false
//            binding.garageRemindersList.isVisible = true
//        }

//        val textView: TextView = binding.textDashboard
//        garageViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    private fun setObservers() {
        garageViewModel.bikes.observe(viewLifecycleOwner) {
            with (binding.garageCycleList) {
                isVisible = true
                removeAllViews()

                it.forEach { bike ->
                    addView(BikeItemView(context).apply {
                        layoutParams = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        ).apply {
                        }
                        bikeName = bike.name
                        bikeBrand = bike.brand
                        bikeOdometer = bikeOdometer
                    })
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}