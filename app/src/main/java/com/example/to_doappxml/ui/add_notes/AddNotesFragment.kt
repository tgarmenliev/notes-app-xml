package com.example.to_doappxml.ui.add_notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.to_doappxml.R
import com.google.android.material.textfield.TextInputEditText

class AddNotesFragment: Fragment() {
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.add_note_fragment, container, false)

        titleEditText = view.findViewById(R.id.notesAddingTitleEditText)
        val titleText = titleEditText.text

        descriptionEditText = view.findViewById(R.id.notesAddingDescriptionEditText)
        val descriptionText = descriptionEditText.text

        val button = view.findViewById<View>(R.id.addNoteButton)

        val cancelButton = view.findViewById<View>(R.id.cancelNoteButton)

        button.setOnClickListener {
            if (validTitle(titleText.toString()) != null) {
                val toast = Toast.makeText(requireContext(), validTitle(titleText.toString()), Toast.LENGTH_SHORT)
                toast.show()
                return@setOnClickListener
            }
            if (validDescription(descriptionText.toString()) != null) {
                val toast = Toast.makeText(requireContext(), validDescription(descriptionText.toString()), Toast.LENGTH_SHORT)
                toast.show()
                return@setOnClickListener
            }
            val toast = Toast.makeText(requireContext(), "Note added", Toast.LENGTH_SHORT)
            toast.show()
            findNavController().navigate(R.id.action_addNoteFragment_to_notesListFragment)
        }

        cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_addNoteFragment_to_notesListFragment)
        }

        return view

    }

    private fun validTitle(titleText: String): String? {
        if(titleText.length < 2) {
            return "Title have to be with minimum 2 characters!"
        }
        return null
    }

    private fun validDescription(descriptionText: String): String? {
        if(descriptionText.length < 2) {
            return "Description have to be with minimum 2 characters!"
        }
        return null
    }
}