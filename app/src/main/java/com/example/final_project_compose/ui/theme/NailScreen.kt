package com.example.final_project_compose.ui.theme

import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.final_project_compose.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight

data class NailItem(
    val name: String,
    val brand: String,
    val price: String,
    val image: Int
)



@Composable
fun NailScreen(navController: NavController) {


    val items = listOf(
        NailItem("Nail Polish Red", "Essence", "$8.00", R.drawable.nail1),
        NailItem("Nail Gel Kit", "Born Pretty", "$15.00", R.drawable.nail2),
        NailItem("Nail Care Oil", "Sally Hansen", "$10.00", R.drawable.nail3),
        NailItem("Manicure Set", "Kiss", "$18.00", R.drawable.nail8),
        NailItem("Nail Remover", "Cutex", "$6.00", R.drawable.nail5),
        NailItem("French Nail Kit", "Beetles", "$20.00", R.drawable.nail6),
        NailItem("Nail Strengthener", "OPI", "$12.00", R.drawable.nail7),
        NailItem("Nail Dryer Lamp", "SUN", "$25.00", R.drawable.nail8)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6))
            .padding(horizontal = 14.dp)
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {

            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "")
            }

            Text(
                text = "Nail Products",
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
                ProductCard(item)
            }
        }
    }
}


@Composable
fun ProductCard(item: NailItem) {

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
                    contentDescription = null,
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
                        text = "30 sold",
                        fontSize = 12.sp,
                        color = Color(0xFFBDBDBD)
                    )
                }
            }
        }
    }
}