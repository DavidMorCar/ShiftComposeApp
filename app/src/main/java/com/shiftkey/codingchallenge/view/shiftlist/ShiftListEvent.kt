package com.shiftkey.codingchallenge.view.shiftlist

import com.shiftkey.codingchallenge.domain.util.CommonOrder

/** ShiftEvent event class */
sealed class ShiftListEvent {
    data class Order(val commonOrder: CommonOrder) : ShiftListEvent()
    object ToggleOrderSection : ShiftListEvent()
}