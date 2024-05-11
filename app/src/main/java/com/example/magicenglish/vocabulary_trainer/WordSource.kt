package com.example.magicenglish.vocabulary_trainer

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



class WordSource(private val client: HttpClient = AppHttpClient) {

    suspend fun load(): List<Word> = withContext(Dispatchers.IO) {
        client.getRemoteWords()
            .lineSequence()
            .map { Word( it) }
            .toList()
    }
}
private suspend fun HttpClient.getRemoteWords(): String =
    get("https://pablisco.com/define/words").toString()
