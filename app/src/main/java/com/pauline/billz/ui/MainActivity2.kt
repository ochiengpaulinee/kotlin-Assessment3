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
import com.pauline.billz.databinding.ActivityMain2Binding
import com.pauline.billz.model.LoginRequest
import com.pauline.billz.model.LoginResponse
import com.pauline.billz.model.RegisterRequest
import com.pauline.billz.utils.Constants
import com.pauline.billz.viewmodel.LoginViewModel
import com.pauline.billz.viewmodel.UserViewModel

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    private val loginViewModel: LoginViewModel by viewModels()
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
        loginViewModel.errorLiveData.observe(this, Observer { err->
            Toast.makeText(this,err,Toast.LENGTH_LONG).show()
            binding.pbLoad.visibility = View.GONE
        })

        loginViewModel.logLiveData.observe(this, Observer { logResponse->
            persistLogin(logResponse)
            binding.pbLoad.visibility = View.GONE
            Toast.makeText(this,logResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        })
    }

    private fun validate(){
        val email = binding.etEmails.text.toString()
        val password = binding.etPasswords.text.toString()
        var error = false

        if(email.isBlank()){
            binding.tilEmails.error = getString(R.string.enter_your_username)
            error = true
        }

        if(password.isBlank()){
            binding.tilPasswords.error = getString(R.string.enter_your_password)
            error = true
        }

        if (!error) {
            if (!error) {
                val loginRequest = LoginRequest(
                    email = email,
                    password = password
                )
                binding.pbLoad.visibility = View.VISIBLE
                loginViewModel.loginUser(loginRequest)
            }
        }
    }

    fun clearErrors(){
        binding.tilEmails.error = null
        binding.tilPasswords.error = null
    }

    fun persistLogin(loginResponse: LoginResponse){
        val sharedPrefs = getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putString(Constants.USER_ID, loginResponse.user_id)
        editor.putString(Constants.ACCESS_TOKEN, loginResponse.access_token)
        editor.apply()
    }


}


