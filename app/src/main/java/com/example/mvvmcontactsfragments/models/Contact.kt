package com.example.mvvmcontactsfragments.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo
    var name: String,
    @ColumnInfo
    var email: String
)
