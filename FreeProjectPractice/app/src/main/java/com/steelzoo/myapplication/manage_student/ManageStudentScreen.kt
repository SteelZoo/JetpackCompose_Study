package com.steelzoo.myapplication.manage_student

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.steelzoo.myapplication.ui.theme.MyApplicationTheme

@Preview(showBackground = true)
@Composable
fun ManageClassScreenPreview() {
    MyApplicationTheme {
        ManageClassScreen()
    }
}

@Composable
fun ManageClassScreen(

) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Manage Class Screen",
            textAlign = TextAlign.Center
        )
    }
}