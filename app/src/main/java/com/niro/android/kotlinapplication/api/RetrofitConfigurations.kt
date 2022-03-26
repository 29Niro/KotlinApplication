package com.niro.android.kotlinapplication.api

import android.text.Editable
import com.niro.android.kotlinapplication.model.Photo
import com.niro.android.kotlinapplication.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface UserAPIService{
    @GET("users")
    fun getUsers():Call<List<User>>

    @GET("photos")
    fun getPhotos():Call<List<Photo>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") id: Editable):Call<User>

    companion object {
        val API_URL = "https://jsonplaceholder.typicode.com/"
        fun create(): UserAPIService {
            val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(UserAPIService::class.java)
        }
    }
}