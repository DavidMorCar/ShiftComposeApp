package com.shiftkey.codingchallenge.domain.util

/** Class with order variables */
sealed class CommonOrder(val orderType: OrderType) {
    class Title(orderType: OrderType) : CommonOrder(orderType)
    class Date(orderType: OrderType) : CommonOrder(orderType)

    fun copy(orderType: OrderType): CommonOrder {
        return when (this) {
            is Title -> Title(orderType)
            is Date -> Date(orderType)
            else -> Date(orderType)
        }
    }
}

