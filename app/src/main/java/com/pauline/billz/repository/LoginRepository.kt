package com.pauline.billz.repository

import com.pauline.billz.api.ApiClient
import com.pauline.billz.api.ApiInterface
import com.pauline.billz.model.LoginRequest
import com.pauline.billz.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepository {
    val apiClients = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>{
        return withContext(Dispatchers.IO){
            apiClients.loginUsers(loginRequest)
        }

    }
}