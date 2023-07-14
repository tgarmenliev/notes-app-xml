package com.example.to_doappxml.ui.registration

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

class RegistrationFragment(): Fragment() {

    private lateinit var nameEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var repasswordEditText: TextInputEditText

    private lateinit var nameField: TextInputLayout
    private lateinit var emailField: TextInputLayout
    private lateinit var passwordField: TextInputLayout
    private lateinit var repasswordField: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.registration_fragment, container, false)

        emailField = view.findViewById(R.id.emailFieldRegistration)
        emailEditText = view.findViewById(R.id.emailRegistrationEditText)

        passwordField = view.findViewById(R.id.passwordFieldRegistration)
        passwordEditText = view.findViewById(R.id.passwordRegistrationEditText)

        repasswordField = view.findViewById(R.id.reenterPasswordField)
        repasswordEditText = view.findViewById(R.id.reenterPasswordEditText)

        nameField = view.findViewById(R.id.nameFieldRegistration)
        nameEditText = view.findViewById(R.id.nameRegistrationEditText)

        val email = emailEditText.text
        val passwordText = passwordEditText.text
        val repasswordText = repasswordEditText.text
        val name = nameEditText.text

        val button = view.findViewById<View>(R.id.registerButton)

        nameEditText.addTextChangedListener { text ->
            if (name.toString().isEmpty()) {

                nameField.helperText = "Name is required!"

                val colorRed = ColorStateList.valueOf(resources.getColor(R.color.helperRequired))
                nameField.setHelperTextColor(colorRed)

            } else if ((validPassword(passwordText.toString()) == null) && (validEmail(email.toString()) == null) && (validRepassword(passwordText.toString(), repasswordText.toString()) == null)) {

                nameField.helperText = "Valid!"

                val colorGreen = ColorStateList.valueOf(resources.getColor(R.color.greenCorrect))
                nameField.setHelperTextColor(colorGreen)

                button.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.buttonEnabled))

                button.isEnabled = true
            }
            else {

                nameField.helperText = "Valid!"

                val colorGreen = ColorStateList.valueOf(resources.getColor(R.color.greenCorrect))
                nameField.setHelperTextColor(colorGreen)
            }
        }

        emailEditText.addTextChangedListener { text ->
            if (validEmail(email.toString()) != null) {

                emailField.helperText = validEmail(email.toString())

                val colorRed = ColorStateList.valueOf(resources.getColor(R.color.helperRequired))
                emailField.setHelperTextColor(colorRed)

            } else if ((validPassword(passwordText.toString()) == null) && (validEmail(email.toString()) == null) && (validRepassword(passwordText.toString(), repasswordText.toString()) == null)) {

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

            } else if ((validEmail(email.toString())) == null && (validPassword(passwordText.toString()) == null) && (validRepassword(passwordText.toString(), repasswordText.toString()) == null)) {

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

        repasswordEditText.addTextChangedListener { text ->
            if(validRepassword(passwordText.toString(), repasswordText.toString()) != null) {

                repasswordField.helperText = validRepassword(passwordText.toString(), repasswordText.toString())

                val colorRed = ColorStateList.valueOf(resources.getColor(R.color.helperRequired))
                repasswordField.setHelperTextColor(colorRed)

            } else if ((validEmail(email.toString())) == null && (validPassword(passwordText.toString()) == null) && (validRepassword(passwordText.toString(), repasswordText.toString()) == null)) {

                repasswordField.helperText = "Correct!"

                val colorGreen = ColorStateList.valueOf(resources.getColor(R.color.greenCorrect))
                repasswordField.setHelperTextColor(colorGreen)

                button.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.buttonEnabled))

                button.isEnabled = true
            }
            else {

                repasswordField.helperText = "Correct!"

                val colorGreen = ColorStateList.valueOf(resources.getColor(R.color.greenCorrect))
                repasswordField.setHelperTextColor(colorGreen)
            }
        }

        button.setOnClickListener {
            val toast = Toast.makeText(requireContext(), "Registration successful", Toast.LENGTH_SHORT)
            toast.show()
            findNavController().navigate(R.id.action_registrationFragment_to_notesListFragment)
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

    private fun validRepassword(passwordText: String, repasswordText: String): String? {
        if(passwordText != repasswordText) {
            return "Passwords must match!"
        }
        return null
    }
}