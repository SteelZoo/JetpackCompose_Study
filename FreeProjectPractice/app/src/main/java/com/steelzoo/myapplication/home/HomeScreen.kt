package com.steelzoo.myapplication.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steelzoo.myapplication.R
import com.steelzoo.myapplication.home.component.RankCardView
import com.steelzoo.myapplication.home.component.RunningCardView
import com.steelzoo.myapplication.home.component.TeacherInfoCard
import com.steelzoo.myapplication.ui.theme.MyApplicationTheme
import com.steelzoo.myapplication.ui.theme.Orange
import com.steelzoo.myapplication.ui.theme.Red

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyApplicationTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp),
    ) {
        TeacherInfoCard()
        RunningCardView(
            modifier = Modifier.padding(top = 40.dp),
            cardColor = Red,
            contentText = "함께달리기",
            textAlign = TextAlign.End,
            imageId = R.drawable.rocket,
            imageAligment = Alignment.BottomStart
        )
        RunningCardView(
            modifier = Modifier.padding(top = 20.dp),
            cardColor = Orange,
            contentText = "이어달리기",
            textAlign = TextAlign.Start,
            imageId = R.drawable.handshake,
            imageAligment = Alignment.CenterEnd
        )
        RankCardView(
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}
