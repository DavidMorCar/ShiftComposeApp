package com.shiftkey.codingchallenge.domain.model.response

import com.google.gson.annotations.SerializedName
import com.shiftkey.codingchallenge.domain.model.Data

data class ShiftResponse(
    @SerializedName("data")
    var data: List<Data>,
)