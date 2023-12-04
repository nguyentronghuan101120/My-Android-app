package com.example.myandroidapp.presentation.quote_detail

import Route
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable()
fun QuoteDetailScreen(quoteId: Int, navController: NavController = rememberNavController()) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Box() {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .background(color = Color.Green)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    IconButton(
                        { navController.popBackStack() },
                    ) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "",
                            modifier = Modifier
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(24.dp)
                                )
                                .padding(8.dp),
                        )
                    }

                    IconButton(
                        {
                            navController.navigate(route = Route.AddNewQuote.route)
                        },
                    ) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "",
                            modifier = Modifier
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(24.dp)
                                )
                                .padding(8.dp),
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = quoteId.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable()
fun Preview() {
    QuoteDetailScreen(1)
}
