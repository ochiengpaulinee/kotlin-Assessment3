package com.pauline.billz.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.pauline.billz.R


class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings,container,false)
        val btnLogOut = view.findViewById<Button>(R.id.btnLogOut)
        btnLogOut.setOnClickListener {
            logOut()
        }
        return view
    }

    private fun logOut(){
        val intent = Intent(activity,MainActivity2::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        activity?.finish()
    }

}
