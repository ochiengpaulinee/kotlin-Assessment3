package com.pauline.billz.api

import com.pauline.billz.model.LoginRequest
import com.pauline.billz.model.LoginResponse
import com.pauline.billz.model.RegisterRequest
import com.pauline.billz.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
    suspend fun registerUser(@Body registerRequest:RegisterRequest): Response<RegisterResponse>

    @POST("/users/login")
    suspend fun loginUsers(@Body loginRequest: LoginRequest):Response<LoginResponse>
}


