package com.example.foodonline.datasource.network

import io.ktor.client.*

expect class KtorClientFactory (){
    fun build(): HttpClient

}