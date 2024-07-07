package com.example.mvvmcontactsfragments.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mvvmcontactsfragments.models.Contact
import com.example.mvvmcontactsfragments.repositories.ContactsRepository

class ContactsSharedViewModel(val repository: ContactsRepository): ViewModel() {
    var selectedContact: Contact? = null
    val contacts = repository.contacts

    fun selectedContact(contact: Contact) {
        selectedContact = contact
    }
}