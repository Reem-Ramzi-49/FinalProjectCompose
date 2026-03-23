package com.example.final_project_compose.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditBottomSheet(onCloseSheet: () -> Unit) {

    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    var userFullName by remember { mutableStateOf("Mona Fadl Al-Harthy") }
    var userPhoneNumber by remember { mutableStateOf("00966 5211043") }
    var userEmailAddress by remember { mutableStateOf("Mona Fadl@gmail.com") }

    ModalBottomSheet(
        onDismissRequest = { onCloseSheet() },
        sheetState = bottomSheetState,
        containerColor = Color.White,
        dragHandle = {
            Box(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .width(45.dp)
                    .height(5.dp)
                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(12.dp)
                    )
            )
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "✕",
                    color = Color.Red,
                    fontSize = 20.sp,
                    modifier = Modifier.clickable {
                        onCloseSheet()
                    }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Your Name")

            Spacer(modifier = Modifier.height(6.dp))

            TextField(
                value = userFullName,
                onValueChange = { userFullName = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF2F2F2),
                    unfocusedContainerColor = Color(0xFFF2F2F2),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Your Phone number")

            Spacer(modifier = Modifier.height(6.dp))

            TextField(
                value = userPhoneNumber,
                onValueChange = { userPhoneNumber = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF2F2F2),
                    unfocusedContainerColor = Color(0xFFF2F2F2),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Your Email Address")

            Spacer(modifier = Modifier.height(6.dp))

            TextField(
                value = userEmailAddress,
                onValueChange = { userEmailAddress = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFF2F2F2),
                    unfocusedContainerColor = Color(0xFFF2F2F2),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(26.dp))

            Button(
                onClick = { onCloseSheet() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFAD2629)
                )
            ) {
                Text(
                    text = "Done",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}