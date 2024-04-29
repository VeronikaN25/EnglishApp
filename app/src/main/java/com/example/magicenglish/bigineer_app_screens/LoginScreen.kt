package com.example.magicenglish.bigineer_app_screens

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.magicenglish.R
import com.example.magicenglish.bigineer_app_screens.action_fun.ActionFun
import com.example.magicenglish.bigineer_app_screens.action_fun.ActionFun.passwordVisibility
import com.example.magicenglish.bigineer_app_screens.action_fun.ActionFun.togglePasswordVisibility
import com.example.magicenglish.ui.theme.BorderColor
import com.example.magicenglish.ui.theme.BrandColor
import com.example.magicenglish.ui.theme.Green
import com.example.magicenglish.ui.theme.MagicEnglishTheme
import com.example.magicenglish.ui.theme.Tertirary

class LogInScreenActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogInScreen()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@SuppressLint("UnrememberedMutableState")
@Composable
fun LogInScreen(){
    val context = LocalContext.current
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    fun PasswordVisibility(){
        passwordVisibility=!passwordVisibility
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 45.dp, horizontal = 27.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(250.dp),
            painter = painterResource(id = R.drawable.login),
            contentDescription = "login"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                fontSize = 45.sp,
                color = Green,
                fontWeight = FontWeight.Bold,
                text = "Log In"
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = BrandColor,
                unfocusedBorderColor = Tertirary,
                focusedLeadingIconColor = BrandColor,
                unfocusedLeadingIconColor = Tertirary
            ),
            label = { Text(text = "Email")},
            value = email,
            leadingIcon = {
                Icon(Icons.Filled.Email,contentDescription = null)
            },
            onValueChange = { email=it }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = BrandColor,
                unfocusedBorderColor = Tertirary,
                focusedLeadingIconColor = BrandColor,
                unfocusedLeadingIconColor = Tertirary
            ),
            value = password,
            label = { Text(text = "Password")},
            leadingIcon = {
               Icon(painter = painterResource(id = R.drawable.lock), contentDescription = null, modifier = Modifier.size(25.dp))
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation(),
            onValueChange = { password=it },
            trailingIcon = {
                IconButton(onClick = { PasswordVisibility() }) {
                    Icon(
                        imageVector = if (passwordVisibility)
                            Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                        contentDescription = "Toggle Icon"
                    )
                }
            },
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            Text(
                color = BrandColor,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                text = "Forgot password?"
            )
        }
        Spacer(modifier = Modifier.height(22.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = BrandColor, contentColor = Color.White),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Log In", fontSize = 20.sp)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                thickness = 1.dp,
                color = Tertirary
            )
            Text(
                text = "OR",
                modifier = Modifier.padding(10.dp),
                color = Tertirary,
                fontSize = 20.sp
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                thickness = 1.dp,
                color = Tertirary
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier.fillMaxWidth()) {
            Text(text = "Don't have an account?", fontSize = 15.sp)
            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .clickable {
                        val intent = Intent(context, RegistrationScreenActivity::class.java)
                        context.startActivity(intent)
                    },
                text = "Register", color = BrandColor,fontSize = 15.sp,

            )
        }
    }
}