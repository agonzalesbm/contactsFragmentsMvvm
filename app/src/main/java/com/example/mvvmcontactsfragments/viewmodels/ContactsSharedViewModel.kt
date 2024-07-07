package com.example.mvvmcontactsfragments.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcontactsfragments.models.Contact
import com.example.mvvmcontactsfragments.repositories.ContactsRepository
import kotlinx.coroutines.launch

class ContactsSharedViewModel(private val repository: ContactsRepository): ViewModel() {

    var contactNameText = MutableLiveData<String>()
    var contactEmail = MutableLiveData<String>()
    var selectedContact: Contact? = null

    val contacts = repository.contacts

    fun insert(contact: Contact) = viewModelScope.launch {
        repository.insert(contact)
    }

    fun update(contact: Contact) = viewModelScope.launch {
        repository.update(contact)
    }

    fun save() {
        if (selectedContact == null) {
            if (!(contactNameText.value).isNullOrBlank() && !(contactEmail.value).isNullOrBlank()) {
                insert(Contact(0, contactNameText.value!!, contactEmail.value!!))
            }
        }
    }

    fun selectedContact(contact: Contact) {
        selectedContact = contact
    }
}