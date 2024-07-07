package com.example.mvvmcontactsfragments.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcontactsfragments.repositories.ContactsRepository
import com.example.mvvmcontactsfragments.room.ContactsAppDatabase

class ContactsViewModelFactory(val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactsSharedViewModel::class.java)) {
            val database = ContactsAppDatabase.getInstance(context)
            val contactsDao = database.contactDao
            val repository = ContactsRepository(contactsDao)
            return ContactsSharedViewModel(repository) as T
        }

        return super.create(modelClass)
    }
}