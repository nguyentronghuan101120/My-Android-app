// QuoteViewModel.kt
import androidx.lifecycle.ViewModel
import com.example.myandroidapp.data.quote.data_source.QuoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val quoteDataSource: QuoteDataSource
) : ViewModel() {
    // Your ViewModel logic here
}