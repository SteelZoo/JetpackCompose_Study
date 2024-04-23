package com.steelzoo.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steelzoo.myapplication.ui.theme.Cream
import com.steelzoo.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                 var selectedBottomNavItem: BottomNavItem by rememberSaveable { mutableStateOf(HomeNavItem) }
                Scaffold(
                    bottomBar = {
                        BottomNav(
                            modifier = Modifier,
                            itemClick = { item ->
                                selectedBottomNavItem = item
                            },
                            selectedItem = selectedBottomNavItem
                        )
                    }
                ) { innerPadding ->
                    MainPage(
                        modifier = Modifier.padding(innerPadding),
                        name = selectedBottomNavItem.label
                    )
                }
            }
        }
    }
}



@Composable
fun MainPage(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun BottomNav(
    modifier: Modifier,
    itemClick: (BottomNavItem) -> Unit = {},
    selectedItem: BottomNavItem,
){
    val selectedItem = rememberUpdatedState(newValue = selectedItem)

    Surface(
        modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        NavigationBar(
            modifier = modifier,
            containerColor = Cream,
        ){
            bottomNavItems.forEach { item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = item.icon),
                            contentDescription = null,
                            tint = item.iconTint
                        )
                    },

                    label = {
                        Text(text = item.label)
                    },
                    selected = selectedItem.value == item,
                    onClick = {
                        itemClick(item)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.White
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {

        var title by remember { mutableStateOf("") }

        Scaffold(
            bottomBar = {
                BottomNav(
                    modifier = Modifier,
                    itemClick = { item ->
                        title = item.label
                    },
                    selectedItem = HomeNavItem
                )
            }
        ) { innerPadding ->
            MainPage(
                modifier = Modifier.padding(innerPadding),
                name = title
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomNavPreview(){
    MyApplicationTheme {
        BottomNav(
            modifier = Modifier.fillMaxWidth(),
            itemClick = {},
            selectedItem = HomeNavItem
        )
    }
}
