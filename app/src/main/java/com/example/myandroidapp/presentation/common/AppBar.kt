package com.example.myandroidapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AppBar(
    isMenu: Boolean = false,
    navController: NavController = rememberNavController(),
    additionalWidget:  @Composable () -> Unit ,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(color = Color.White), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = {
            if (isMenu) {/*TODO*/
            } else {
                navController.popBackStack()
            }
        }) {
            Icon(
                imageVector = if (isMenu) Icons.Filled.Menu else Icons.Filled.ArrowBack,
                contentDescription = ""
            )
        }

        additionalWidget()

    }

}

@Preview
@Composable
fun Preview() {
//    AppBar()
}