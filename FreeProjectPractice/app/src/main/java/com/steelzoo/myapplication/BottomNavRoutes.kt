package com.steelzoo.myapplication

import androidx.compose.ui.graphics.Color
import com.steelzoo.myapplication.ui.theme.Blue
import com.steelzoo.myapplication.ui.theme.Green
import com.steelzoo.myapplication.ui.theme.Purple
import com.steelzoo.myapplication.ui.theme.Red
import java.io.Serializable

val bottomNavItems = listOf(
    HomeNavItem,
    BoardNavItem,
    ManageStudentNavItem,
    ManageClassNavItem
)

interface BottomNavItem : Serializable {
    val icon: Int
    val iconTint: Color
    val label: String
    val route: String
}

object HomeNavItem : BottomNavItem {
    private fun readResolve(): Any = HomeNavItem
    override val icon: Int = R.drawable.home_rocket
    override val iconTint: Color = Red
    override val label: String = "홈"
    override val route: String = "home"
}

object BoardNavItem : BottomNavItem {
    private fun readResolve(): Any = BoardNavItem
    override val icon: Int = R.drawable.board
    override val iconTint: Color = Blue
    override val label: String = "게시판"
    override val route: String = "board"
}

object ManageStudentNavItem : BottomNavItem {
    private fun readResolve(): Any = ManageStudentNavItem
    override val icon: Int = R.drawable.manage_student
    override val iconTint: Color = Purple
    override val label: String = "학생관리"
    override val route: String = "manage_student"
}

object ManageClassNavItem : BottomNavItem {
    private fun readResolve(): Any = ManageClassNavItem
    override val icon: Int = R.drawable.manage_class
    override val iconTint: Color = Green
    override val label: String = "학급관리"
    override val route: String = "manage_class"
}