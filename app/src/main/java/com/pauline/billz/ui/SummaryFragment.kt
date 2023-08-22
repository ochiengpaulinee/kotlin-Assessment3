package com.pauline.billz.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pauline.billz.R
import com.pauline.billz.databinding.FragmentSummaryBinding

class SummaryFragment : Fragment() {

    private var _binding:FragmentSummaryBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSummaryBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        // attach to root determines whether the activity is able to access click events in the adapter
//        binding.root - references of root view
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        binding?.fbAdd?.setOnClickListener {
            startActivity(Intent(requireContext(), AddBillActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}