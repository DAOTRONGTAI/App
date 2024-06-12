package com.example.login_example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (
    @PrimaryKey
    val id: Int ?= null,
    val titleNote: String ?= null,
    val contentNote: String ?= null,
)