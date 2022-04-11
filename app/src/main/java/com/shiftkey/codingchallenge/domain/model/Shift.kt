package com.shiftkey.codingchallenge.domain.model

import com.google.gson.annotations.SerializedName

data class Shift(
    @SerializedName("shift_id")
    var shiftId: String,
    @SerializedName("normalized_start_date_time")
    var shiftStartDate: String,
    @SerializedName("normalized_end_date_time")
    var shiftEndDate: String,
    @SerializedName("shift_kind")
    var shiftKind: String,
    @SerializedName("skill")
    var shiftSkill: Skill,
    @SerializedName("facility_type")
    var shiftFacility: Facility
)