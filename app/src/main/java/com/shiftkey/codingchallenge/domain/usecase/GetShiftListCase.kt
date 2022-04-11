package com.shiftkey.codingchallenge.domain.usecase

import com.shiftkey.codingchallenge.domain.model.Shift
import com.shiftkey.codingchallenge.domain.repository.BaseShiftRepository
import com.shiftkey.codingchallenge.domain.util.CommonOrder
import com.shiftkey.codingchallenge.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

/** Get ShiftList Case */
class GetShiftListCase(
    private val repository: BaseShiftRepository
) {

    operator fun invoke(
        order: CommonOrder = CommonOrder.Date(orderType = OrderType.Descending)
    ): Flow<List<Shift>> {
        return flow { emit(repository.getShiftList()) }.map { shifts ->
            when (order.orderType) {
                is OrderType.Ascending -> {
                    when (order) {
                        is CommonOrder.Title -> shifts!!.sortedBy { it.shiftKind.lowercase() }
                        is CommonOrder.Date -> shifts!!.sortedBy {
                            it.shiftStartDate.lowercase()
                        }
                    }
                }
                is OrderType.Descending -> {
                    when (order) {
                        is CommonOrder.Title -> shifts!!.sortedByDescending {
                            it.shiftKind.lowercase()
                        }
                        is CommonOrder.Date -> shifts!!.sortedByDescending {
                            it.shiftStartDate.lowercase()
                        }
                    }
                }
            }
        }
    }
}