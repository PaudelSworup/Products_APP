package com.example.videoapplication.presentation.ui.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun CustomImage(imageUrl:String, contentScale: ContentScale, modifier: Modifier){
    AsyncImage(model = if(imageUrl !="") imageUrl else ("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"),
        contentDescription = null,
        modifier= modifier.fillMaxWidth().aspectRatio(1f),
        contentScale = ContentScale.FillBounds)
}