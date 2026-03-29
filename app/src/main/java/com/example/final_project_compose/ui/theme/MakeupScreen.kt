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

data class MakeupItem(
    val name: String,
    val brand: String,
    val price: String,
    val image: Int
)

@Composable
fun MakeupScreen(navController: NavController) {

    val items = listOf(
        MakeupItem("Lipstick Set", "Huda Beauty", "$25.00", R.drawable.makeup1),
        MakeupItem("Foundation", "Maybelline", "$18.00", R.drawable.makeup2),
        MakeupItem("Eyeshadow Palette", "Anastasia", "$40.00", R.drawable.makeup3),
        MakeupItem("Mascara", "L’Oreal", "$15.00", R.drawable.makeup4),
        MakeupItem("Blush Kit", "Rare Beauty", "$22.00", R.drawable.makeup5),
        MakeupItem("Highlighter", "Fenty", "$28.00", R.drawable.makeup6),
        MakeupItem("Setting Spray", "NYX", "$12.00", R.drawable.makeup7),
        MakeupItem("Concealer", "NARS", "$20.00", R.drawable.makeup8)
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
                text = "Makeup",
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
                MakeupCard(item)
            }
        }
    }
}

@Composable
fun MakeupCard(item: MakeupItem) {

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
                        text = "35 sold",
                        fontSize = 12.sp,
                        color = Color(0xFFBDBDBD)
                    )
                }
            }
        }
    }
}