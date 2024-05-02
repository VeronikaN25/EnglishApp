package com.example.magicenglish.components.main_screen

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.magicenglish.grammar_trainer.data.GrammarTrainerActivity
import com.example.magicenglish.grammar_trainer.data.GrammarTrainerContent
import com.example.magicenglish.ui.theme.BrandColor
import com.example.magicenglish.ui.theme.Lavender
import com.example.magicenglish.ui.theme.Pink80
import com.example.magicenglish.ui.theme.Purple80
import com.example.magicenglish.ui.theme.PurpleGrey80
import com.example.magicenglish.ui.theme.Tertirary

@Preview(showBackground = true)
@Composable
fun HomeScreen(){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp),
    ) {
        Text(
            text = "Home",
            fontSize = 40.sp
        )
        Divider(color = Color.Black, modifier = Modifier.padding(top=10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 45.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp)
                    .clickable {
                        val intent = Intent(context, GrammarTrainerActivity::class.java)
                        context.startActivity(intent)
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Purple80,
                )
            ) {
                Text(text = "Grammar Trainer", fontSize = 25.sp,
                    modifier = Modifier.padding(vertical = 26.dp, horizontal = 16.dp)
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Pink80,
                    )
            ) {
                Text(text = "Vocabulary Trainer" ,fontSize = 25.sp, modifier = Modifier.padding(vertical = 26.dp, horizontal = 16.dp))
            }
            Spacer(modifier = Modifier.height(25.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PurpleGrey80
                )
            ) {
                Text(text = "Collection Trainer", fontSize = 25.sp, modifier = Modifier.padding(vertical = 26.dp, horizontal = 16.dp))
            }
        }
    }
}