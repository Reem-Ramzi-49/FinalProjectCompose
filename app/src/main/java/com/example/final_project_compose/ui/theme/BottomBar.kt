package com.example.final_project_compose.ui.theme

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.final_project_compose.R

@Composable
fun MainBottomNavigation(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val selectedColor = Color(0xFF8B1E1E)

    NavigationBar(
        containerColor = Color(0xFFEFEFEF)
    ) {

        NavigationBarItem(
            selected = currentRoute == "home_screen",
            onClick = { navController.navigate("home_screen") },
            icon = {
                Icon(
                    painterResource(R.drawable.home),
                    contentDescription = "",
                    tint = if (currentRoute == "home_screen") selectedColor else Color.Gray
                )
            }
        )

        NavigationBarItem(
            selected = currentRoute == "categories_screen",
            onClick = { navController.navigate("categories_screen") },
            icon = {
                Icon(
                    painterResource(R.drawable.categories),
                    contentDescription = "",
                    tint = if (currentRoute == "categories_screen") selectedColor else Color.Gray
                )
            }
        )

        NavigationBarItem(
            selected = currentRoute == "cart_screen",
            onClick = { navController.navigate("cart_screen") },
            icon = {
                Icon(
                    painterResource(R.drawable.cart),
                    contentDescription = "",
                    tint = if (currentRoute == "cart_screen") selectedColor else Color.Gray
                )
            }
        )

        NavigationBarItem(
            selected = currentRoute == "favorite_screen",
            onClick = { navController.navigate("favorite_screen") },
            icon = {
                Icon(
                    painterResource(R.drawable.favorite_navigation),
                    contentDescription = "",
                    tint = if (currentRoute == "favorite_screen") selectedColor else Color.Gray
                )
            }
        )

        NavigationBarItem(
            selected = currentRoute == "profile_screen",
            onClick = { navController.navigate("profile_screen") },
            icon = {
                Icon(
                    painterResource(R.drawable.profile),
                    contentDescription = "",
                    tint = if (currentRoute == "profile_screen") selectedColor else Color.Gray
                )
            }
        )
    }
}