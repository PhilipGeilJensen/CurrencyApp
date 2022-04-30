package com.example.currency.layout

import android.content.Context
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.currency.calculator.models.Rates
import com.example.currency.components.BottomNavigation
import com.example.currency.components.NavigationGraph
import org.json.JSONObject

/**
 * This is the main content which sets the layout for the app. Containing the Scaffold and the bottom navigation bar.
 * @param context Takes the context as a parameter to be used in fetching the data.
 */
@Composable
fun MainContent(context: Context) {
    var rates = remember {
        mutableStateOf(Rates())
    }
    val navController = rememberNavController()
    fun fetchData(base: String, context: Context) {
        try {
// Request a string response from the provided URL.
            val url = "https://api.exchangerate.host/latest?base=$base"
            val queue = Volley.newRequestQueue(context)
            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                { response ->
                    var r: Rates = Rates()
                    var test: JSONObject = response["rates"] as JSONObject
                    test.keys().forEach { entry ->
                        r.Rates[entry] = test[entry].toString()
                    }
                    r.Base = response["base"].toString()
                    rates.value = r
                },
                { error ->
                    println(error)
                    println("It did not work")
                }

            )
            queue.add(jsonObjectRequest)
        } catch (e: Exception) {
            println(e)
        }
    }
    fetchData("DKK", context)
    Scaffold(
        content = {
            NavigationGraph(
                navController = navController,
                rates.value
            ) { base -> fetchData(base, context) }
        },

        bottomBar = {
            BottomNavigation(navController = navController)
        }
    )
}