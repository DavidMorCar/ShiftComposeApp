package com.shiftkey.codingchallenge.domain.util

/** Class with order types */
sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}
