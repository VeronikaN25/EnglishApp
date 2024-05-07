package com.example.magicenglish

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.magicenglish.bigineer_app_screens.BeginScreen
import com.example.magicenglish.bigineer_app_screens.BeginScreenActivity
import com.example.magicenglish.grammar_trainer.action.ActionTestScreen
import com.example.magicenglish.grammar_trainer.action.nounsTestQuestion
import com.example.magicenglish.grammar_trainer.presentation.nouns_test.NounsTestScreenButton


import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val context = this@MainActivity
            val isLoading = remember { mutableStateOf(false) }
            val isError = remember { mutableStateOf(false) }
            val composition by rememberLottieComposition(
                spec = LottieCompositionSpec.RawRes(R.raw.splach_screen)
            )

            val progress by animateLottieCompositionAsState(
                composition = composition,
                iterations = LottieConstants.IterateForever
            )

            LaunchedEffect(key1 = true) {
                if (isNetworkAvailable(context)) {
                    try {
                        isLoading.value = true
                        delay(3000)
                        isLoading.value = false
                    } catch (e: Exception) {
                        isError.value = true
                        isLoading.value = false
                    }
                } else {
                    isError.value = true
                }
            }
            if (isLoading.value) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    LottieAnimation(
//                        modifier = Modifier.size(150.dp),
                        composition = composition,
                        progress = { progress }
                    )
                }
            } else if (isError.value) {
                AlertDialog(
                    onDismissRequest = {
                        // Закрытие диалога
                        isError.value = false
                    },
                    title = {
                        Text(text = "Error loading data")
                    },
                    text = {
                        Text(text = "An error occurred while uploading the data.\nPlease check your internet connection and try again.")
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                // Повторная попытка загрузки данных
                                isError.value = false
                                if (isNetworkAvailable(context)) {
                                    isLoading.value = true
                                } else {
                                    isError.value = true
                                }
                            }
                        ) {
                            Text("Replay")
                        }
                    }
                )
            } else {
                val intent = Intent(this,BeginScreenActivity::class.java)
                startActivity(intent)
            }
        }
    }
}


fun isNetworkAvailable(context : Context):Boolean{
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}