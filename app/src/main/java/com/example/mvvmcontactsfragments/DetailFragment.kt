package com.example.mvvmcontactsfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.mvvmcontactsfragments.databinding.FragmentDetailBinding
import com.example.mvvmcontactsfragments.viewmodels.ContactDetailsViewModel
import com.example.mvvmcontactsfragments.viewmodels.ContactsSharedViewModel

class DetailFragment : Fragment(R.layout.fragment_detail) {

    lateinit var binding: FragmentDetailBinding
    lateinit var viewModel: ContactsSharedViewModel
    lateinit var detailsViewModels: ContactDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).contactsViewModel
        detailsViewModels = (activity as MainActivity).contactsDetailsViewModel
        binding.viewModel = viewModel
        binding.detailsViewModel = detailsViewModels
        binding.lifecycleOwner = this
        detailsViewModels.updateTexts()
        binding.button.setOnClickListener {
            detailsViewModels.save()
            binding.root.findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
        }
    }

}