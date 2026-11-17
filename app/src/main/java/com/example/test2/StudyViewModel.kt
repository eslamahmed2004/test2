package com.example.test2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class StudyLocation(
    val id: Int,
    val title: String,
    val category: String,
    val location: String,
    val description: String
)

class StudyViewModel : ViewModel() {
    private val _studyHours = MutableStateFlow(0)
    val studyHours: StateFlow<Int> = _studyHours.asStateFlow()

    private val _selectedLocation = MutableStateFlow<StudyLocation?>(null)
    val selectedLocation: StateFlow<StudyLocation?> = _selectedLocation.asStateFlow()

    val locations = listOf(
        StudyLocation(1, "Main Library", "Quiet Study", "North Campus", "Perfect for deep focus with individual carrels."),
        StudyLocation(2, "Engineering Hub", "Group Work", "East Wing", "Open tables and whiteboards for collaborative projects."),
        StudyLocation(3, "Coffee House", "Casual Study", "Student Union", "Relaxed environment with background noise and caffeine."),
        StudyLocation(4, "Science Quad", "Outdoor", "South Campus", "Shaded benches under oak trees, great for reading."),
        StudyLocation(5, "Law Library", "Silent Study", "West Wing", "Strictly silent zone with historic architecture."),
        StudyLocation(6, "Innovation Lab", "Tech", "East Campus", "Equipped with 3D printers and dual-monitor stations."),
        StudyLocation(7, "Art Studio", "Creative", "Fine Arts Building", "Spacious desks with excellent natural lighting."),
        StudyLocation(8, "Study Pods", "Focus", "Library 2nd Floor", "Soundproof pods for video calls and intense focus."),
        StudyLocation(9, "Dining Hall", "Casual Study", "North Campus", "Convenient between classes, good for light review."),
        StudyLocation(10, "Math Center", "Tutoring", "Science Building", "Walk-in help and group tables for problem sets."),
        StudyLocation(11, "Language Lounge", "Social", "Humanities Hall", "Practice languages or study in a conversational setting."),
        StudyLocation(12, "Roof Garden", "Outdoor", "Student Union", "Scenic views and fresh air, great for stress relief.")
    )

    fun incrementHours() { _studyHours.update { it + 1 } }
    fun decrementHours() { _studyHours.update { if (it > 0) it - 1 else 0 } }
    fun resetHours() { _studyHours.value = 0 }
    fun selectLocation(location: StudyLocation?) { _selectedLocation.value = location }
}
