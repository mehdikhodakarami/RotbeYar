package com.rotbeyar.app.presentation.student_dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rotbeyar.app.presentation.student_dashboard.home.navigation.StudentDashboardRoute
import com.rotbeyar.app.presentation.student_dashboard.home.screens.HomeScreen
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.VazirFamily

@Composable
fun StudentDashboardScreen(






){
    Scaffold (
        bottomBar = {
            StudentBottomNavigation(
                navController = rememberNavController(),
                currentRoute = StudentDashboardRoute.Home
            )
        }




    ){ contentPadding ->

        HomeScreen(contentPaddingValues = contentPadding)
    }

}

@Composable
fun StudentBottomNavigation(
    navController: NavHostController,
    currentRoute: StudentDashboardRoute?
) {
    val items = listOf(
        StudentDashboardRoute.Home,
        StudentDashboardRoute.Reports,
        StudentDashboardRoute.Plan,
        StudentDashboardRoute.Counseling,
        StudentDashboardRoute.Profile
    )
    Column {
        Divider(Modifier.height(0.5.dp), color = Color.LightGray)
        NavigationBar(containerColor = Color.White,
            modifier = Modifier.height(66.dp)) {
            items.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item,
                    onClick = {
                        navController.navigate(item) {
                            // جلوگیری از دوباره ایجاد شدن مسیر روی back stack
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                        }
                    },
                    icon = {  Icon(
                        imageVector = ImageVector.vectorResource(item.icon),
                        contentDescription = stringResource(item.title)
                    )},
                    label = { Text(fontFamily = VazirFamily,
                        fontSize = 10.sp

                        ,text=stringResource(item.title)) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,      // رنگ آیکون وقتی انتخاب شده
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant, // رنگ آیکون وقتی انتخاب نشده
                        selectedTextColor = MaterialTheme.colorScheme.primary,      // رنگ متن وقتی انتخاب شده
                        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant, // رنگ متن وقتی انتخاب نشده
                        indicatorColor = Color.White // بکگراند هایلایت زیر آیتم انتخاب شده
                    )

                )
            }
        }

    }


}
@Preview(showBackground = true, locale = "fa")
@Composable
fun StudentDashboardScreenPreview(){
    AppTheme {
        StudentDashboardScreen()

    }
}