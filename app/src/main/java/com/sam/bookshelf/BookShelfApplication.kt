package com.sam.bookshelf

import android.app.Application
import com.sam.bookshelf.appRepository.AppContainer

class BookShelfApplication :Application(){

    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container
    }
}