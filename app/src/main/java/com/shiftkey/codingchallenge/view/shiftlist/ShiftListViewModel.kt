package com.shiftkey.codingchallenge.view.shiftlist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiftkey.codingchallenge.domain.usecase.ShiftUseCase
import com.shiftkey.codingchallenge.domain.util.CommonOrder
import com.shiftkey.codingchallenge.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/** ShiftList ViewModel */
@HiltViewModel
class ShiftListViewModel @Inject constructor(
    private val shiftListUseCase: ShiftUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(ShiftListState())
    val state: State<ShiftListState> = _state

    private var getShiftListJob: Job? = null

    /** First state of the ViewModel */
    init {
        getShiftList(CommonOrder.Date(OrderType.Ascending))
    }

    /** Function to call if any event changed */
    fun onEvent(event: ShiftListEvent) {
        when (event) {
            is ShiftListEvent.Order -> {
                if (state.value.shiftOrder::class == event.commonOrder::class &&
                    state.value.shiftOrder.orderType == event.commonOrder.orderType
                ) {
                    return
                }
                event.commonOrder.orderType.let { CommonOrder.Date(OrderType.Descending) }
                getShiftList(event.commonOrder)
            }
            else -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    /** Function to make the ShiftList call */
    private fun getShiftList(commonOrder: CommonOrder) {
        getShiftListJob?.cancel()
        viewModelScope.launch {
            getShiftListJob = shiftListUseCase.getShiftList(commonOrder)
                .onEach { shifts ->
                    _state.value = state.value.copy(
                        shiftList = shifts,
                        shiftOrder = commonOrder
                    )
                }
                .launchIn(viewModelScope)
        }
    }
}
