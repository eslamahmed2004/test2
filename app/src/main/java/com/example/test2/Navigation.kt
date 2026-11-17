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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

val allRoutes = listOf(Routes.EXPLORE, Routes.TRACKER, Routes.ABOUT)

fun getIconForRoute(route: String): ImageVector = when (route) {
    Routes.EXPLORE -> Icons.Default.LocationOn
    Routes.TRACKER -> Icons.Default.PlayArrow
    else -> Icons.Default.Info
}

@Composable
fun AppNavigationRail(currentRoute: String, onNavigate: (String) -> Unit) {
    NavigationRail {
        allRoutes.forEach { route ->
            NavigationRailItem(
                selected = currentRoute == route,
                onClick = { onNavigate(route) },
                icon = { Icon(getIconForRoute(route), contentDescription = route) },
                label = { Text(route) }
            )
        }
    }
}

@Composable
fun AppNavigationDrawer(currentRoute: String, onNavigate: (String) -> Unit) {
    Column(modifier = Modifier.width(240.dp).padding(16.dp)) {
        Text(
            text = "Study Companion",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp, start = 16.dp)
        )
        allRoutes.forEach { route ->
            NavigationDrawerItem(
                selected = currentRoute == route,
                onClick = { onNavigate(route) },
                icon = { Icon(getIconForRoute(route), contentDescription = route) },
                label = { Text(route) }
            )
        }
    }
}
