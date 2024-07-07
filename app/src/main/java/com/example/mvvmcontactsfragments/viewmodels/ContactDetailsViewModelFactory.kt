package com.example.mvvmcontactsfragments.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ContactDetailsViewModelFactory(val sharedViewModel: ContactsSharedViewModel): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactDetailsViewModel::class.java)) {
            return ContactDetailsViewModel(sharedViewModel) as T
        }
        return super.create(modelClass)
    }
}