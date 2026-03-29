package com.example.final_project_compose.ui.theme

import ProfileScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*

@Composable
fun ScreenRoutes() {

    val navigator = rememberNavController()
    val backStackEntry = navigator.currentBackStackEntryAsState()
    val currentRoute = backStackEntry.value?.destination?.route

    val bottomBarScreens = listOf(
        "home_screen",
        "categories_screen",
        "cart_screen",
        "favorite_screen",
        "profile_screen"
    )

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomBarScreens) {
                MainBottomNavigation(navigator)
            }
        }
    ) { padding ->

        NavHost(
            navController = navigator,
            startDestination = "splash_screen",
            modifier = Modifier.padding(padding)
        ) {

            composable("splash_screen") {
                SplashScreen(navigator)
            }

            composable("login_screen") {
                LoginScreen(navigator)
            }

            composable("home_screen") {
                HomeScreen(navigator)
            }

            composable("categories_screen") {
                CategoriesPage(navigator)
            }

            composable("cart_screen") {
                CartScreen(navigator)
            }

            composable("favorite_screen") {
                FavoriteScreen(navigator)
            }

            composable("profile_screen") {
                ProfileScreen(navigator)
            }

            composable("details/{imageRes}") { backStackEntry ->

                val imageRes = backStackEntry.arguments?.getString("imageRes")?.toInt() ?: 0

                ProductDetailsScreen(navigator, imageRes)
            }

            composable("purchases_screen") {
                PurchasesScreen(navController = navigator)
            }

            composable("skin_screen") {
                SkinCreamScreen(navigator)
            }

            composable("nail_screen") {
                NailScreen(navigator)
            }

            composable("perfume_screen") {
                PerfumeScreen(navigator)
            }

            composable("tools_screen") {
                SkinCareToolsScreen(navigator)
            }

            composable("makeup_screen") {
                MakeupScreen(navigator)
            }

            composable("hair_tools_screen") {
                HairCareToolsScreen(navigator)
            }

        }
    }
}