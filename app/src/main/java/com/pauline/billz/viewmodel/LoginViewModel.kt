package com.pauline.billz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauline.billz.model.LoginRequest
import com.pauline.billz.model.LoginResponse
import com.pauline.billz.repository.LoginRepository
//import com.pauline.billz.model.RegisterRequest
//import com.pauline.billz.model.RegisterResponse
//import com.pauline.billz.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel :ViewModel(){
    val userRepo =LoginRepository()
    val logLiveData = MutableLiveData<LoginResponse>()
    var errorLiveData = MutableLiveData<String>()


    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch{
            val response = userRepo.loginUser(loginRequest)
            if (response.isSuccessful){
                logLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}



