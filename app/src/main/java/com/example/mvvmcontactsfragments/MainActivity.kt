package com.example.mvvmcontactsfragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcontactsfragments.viewmodels.ContactsSharedViewModel
import com.example.mvvmcontactsfragments.viewmodels.ContactsViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var contactViewModel: ContactsSharedViewModel
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
        contactViewModel = ViewModelProvider(this, factory).get(ContactsSharedViewModel::class.java)
    }
}