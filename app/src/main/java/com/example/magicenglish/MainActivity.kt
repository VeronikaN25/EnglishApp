package com.example.magicenglish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.magicenglish.bigineer_app_screens.BeginScreen
import com.example.magicenglish.grammar_trainer.presentation.nouns_test.view.NounsTestScreen

import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
//           SplashScreen()
//            RegistrationScreen()
//            AccountScreen()
//            MainScreen()
//            GrammarTrainerContent()
            NounsTestScreen()
        }
    }
}

@Composable
fun SplashScreen(){
    val isLoading = remember { mutableStateOf(false) }
    val isError = remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        try {
            isLoading.value = true
            delay(2000)
            isLoading.value = false
        }catch (e:Exception){
            isError.value = true
            isLoading.value = false
        }
    }
    if (isLoading.value) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }else if(isError.value){
        AlertDialog(
            onDismissRequest = {
                // Закрытие диалога
                isError.value = false
            },
            title = {
                Text(text = "Error loading data")
            },
            text = {
                Text(text = "An error occurred while uploading the data. Please try again.")
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Повторная попытка загрузки данных
                        isError.value = false
                        isLoading.value = true
                    }
                ) {
                    Text("Replay")
                }
            }
        )
    }
    else{
        BeginScreen()
    }
}