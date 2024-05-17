package com.example.magicenglish.inside_app_components.navigation


import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.magicenglish.ui.theme.BlanchedAlmond
import com.example.magicenglish.ui.theme.LightSalmon

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
            Text(
                text = screen.title,
                color = Color.Black
            )
        },
        selected = navDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
                restoreState = true
            }
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Black,
            unselectedIconColor = Color.Black,
            indicatorColor = LightSalmon
        )
    )
}
@Composable
fun BottomNavigationBar(navController: NavHostController){
    var screens = listOf(
        NavigationItems.Home,
        NavigationItems.Note,
        NavigationItems.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var currentDestination = navBackStackEntry?.destination

    NavigationBar(containerColor = BlanchedAlmond){
        screens.forEach {screen->
            AddItem(

                screen = screen,
                navDestination = currentDestination ,
                navController = navController )
        }
    }
}
