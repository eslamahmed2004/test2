package com.example.test2

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExploreScreen(isCompact: Boolean, viewModel: StudyViewModel) {
    val selectedIndex = viewModel.selectedLocationIndex.intValue
    val locations = viewModel.locations

    if (isCompact) {
        if (selectedIndex == -1) {
            LocationList(
                locations = locations,
                onLocationSelect = { viewModel.selectLocation(it) },
                modifier = Modifier.fillMaxSize()
            )
        } else {
            BackHandler { viewModel.selectLocation(-1) }
            LocationDetail(
                location = locations[selectedIndex],
                onBack = { viewModel.selectLocation(-1) },
                modifier = Modifier.fillMaxSize()
            )
        }
    } else {
        Row(modifier = Modifier.fillMaxSize()) {
            LocationList(
                locations = locations,
                onLocationSelect = { viewModel.selectLocation(it) },
                modifier = Modifier.weight(1f)
            )
            if (selectedIndex != -1) {
                LocationDetail(
                    location = locations[selectedIndex],
                    onBack = null,
                    modifier = Modifier.weight(1f)
                )
            } else {
                Text(
                    text = "Select a location to view details",
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Composable
fun LocationList(
    locations: List<StudyLocation>,
    onLocationSelect: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(locations) { index, location ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onLocationSelect(index) },
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = location.name, style = MaterialTheme.typography.titleLarge)
                    Text(text = location.category, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationDetail(
    location: StudyLocation,
    onBack: (() -> Unit)?,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            if (onBack != null) {
                TopAppBar(
                    title = { Text(location.name) },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            if (onBack == null) {
                Text(text = location.name, style = MaterialTheme.typography.headlineMedium)
            }
            Text(
                text = "Category: ${location.category}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Location: ${location.location}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = location.description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}
