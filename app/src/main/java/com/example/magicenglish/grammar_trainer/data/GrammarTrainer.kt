package com.example.magicenglish.grammar_trainer.data

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.magicenglish.grammar_trainer.presentation.nouns_test.NounsTestScreenButton
import com.example.magicenglish.ui.theme.Green
import com.example.magicenglish.ui.theme.Lavender
import com.example.magicenglish.ui.theme.Light
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GrammarTrainerActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GrammarTrainerContent()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarGrammarTrainer(navController: NavController){
   TopAppBar(
       colors = TopAppBarDefaults.topAppBarColors(containerColor = Light, titleContentColor = Color.White, navigationIconContentColor = Color.White),
       navigationIcon = {
           IconButton(onClick = {
               navController.navigateUp()
           }) {
               Icon(Icons.Filled.ArrowBack,contentDescription = null)
           }
       },
       title = { Text(text = "Grammar Trainer") },
   )
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun GrammarTrainerContent() {
    val navController = rememberNavController()
        Column(
            modifier = Modifier
                .fillMaxSize()
//            .padding(horizontal = 20.dp)
        ) {
            TopAppBarGrammarTrainer(navController = navController)
            Spacer(modifier = Modifier.height(20.dp))
            NavHost(navController, startDestination = "main_screen") {
                // другие маршруты
                composable("main_screen") {
                    CardItemList(navController = navController)
                }
                composable("nouns_test_screen") {
                    NounsTestScreenButton(navController = navController)
                }
                // другие экраны
            }
        }
    }
@Composable
fun CardItemList(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ){
            items(cardList){ card->
                CardItem(card = card, navController = navController)
            }
        }
    }
}
@Composable
fun CardItem(card: String, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                when (card) {
                    "Nouns" -> navController.navigate("nouns_test_screen")
                    "Pronouns" -> navController.navigate("pronouns_screen")
                    // добавьте другие карточки, если нужно
                }
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