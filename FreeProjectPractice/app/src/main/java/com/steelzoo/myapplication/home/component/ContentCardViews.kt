package com.steelzoo.myapplication.home.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
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
import com.steelzoo.myapplication.home.model.RunningRelayState
import com.steelzoo.myapplication.home.model.RunningState
import com.steelzoo.myapplication.home.model.RunningTogetherState
import com.steelzoo.myapplication.ui.theme.DarkRed
import com.steelzoo.myapplication.ui.theme.MyApplicationTheme
import com.steelzoo.myapplication.ui.theme.Red
import com.steelzoo.myapplication.ui.theme.Yellow
import java.text.SimpleDateFormat
import java.util.Locale

@Preview(showBackground = true)
@Composable
fun ContentCardViewPreview() {
    MyApplicationTheme {
        ContentCard(
            modifier = Modifier.fillMaxWidth(),
            contentAligment = ContentAligment.ImageStart_TextEnd,
            cardColor = Red,
            contentName = "함께 달리기",
            contentImageId = R.drawable.rocket
        )
    }
}


@Preview(showBackground = true)
@Composable
fun RunningCardViewPreview() {
    MyApplicationTheme {
        RunningCardView(
            cardColor = Red,
            contentText = "함께 달리기",
            textAlign = TextAlign.Right,
            imageId = R.drawable.rocket,
            imageAligment = Alignment.CenterStart,
//            runningState = RunningTogetherState(
//                System.currentTimeMillis(),
//                System.currentTimeMillis(),
//                15,
//                5
//            )
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

enum class ContentAligment{
    ImageStart_TextEnd,
    ImageEnd_TextStart
}

@Composable
fun ContentCard(
    modifier: Modifier = Modifier,
    contentAligment: ContentAligment,
    cardColor: Color,
    contentName: String,
    @DrawableRes contentImageId: Int,
    runningState: RunningState? = null
){
    Card(
        modifier = modifier.height(160.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
    ) {
        Row {
            if (contentAligment == ContentAligment.ImageStart_TextEnd) {
                Image(
                    painter = painterResource(id = contentImageId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                )
                Text(
                    text = contentName,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(20.dp),
                    textAlign = TextAlign.End,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Black
                )
            } else {
                Text(
                    text = contentName,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(20.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Black
                )
                Image(
                    painter = painterResource(id = contentImageId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                )
            }
        }
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
    imageAligment: Alignment,
    runningState: RunningState? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 6.dp
        ),
        onClick = {}
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(1f),
                    painter = painterResource(id = imageId),
                    contentDescription = contentText,
                    alignment = imageAligment
                )
                if(runningState == null){
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 40.dp, end = 40.dp, bottom = 20.dp),
                        text = contentText,
                        textAlign = textAlign,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 6.sp
                    )
                } else {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                    ) {
                        val dateformat = SimpleDateFormat("MM월 dd일", Locale.KOREA)
                        val timeformat = SimpleDateFormat("HH:mm", Locale.KOREA)
                        val boldText = if (runningState is RunningTogetherState) {
                            "${dateformat.format(runningState.date)} 함께 달리기"
                        } else {
                            val runningRelayState = runningState as RunningRelayState
                            "${runningRelayState.question}"
                        }
                        val normalText = if (runningState is RunningTogetherState) {
                            "함께 달리기"
                        } else {
                            "이어 달리기"
                        }
                        Text(
                            text = "dsd"
                        )
                        Text(
                            text = "dsd"
                        )
                    }
                }
            }
            AnimatedVisibility(
                visible = runningState != null
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                ) {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp),
                        progress = runningState?.let { it.successStudent.toFloat()/it.totalStudent.toFloat() } ?: 0f,
                        trackColor = Color.White,
                        color = DarkRed
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "${runningState?.totalStudent}명 중 ${runningState?.successStudent} 명이 진행했습니다.",
                        textAlign = TextAlign.End,
                        fontSize = 14.sp,
                    )
                }
            }
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