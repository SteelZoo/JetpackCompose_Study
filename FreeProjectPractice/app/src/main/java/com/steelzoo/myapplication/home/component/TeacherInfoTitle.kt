package com.steelzoo.myapplication.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steelzoo.myapplication.R

@Preview(showBackground = true)
@Composable
fun TeacherInfoCardPreview() {
    TeacherInfoCard(
        teacherName = "홍유준"
    )
}

@Composable
fun TeacherInfoCard(
    teacherName: String
){
    val height = 120.dp

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.teacher),
                contentDescription = null,
                modifier = Modifier.size(height),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier.height(height),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$teacherName 선생님\n환영합니다.",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
        }
    }
}