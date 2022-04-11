package com.shiftkey.codingchallenge.view.shiftlist

import android.app.Activity
import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeveloperMode
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shiftkey.codingchallenge.domain.util.DEV_URL
import com.shiftkey.codingchallenge.domain.util.openURL
import com.shiftkey.codingchallenge.view.Screen
import com.shiftkey.codingchallenge.view.components.OrderSection
import com.shiftkey.codingchallenge.view.components.ShiftItem
import com.shiftkey.codingchallenge.view.shiftdetail.ShiftDetailViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

/** ShiftList composable view */
@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@Composable
fun ShiftListView(
    navController: NavController,
    viewModel: ShiftListViewModel = hiltViewModel(),
    detailViewModel: ShiftDetailViewModel,
    context: Activity,
) {
    val state = viewModel.state.value

    Scaffold(
        floatingActionButton = {
            Column(
            ) {
                FloatingActionButton(
                    onClick = {
                        openURL(
                            DEV_URL,
                            context
                        )
                    },
                    backgroundColor = MaterialTheme.colors.primary
                ) {
                    Icon(
                        imageVector = Icons.Default.DeveloperMode,
                        contentDescription = "Developer Info"
                    )
                }
            }
        },

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Dallas, TX | Week Shifts",
                    style = MaterialTheme.typography.h5
                )
                IconButton(
                    onClick = {
                        viewModel.onEvent(ShiftListEvent.ToggleOrderSection)
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.Sort,
                        contentDescription = "Sort"
                    )
                }
            }
            AnimatedVisibility(
                visible = state.isOrderSectionVisible,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                OrderSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    order = state.shiftOrder,
                    onOrderChange = {
                        viewModel.onEvent(ShiftListEvent.Order(it))
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.shiftList!!) { shift ->
                    ShiftItem(
                        shift = shift,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                detailViewModel.shift = shift
                                navController.navigate(Screen.ShiftDetailScreen.route)
                            },
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}