package com.example.magicenglish.inside_app_components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notes
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItems(var route:String,val icon:ImageVector?,var title:String){
    object Home:NavigationItems("Home",Icons.Rounded.Home,"Home")
    object Note:NavigationItems("Note",Icons.Rounded.Notes,"Note")
    object Profile:NavigationItems("Profile",Icons.Rounded.AccountCircle,"Profile")
}