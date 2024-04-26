package com.steelzoo.myapplication.home

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steelzoo.myapplication.R
import com.steelzoo.myapplication.home.component.ContentAligment
import com.steelzoo.myapplication.home.component.ContentCard
import com.steelzoo.myapplication.home.component.RankCard
import com.steelzoo.myapplication.home.component.TeacherInfoCard
import com.steelzoo.myapplication.home.model.RunningRelayState
import com.steelzoo.myapplication.home.model.RunningTogetherState
import com.steelzoo.myapplication.ui.theme.Cream
import com.steelzoo.myapplication.ui.theme.MyApplicationTheme
import com.steelzoo.myapplication.ui.theme.Red

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyApplicationTheme {
        HomeScreen()
    }
}

val runningTogetherState = RunningTogetherState(
    System.currentTimeMillis(),
    System.currentTimeMillis(),
    15,
    5
)
val runningRelayState = RunningRelayState(
    "커서 어떤 사람이 되고 싶은가요?",
    "오하빈",
    15,
    5
)

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp)
            .verticalScroll(ScrollState(0)),
    ) {
        TeacherInfoCard(
            modifier = Modifier.padding(top = 20.dp),
            teacherName = "홍유준"
        )
        ContentCard(
            modifier = Modifier.fillMaxWidth(),
            contentAligment = ContentAligment.ImageStart_TextEnd,
            cardColor = Red,
            contentName = "함께 달리기",
            contentImageId = R.drawable.rocket
        )
        Spacer(modifier = Modifier.height(20.dp))
        ContentCard(
            modifier = Modifier.fillMaxWidth(),
            contentAligment = ContentAligment.ImageEnd_TextStart,
            cardColor = Cream,
            contentName = "이어 달리기",
            contentImageId = R.drawable.handshake,
            runningState = runningRelayState
        )
        RankCard(
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
        )
    }
}
