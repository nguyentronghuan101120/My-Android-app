import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myandroidapp.R
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme

@Composable
fun LoginPage(modifier: Modifier = Modifier, onPress: () -> Unit = {}) {
    val navController = rememberNavController()

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
        Text(
            text = stringResource(R.string.you_must_sign_in_to_join),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(bottom = 16.dp))
        Text(
            text = stringResource(R.string.we_re_a_team_that_guides_each_other),
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFFB1B1B1)
        )
        Spacer(modifier = Modifier.padding(bottom = 50.dp))

        AppTextField(
            icon = Icons.Filled.Person,
            placeHolder = stringResource(R.string.uname_mail_com),
            label = stringResource(R.string.email_or_username),
        )
        Spacer(modifier = Modifier.padding(bottom = 24.dp))

        AppTextField(
            icon = Icons.Filled.Lock,
            placeHolder = stringResource(R.string.password),
            label = stringResource(R.string.password)
        )

        Spacer(modifier = Modifier.padding(bottom = 30.dp))
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 32.dp)
        ) {
            Text(
                text = stringResource(R.string.forgot_password),
                fontSize = 12.sp,
                color = Color(0xff818ED5),
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 30.dp))

        Button(
            onClick = {
                navController.navigate(Route.Home.route)

            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff2A08F8)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
                .height(44.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(
                text = stringResource(R.string.sign_in),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 40.dp))

        Row {
            Text(
                text = stringResource(R.string.dont_have_an_account),
                color = Color(0xffD1D1D1),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(R.string.sign_up),
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PagePreview() {
    MyAndroidAppTheme {
        LoginPage()
    }
}