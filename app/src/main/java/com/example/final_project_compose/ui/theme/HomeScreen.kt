package com.example.final_project_compose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.final_project_compose.R

@Composable
fun HomeScreen(navController: NavController) {

    Scaffold { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color(0xFFF6F6F6))
        ) {

            HeaderSection()
            PromotionBanner()

            Spacer(modifier = Modifier.height(14.dp))

            ItemsGrid()
        }
    }
}

@Composable
fun HeaderSection() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 22.dp, start = 18.dp, end = 18.dp, bottom = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "Good morning",
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold
        )

        Row {

            Icon(
                painter = painterResource(R.drawable.search),
                contentDescription = "",
                tint = Color.Gray,
                modifier = Modifier.size(23.dp)
            )

            Spacer(modifier = Modifier.width(14.dp))

            BadgedBox(
                badge = { Badge(containerColor = Color.Red) }
            ) {
                Icon(
                    painter = painterResource(R.drawable.notification),
                    contentDescription = "",
                    tint = Color.Gray,
                    modifier = Modifier.size(23.dp)
                )
            }
        }
    }
}

@Composable
fun PromotionBanner() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(horizontal = 12.dp)
    ) {

        Image(
            painter = painterResource(R.drawable.lip),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .padding(start = 18.dp, top = 18.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "lipsticks set",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$10",
                color = Color.Red,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB62025)
                )
            ) {
                Text("Shop Now")
            }
        }
    }
}

@Composable
fun ItemsGrid() {

    val items = listOf(
        R.drawable.product1,
        R.drawable.product2,
        R.drawable.product3,
        R.drawable.product4
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        items(items.size) { index ->

            val label =
                when (index) {
                    2 -> "%50"
                    3 -> "%33"
                    else -> ""
                }

            ItemCard(items[index], label)
        }
    }
}

@Composable
fun ItemCard(imageRes: Int, badgeText: String) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column(modifier = Modifier.padding(18.dp)) {

            Box {

                Image(
                    painter = painterResource(imageRes),
                    contentDescription = "",
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                if (badgeText.isNotEmpty()) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(6.dp)
                            .background(Color.Red, RoundedCornerShape(5.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = badgeText,
                            color = Color.White,
                            fontSize = 10.sp
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(6.dp)
                        .size(30.dp)
                        .background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "",
                        tint = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Device Laser Hair Rem...",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = "Qmele",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )

            Row {

                Text(
                    text = "$20",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.LineThrough
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "$18",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "50 sold",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}