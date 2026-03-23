package com.example.final_project_compose

import ProfileScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.final_project_compose.ui.theme.CartScreen
import com.example.final_project_compose.ui.theme.CategoriesPage
import com.example.final_project_compose.ui.theme.FavoriteScreen
import com.example.final_project_compose.ui.theme.ProductDetailsScreen
import com.example.final_project_compose.ui.theme.ProfileEditBottomSheet
 import com.example.final_project_compose.ui.theme.ScreenRoutes


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ScreenRoutes()

        }

        }
    }
