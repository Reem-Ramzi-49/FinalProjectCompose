package com.example.final_project_compose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.final_project_compose.R

data class HairToolItem(
    val name: String,
    val brand: String,
    val price: String,
    val image: Int
)

@Composable
fun HairCareToolsScreen(navController: NavController) {

    val items = listOf(
        HairToolItem("Hair Dryer", "Philips", "$45.00", R.drawable.hair1),
        HairToolItem("Hair Straightener", "Remington", "$50.00", R.drawable.hair2),
        HairToolItem("Curling Iron", "Babyliss", "$40.00", R.drawable.hair3),
        HairToolItem("Hair Brush", "Tangle Teezer", "$15.00", R.drawable.hair4),
        HairToolItem("Hair Trimmer", "Panasonic", "$35.00", R.drawable.hair5),
        HairToolItem("Hair Steamer", "Kemei", "$60.00", R.drawable.hair6),
        HairToolItem("Diffuser", "Revlon", "$18.00", R.drawable.hair7),
        HairToolItem("Hot Air Brush", "Dyson", "$120.00", R.drawable.hair8)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6))
            .padding(horizontal = 14.dp)
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        Box(modifier = Modifier.fillMaxWidth()) {

            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }

            Text(
                text = "Hair Care Tools",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(items) { item ->
                HairToolCard(item)
            }
        }
    }
}

@Composable
fun HairToolCard(item: HairToolItem) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color(0xFFF1E5E8))
            ) {

                Image(
                    painter = painterResource(item.image),
                    contentDescription = item.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Column(modifier = Modifier.padding(12.dp)) {

                Text(item.name)

                Text(item.brand)

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = item.price,
                        color = Color(0xFF8A2126),
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        text = "20 sold",
                        fontSize = 12.sp,
                        color = Color(0xFFBDBDBD)
                    )
                }
            }
        }
    }
}