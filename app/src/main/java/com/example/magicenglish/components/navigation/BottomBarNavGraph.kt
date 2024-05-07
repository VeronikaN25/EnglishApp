package com.example.magicenglish.components.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.magicenglish.components.main_screen.AccountScreen
import com.example.magicenglish.components.main_screen.HomeScreen
import com.example.magicenglish.components.main_screen.NotesScreen

@Composable
 fun BottomBarNavGraph(navController: NavHostController){
    NavHost(navController, startDestination = NavigationItems.Home.route) {
        composable(NavigationItems.Home.route) {
            HomeScreen()
        }
        composable(NavigationItems.Note.route) {
            NotesScreen()

        }
        composable(NavigationItems.Account.route) {
            AccountScreen()
        }
    }
}