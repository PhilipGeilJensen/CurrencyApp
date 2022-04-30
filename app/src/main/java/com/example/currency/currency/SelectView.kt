package com.example.currency.currency

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.currency.calculator.models.Rates

/**
 * The component for selecting currency and value.
 */
@Composable
fun Select(
    text: TextFieldValue,
    onChange: (TextFieldValue) -> Unit,
    rates: Rates,
    updateRates: (String) -> Unit
) {
    val openDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(text = "Select currency")
        Text(text = rates.Base, modifier = Modifier.clickable { openDialog.value = true })
        Text(text = "Enter amount")
        OutlinedTextField(
            value = text,
            label = { Text(text = "Amount") },
            placeholder = { Text(text = "eg 100") },
            onValueChange = onChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
    CurrencyDialog(
        open = openDialog.value,
        onDismissRequest = { openDialog.value = false },
        rates = rates,
        updateRates
    )
}