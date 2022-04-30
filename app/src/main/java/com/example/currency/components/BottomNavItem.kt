package com.example.currency.components

import com.example.currency.R

sealed class BottomNavItem(
    var title: String, var icon: Int, var screen_route: String
) {
    object Home : BottomNavItem("Home", R.drawable.home, "home")
    object Camera : BottomNavItem("Camera", R.drawable.camera, "camera")
}