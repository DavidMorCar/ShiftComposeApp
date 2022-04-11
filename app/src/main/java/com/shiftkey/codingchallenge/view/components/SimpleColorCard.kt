package com.shiftkey.codingchallenge.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shiftkey.codingchallenge.domain.util.getColor

/** Simple Color Card composable view */
@Composable
fun SimpleColorCard(
    color: String,
    max: Dp,
    min: Dp,
) {
    Card(
        elevation = 4.dp,
        backgroundColor = getColor(color = color),
    ) {
        Column(
            Modifier
                .padding(10.dp)
                .widthIn(max = max, min = min)
                .heightIn(max = max, min = min),
        ) {
        }
    }
}