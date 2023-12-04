import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myandroidapp.data.quote.data_source.QuoteDataSource
import com.example.myandroidapp.presentation.home.QuoteCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(

                title = {
                    Text("Top app bar", color = Color.White)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xff2A08F8))

            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(QuoteDataSource().showListQuotes().size) { index ->
                QuoteCard(quote = QuoteDataSource().showListQuotes()[index].quote)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPreview() {
    HomeScreen()
}