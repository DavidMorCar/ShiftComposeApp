package com.shiftkey.codingchallenge.domain.model

import com.google.gson.annotations.SerializedName

data class Skill(
    @SerializedName("id")
    var skillId: String,
    @SerializedName("name")
    var skillName: String,
    @SerializedName("color")
    var skillColor: String
)