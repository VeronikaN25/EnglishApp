package com.example.magicenglish.vocabulary_trainer

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class WordRepository(
    private val wordSource: WordSource,
    private val wordStore: WordStore,
) {
    constructor(database: AppDatabase) : this(
        wordSource = WordSource(),
        wordStore = WordStore(database),
    )
    suspend fun allWords():Flow<PagingData<Word>> = wordStore.ensureIsNotEmpty().all()
    suspend fun allWords(term: String): Flow<PagingData<Word>> =
        wordStore.ensureIsNotEmpty().all(term)

    private suspend fun WordStore.ensureIsNotEmpty() = apply {
        if (isEmpty()) {
            val words = wordSource.load()
            save(words)
        }
    }
}
