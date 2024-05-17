package com.example.magicenglish.inside_app_components.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.magicenglish.R
import com.example.magicenglish.ui.theme.DarkBlue
import com.example.magicenglish.ui.theme.LightSalmon
import com.example.magicenglish.ui.theme.Moccasin
import com.example.magicenglish.ui.theme.PaleGoldenrod


@Composable
fun HomeScreen(
    onClick: () -> Unit,
){
    Column(
        modifier = Modifier
//            .fillMaxHeight()
            .padding(20.dp),
    ) {
        Text(
            text = "Home",
            fontSize = 40.sp,
            color = DarkBlue,
            fontWeight = FontWeight.Bold
        )
        Divider(color = DarkBlue, modifier = Modifier.padding(top=10.dp), thickness = 1.5.dp)
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
                        onClick()
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Moccasin,
                )
            ) {
                Row {
                    Text(
                        text = "Grammar Trainer", fontSize = 25.sp,
                        modifier = Modifier
                            .padding(vertical = 26.dp, horizontal = 16.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.grammar_trainer),
                        contentDescription = "grammar"
                    )
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp)
                    .clickable {
                        onClick
                    },
                colors = CardDefaults.cardColors(containerColor = PaleGoldenrod)
            ) {
                Row {
                    Text(
                        text = "Vocabulary Trainer",
                        fontSize = 25.sp,
                        modifier = Modifier
                            .padding(vertical = 26.dp, horizontal = 10.dp)
                    )
                    Image(painter = painterResource(id = R.drawable.dictionary), contentDescription = "vocabulary")
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(120.dp),
                colors = CardDefaults.cardColors(
                    containerColor = LightSalmon
                )
            ) {
                Row {
                    Text(
                        text = "Collection Trainer",
                        fontSize = 25.sp,
                        modifier = Modifier.padding(vertical = 26.dp, horizontal = 16.dp)
                    )
                }
            }
        }
    }
}