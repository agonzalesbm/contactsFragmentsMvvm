package com.example.mvvmcontactsfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvmcontactsfragments.databinding.FragmentDetailBinding
import com.example.mvvmcontactsfragments.viewmodels.ContactsSharedViewModel

class DetailFragment : Fragment(R.layout.fragment_detail) {

    lateinit var binding: FragmentDetailBinding
    lateinit var viewModel: ContactsSharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).contactViewModel
    }

}