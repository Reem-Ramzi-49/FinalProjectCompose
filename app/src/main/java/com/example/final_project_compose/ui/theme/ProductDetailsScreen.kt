package com.example.final_project_compose.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun ProductDetailsScreen(navController: NavController, imageRes: Int){

    var quantity by remember { mutableStateOf(1) }

    Scaffold(
        containerColor = Color(0xFFF6F6F6),

        bottomBar = {

            Card(
                shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFFE5E5E5)),
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-6).dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 14.dp, bottom = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(Color(0xFFF3F3F3), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.ShoppingCart,
                            contentDescription = null,
                            tint = Color(0xFFB62025)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Button(
                        onClick = {
                            CartManager.addItem(
                                CartItemData(
                                    id = System.currentTimeMillis().toInt(),
                                    title = "Device Laser Hair Rem...",
                                    price = 10.0,
                                    image = imageRes
                                )
                            )

                            navController.navigate("cart_screen")
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(55.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFB62025)
                        )
                    ) {
                        Text("Buy now", color = Color.White)
                    }
                }
            }
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

             Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.arrow_back),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Device Laser Hair Removal",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))
            }

             Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .background(Color(0xFFF5E6EA)),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .width(240.dp)
                        .height(240.dp),
                    contentScale = ContentScale.Fit
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 20.dp)                        .size(36.dp)
                        .background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                }
            }

             Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                    .background(Color.White)
                    .padding(horizontal = 16.dp, vertical = 20.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        "$10.00",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(Color(0xFFD9A6A6), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(
                                onClick = { if (quantity > 1) quantity-- },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    Icons.Default.Remove,
                                    null,
                                    tint = Color.White,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }

                        Spacer(Modifier.width(6.dp))

                        Text(quantity.toString(), fontSize = 14.sp)

                        Spacer(Modifier.width(6.dp))

                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(Color(0xFFB62025), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(
                                onClick = { quantity++ },
                                modifier = Modifier.size(24.dp)
                            ) {
                                Icon(
                                    Icons.Default.Add,
                                    null,
                                    tint = Color.White,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }
                    }
                }

                Spacer(Modifier.height(14.dp))

                Card(
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, Color(0xFFE0E0E0)),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(Icons.Default.Star, null, tint = Color(0xFFFFC107))

                        Spacer(Modifier.width(6.dp))

                        Text("4.8")

                        Spacer(Modifier.width(6.dp))

                        Text("50 Orders", color = Color.Gray)

                        Spacer(Modifier.weight(1f))

                        Icon(Icons.Default.KeyboardArrowRight, null)
                    }
                }

                Spacer(Modifier.height(18.dp))



                Column {

                    Text(
                        text = "1. Applicable : 100-240V working voltage, suitable for all the countries in the world.",
                        fontSize = 13.sp,
                        lineHeight = 22.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "2. Painless: Adjustable optimal energy level according to the skin tolerance. Providing the gentle treatment painlessly and easily , without hurting the skin. The LED light clear shows the energy level.",
                        fontSize = 13.sp,
                        lineHeight = 22.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "3. Fast and big treatment area : wavelength >510um, 3 cm² : spot size not too big or neither too small for any area.",
                        fontSize = 13.sp,
                        lineHeight = 22.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }
}