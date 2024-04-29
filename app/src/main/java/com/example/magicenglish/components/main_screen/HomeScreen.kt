package com.example.magicenglish.components.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier
                    .size(125.dp)
                    .padding(end = 8.dp),
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 35.dp, horizontal = 15.dp),
                    text = "Grammar\nTrainer"
                )
            }
            Card(
                modifier = Modifier
                    .size(125.dp)
                    .padding(start = 8.dp),
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 35.dp, horizontal = 15.dp),
                    text = "Vocabulary\nTrainer"
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Card(
                modifier = Modifier
                    .size(125.dp)
                    .padding(end = 8.dp),
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 35.dp, horizontal = 15.dp),
                    text = "Listening\nTrainer"
                )
            }
            Card(
                modifier = Modifier
                    .size(125.dp)
                    .padding(start = 8.dp),
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 35.dp, horizontal = 15.dp),
                    text = "Collection\nTrainer"
                )
            }
        }

    }
}