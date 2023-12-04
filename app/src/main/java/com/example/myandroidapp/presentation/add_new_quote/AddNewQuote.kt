package com.example.myandroidapp.presentation.add_new_quote

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myandroidapp.presentation.common.AppBar

@Composable
fun AddNewQuoteScreen(navController: NavController = rememberNavController()) {
    Column {
//        AppBar(navController = navController)

        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Quote image")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "",
                    modifier = Modifier.background(color = Color(0.2f, 0.2f, 0.2f, 2f)).height(20.dp).width(20.dp),tint = Color.White
                )
            }
            Text(text = "Quote content")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    AddNewQuoteScreen()
}