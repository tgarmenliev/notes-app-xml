package com.example.to_doappxml.ui.login

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.to_doappxml.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LogInFragment(): Fragment() {

    private lateinit var passwordEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText

    private lateinit var emailField: TextInputLayout
    private lateinit var passwordField: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.login_fragment, container, false)

        emailField = view.findViewById(R.id.emailField)
        passwordField = view.findViewById(R.id.passwordField)

        emailEditText = view.findViewById(R.id.emailEditText)
        val email = emailEditText.text

        passwordEditText = view.findViewById(R.id.passwordEditText)
        val passwordText = passwordEditText.text

        val button = view.findViewById<View>(R.id.loginButton)

        emailEditText.addTextChangedListener { text ->
            if (validEmail(email.toString()) != null) {

                emailField.helperText = validEmail(email.toString())

                val colorRed = ColorStateList.valueOf(resources.getColor(R.color.helperRequired))
                emailField.setHelperTextColor(colorRed)

            } else if ((validPassword(passwordText.toString()) == null) && (validEmail(email.toString()) == null)) {

                emailField.helperText = "Valid!"

                val colorGreen = ColorStateList.valueOf(resources.getColor(R.color.greenCorrect))
                emailField.setHelperTextColor(colorGreen)

                button.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.buttonEnabled))

                button.isEnabled = true
            }
            else {

                val colorGreen = ColorStateList.valueOf(resources.getColor(R.color.greenCorrect))
                emailField.setHelperTextColor(colorGreen)

                emailField.helperText = "Valid!"
            }
        }

        passwordEditText.addTextChangedListener { text ->
            if (validPassword(passwordText.toString()) != null) {

                passwordField.helperText = validPassword(passwordText.toString())

                val colorRed = ColorStateList.valueOf(resources.getColor(R.color.helperRequired))
                passwordField.setHelperTextColor(colorRed)

            } else if ((validEmail(email.toString())) == null && (validPassword(passwordText.toString()) == null)) {

                passwordField.helperText = "Correct!"

                val colorGreen = ColorStateList.valueOf(resources.getColor(R.color.greenCorrect))
                passwordField.setHelperTextColor(colorGreen)

                button.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.buttonEnabled))

                button.isEnabled = true
            }
            else {

                passwordField.helperText = "Correct!"

                val colorGreen = ColorStateList.valueOf(resources.getColor(R.color.greenCorrect))
                passwordField.setHelperTextColor(colorGreen)
            }
        }

        button.setOnClickListener {
            val toast = Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_SHORT)
            toast.show()
            findNavController().navigate(R.id.action_logInFragment_to_notesListFragment)
        }
        return view
    }

    private fun validEmail(email: String): String? {
        if (email.isEmpty()) {
            return "Email is required!"
        }
        return null
    }

    private fun validPassword(passwordText: String): String? {
        if(passwordText.length < 8) {
            return "Password have to be with minimum 8 characters!"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex())) {
            return "Password must contain 1 upper-case character!"
        }
        if(!passwordText.matches(".*[a-z].*".toRegex())) {
            return "Password must contain 1 lower-case character!"
        }
        if(!passwordText.matches(".*[@#\$%.!^&+{}_=].*".toRegex())) {
            return "Password must contain 1 special character (@#\$%^&+=.)!"
        }
        println(passwordText)
        return null
    }
}