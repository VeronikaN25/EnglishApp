package com.example.magicenglish.components.navigation


import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun RowScope.AddItem(
    screen: NavigationItems,
    navDestination: NavDestination?,
    navController: NavHostController
){
    NavigationBarItem(
        icon = {
            screen.icon?.let { Icon(imageVector = it, contentDescription = " NavBar Icon") }
        },
        label = {
            Text(text = screen.title)
        },
        selected = navDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
                restoreState = true
            }
        }
    )
}
@Composable
fun BottomNavigationBar(navController: NavHostController){
    var screens= listOf(
        NavigationItems.Home,
        NavigationItems.Note,
        NavigationItems.Account
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var currentDestination = navBackStackEntry?.destination

    NavigationBar{
        screens.forEach {screen->
            AddItem(
                screen = screen,
                navDestination = currentDestination ,
                navController = navController )
        }
    }
}
