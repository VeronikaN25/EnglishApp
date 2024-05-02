package com.example.magicenglish.grammar_trainer.data.repository

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.magicenglish.grammar_trainer.data.model.Utils.cardList
import com.example.magicenglish.ui.theme.Green
import com.example.magicenglish.ui.theme.Lavender
import com.example.magicenglish.ui.theme.Light


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarGrammarTrainer(){
   TopAppBar(
       colors = TopAppBarDefaults.topAppBarColors(containerColor = Light, titleContentColor = Color.White, navigationIconContentColor = Color.White),
       navigationIcon = {
           IconButton(onClick = { /*TODO*/ }) {
               Icon(Icons.Filled.ArrowBack,contentDescription = null)
           }
       },
       title = { Text(text = "Grammar Trainer") },
   )
}
@Preview(showBackground = true)
@Composable
fun GrammarTrainerContent(){
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .padding(horizontal = 20.dp)
    ) {
        TopAppBarGrammarTrainer()
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ){
            items(cardList){card->
               CardItem(navController = navController,card = card)
            }
        }
    }
}
@Composable
fun CardItem(card: String,navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {

            },
        colors = CardDefaults.cardColors(containerColor = Lavender),
        border = BorderStroke(1.dp, color = Green)
    ) {
        Text(
            text = card,
            modifier = Modifier.padding(16.dp)
        )
    }
}