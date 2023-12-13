import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myandroidapp.presentation.common.AppBar
import com.example.myandroidapp.presentation.home.QuoteCard
import com.example.myandroidapp.presentation.home.view_model.HomeViewModel

@Composable
fun HomeScreen(navController: NavController = rememberNavController(), text: String) {

    val viewModel = hiltViewModel<HomeViewModel>()

    viewModel.getUsers()

    val state by viewModel.state.collectAsState()

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
            if (state.isEmpty()) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()

                    )
                }
            }
            items(state) { user ->
                QuoteCard(
                    quote = user.name,
                    onClick = { })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPreview() {
//    HomeScreen()
}