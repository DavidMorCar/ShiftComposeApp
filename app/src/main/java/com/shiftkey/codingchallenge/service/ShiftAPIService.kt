package com.shiftkey.codingchallenge.service

import com.shiftkey.codingchallenge.domain.model.Shift
import com.shiftkey.codingchallenge.domain.util.DATE_PATTER
import java.text.SimpleDateFormat
import java.util.*

/** Class for Album API calls */
class ShiftAPIService constructor(
    private var service: ShiftAPI
) {

    /** Function to load a SongList */
    suspend fun getShiftList(): List<Shift>? {
        try {
            val date = Calendar.getInstance().time
            val formatter = SimpleDateFormat(DATE_PATTER, Locale.US)
            val call = service.getShiftService(
                address = "Dallas, TX",
                start = formatter.format(date),
                type = "week",
                acceptHeader = "application/json",
                contentHeader = "application/json",
            )
            val response = call.body()
            return if (call.isSuccessful && response != null) {
                val list = mutableListOf<Shift>()
                for (item in response.data) {
                    list.addAll(item.ShiftList)
                }
                return list
            } else {
                null
            }
        } catch (e: Exception) {
            // has to be replaced with error handling implementation and connection check
            return emptyList()
        }
    }
}