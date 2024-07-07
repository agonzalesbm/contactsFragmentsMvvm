package com.example.mvvmcontactsfragments.repositories

import com.example.mvvmcontactsfragments.room.ContactDao
import com.example.mvvmcontactsfragments.models.Contact

class ContactsRepository(private val contactsDao: ContactDao) {

    val contacts = contactsDao.getAllContacts()

    suspend fun insert(contact: Contact) {
        contactsDao.insertContact(contact)
    }

    suspend fun update(contact: Contact) {
        contactsDao.updateContact(contact)
    }

}