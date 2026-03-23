package com.example.final_project_compose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.final_project_compose.R

@Composable
fun CategoriesPage(navController: NavController) {

    Scaffold(

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFFF6F6F6))
        ) {

            CategoryHeader()

            Spacer(modifier = Modifier.height(4.dp))

            CategoryListGrid()
        }
    }
}

@Composable
fun CategoryHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier.size(22.dp))

        Text(
            text = "Categories",
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold
        )

        Icon(
            imageVector = Icons.Outlined.Search,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}

data class CategoryModel(
    val name: String,
    val imageRes: Int
)

@Composable
fun CategoryListGrid() {

    val data = listOf(
        CategoryModel("Skin creams", R.drawable.skin_cream_items),
        CategoryModel("Nail products", R.drawable.nail_care_products),
        CategoryModel("Perfume", R.drawable.perfume_collection),
        CategoryModel("Skin care Tools", R.drawable.skincare_devices),
        CategoryModel("Makeup", R.drawable.makeup_kit),
        CategoryModel("Hair care tools", R.drawable.hair_styling),
        CategoryModel("Toothbrush", R.drawable.oral_care_brush),
        CategoryModel("Shampoo", R.drawable.hair_shampoo)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        items(data) { item ->
            CategoryTile(item)
        }
    }
}

@Composable
fun CategoryTile(model: CategoryModel) {

    Box(
        modifier = Modifier
            .height(158.dp)
            .clip(RoundedCornerShape(15.dp))
    ) {

        Image(
            painter = painterResource(model.imageRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.22f))
        )

        Text(
            text = model.name,
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(14.dp)
        )
    }
}

