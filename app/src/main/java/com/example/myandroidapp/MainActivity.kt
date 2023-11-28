package com.example.myandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAndroidAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    LoginPage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally)
    {
        Box(
            modifier = Modifier.padding(
                top = 72.dp,
                start = 162.dp,
                end = 162.dp,
                bottom = 30.dp
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_logo),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp, 50.dp),
            )
        }
        Text(text = "You must sign in to join", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(bottom = 16.dp))
        Text(
            text = "We’re a Team That Guides Each Other",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFFB1B1B1)
        )
        Spacer(modifier = Modifier.padding(bottom = 50.dp))

        AppTextField(
            icon = Icons.Filled.Person,
            placeHolder = "Uname@mail.com",
            label = "Email or Username",
        )
        Spacer(modifier = Modifier.padding(bottom = 24.dp))

        AppTextField(icon = Icons.Filled.Lock, placeHolder = "Password", label = "Password")

        Spacer(modifier = Modifier.padding(bottom = 30.dp))
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 32.dp)
        ) {
            Text(
                text = "Forgot password?",
                fontSize = 12.sp,
                color = Color(0xff818ED5),
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 30.dp))

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff2A08F8)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
                .height(44.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(
                text = "Sign in",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 40.dp))

        Row {
            Text(
                text = "Dont have an account? ",
                color = Color(0xffD1D1D1),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Sign up",
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable()
fun AppTextField(icon: ImageVector, placeHolder: String, label: String) {
    Column(modifier = Modifier.padding(start = 32.dp, end = 32.dp)) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = Color(0xffB1B1B1),
        )
        Spacer(modifier = Modifier.padding(bottom = 8.dp))

        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()

                .background(color = MaterialTheme.colorScheme.background)
                .border(
                    width = 1.dp,
                    color = Color(0xFFB1B1B1),
                    shape = RoundedCornerShape(8.dp) // Adjust the corner radius as needed
                ),

            leadingIcon = {
                Icon(
                    icon,
                    contentDescription = null,
                    tint = Color(0xffDFDCDC)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White, disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    placeHolder, fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB1B1B1)
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PagePreview() {
    MyAndroidAppTheme {
        LoginPage()
    }
}