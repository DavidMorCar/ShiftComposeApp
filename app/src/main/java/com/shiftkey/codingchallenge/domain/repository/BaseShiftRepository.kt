package com.shiftkey.codingchallenge.domain.repository

import com.shiftkey.codingchallenge.domain.model.Shift

/** BaseShift repository */
interface BaseShiftRepository {
    suspend fun getShiftList(): List<Shift>?
}