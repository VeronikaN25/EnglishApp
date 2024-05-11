package com.example.magicenglish.vocabulary_trainer

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import kotlinx.coroutines.flow.Flow


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WordListUi(
    words: Flow<PagingData<Word>>,
    search: String?,
    onSearch: (String?) -> Unit) {
    Scaffold(
        topBar = {
            SearchBar(
                search = search,
                onSearch = onSearch
            )
        },
        content = {
            WordsContent(
                words = words,
                onSelected = {word -> Log.e("WordsContent","Selected: $word") }
            )
        }
    )
}
@Composable
private fun WordsContent(
    words: Flow<PagingData<Word>>,
    onSelected: (Word) -> Unit,
) {
    val items: LazyPagingItems<Word> = words.collectAsLazyPagingItems()
    LazyColumn {
        items(items){word->
            if(word!=null){
                WordColumnItem(
                    word = word
                ) { onSelected(word)}
            }
        }
        if (items.itemCount==0){
            item { EmptyContent() }
        }
    }
}
@Composable
private fun LazyItemScope.EmptyContent() {
    Box(
        modifier = Modifier.fillParentMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "No words")
    }
}
@Composable
private fun WordColumnItem(
    word: Word,
    onClick: ()->Unit){
    Row(
        modifier = Modifier.clickable { onClick }
    ) {
        Text(modifier = Modifier
            .padding(16.dp)
            .weight(1f),
            text = word.value
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(actions: @Composable RowScope.()->Unit={}){
    TopAppBar(
        title = { Text(text = "Words") },
        actions = actions
    )
}
@Composable
fun BackIcon(onClick: () -> Unit){
    IconButton(
        onClick = {onClick},
        content = {
            Icon(
                imageVector = Icons.Filled.ArrowBack, contentDescription = "back"
            )
        }
    )
}
@Composable
fun SearchIcon(onClick: () -> Unit){
    IconButton(
        onClick = {onClick},
        content = {
            Icon(
                imageVector = Icons.Filled.Search, contentDescription = "search"
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(search: String?,onSearch: (String?) -> Unit){
    when(search){
        null-> MainTopBar(actions={ SearchIcon{ onSearch("")}})
        else-> TopAppBar(
            title = {
                SearchtextField(search, onSearch)
            },
            navigationIcon = {
                BackHandler { onSearch(null) }
                BackIcon { onSearch(null) }
            },
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SearchtextField(search: String,onSearch: (String?) -> Unit){
    val textFieldColors = TextFieldDefaults.textFieldColors()
    val focusRequester = remember{FocusRequester()}
//    val cursorColor = TextFieldDefaults.textFieldColors().cursorColor(isError = false ).value
    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester),
        value = search,
        onValueChange = onSearch,
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
//        cursorBrush = SolidColor(cursorColor),
    )
    LaunchedEffect(Unit){
        if(search.isEmpty()){
            focusRequester.requestFocus()
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoadingUi(){
    Scaffold(
        topBar = { MainTopBar()},
        content = { LoadingIndicator()}
    )
}
@Composable
fun LoadingIndicator(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        CircularProgressIndicator()
    }
}