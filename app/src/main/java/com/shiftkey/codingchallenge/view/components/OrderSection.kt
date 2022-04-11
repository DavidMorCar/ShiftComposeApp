package com.shiftkey.codingchallenge.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shiftkey.codingchallenge.domain.util.CommonOrder
import com.shiftkey.codingchallenge.domain.util.OrderType

/** Generic OrderSection composable view */
@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    order: CommonOrder = CommonOrder.Date(OrderType.Ascending),
    onOrderChange: (CommonOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Type",
                selected = order is CommonOrder.Title,
                onSelect = { onOrderChange(CommonOrder.Title(order.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = order is CommonOrder.Date,
                onSelect = { onOrderChange(CommonOrder.Date(order.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Ascending",
                selected = order.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(order.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = order.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(order.copy(OrderType.Descending))
                }
            )
        }
    }
}