package com.example.test2

import androidx.compose.runtime.Composable

@Composable
fun NavGraph(
    isCompact: Boolean,
    currentRoute: Route,
    viewModel: StudyViewModel
) {
    when (currentRoute) {
        Route.Explore -> ExploreScreen(isCompact, viewModel)
        Route.Tracker -> TrackerScreen(viewModel)
        Route.About -> AboutScreen(isCompact)
    }
}
