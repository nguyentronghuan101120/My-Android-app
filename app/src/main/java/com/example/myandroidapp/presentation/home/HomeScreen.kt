import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myandroidapp.data.user.models.reponses.UserResponse
import com.example.myandroidapp.presentation.common.AppBar
import com.example.myandroidapp.presentation.home.QuoteCard
import com.example.myandroidapp.presentation.home.view_model.HomeViewModel


@Composable
fun HomeScreen(navController: NavController = rememberNavController(), text: String) {

    val viewModel = hiltViewModel<HomeViewModel>()

    val state by viewModel.users.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getUsers()
    }



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


        when (state) {
            is HomeState.Loading -> {
                // Show loading indicator
                CircularProgressIndicator()
            }

            is HomeState.Success -> {
                val users = (state as HomeState.Success<List<UserResponse>>).data
                // Display the fetched data using Jetpack Compose components
                LazyColumn(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    if (users.isEmpty()) {
                        item {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .fillMaxSize()

                            )
                        }
                    }

                    items(users) { user ->
                        QuoteCard(
                            quote = user.name,
                            onClick = { })
                    }
                }
            }

            is HomeState.Error -> {
                val error = (state as HomeState.Error).message
                // Show error message
                Text(
                    text = "Failed to fetch data: $error",
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }

            else -> {}
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShowPreview() {
//    HomeScreen()
}