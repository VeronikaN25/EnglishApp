package com.example.magicenglish

import android.content.Intent
import android.os.Bundle
import android.text.Layout.Alignment
import android.util.Log
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.magicenglish.screens.input.InputAppActivity
import com.example.magicenglish.screens.login_screen.LoginScreen
import com.example.magicenglish.ui.theme.MagicEnglishTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }
    }
}
@Composable
fun SplashScreen(){
    val isLoading = remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        isLoading.value = true
        delay(2000)
        isLoading.value = false
    }
    if (isLoading.value) {

        CircularProgressIndicator()
    } else{
        LoginScreen()
    }
}