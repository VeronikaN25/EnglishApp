package com.example.magicenglish.bigineer_app_screens.action_fun


import androidx.compose.runtime.mutableStateOf

data class Account(
    val email: String,
    val username: String,
    val password: String
)
object ActionFun {
    var email = mutableStateOf("")
    var username = mutableStateOf("")
    var password = mutableStateOf("")
    var repeatePassword = mutableStateOf("")
    val passwordVisibility= mutableStateOf(false)
    fun togglePasswordVisibility(){
        passwordVisibility.value=!passwordVisibility.value
    }
}