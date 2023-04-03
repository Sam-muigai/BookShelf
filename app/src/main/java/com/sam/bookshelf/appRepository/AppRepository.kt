package com.sam.bookshelf.appRepository

import com.sam.bookshelf.data.BookShelfApi
import com.sam.bookshelf.model.Books
import com.sam.bookshelf.model.ImageLinks
import com.sam.bookshelf.model.Item
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppRepository {
    suspend fun getPhotos () : List<Item>
}

class RepositoryImplementation(private val api:BookShelfApi): AppRepository{
    override suspend fun getPhotos(): List<Item> {
       return api.getBooks().items
    }
}

interface AppContainer{
    fun provideAppRepository():AppRepository
}

class DefaultAppContainer:AppContainer {
    private val retrofit = Retrofit.Builder().baseUrl(BookShelfApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val retrofitService:BookShelfApi by lazy {
        retrofit.create(BookShelfApi::class.java)
    }

    override fun provideAppRepository(): AppRepository {
        return RepositoryImplementation(retrofitService)
    }

}