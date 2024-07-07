package com.example.mvvmcontactsfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcontactsfragments.adapters.ContactsRecyclerViewAdapter
import com.example.mvvmcontactsfragments.databinding.FragmentHomeBinding
import com.example.mvvmcontactsfragments.viewmodels.ContactsSharedViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: ContactsSharedViewModel
    lateinit var adapter: ContactsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).contactsViewModel
        setupRecyclerView()
        setupAddButton()
    }

    private fun setupAddButton() {
        binding.floatingActionButton.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
            binding.root.findNavController().navigate(direction)
        }
    }

    private fun setupRecyclerView() {
        adapter = ContactsRecyclerViewAdapter(listOf()) { contact ->
            viewModel.selectedContact(contact)
            //redireccionar al Detail fragment
//            view?.findNavController()?.navigate(R.id.action_homeFragment_to_detailFragment)
            // con este forma podemos enviarle parametros similar a lo que haciamos con el bundle
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
            binding.root.findNavController().navigate(direction)
        }
        val ownerContext = (activity as MainActivity)
        binding.recyclerView.layoutManager = LinearLayoutManager(ownerContext, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
        activity.let {
            viewModel.contacts.observe(viewLifecycleOwner) { contacts ->
                adapter.contacts = contacts
                adapter.notifyDataSetChanged()
            }
        }
    }

}