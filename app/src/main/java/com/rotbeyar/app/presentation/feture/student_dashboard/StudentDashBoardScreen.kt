package com.rotbeyar.app.presentation.feture.student_dashboard

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.feture.student_dashboard.components.BottomNavItem
import com.rotbeyar.app.presentation.feture.student_dashboard.components.CustomBottomNavigationBar
import com.rotbeyar.app.presentation.feture.student_dashboard.navigation.DashboardNavHost

import com.rotbeyar.app.presentation.student_dashboard.navigation.StudentDashboardRoute
import com.rotbeyar.app.ui.theme.AppTheme




object StudentBottomNavItems {
    val items = listOf(
        BottomNavItem(
            route = StudentDashboardRoute.Home,
            icon = R.drawable.home_icon,
            selectedIcon = R.drawable.home_icon,
            title =R.string.home
        ),
        BottomNavItem(
            route = StudentDashboardRoute.Reports,
            icon = R.drawable.report_icon,
            selectedIcon = R.drawable.report_icon,
            title = R.string.reports
        ),
        BottomNavItem(
            route = StudentDashboardRoute.Plan,
            icon = R.drawable.plan_icon,
            selectedIcon = R.drawable.plan_icon,
            title = R.string.plan
        ),
        BottomNavItem(
            route = StudentDashboardRoute.Counseling,
            icon = R.drawable.counslant_icon,
            selectedIcon = R.drawable.counslant_icon,
            title = R.string.counseling
        ),
        BottomNavItem(
            route = StudentDashboardRoute.Profile,
            icon = R.drawable.profile_icon,
            selectedIcon = R.drawable.profile_icon,
            title = R.string.profile
        )
    )
}



@Composable
fun StudentDashboardScreen() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    fun isRouteSelected(route: StudentDashboardRoute): Boolean {
        return currentDestination?.hasRoute(route::class) == true
    }

    BackHandler(enabled = !isRouteSelected(StudentDashboardRoute.Home)) {
        if (!isRouteSelected(StudentDashboardRoute.Home)) {
            navController.navigate(StudentDashboardRoute.Home) {
                popUpTo<StudentDashboardRoute.Home> {
                    inclusive = false
                }
                launchSingleTop = true
            }
        }
    }

    Scaffold(
        bottomBar = {
            CustomBottomNavigationBar(
                currentDestination = currentDestination,
                onNavigate = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }

            )
        }
    ) { paddingValues ->
        DashboardNavHost(
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}



