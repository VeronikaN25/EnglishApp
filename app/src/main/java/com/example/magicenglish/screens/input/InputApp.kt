package com.example.magicenglish.screens.input

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Visibility
import androidx.lifecycle.ViewModel
import com.example.magicenglish.ui.theme.MagicEnglishTheme

class InputAppActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            InputApp()
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun InputApp(){

    var email= mutableStateOf("")
    var password = mutableStateOf("")

    val passwordVisibility= mutableStateOf(false)

    fun togglePasswordVisibility(){
        passwordVisibility.value=!passwordVisibility.value
    }

    MagicEnglishTheme {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFF0D47A1), Color(0xFF64B5F6)),
                        startY = 1000f,
                        endY = 0f
                    )
                )
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Magic English",
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    fontSize = 55.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(46.dp))
                Card(
                    modifier = Modifier.padding(16.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        TextField(
                            value = email.value,
                            onValueChange = {email.value=it},
                            label = { Text(text = "Email")}
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        TextField(
                            value = password.value,
                            onValueChange = {password.value=it},
                            label = { Text(text = "Password")},
                            visualTransformation = if(passwordVisibility.value) VisualTransformation.None
                            else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = { togglePasswordVisibility()}) {
                                    Icon(
                                        imageVector = if (passwordVisibility.value)
                                            Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                        contentDescription = "Toggle Icon"
                                    )
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                Row(
                    modifier = Modifier.padding(top=45.dp)
                ){
                    Button(
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            modifier = Modifier.padding(start=26.dp,end=26.dp),
                            text = "SIGN IN",
                            fontSize = 16.sp)
                    }
                }
            }
        }
    }
}