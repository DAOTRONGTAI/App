package com.example.login_example.features.login.account.forgetaccount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.login_example.base.baseui.BaseFragment
import com.example.login_example.databinding.FragmentForgetAcountBinding

class FragmentForgetAcount : BaseFragment() {
    private var binding: FragmentForgetAcountBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgetAcountBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEvents()
        initLiteners()
        initControls()
    }

    private fun initControls() {
    }

    private fun initLiteners() {
    }

    private fun initEvents() {
    }

    override fun onResume() {
        super.onResume()
    }
}
