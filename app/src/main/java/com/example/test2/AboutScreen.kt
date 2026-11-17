package com.example.test2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val infoCards = listOf(
    Pair("Campus Guide", "Your ultimate companion for finding the best study spots on campus."),
    Pair("Study Goals", "Track your hours and build a consistent study habit throughout the semester."),
    Pair("Library Hours", "Main library is open 24/7 during finals. Check local times for other branches."),
    Pair("Tutoring", "Math and Science tutoring centers offer walk-in sessions every weekday."),
    Pair("Counseling", "Mental health resources are available at the student health center."),
    Pair("Events", "Join weekend study groups and hackathons at the student union."),
    Pair("Campus Guide", "Your ultimate companion for finding the best study spots on campus."),
    Pair("Study Goals", "Track your hours and build a consistent study habit throughout the semester."),
    Pair("Library Hours", "Main library is open 24/7 during finals. Check local times for other branches."),
    Pair("Tutoring", "Math and Science tutoring centers offer walk-in sessions every weekday."),
    Pair("Counseling", "Mental health resources are available at the student health center."),
    Pair("Events", "Join weekend study groups and hackathons at the student union."),
    Pair("Campus Guide", "Your ultimate companion for finding the best study spots on campus."),
    Pair("Study Goals", "Track your hours and build a consistent study habit throughout the semester."),
    Pair("Library Hours", "Main library is open 24/7 during finals. Check local times for other branches."),
    Pair("Tutoring", "Math and Science tutoring centers offer walk-in sessions every weekday."),
    Pair("Counseling", "Mental health resources are available at the student health center."),
    Pair("Events", "Join weekend study groups and hackathons at the student union."),
    Pair("Campus Guide", "Your ultimate companion for finding the best study spots on campus."),
    Pair("Study Goals", "Track your hours and build a consistent study habit throughout the semester."),
    Pair("Library Hours", "Main library is open 24/7 during finals. Check local times for other branches."),
    Pair("Tutoring", "Math and Science tutoring centers offer walk-in sessions every weekday."),
    Pair("Counseling", "Mental health resources are available at the student health center."),
    Pair("Events", "Join weekend study groups and hackathons at the student union."),
    Pair("Campus Guide", "Your ultimate companion for finding the best study spots on campus."),
    Pair("Study Goals", "Track your hours and build a consistent study habit throughout the semester."),
    Pair("Library Hours", "Main library is open 24/7 during finals. Check local times for other branches."),
    Pair("Tutoring", "Math and Science tutoring centers offer walk-in sessions every weekday."),
    Pair("Counseling", "Mental health resources are available at the student health center."),
    Pair("Events", "Join weekend study groups and hackathons at the student union.")
)

@Composable
fun AboutScreen(isCompact: Boolean) {
    val columns = if (isCompact) 1 else 2

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(infoCards) { (title, desc) ->
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = desc,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
