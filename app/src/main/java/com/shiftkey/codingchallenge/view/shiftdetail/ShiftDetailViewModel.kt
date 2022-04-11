package com.shiftkey.codingchallenge.view.shiftdetail

import androidx.lifecycle.ViewModel
import com.shiftkey.codingchallenge.domain.model.Shift
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/** ShiftList ViewModel to conserve the selected shift*/
@HiltViewModel
class ShiftDetailViewModel @Inject constructor() : ViewModel() {

    var shift: Shift? = null

    /** First state of the ViewModel */
    init {}
}