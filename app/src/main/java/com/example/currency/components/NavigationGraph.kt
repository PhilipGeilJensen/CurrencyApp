package com.example.currency.components

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.currency.calculator.models.Rates
import com.example.currency.camera.CameraView
import com.example.currency.currency.CurrencyPage

/**
 * Defines the content of the routes.
 */
@Composable
fun NavigationGraph(navController: NavHostController, rates: Rates, updateRates: (String) -> Unit) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            CurrencyPage(rates, updateRates)
        }
        composable(BottomNavItem.Camera.screen_route) {
            CameraView(onImageCaptured = { uri, fromGallery ->
                Log.d(ContentValues.TAG, "Image Uri Captured from Camera View")
                println(uri)
            }, onError = { imageCaptureException ->
                println(imageCaptureException)
            })
        }
    }
}