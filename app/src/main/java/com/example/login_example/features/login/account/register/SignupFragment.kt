package com.example.login_example.features.login.account.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.login_example.R
import com.example.login_example.base.baseui.BaseFragment
import com.example.login_example.databinding.FragmentSignupBinding
import com.example.login_example.features.login.account.data.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupFragment : BaseFragment() {
    var firebaseDatabase: FirebaseDatabase? = null
    var reference: DatabaseReference? = null

    private var binding: FragmentSignupBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEvents()
    }

    private fun initEvents() {
        binding!!.btnSignup.setOnClickListener {
            firebaseDatabase = FirebaseDatabase.getInstance()
            reference = firebaseDatabase!!.getReference("users")

            val name = binding!!.edtName.text.toString()
            val email = binding!!.edtEmail.text.toString()
            val username = binding!!.edtUserName.text.toString()
            val password = binding!!.edtPassword.text.toString()

            val user = User(name, email, username, password)
            reference!!.child(username).setValue(user)
            navController.navigate(R.id.action_signupFragment_to_loginFragment)
        }
    }

    override fun onResume() {
        super.onResume()
    }
}