package com.shiftkey.codingchallenge.domain.model

import com.google.gson.annotations.SerializedName

class Data(
    @SerializedName("date")
    var date: String,
    @SerializedName("shifts")
    var ShiftList: List<Shift>
)