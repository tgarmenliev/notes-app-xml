package com.example.to_doappxml.ui.notes_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.to_doappxml.MyAdaptor
import com.example.to_doappxml.R

class NotesListFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.notes_list_fragment, container, false)

        val button = view.findViewById<View>(R.id.addNoteButton)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView : RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val button = view.findViewById<View>(R.id.addNoteButton)

        button.setOnClickListener {
            findNavController().navigate(R.id.action_notesListFragment_to_addNoteFragment)
        }

        val items = fetchData()
        val descriptions = fetchDescriptions()

        val adaptor = MyAdaptor(items, descriptions)
        recyclerView.adapter = adaptor
    }

    fun fetchData(): ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 0 until 30) {
            list.add("Note $i")
        }
        return list
    }

    fun fetchDescriptions(): ArrayList<String> {
        val list = ArrayList<String>()
        for (i in 0 until 30) {
            list.add("Description on note number $i")
        }
        return list
    }
}