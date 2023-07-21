package com.pauline.billz.repository

import com.pauline.billz.api.ApiClient
import com.pauline.billz.api.ApiInterface
import com.pauline.billz.model.RegisterRequest
import com.pauline.billz.model.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun registerUser(registerRequest: RegisterRequest):Response<RegisterResponse>{
        return withContext(Dispatchers.IO){
            apiClient.registerUser(registerRequest)
        }
    }
}