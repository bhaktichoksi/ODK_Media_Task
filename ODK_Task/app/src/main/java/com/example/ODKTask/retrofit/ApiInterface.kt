package com.example.ODKTask.retrofit

import com.example.ODKTask.model.MarvelMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {

    @GET("characters?ts=1&apikey=76b18c4275f3da8c9140a43a03cfc447&hash=34c02ddb99d1ca209cee083a16f5d2da")
    fun getServices() : Call<MarvelMovie>

    @GET("characters/{post_id}?ts=1&apikey=76b18c4275f3da8c9140a43a03cfc447&hash=34c02ddb99d1ca209cee083a16f5d2da")
    fun getDetail(@Path("post_id")postId: String) : Call<MarvelMovie>

}