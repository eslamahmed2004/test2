package com.example.test2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.test2.ui.theme.Test2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test2Theme {
                val windowSizeClass = calculateWindowSizeClass(this)
                val studyViewModel: StudyViewModel = viewModel()
                var currentRoute by rememberSaveable { mutableStateOf(Route.Explore) }
                val isCompact = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

                Scaffold { innerPadding ->
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            NavGraph(
                                isCompact = isCompact,
                                currentRoute = currentRoute,
                                viewModel = studyViewModel
                            )
                        }



                        if (isCompact) {
                            AppNavigationRail(
                                currentRoute = currentRoute,
                                onNavigate = { currentRoute = it }
                            )
                        } else {
                            AppNavigationDrawer(
                                currentRoute = currentRoute,
                                onNavigate = { currentRoute = it }
                            )
                        }
                    }
                }
            }
        }
    }
}
