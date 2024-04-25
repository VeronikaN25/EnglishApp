package com.example.magicenglish.screens.login_screen

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.magicenglish.screens.input.InputAppActivity
import com.example.magicenglish.ui.theme.MagicEnglishTheme


@Composable
fun LoginScreen() {
    val context= LocalContext.current

    MagicEnglishTheme {
        Surface {
            Box {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Magic English",
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                        fontSize = 55.sp,
                    )
                    Text(
                        modifier = Modifier.padding(15.dp),
                        text = "Learn English with fun",
                        fontSize = 18.sp,
                    )
                    Button(
                        modifier = Modifier.padding(top = 35.dp),
                        onClick = {
                            val intent=Intent(context,InputAppActivity::class.java)
                            context.startActivity(intent)
                        }
                    ) {
                        Text(
                            text = "Already have an account",
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Button(
                            modifier = Modifier
                                .padding(top = 125.dp),
                            onClick = {
                                 }
                        ) {
                            Text(
                                modifier = Modifier.padding(vertical = 8.dp, horizontal = 70.dp),
                                text = "Continue",
                                fontSize = 25.sp
                            )
                        }
                    }
                }
            }
        }
    }
}