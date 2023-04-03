package com.sam.bookshelf.model

data class Books(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)