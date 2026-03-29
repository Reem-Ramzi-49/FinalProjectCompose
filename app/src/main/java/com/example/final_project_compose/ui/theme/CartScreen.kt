package com.example.final_project_compose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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

object CartManager {

    val cartItems = mutableStateListOf<CartItemData>()

    fun addItem(item: CartItemData) {
        cartItems.add(item)
    }

    fun removeItem(item: CartItemData) {
        cartItems.remove(item)
    }

}

object PurchaseManager {
    val purchasedItems = mutableStateListOf<CartItemData>()

    fun addItem(item: CartItemData) {
        purchasedItems.add(item)
    }
}

data class CartItemData(
    val id: Int,
    val title: String,
    val price: Double,
    val image: Int ,
    var quantity: MutableState<Int> = mutableStateOf(1)

)

@Composable
fun CartScreen(navController: NavController) {

    val items = CartManager.cartItems

    val subtotal = items.sumOf { it.price * it.quantity.value }

    Scaffold(
        containerColor = Color(0xFFF4F4F4),
     ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {

            Spacer(Modifier.height(10.dp))

             Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Cart",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.width(4.dp))

                Text(
                    text = "(${items.size})",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }

            Spacer(Modifier.height(20.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(items, key = { it.id }) { item ->
                    CartCard(item, navController)                }
            }

            Divider()

            Spacer(Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("SubTotal")
                Text("$${"%.2f".format(subtotal)}")
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {   PurchaseManager.purchasedItems.addAll(CartManager.cartItems)

                     CartManager.cartItems.clear()

                     navController.navigate("purchases_screen") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB62025)
                )
            ) {
                Text("Buy now", color = Color.White, fontSize = 18.sp)
            }

            Spacer(Modifier.height(12.dp))
        }
    }
}

@Composable
fun CartCard(item: CartItemData, navController: NavController) {

    var showDialog by remember { mutableStateOf(false) }
    val quantity = item.quantity

    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column {

            Box {

                Image(
                    painter = painterResource(item.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(26.dp)
                        .background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = {
                        CartManager.removeItem(item)
                    }) {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = null,
                            tint = Color.Red,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            Column(modifier = Modifier.padding(12.dp)) {

                Text(item.title, fontSize = 14.sp)

                Spacer(Modifier.height(6.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                     Text(
                        "$${"%.2f".format(item.price * quantity.value)}",
                        color = Color.Red,
                        fontSize = 14.sp
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {

                         Box(
                            modifier = Modifier
                                .size(26.dp)
                                .background(Color(0xFFD9A6A6), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(
                                onClick = {
                                    if (quantity.value > 1) {
                                        quantity.value--
                                    }
                                },
                                modifier = Modifier.size(26.dp)
                            ) {
                                Icon(
                                    Icons.Default.Remove,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }

                        Spacer(Modifier.width(4.dp))

                         Text(
                            quantity.value.toString(),
                            fontSize = 13.sp
                        )

                        Spacer(Modifier.width(4.dp))

                         Box(
                            modifier = Modifier
                                .size(26.dp)
                                .background(Color(0xFFB62025), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(
                                onClick = {
                                    quantity.value++
                                },
                                modifier = Modifier.size(26.dp)
                            ) {
                                Icon(
                                    Icons.Default.Add,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }
                    }
                }

                Spacer(Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        "Buy now",
                        color = Color(0xFFB62025),
                        fontSize = 14.sp,
                        modifier = Modifier.clickable {
                            showDialog = true
                        }
                    )

                    Icon(
                        Icons.Default.Info,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }

     if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Success") },
            text = { Text("Purchase successful") },
            confirmButton = {
                Button(onClick = {
                    showDialog = false

                    PurchaseManager.addItem(item)
                    CartManager.removeItem(item)

                    navController.navigate("purchases_screen")
                }) {
                    Text("OK")
                }
            }
        )
    }
}