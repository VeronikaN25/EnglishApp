package com.example.magicenglish.components.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun NotesScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp),
        ) {
        Text(
            text = "Notes",
            fontSize = 40.sp
        )
        Divider(color = Color.Black, modifier = Modifier.padding(top=10.dp))
    }
}
