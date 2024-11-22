package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardAppImage(
                        name = stringResource(R.string.name),
                        title = stringResource(R.string.title),
                        phoneNumber = stringResource(R.string.phone_number),
                        email = stringResource(R.string.email),
                        social = stringResource(R.string.social)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardAppText(
    name: String,
    title: String,
    phoneNumber: String,
    email: String,
    social: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.pfp)
    val phoneIcon = painterResource(R.drawable.phone_24dp_5f6368)
    val networkIcon = painterResource(R.drawable.network)
    val emailIcon = painterResource(R.drawable.email_24dp_5f6368)

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier.padding(12.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            // Image Composable - Profile Image
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.height(120.dp)
            )
            // Text Composable - Full Name
            Text(
                text = name,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            // Test Composable - Title
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.align(alignment = Alignment.End)
        ) {
            Row {
                // Icon Composable - Phone
                Icon(
                    painter = phoneIcon,
                    contentDescription = stringResource(R.string.phone_icon_desc)
                )
                // Text Composable - Phone number
                ContactInfo(contact = phoneNumber)
            }

            Row {
                // Icon Composable - email
                Icon(
                    painter = emailIcon,
                    contentDescription = stringResource(R.string.email_icon_desc)
                )
                // Text Composable - email address
                ContactInfo(contact = email)
            }

            Row {
                // Icon Composable - network
                Icon(
                    painter = networkIcon,
                    contentDescription = stringResource(R.string.network_icon_desc)
                )
                // Text Composable - mastadon id
                ContactInfo(contact = social)
            }
        }
    }
}

@Composable
fun ContactInfo(contact: String) {
    Text(
        text = contact,
        fontSize = 18.sp,
        modifier = Modifier.padding(4.dp),
        textAlign = TextAlign.Left
    )
}

@Composable
fun BusinessCardAppImage(
    name: String,
    title: String,
    phoneNumber: String,
    email: String,
    social: String,
    modifier: Modifier = Modifier
) {
    val backgroundImage = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )

        BusinessCardAppText(
            name = name,
            title = title,
            phoneNumber = phoneNumber,
            email = email,
            social = social,
            modifier = Modifier.fillMaxSize()
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardAppImage(
            name = stringResource(R.string.name),
            title = stringResource(R.string.title),
            phoneNumber = stringResource(R.string.phone_number),
            email = stringResource(R.string.email),
            social = stringResource(R.string.social)
        )
    }
}