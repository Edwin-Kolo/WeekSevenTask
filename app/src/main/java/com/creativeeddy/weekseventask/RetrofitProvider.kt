package com.creativeeddy.weekseventask

import com.creativeeddy.weekseventask.item.ItemService
import com.creativeeddy.weekseventask.student.StudentService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitProvider {
    val retrofit = Retrofit.Builder ()
        .baseUrl("https://ict-yep-backend.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: ItemService = retrofit.create(ItemService::class.java)
    val service1: StudentService = retrofit.create(StudentService::class.java)

}