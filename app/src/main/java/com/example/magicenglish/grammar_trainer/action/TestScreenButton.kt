package com.example.magicenglish.grammar_trainer.action

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.magicenglish.ui.theme.Orange

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TestScreenButton(onClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var isTestStarted by remember { mutableStateOf(false) }
        if (isTestStarted) {

        } else {
            Text(text = "Are you ready?\nLet's start the test.", fontSize = 35.sp, lineHeight = 45.sp)
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Orange, contentColor = Color.Black),
                onClick = {
                    isTestStarted = true
                    onClick
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp)
                    .size(50.dp),
                elevation = ButtonDefaults.buttonElevation(5.dp)
            ) {
                Text(text = "Start test", fontSize = 20.sp)
            }
        }
    }
}