package com.example.myandroidapp.data.quote.data_source

import com.example.myandroidapp.data.quote.models.QuoteModel

class QuoteDataSource {
    fun showListQuotes(): List<QuoteModel> {
        return List<QuoteModel>(100){
            index -> QuoteModel(quote = "Quote: $index", id = index)
        }
    }
}