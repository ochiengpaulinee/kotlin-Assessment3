package com.pauline.billz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pauline.billz.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnLogins.setOnClickListener {
            validate()
            clearErrors()
        }
    }

    fun validate(){
        val username = binding.etUsername.text.toString()
        val password = binding.etPasswords.text.toString()
        var error = false

        if(username.isBlank()){
            binding.tilUsername.error = "Enter your username"
            error = true
        }

        if(password.isBlank()){
            binding.tilPasswords.error = "Enter your password"
            error = true
        }

        if (!error) {
            Toast.makeText(this, "Logged in successfully", Toast.LENGTH_LONG)
                .show()
        }
    }

    fun clearErrors(){
        binding.tilUsername.error = null
        binding.tilPasswords.error = null
    }


}


