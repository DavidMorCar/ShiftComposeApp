package com.shiftkey.codingchallenge.view.shiftdetail

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeveloperMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shiftkey.codingchallenge.domain.util.DEV_URL
import com.shiftkey.codingchallenge.domain.util.openURL
import com.shiftkey.codingchallenge.ui.theme.Purple200
import com.shiftkey.codingchallenge.view.components.SimpleCardTextItem
import com.shiftkey.codingchallenge.view.components.SimpleHorizontalTextGroup

/** ShiftDetail composable view */
@Composable
fun ShiftDetailView(
    context: Activity,
    viewModel: ShiftDetailViewModel,
) {
    // Smoothly scroll 100px on first composition
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }

    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Shift Details",
                    style = MaterialTheme.typography.h5
                )
                IconButton(
                    onClick = {
                        openURL(DEV_URL, context)
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.DeveloperMode,
                        contentDescription = "Developer Info"
                    )
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
            Spacer(
                modifier = Modifier
                    .background(Purple200)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(1.dp)
            )
            Spacer(modifier = Modifier.height(14.dp))
            SimpleHorizontalTextGroup(
                title = "Shift ID",
                description = viewModel.shift!!.shiftId
            )
            Spacer(modifier = Modifier.height(10.dp))
            SimpleHorizontalTextGroup(
                title = "Start Date",
                description = viewModel.shift!!.shiftStartDate
            )
            Spacer(modifier = Modifier.height(10.dp))
            SimpleHorizontalTextGroup(
                title = "End Date",
                description = viewModel.shift!!.shiftEndDate
            )
            Spacer(modifier = Modifier.height(10.dp))
            SimpleHorizontalTextGroup(
                title = "Shift Kind",
                description = viewModel.shift!!.shiftKind
            )
            Spacer(modifier = Modifier.height(14.dp))
            Spacer(
                modifier = Modifier
                    .background(Purple200)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(1.dp)
            )
            Spacer(modifier = Modifier.height(14.dp))
            SimpleCardTextItem(
                title = "Shift Facility",
                description = viewModel.shift!!.shiftFacility.facilityName,
                color = viewModel.shift!!.shiftFacility.facilityColor
            )
            Spacer(modifier = Modifier.height(10.dp))
            SimpleCardTextItem(
                title = "Shift Skill",
                description = viewModel.shift!!.shiftSkill.skillName,
                color = viewModel.shift!!.shiftSkill.skillColor
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}