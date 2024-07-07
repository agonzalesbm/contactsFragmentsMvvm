package com.example.mvvmcontactsfragments.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mvvmcontactsfragments.models.Contact

@Dao
interface ContactDao {

    @Insert
    suspend fun insertContact(contact: Contact): Long

    @Update
    suspend fun updateContact(contact: Contact)

    @Query("Select * from contacts")
    fun getAllContacts(): LiveData<List<Contact>>
}