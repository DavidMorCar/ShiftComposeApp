package com.shiftkey.codingchallenge.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/** Simple Vertical Text Group composable view */
@Composable
fun SimpleVerticalTextGroup(
    title: String,
    description: String,
) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Text(
            text = "$title:",
            style = MaterialTheme.typography.body1,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.End),
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = description,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(Alignment.End),
        )
    }
}