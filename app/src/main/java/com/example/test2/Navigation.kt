package com.example.test2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

fun getIconForRoute(route: Route): ImageVector = when (route) {
    Route.Explore -> Icons.Default.LocationOn
    Route.Tracker -> Icons.Default.PlayArrow
    Route.About -> Icons.Default.Info
}

@Composable
fun AppNavigationRail(currentRoute: Route, onNavigate: (Route) -> Unit) {
    NavigationRail {
        Route.entries.forEach { route ->
            NavigationRailItem(
                selected = currentRoute == route,
                onClick = { onNavigate(route) },
                icon = { Icon(getIconForRoute(route), contentDescription = route.title) },
                label = { Text(route.title) }
            )
        }
    }
}

@Composable
fun AppNavigationDrawer(currentRoute: Route, onNavigate: (Route) -> Unit) {
    PermanentDrawerSheet(modifier = Modifier.width(240.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Study Companion",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp, start = 16.dp)
            )
            Route.entries.forEach { route ->
                NavigationDrawerItem(
                    selected = currentRoute == route,
                    onClick = { onNavigate(route) },
                    icon = { Icon(getIconForRoute(route), contentDescription = route.title) },
                    label = { Text(route.title) }
                )
            }
        }
    }
}
