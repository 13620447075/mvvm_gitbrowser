package com.fgh.gitbrowser.api

import androidx.lifecycle.LiveData
import com.fgh.gitbrowser.vo.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    //api接口
    @GET("users/{login}")
    fun getUser(@Path("login") login: String): LiveData<ApiResponse<User>>

}