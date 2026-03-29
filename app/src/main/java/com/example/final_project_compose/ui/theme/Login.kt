package com.example.final_project_compose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.final_project_compose.R

@Composable
fun LoginScreen(navController: NavController) {

    var mobileInput by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    val titleText = "Your Phone Number"
    val emailLogin = "Sign in with Email"
    val loginButton = "Login"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F2E8))
    ) {

        TopImage()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
        ) {

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = titleText,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(7.dp))

            PhoneInputRow(
                value = mobileInput,
                onValueChange = { mobileInput = it }
            )

            if (isError) {
                Text(
                    text = "Please enter phone number",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(11.dp))

            Text(
                text = emailLogin,
                color = Color(0xFFB62025),
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            LoginBtn(loginButton) {
                if (mobileInput.length >= 10) {
                    isError = false
                    navController.navigate("home_screen")
                } else {
                    isError = true
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            TermsText()

            Spacer(modifier = Modifier.height(25.dp))

            DividerSection()

            Spacer(modifier = Modifier.height(24.dp))

            SocialIconsRow()
        }
    }
}

@Composable
fun TopImage() {

    Image(
        painter = painterResource(R.drawable.girl_imag),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun PhoneInputRow(value: String, onValueChange: (String) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text("+972")

        Spacer(modifier = Modifier.width(8.dp))

        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text("Enter phone number") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun LoginBtn(label: String, onClick: () -> Unit) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFB62025)
        )
    ) {

        Text(
            text = label,
            color = Color.White,
            fontSize = 18.sp
        )
    }
}

@Composable
fun TermsText() {

    Text(
        text = buildAnnotatedString {

            append("By clicking login you agree to our ")

            withStyle(style = SpanStyle(color = Color(0xFF2F80ED))) {
                append("terms & conditions")
            }

            append(" and ")

            withStyle(style = SpanStyle(color = Color(0xFF2F80ED))) {
                append("privacy policy")
            }
        },

        fontSize = 12.sp,
        color = Color.Gray,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun DividerSection() {

    Row(verticalAlignment = Alignment.CenterVertically) {

        Divider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = Color.White
        )

        Text("  OR  ")

        Divider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = Color.White
        )
    }
}

@Composable
fun SocialIconsRow() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        SocialCircle(R.drawable.google)
        SocialCircle(R.drawable.facebook)
        SocialCircle(R.drawable.twitter)
    }
}

@Composable
fun SocialCircle(icon: Int) {

    Box(
        modifier = Modifier
            .size(60.dp)
            .shadow(4.dp, CircleShape)
            .background(Color.White, CircleShape),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
    }
}