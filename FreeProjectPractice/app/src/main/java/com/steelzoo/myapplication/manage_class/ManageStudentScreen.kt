package com.steelzoo.myapplication.manage_class

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.steelzoo.myapplication.home.HomeScreen
import com.steelzoo.myapplication.ui.theme.MyApplicationTheme

@Preview(showBackground = true)
@Composable
fun ManageStudentScreenPreview() {
    MyApplicationTheme {
        ManageStudentScreen()
    }
}

@Composable
fun ManageStudentScreen(

) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Manage Student Screen",
            textAlign = TextAlign.Center
        )
    }
}