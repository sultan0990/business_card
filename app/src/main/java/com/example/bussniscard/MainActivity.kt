package com.example.bussniscard

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import com.example.bussniscard.ui.theme.BussnisCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BussnisCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PortfolioScreen() // Change to PortfolioScreen for the full layout
                }
            }
        }
    }
}
fun openLink(url: String, context: Context) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

@Composable
fun PortfolioScreen() {
    val scrollState = rememberScrollState() // Create a scroll state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState) // Make the column scrollable
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF1565C0), Color(0xFF42A5F5)) // Blue gradient background
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        ProfileSection()
        Spacer(modifier = Modifier.height(20.dp))
        AboutMeSection()
        Spacer(modifier = Modifier.height(20.dp))
        EducationSection()
        Spacer(modifier = Modifier.height(20.dp))
        SkillsSection()
        Spacer(modifier = Modifier.height(20.dp))
        ProjectsSection()
        Spacer(modifier = Modifier.height(20.dp))
        SocialLinksSection()
    }
}

@Composable
fun ProfileSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image), // Add your profile image in 'drawable'
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(120.dp)
                .background(color = Color.Gray, shape = CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Sultan Salauddin",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        ContactInfo()
    }
}

@Composable
fun ContactInfo() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 4.dp)
        ) {
            Icon(imageVector = Icons.Default.Phone, contentDescription = "Phone", tint = Color.White)
            Text(
                text = "9339150390",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 4.dp)
        ) {
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email", tint = Color.White)
            Text(
                text = "snn1450@gmail.com",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun AboutMeSection() {
    Text(
        text = "I am Sultan Salauddin, a passionate Android developer with expertise in Kotlin and Java. I enjoy solving problems and building user-friendly mobile applications.",
        fontSize = 16.sp,
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun EducationSection() {
    Text(
        text = "Education",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        textAlign = TextAlign.Left,
        modifier = Modifier.fillMaxWidth()
    )

    Text(
        text = "• B.Tech in Computer Science and Engineering (Expected 2025)\n• Diploma in Software Engineering (2022)\n• High School (2019)",
        fontSize = 16.sp,
        color = Color(0xFFBBDEFB),
        textAlign = TextAlign.Left,
        modifier = Modifier.fillMaxWidth().padding(start = 8.dp, top = 8.dp)
    )
}

@Composable
fun SkillsSection() {
    Text(
        text = "Skills",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        textAlign = TextAlign.Left,
        modifier = Modifier.fillMaxWidth()
    )

    Text(
        text = "• Android Development (Kotlin, Java)\n• Git, GitHub\n• REST APIs and JSON\n• LeetCode Competitive Coding",
        fontSize = 16.sp,
        color = Color(0xFFBBDEFB),
        textAlign = TextAlign.Left,
        modifier = Modifier.fillMaxWidth().padding(start = 8.dp, top = 8.dp)
    )
}

@Composable
fun ProjectsSection() {
    Text(
        text = "Projects",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        textAlign = TextAlign.Left,
        modifier = Modifier.fillMaxWidth()
    )

    Text(
        text = "• Virtual Assistant using Flutter and Gemini API\n• Image-to-Text Generator using Flutter and OpenCV\n• Personalized Learning Pathway Recommendation using GATs",
        fontSize = 16.sp,
        color = Color(0xFFBBDEFB),
        textAlign = TextAlign.Left,
        modifier = Modifier.fillMaxWidth().padding(start = 8.dp, top = 8.dp)
    )
}

@Composable
fun SocialLinksSection() {
    val context = LocalContext.current

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        ClickableText(
            text = buildAnnotatedString {
                pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                append("GitHub")
                pop()
            },
            onClick = { offset ->
                if (offset in 0 until "GitHub".length) {
                    openLink("https://github.com/sultan0990", context)
                }
            },
            modifier = Modifier.padding(end = 20.dp)
        )

        ClickableText(
            text = buildAnnotatedString {
                pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                append("LeetCode")
                pop()
            },
            onClick = { offset ->
                if (offset in 0 until "LeetCode".length) {
                    openLink("https://leetcode.com/u/sultan09/", context)
                }
            }
        )

        // Add more links as needed
        ClickableText(
            text = buildAnnotatedString {
                pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                append("LinkedIn")
                pop()
            },
            onClick = { offset ->
                if (offset in 0 until "LinkedIn".length) {
                    openLink("https://www.linkedin.com/in/sultan-salauddin/", context)
                }
            },
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}