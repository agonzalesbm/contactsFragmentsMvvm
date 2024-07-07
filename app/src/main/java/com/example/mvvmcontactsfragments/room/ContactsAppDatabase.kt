package com.example.mvvmcontactsfragments.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmcontactsfragments.models.Contact

@Database(entities = [Contact::class], version = 1)
abstract class ContactsAppDatabase: RoomDatabase() {
    abstract val contactDao: ContactDao

    // Singleton
    companion object {
        @Volatile
        private var INSTANCE: ContactsAppDatabase? = null
        fun getInstance(context: Context): ContactsAppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    // Creamos la db
                    instance = Room.databaseBuilder(context.applicationContext, ContactsAppDatabase::class.java, "contacts_db").build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }
}