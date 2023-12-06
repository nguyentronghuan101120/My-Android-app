import com.example.myandroidapp.data.quote.data_source.QuoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
object AppModule {
    @Provides
    fun provideQuoteDataSource(): QuoteDataSource = QuoteDataSource()
}