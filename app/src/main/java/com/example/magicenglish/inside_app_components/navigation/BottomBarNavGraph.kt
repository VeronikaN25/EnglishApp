package com.example.magicenglish.inside_app_components.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.magicenglish.grammar_trainer.data.GrammarTrainerContent
import com.example.magicenglish.inside_app_components.main_screen.HomeScreen
import com.example.magicenglish.inside_app_components.main_screen.NotesScreen

@Composable
 fun BottomBarNavGraph(navController: NavHostController){
    NavHost(navController, startDestination = NavigationItems.Home.route) {
        composable(NavigationItems.Home.route) {
            HomeScreen{
                navController.navigate("grammar_trainer_content")
            }
        }
        composable("grammar_trainer_content") {
            GrammarTrainerContent(navController)
        }

        composable(NavigationItems.Note.route) {
            NotesScreen()
        }
        composable(NavigationItems.Profile.route) {

        }
    }
}
