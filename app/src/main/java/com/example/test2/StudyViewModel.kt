package com.example.test2

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

data class StudyLocation(
    val name: String,
    val category: String,
    val location: String,
    val description: String
)

class StudyViewModel : ViewModel() {
    var studyHours = mutableIntStateOf(0)
        private set

    var selectedLocationIndex = mutableIntStateOf(-1)
        private set

    val locations = listOf(
        StudyLocation("Main Library", "Quiet Study", "North Campus", "Perfect for deep focus."),
        StudyLocation("Engineering Hub", "Group Work", "East Wing", "Open tables and whiteboards."),
        StudyLocation("Coffee House", "Casual Study", "Student Union", "Relaxed environment."),
        StudyLocation("Science Quad", "Outdoor", "South Campus", "Shaded benches under oak trees."),
        StudyLocation("Law Library", "Silent Study", "West Wing", "Strictly silent zone."),
        StudyLocation("Innovation Lab", "Tech", "East Campus", "Equipped with 3D printers."),
        StudyLocation("Art Studio", "Creative", "Fine Arts Building", "Spacious desks with natural lighting."),
        StudyLocation("Study Pods", "Focus", "Library 2nd Floor", "Soundproof pods for intense focus.")
    )

    fun addHour() { studyHours.intValue++ }
    fun resetHours() { studyHours.intValue = 0 }
    fun selectLocation(index: Int) { selectedLocationIndex.intValue = index }
}
