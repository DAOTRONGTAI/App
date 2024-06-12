package com.example.login_example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey
    var id: Int ? = null,

    var name: String? = null,
    var email: String? = null,
    var username: String? = null,
    var password: String? = null,
)


