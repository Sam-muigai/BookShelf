package com.sam.bookshelf.data

import com.sam.bookshelf.model.Books
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface BookShelfApi{

    @GET("/v1/volumes")
    suspend fun getBooks(
        @Query("q") word:String = "Android"
    ):Books


    companion object{
        const val BASE_URL = "https://www.googleapis.com/books"
    }

}