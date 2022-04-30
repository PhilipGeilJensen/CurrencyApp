package com.example.currency.currency

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.currency.calculator.models.Rates

/**
 * The CurrencyDialog is the dialog view which appears when changing the base currency.
 * @param open Boolean for whether or not the dialog should be appearing
 * @param onDismissRequest Callback for what should happen when the dismiss request has been called.
 * @param rates The Rates object which contains the list of valid currencies
 * @param updateRates Callback for when a currency has been selected
 */
@Composable
fun CurrencyDialog(
    open: Boolean,
    onDismissRequest: () -> Unit,
    rates: Rates,
    updateRates: (String) -> Unit
) {
    if (open) {
        Dialog(onDismissRequest = onDismissRequest) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(16.dp),
                color = Color.LightGray
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    LazyColumn() {
                        items(rates.Rates.toList()) { item ->
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp)
                                    .clickable {
                                        updateRates(item.first)
                                        onDismissRequest()
                                    },
                            ) {
                                Text(text = item.first)
                            }
                        }
                    }
                }
            }
        }

    }
}