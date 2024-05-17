package com.example.magicenglish.inside_app_components.main_screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.magicenglish.inside_app_components.navigation.BottomBarNavGraph
import com.example.magicenglish.inside_app_components.navigation.BottomNavigationBar

class MainScreenActivity :ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Preview(showBackground = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
           BottomNavigationBar(navController = navController)
        }
    ) { it
        BottomBarNavGraph(navController = navController)
    }
}