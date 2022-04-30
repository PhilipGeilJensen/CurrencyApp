package com.example.currency.currency

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CurrencyLine(map: Pair<String, String>, base: String) {
    println("Base:")
    println(base)
    var b: Double = 0.0
    try {
        b = base.toDouble()
    } catch (e: java.lang.Exception) {
        println(e)
    }
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
//        Image(painter = painterResource(id = R.drawable.dk), contentDescription = "dk")
        Text(text = map.first)
        Text(text = (map.second.toDouble() * b).toString())
        Spacer(modifier = Modifier.weight(1.0f))
        Icon(Icons.Filled.ArrowForward, contentDescription = "Arrow forward")
    }
}