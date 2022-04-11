package com.shiftkey.codingchallenge.domain.model

import com.google.gson.annotations.SerializedName

data class Facility(
    @SerializedName("id")
    var facilityId: String,
    @SerializedName("name")
    var facilityName: String,
    @SerializedName("color")
    var facilityColor: String
)