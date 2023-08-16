package com.pauline.billz.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.pauline.billz.R
import com.pauline.billz.databinding.ActivityMainBinding
import com.pauline.billz.model.RegisterRequest
import com.pauline.billz.utils.Constants
import com.pauline.billz.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        redirectUser()
    }

    override fun onResume() {
        super.onResume()
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnSignup.setOnClickListener {
            validateSignup()
            clearErrors()
        }
        userViewModel.errLiveData.observe(this, Observer { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
            binding.pbRegister.visibility = View.GONE
        })

        userViewModel.regLiveData.observe(this, Observer { regResponse ->
            binding.pbRegister.visibility = View.GONE
            Toast.makeText(this, regResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity2::class.java))
        })

    }

    private fun validateSignup() {
        val firstName = binding.etFirstName.text.toString()
        val name = binding.etName.text.toString()
        val phone = binding.etPhone.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()
        var error = false

        if (name.isBlank()) {
            binding.tilName.error = getString(R.string.enter_name)
            error = true
        }
        if (phone.isBlank()) {
            binding.tilPhone.error = getString(R.string.enter_phone_number)
            error = true
        }

        if (email.isBlank()) {
            binding.tilEmail.error = getString(R.string.enter_email_adress)
            error = true
        }

        if (password.isBlank()) {
            binding.tilPassword.error = getString(R.string.enter_a_password)
            error = true
        }

        if (firstName.isBlank()) {
            binding.tilFirstName.error = getString(R.string.enter_your_first_name)
            error = true
        }

        if (confirmPassword != password) {
            binding.tilConfirmPassword.error = getString(R.string.password_do_not_match)
            error = true
        }

        if (!error) {
            val registerRequest = RegisterRequest(
                firstName = firstName,
                email = email,
                password = password,
                phoneNumber = phone,
                lastName = name
            )
            binding.pbRegister.visibility = View.VISIBLE
            userViewModel.registerUser(registerRequest)
        }

    }

    private fun clearErrors() {
        binding.tilFirstName.error = null
        binding.tilName.error = null
        binding.tilPhone.error = null
        binding.tilEmail.error = null
        binding.tilPassword.error = null
        binding.tilConfirmPassword.error = null
    }

    fun redirectUser() {
        val sharedPrefs = getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE)
        val userId = sharedPrefs.getString(Constants.USER_ID, Constants.EMPTY_STRING)
        if (userId.isNullOrBlank()) {
            startActivity(Intent(this, MainActivity2::class.java))
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
        finish()
    }
}

















