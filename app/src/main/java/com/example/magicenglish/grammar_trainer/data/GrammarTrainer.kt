package com.example.magicenglish.grammar_trainer.data

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.magicenglish.grammar_trainer.action.TestScreenButton
import com.example.magicenglish.ui.theme.Light
import com.example.magicenglish.ui.theme.LightSalmon
import com.example.magicenglish.ui.theme.Orange


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrammarTrainerContent(navController: NavController){
    val navController = rememberNavController()
    val selectedCard = remember{ mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = LightSalmon),
                windowInsets = TopAppBarDefaults.windowInsets,
                navigationIcon = {
                    if (selectedCard.value != null) {
                        IconButton(onClick = {
                            selectedCard.value = null
                        }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = null)
                        }
                    } else {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = null)
                        }
                    }
                },
                title = { Text(text = selectedCard.value?: "Grammar Trainer") },
            )
        },
        content = {
            if (selectedCard.value == null) {
                CardListScreen { card ->
                    selectedCard.value = card.toString()

                }
            } else {
                CardDetailScreen(selectedCard.value!!){
                   when(selectedCard.value){
                       CardType.NOUNS.toString() -> navController.navigate("nouns_test_screen")
                       CardType.PRONOUNS.toString() -> navController.navigate("pronouns_test_screen")
                       //other

                   }
                }
            }
        }
    )
}
@Composable
fun CardDetailScreen(cardType: String, onStartTest: () -> Unit) {
    TestScreenButton {
        onStartTest
    }
}
@Composable
fun CardListScreen(onCardSelected: (CardType) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 70.dp)
    ) {
        items(CardType.values()) { cardType ->
            CardItem(cardType) {
                onCardSelected(cardType)
            }
        }
    }
}
@Composable
fun CardItem(cardType: CardType, onClick: () -> Unit) {
    Card(
        border = BorderStroke(width = 1.5.dp, color = Orange),
        colors = CardDefaults.cardColors(containerColor = Light),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onClick()
            },
    ) {
        Text(
            text = cardType.title,
            modifier = Modifier.padding(16.dp),
            color = Color.Black,
            fontSize = 17.sp
        )
    }
}

