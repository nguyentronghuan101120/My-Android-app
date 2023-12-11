package com.example.myandroidapp.data.common

data class BaseResponse<T>(val data: T, val message: String, val status: Int) {
}