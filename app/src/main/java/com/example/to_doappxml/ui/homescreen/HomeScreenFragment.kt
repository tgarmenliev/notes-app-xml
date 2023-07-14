package com.example.to_doappxml.ui.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.to_doappxml.R

class HomeScreenFragment(): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.homescreen_fragment, container, false)

        val button_login = view.findViewById<View>(R.id.buttonLogin)

        button_login.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreenFragment_to_logInFragment)
        }

        val button_register = view.findViewById<View>(R.id.buttonRegister)

        button_register.setOnClickListener {
            findNavController().navigate(R.id.action_homeScreenFragment_to_registrationFragment)
        }

        return view
    }
}