package com.creativeeddy.weekseventask.item

import retrofit2.http.GET

interface ItemService {

    @GET("items")
    suspend fun getAllItems (): List<ItemModel>
}