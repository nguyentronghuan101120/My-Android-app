import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
