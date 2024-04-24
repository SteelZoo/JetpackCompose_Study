package com.steelzoo.myapplication.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steelzoo.myapplication.R
import com.steelzoo.myapplication.ui.theme.MyApplicationTheme
import com.steelzoo.myapplication.ui.theme.Red
import com.steelzoo.myapplication.ui.theme.Yellow

@Preview(showBackground = true)
@Composable
fun ContentCardViewPreview() {
    MyApplicationTheme {
        RunningCardView(
            cardColor = Red,
            contentText = "함께 달리기",
            textAlign = TextAlign.Right,
            imageId = R.drawable.rocket,
            imageAligment = Alignment.CenterStart
        )
    }
}

//rank card preview
@Preview(showBackground = true)
@Composable
fun RankCardViewPreview() {
    MyApplicationTheme {
        RankCardView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RunningCardView(
    modifier: Modifier = Modifier,
    cardColor: Color,
    contentText: String,
    textAlign: TextAlign,
    @DrawableRes imageId: Int,
    imageAligment: Alignment
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
            pressedElevation = 4.dp
        ),
        onClick = {}
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painterResource(id = imageId),
                contentDescription = contentText,
                alignment = imageAligment
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                text = contentText,
                textAlign = textAlign,
                fontSize = 30.sp,
                fontWeight = FontWeight.Black
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RankCardView(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(160.dp)
            .aspectRatio(1f),
        colors = CardDefaults.cardColors(
            containerColor = Yellow
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp
        ),
        onClick = {}
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.rank_trophy),
                contentDescription = null,
            )
            Text(
                text = "랭크",
                fontSize = 30.sp,
                fontWeight = FontWeight.Black
            )
        }
    }
}