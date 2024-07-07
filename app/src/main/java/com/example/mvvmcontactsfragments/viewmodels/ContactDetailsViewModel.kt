package com.example.mvvmcontactsfragments.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcontactsfragments.models.Contact
import kotlinx.coroutines.launch

class ContactDetailsViewModel(private val contactsSharedViewModel: ContactsSharedViewModel): ViewModel() {
    private val repository = contactsSharedViewModel.repository
    var isValid = MediatorLiveData<Boolean>()
    var contactNameText = MutableLiveData<String>()
    var contactEmail = MutableLiveData<String>()

    init {
        isValid.addSource(contactNameText) {
            isValid.value = checkIfValid()
        }
        isValid.addSource(contactEmail) {
            isValid.value = checkIfValid()
        }
    }

    fun updateTexts() {
        contactNameText.value = contactsSharedViewModel.selectedContact?.name
        contactEmail.value = contactsSharedViewModel.selectedContact?.email
    }

    private fun insert(contact: Contact) = viewModelScope.launch {
        repository.insert(contact)
    }

    private fun update(contact: Contact) = viewModelScope.launch {
        repository.update(contact)
    }

    fun save() {
        if (contactsSharedViewModel.selectedContact == null) {
            if (!(contactNameText.value).isNullOrBlank() && !(contactEmail.value).isNullOrBlank()) {
                insert(Contact(0, contactNameText.value!!, contactEmail.value!!))
                contactNameText.value = ""
                contactEmail.value = ""
            }
        } else {
            if (!(contactNameText.value).isNullOrBlank() && !(contactEmail.value).isNullOrBlank()) {
                contactsSharedViewModel.selectedContact?.name = contactNameText.value!!
                contactsSharedViewModel.selectedContact?.email = contactEmail.value!!
                update(contactsSharedViewModel.selectedContact!!)
                contactsSharedViewModel.selectedContact = null
                contactNameText.value = ""
                contactEmail.value = ""
            }
        }
    }

    private fun checkIfValid() = !(contactNameText.value).isNullOrBlank() &&
            !(contactEmail.value).isNullOrBlank()
}