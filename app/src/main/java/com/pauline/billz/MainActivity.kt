package com.pauline.billz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pauline.billz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        binding.btnSignup.setOnClickListener {
            validate()
            clearErrors()
        }
    }

    fun validate() {
        val name = binding.etName.text.toString()
        val phone = binding.etPhone.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        var error = false

        if (name.isBlank()) {
            binding.tilName.error = "Enter name"
            error = true
        }
        if (phone.isBlank()) {
            binding.tilPhone.error = "Enter Phone number"
            error = true
        }

        if (email.isBlank()) {
            binding.tilEmail.error = "Enter email adress"
            error = true
        }

        if (password.isBlank()) {
            binding.tilPassword.error = "Enter a password"
            error = true
        }

        if (!error) {
            Toast.makeText(this, "Thank you for signing up", Toast.LENGTH_LONG)
                .show()
        }

    }

    fun clearErrors() {
        binding.tilName.error = null
        binding.tilPhone.error = null
        binding.tilEmail.error = null
        binding.tilPassword.error = null
    }
}

















