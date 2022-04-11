package com.shiftkey.codingchallenge.view.shiftlist

import com.shiftkey.codingchallenge.domain.model.Shift
import com.shiftkey.codingchallenge.domain.util.CommonOrder
import com.shiftkey.codingchallenge.domain.util.OrderType

/** ShiftList state class */
data class ShiftListState(
    val shiftList: List<Shift>? = emptyList(),
    val shiftOrder: CommonOrder = CommonOrder.Date(OrderType.Ascending),
    val isOrderSectionVisible: Boolean = false
)