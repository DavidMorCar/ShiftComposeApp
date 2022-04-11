package com.shiftkey.codingchallenge.domain.repository

import com.shiftkey.codingchallenge.domain.model.Shift
import com.shiftkey.codingchallenge.service.ShiftAPI
import com.shiftkey.codingchallenge.service.ShiftAPIService

/** Shift repository */
class ShiftRepository(
    shiftAPI: ShiftAPI
) : BaseShiftRepository {

    private val shiftService: ShiftAPIService = ShiftAPIService(shiftAPI)

    override suspend fun getShiftList(): List<Shift>? {
        return shiftService.getShiftList()
    }
}