package com.example.myandroidapp.data.quote.data_source

import com.example.myandroidapp.data.quote.models.QuoteModel

class QuoteDataSource {
//    fun showListQuotes(): List<QuoteModel> {
//        return List<QuoteModel>(100) { index ->
//            QuoteModel(quote = "Quote: $index", id = index)
//        }
//    }

    val data = mutableListOf<QuoteModel>(
        QuoteModel(quote = "Quote: 0", id = 0),
        QuoteModel(quote = "Quote: 1", id = 1),
        QuoteModel(quote = "Quote: 2", id = 2),
        QuoteModel(quote = "Quote: 3", id = 3),
        QuoteModel(quote = "Quote: 4", id = 4),
    )
}