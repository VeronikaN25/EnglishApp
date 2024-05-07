package com.example.magicenglish.bigineer_app_screens

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.magicenglish.R
import com.example.magicenglish.ui.theme.BorderColor
import com.example.magicenglish.ui.theme.BrandColor
import com.example.magicenglish.ui.theme.Green
import com.example.magicenglish.ui.theme.Light
import com.example.magicenglish.ui.theme.MidnightBlue
import com.example.magicenglish.ui.theme.Tertirary

class BeginScreenActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeginScreen()
        }
    }
}

@Composable
fun BeginScreen() {
    val context= LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            alignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.begin_screens),
            contentDescription = null
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        )
        {
            Column() {
                Card(
                    modifier = Modifier.padding(top=105.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 35.dp),
                        horizontalArrangement = Arrangement.Center) {
                        Text(
                            fontWeight = FontWeight.Bold,
                            color = Green,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily.Cursive,
                            fontSize = 45.sp ,
                            text = "Learn English with Panda")
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 25.dp, end = 25.dp),
                            onClick = {
                                val intent=Intent(context,LogInScreenActivity::class.java)
                                context.startActivity(intent)
                            },
                            colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Light)
                        ) {
                            Text(
                                fontSize = 20.sp,
                                text = "Log In")
                        }
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 25.dp, end = 25.dp),
                            colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Light),
                            onClick = {
                                val intent=Intent(context,RegistrationScreenActivity::class.java)
                                context.startActivity(intent)
                            }
                        ) {
                            Text(
                                fontSize = 20.sp,
                                text = "Sign Up")
                        }
                    }

                }
            }
        }
    }
}


