package com.shiftkey.codingchallenge.view

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shiftkey.codingchallenge.ui.theme.CodingChallengeTheme
import com.shiftkey.codingchallenge.view.shiftdetail.ShiftDetailViewModel
import com.shiftkey.codingchallenge.view.shiftdetail.ShiftDetailView
import com.shiftkey.codingchallenge.view.shiftlist.ShiftListView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

/** Only Activity of the application */
@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = this
        installSplashScreen().apply {
            setContent {
                CodingChallengeTheme() {
                    Surface {
                        NavigationSystem(context = context)
                    }
                }
            }
        }
    }

    /** creates the composable view */
    @Composable
    fun NavigationSystem(context: Activity) {
        val navController = rememberNavController()
        val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
            "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
        }
        val detailViewModel =
            viewModel<ShiftDetailViewModel>(viewModelStoreOwner = viewModelStoreOwner)
        /** Navigation Graph */
        NavHost(
            navController = navController,
            startDestination = Screen.ShiftListScreen.route
        ) {
            composable(route = Screen.ShiftListScreen.route) {
                ShiftListView(
                    navController = navController,
                    context = context,
                    detailViewModel = detailViewModel
                )
            }
            composable(
                route = Screen.ShiftDetailScreen.route,
            ) {
                CompositionLocalProvider(
                    LocalViewModelStoreOwner provides viewModelStoreOwner
                ) {
                    ShiftDetailView(
                        context = context,
                        viewModel = detailViewModel
                    )
                }
            }
        }
    }
}
