package com.example.magicenglish.vocabulary_trainer

import io.ktor.client.*


val AppHttpClient: HttpClient by lazy {
    HttpClient()
}