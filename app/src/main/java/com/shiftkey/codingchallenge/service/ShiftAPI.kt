package com.shiftkey.codingchallenge.service

import com.shiftkey.codingchallenge.domain.model.response.ShiftResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/** Retrofit interface */
interface ShiftAPI {

    @GET("available_shifts")
    suspend fun getShiftService(
        @Query(value = "address", encoded = true) address: String,
        @Query(value = "start", encoded = true) start: String,
        @Query(value = "type", encoded = true) type: String,
        @Header("Accept") acceptHeader: String,
        @Header("Content-Type") contentHeader: String,
    ): Response<ShiftResponse>

}