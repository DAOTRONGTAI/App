package com.example.login_example.features.account.login

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.login_example.R
import com.example.login_example.base.baseui.BaseFragment
import com.example.login_example.databinding.FragmentLoginBinding
import com.example.login_example.features.MainActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class LoginFragment : BaseFragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEvents()
        initListeners()
        initControls()
    }

    private fun initEvents() {
//        binding!!.tvForgetPass.paintFlags = Paint.UNDERLINE_TEXT_FLAG
//
//        binding!!.tvRegister.setOnClickListener { navController.navigate(R.id.action_loginFragment_to_signupFragment) }
//
//        binding!!.btnLogin.setOnClickListener {
//            if (!validateName() or !validatePassword()) {
//            } else {
//                checkUser()
//            }
//        }
        binding.btnLogin.setOnClickListener {
            if (binding.edtName.text.toString() == "taidao" && binding.edtPassword.text.toString() == "123456") {
                val intent = Intent(requireActivity(), MainActivity :: class.java)
                startActivity(intent)
            }else{
                showErrorMessage("Số điện thoại hoặc mật khẩu không đúng")
            }
        }

        binding.tvRegister.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_signupFragment)
        }

        binding.tvForgetPass.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }

    private fun initListeners() {
    }

    private fun initControls() {
    }

    fun validateName(): Boolean {
        val `val` = binding!!.edtName.text.toString()
        if (`val`.isEmpty()) {
            binding!!.edtName.error = "Name cannot be empty"
            return false
        } else {
            binding!!.edtName.error = null
            return true
        }
    }

//    fun validatePassword(): Boolean {
//        val `val` = binding!!.edtPassword.text.toString()
//        if (`val`.isEmpty()) {
//            binding!!.edtPassword.error = "Password cannot be empty"
//            return false
//        } else {
//            binding!!.edtPassword.error = null
//            return true
//        }
//    }
//
//    fun checkUser() {
//        val userName = binding!!.edtName.text.toString().trim { it <= ' ' }
//        val userPassword = binding!!.edtPassword.text.toString().trim { it <= ' ' }
//
//        val reference = FirebaseDatabase.getInstance().getReference("users")
//        val checkUserDatabase = reference.orderByChild("username").equalTo(userName)
//
//        checkUserDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if (snapshot.exists()) {
//                    binding!!.edtName.error = null
//                    val pwFromDB = snapshot.child(userName).child("password").getValue(
//                        String::class.java
//                    )
//
//                    //                    if(!Objects.equals(pwFromDB,userPassword)){
//                    if (pwFromDB == userPassword) {
//                        binding!!.edtName.error = null
////                        navController.navigate(R.id.action_loginFragment_to_welcomeFragment)
//                        val intent = Intent(requireActivity(), MainActivity :: class.java)
//                        startActivity(intent)
//                    } else {
//                        binding!!.edtPassword.error = "Password error!!!"
//                        binding!!.edtPassword.requestFocus()
//                    }
//                } else {
//                    binding!!.edtName.error = "Name error!!!"
//                    binding!!.edtName.requestFocus()
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//            }
//        })
//    }

    override fun onResume() {
        super.onResume()
    }
}