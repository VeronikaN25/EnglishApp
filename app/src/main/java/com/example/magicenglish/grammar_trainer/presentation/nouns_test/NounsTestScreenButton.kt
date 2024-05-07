package com.example.magicenglish.grammar_trainer.presentation.nouns_test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.magicenglish.grammar_trainer.action.ActionTestScreen
import com.example.magicenglish.grammar_trainer.action.ActionTestScreenActivity
import com.example.magicenglish.grammar_trainer.action.TestQuestion
import com.example.magicenglish.grammar_trainer.action.nounsTestQuestion

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NounsTestScreenButton(navController: NavController) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var isTestStarted by remember { mutableStateOf(false) }
        if (isTestStarted) {
            val intent = Intent(context, ActionTestScreenActivity::class.java)
            context.startActivity(intent)
        } else {
            Text(text = "Are you ready?\nLet's start the test.", fontSize = 35.sp)
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = { isTestStarted = true },
                modifier = Modifier.fillMaxWidth().padding(25.dp)
            ) {
                Text(text = "Start test", fontSize = 20.sp)
            }
        }
    }
}
