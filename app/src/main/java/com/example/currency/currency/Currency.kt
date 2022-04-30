package com.example.currency.currency

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currency.calculator.models.Rates

/**
 * The page view of the currency calculator
 * @param rates The Rates object which keeps the data fetched from the API
 * @param updateRates Callback for updating the rates.
 */
@Composable
fun CurrencyPage(rates: Rates, updateRates: (String) -> Unit) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    println("Text:")
    println(text.text.isEmpty())
    Box(
        Modifier
            .padding(16.dp)
            .fillMaxSize(),
    ) {
        Column {
            Select(text, { newValue -> text = newValue }, rates, updateRates)
            Text(
                text = "Currencies",
                fontSize = 22.sp,
                fontFamily = FontFamily.Serif,
            )

            if (text.text.isNotEmpty()) {
                LazyColumn() {
                    items(rates.Rates.toList()) { item ->
                        CurrencyLine(map = item, text.text)
                    }
                }
            }
        }
    }
}