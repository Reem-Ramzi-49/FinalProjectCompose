
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.final_project_compose.R
import com.example.final_project_compose.ui.theme.ProfileEditBottomSheet

@Composable
fun ProfileScreen(navController: NavController) {

    var showEditSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Profile",
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box {

                Image(
                    painter = painterResource(R.drawable.user_photo1),
                    contentDescription = "",
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE53935)),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        painter = painterResource(R.drawable.camera),
                        contentDescription = "",
                        modifier = Modifier.size(17.dp)
                    )

                }

            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = "Mona Fadl Al-Harthy",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "009665211043",
                    color = Color.Gray,
                    fontSize = 13.sp
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Mona Fadl@gmail.com",
                        color = Color.Gray,
                        fontSize = 13.sp
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        painter = painterResource(R.drawable.ic_edit),
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                showEditSheet = true
                            }
                    )

                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Divider(
            color = Color(0xFFE7E7E7),
            thickness = 1.dp
        )

        ProfileOption(
            icon = R.drawable.ic_orders,
            label = "My order",
            count = "4",
            onPress = {
                navController.navigate("purchases_screen")
            }
        )
        ProfileOption(icon = R.drawable.ic_card, label = "Payment method")

        ProfileOption(icon = R.drawable.location, label = "Shipping address")

        Divider(
            color = Color(0xFFE7E7E7),
            thickness = 1.dp
        )

        ProfileOption(icon = R.drawable.faq_icon, label = "FAQ")

        ProfileOption(icon = R.drawable.user_photo, label = "Invite friends")

        ProfileOption(icon = R.drawable.settings_icon, label = "Settings")

        Divider(
            color = Color(0xFFE7E7E7),
            thickness = 1.dp
        )

        ProfileOption(
            icon = R.drawable.logout_icon,
            label = "Logout",
            onPress = {
                navController.navigate("login_screen")            }
        )
    }

    if (showEditSheet) {
        ProfileEditBottomSheet(
            onCloseSheet = {
                showEditSheet = false
            }
        )
    }
}


@Composable
fun ProfileOption(
    icon: Int,
    label: String,
    count: String? = null,
    onPress: (() -> Unit)? = null
) {

    val clickSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = clickSource,
                indication = null
            ) {
                onPress?.invoke()
            }
            .padding(horizontal = 22.dp, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(icon),
            contentDescription = "",
            modifier = Modifier.size(21.dp)
        )

        Spacer(modifier = Modifier.width(14.dp))

        Text(
            text = label,
            fontSize = 15.sp,
            modifier = Modifier.weight(1f)
        )

        if (count != null) {

            Text(
                text = count,
                color = Color(0xFFB71C1C),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

        }
    }

}



