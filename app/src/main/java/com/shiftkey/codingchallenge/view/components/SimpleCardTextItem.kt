package com.shiftkey.codingchallenge.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** Simple Card Text Item composable view */
@Composable
fun SimpleCardTextItem(
    title: String,
    description: String,
    color: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SimpleColorCard(color, 50.dp, 50.dp)
        SimpleVerticalTextGroup(
            title = title,
            description = description
        )
    }
}