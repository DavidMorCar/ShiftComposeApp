package com.shiftkey.codingchallenge.view

/** Screen navigation helper */
sealed class Screen(val route: String) {
    object ShiftListScreen : Screen("shift_list_screen")
    object ShiftDetailScreen : Screen("shift_details_screen")
}
