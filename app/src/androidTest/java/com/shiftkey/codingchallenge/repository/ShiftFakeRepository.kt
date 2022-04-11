package com.shiftkey.codingchallenge.repository

import com.shiftkey.codingchallenge.domain.model.Facility
import com.shiftkey.codingchallenge.domain.model.Shift
import com.shiftkey.codingchallenge.domain.model.Skill
import com.shiftkey.codingchallenge.domain.repository.BaseShiftRepository

/** Fake ShiftRepository */
class ShiftFakeRepository() : BaseShiftRepository {

    override suspend fun getShiftList(): List<Shift> = getShiftTestArray()

    /** Function to mock a Film List */
    private fun getShiftTestArray(): List<Shift> = listOf(

        Shift
            (
            "TestID1", "2022-04-12", "2022-04-14", "TestType",
            Skill("testID", "testName", "testColor"),
            Facility("testID", "testName", "testColor")
        ),
        Shift
            (
            "TestID2", "2022-04-15", "2022-04-14", "TestType",
            Skill("testID", "testName", "testColor"),
            Facility("testID", "testName", "testColor")
        ),
        Shift
            (
            "TestID3", "2022-04-16", "2022-04-14", "TestType",
            Skill("testID", "testName", "testColor"),
            Facility("testID", "testName", "testColor")
        )
    )

}