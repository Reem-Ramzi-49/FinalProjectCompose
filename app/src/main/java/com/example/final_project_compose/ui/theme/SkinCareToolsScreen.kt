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

data class ToolItem(
    val name: String,
    val brand: String,
    val price: String,
    val image: Int
)

@Composable
fun SkinCareToolsScreen(navController: NavController) {

    val items = listOf(
        ToolItem("Facial Cleanser Brush", "Foreo", "$35.00", R.drawable.tool1),
        ToolItem("Blackhead Remover", "Xiaomi", "$20.00", R.drawable.tool2),
        ToolItem("Face Massager", "Revlon", "$18.00", R.drawable.tool3),
        ToolItem("Derma Roller", "BeautyPro", "$15.00", R.drawable.tool4),
        ToolItem("Ice Roller", "SkinGym", "$12.00", R.drawable.tool5),
        ToolItem("LED Face Mask", "Dr.Dennis", "$80.00", R.drawable.tool6),
        ToolItem("Pore Vacuum", "Panasonic", "$25.00", R.drawable.tool7),
        ToolItem("Skin Scrubber", "Ultrasonic", "$30.00", R.drawable.tool8)
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
                text = "Skin Care Tools",
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
                ToolCard(item)
            }
        }
    }
}

@Composable
fun ToolCard(item: ToolItem) {

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
                        text = "25 sold",
                        fontSize = 12.sp,
                        color = Color(0xFFBDBDBD)
                    )
                }
            }
        }
    }
}