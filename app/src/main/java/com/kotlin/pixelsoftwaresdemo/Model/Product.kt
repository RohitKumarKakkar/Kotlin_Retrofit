package com.kotlin.pixelsoftwaresdemo.Model

data class Product(
    val id: Long? = null,
    val title: String? = null,
    val price: Double? = null,
    val description: String? = null,
    val category: Category? = null,
    val image: String? = null,
    val rating: Rating? = null
)
