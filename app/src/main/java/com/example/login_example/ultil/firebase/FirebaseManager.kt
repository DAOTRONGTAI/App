package com.example.login_example.ultil.firebase

class FirebaseManager {

    companion object {
        var firebaseManager: FirebaseManager? = null


    }

    fun getInstance(): FirebaseManager? {
        if (firebaseManager == null) {
            return FirebaseManager().also { firebaseManager = it }
        }
        return firebaseManager
    }
}