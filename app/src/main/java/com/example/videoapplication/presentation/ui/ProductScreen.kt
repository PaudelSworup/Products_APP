package com.example.videoapplication.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.videoapplication.presentation.ui.components.CustomScaffold
import com.example.videoapplication.presentation.ui.components.LoadingIndicator
import com.example.videoapplication.presentation.ui.components.TopBar
import com.example.videoapplication.presentation.viewModel.ProductsViewModel
import org.koin.androidx.compose.koinViewModel
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavHostController
import com.example.videoapplication.presentation.ui.components.ProductCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(viewModel: ProductsViewModel = koinViewModel(), navController: NavHostController){
    val state by viewModel.state.collectAsStateWithLifecycle()
    LoadingIndicator(isLoading = state.isLoading)
    CustomScaffold(
        topBar = { TopBar("Products") }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding) // ✅ Use padding here
                .fillMaxSize()
        ) {
            LazyVerticalStaggeredGrid(
                modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp),
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalItemSpacing = 10.dp
            ) {
               items(state.products){product->
                   ProductCard(modifier = Modifier, product = product, navController = navController)
               }
            }
        }
    }


}
