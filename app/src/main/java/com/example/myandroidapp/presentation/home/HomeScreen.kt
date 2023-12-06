import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myandroidapp.data.quote.data_source.QuoteDataSource
import com.example.myandroidapp.presentation.common.AppBar
import com.example.myandroidapp.presentation.home.QuoteCard

@Composable
fun HomeScreen(navController: NavController = rememberNavController(), text: String) {

    Column {
        AppBar(
            navController = navController, isMenu = true,
        ) {
            IconButton(
                onClick = {
                    navController.navigate(Route.AddNewQuote.route)
                },
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "")
            }
        }


        LazyColumn(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(QuoteDataSource().data.size) { index ->
                QuoteCard(
                    quote = QuoteDataSource().data[index].quote,
                    onClick = { navController.navigate(Route.Detail.createRoute(index)) })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPreview() {
//    HomeScreen()
}