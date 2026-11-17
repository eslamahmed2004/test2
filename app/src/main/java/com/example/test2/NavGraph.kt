package com.example.test2

import androidx.compose.runtime.Composable

@Composable
fun NavGraph(
    isCompact: Boolean,
    currentRoute: String,
    viewModel: StudyViewModel
) {
    when (currentRoute) {
        Routes.EXPLORE -> ExploreScreen(isCompact, viewModel)
        Routes.TRACKER -> TrackerScreen(viewModel)
        Routes.ABOUT -> AboutScreen(isCompact)
    }
}
