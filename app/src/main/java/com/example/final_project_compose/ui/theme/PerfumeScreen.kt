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

 data class PerfumeItem(
    val name: String,
    val brand: String,
    val price: String,
    val image: Int
)

@Composable
fun PerfumeScreen(navController: NavController) {

    val items = listOf(
        PerfumeItem("Floral Essence", "Chanel", "$45.00", R.drawable.perfume1),
        PerfumeItem("Rose Bloom", "Dior", "$50.00", R.drawable.perfume2),
        PerfumeItem("Vanilla Touch", "YSL", "$55.00", R.drawable.perfume3),
        PerfumeItem("Fresh Breeze", "Gucci", "$48.00", R.drawable.perfume4),
        PerfumeItem("Golden Scent", "Armani", "$60.00", R.drawable.perfume5),
        PerfumeItem("Sweet Love", "Versace", "$52.00", R.drawable.perfume6),
        PerfumeItem("Ocean Mist", "Davidoff", "$40.00", R.drawable.perfume7),
        PerfumeItem("Luxury Oud", "Tom Ford", "$70.00", R.drawable.perfume8)
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
                text = "Perfumes",
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
                PerfumeCard(item)
            }
        }
    }
}

@Composable
fun PerfumeCard(item: PerfumeItem) {

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
                    painter = painterResource(id = item.image),
                    contentDescription = item.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Column(modifier = Modifier.padding(12.dp)) {

                Text(
                    text = item.name,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = item.brand,
                    fontSize = 13.sp,
                    color = Color.Gray
                )

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
                        text = "40 sold",
                        fontSize = 12.sp,
                        color = Color(0xFFBDBDBD)
                    )
                }
            }
        }
    }
}