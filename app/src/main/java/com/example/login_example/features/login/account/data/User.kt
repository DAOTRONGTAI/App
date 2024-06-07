package com.example.login_example.features.login.account.data

class User {
    var name: String? = null
    var email: String? = null
    var username: String? = null
    var password: String? = null

    constructor()

    constructor(name: String?, email: String?, username: String?, password: String?) {
        this.name = name
        this.email = email
        this.username = username
        this.password = password
    }
}
