package com.example.videoapplication.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.videoapplication.domain.model.Product
import com.example.videoapplication.navigation.Screen

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product,
    navController: NavHostController
) {

    Card(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                navController.navigate(Screen.ProductDetail.createRoute(product.id.toString()))
            }, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
       , colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            AsyncImage(
                model = product.image, contentDescription = null, modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f), contentScale = ContentScale.FillBounds
            )
            Spacer(Modifier.height(5.dp))
            Text(text = product.title, style = MaterialTheme.typography.titleMedium)
        }
    }
}