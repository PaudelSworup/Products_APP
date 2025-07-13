package com.example.videoapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.videoapplication.presentation.ui.ProductDescription
import com.example.videoapplication.presentation.ui.ProductScreen
import com.example.videoapplication.utils.Routes

sealed class Screen(val route: String) {
    object ProductDetail : Screen(Routes.productDetailScreen) {
        fun createRoute(productId: String) = "productDetail/$productId"
    }
    object Product : Screen(Routes.productScreen)
}


@Composable
fun Route(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = com.example.videoapplication.navigation.Screen.Product.route
    ) {
        composable(com.example.videoapplication.navigation.Screen.ProductDetail.route, arguments = listOf(
            navArgument("productId"){type=
                NavType.StringType})) { backStackEntry->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDescription(productId = productId, navController)
        }
        composable(com.example.videoapplication.navigation.Screen.Product.route) {
            ProductScreen(navController = navController)
        }
    }
}