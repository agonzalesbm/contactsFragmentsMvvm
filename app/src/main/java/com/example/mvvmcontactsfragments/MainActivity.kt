package com.example.mvvmcontactsfragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcontactsfragments.viewmodels.ContactDetailsViewModelFactory
import com.example.mvvmcontactsfragments.viewmodels.ContactDetailsViewModel
import com.example.mvvmcontactsfragments.viewmodels.ContactsSharedViewModel
import com.example.mvvmcontactsfragments.viewmodels.ContactsViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var contactsViewModel: ContactsSharedViewModel
    lateinit var contactsDetailsViewModel: ContactDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val factory = ContactsViewModelFactory(applicationContext)
        contactsViewModel = ViewModelProvider(this, factory).get(ContactsSharedViewModel::class.java)
        val detailsFactory = ContactDetailsViewModelFactory(contactsViewModel)
        contactsDetailsViewModel = ViewModelProvider(this, detailsFactory).get(ContactDetailsViewModel::class.java)
    }
}