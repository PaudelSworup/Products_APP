package com.example.videoapplication.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String? = "",
    showBackButton: Boolean = false,
    onBackClick: () -> Unit = {},
    showActionIcon: Boolean = false,
    actionIcon: ImageVector = Icons.Default.ShoppingCart,
    onActionClick: () -> Unit = {}
) {
    TopAppBar(
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        },

        actions = {

            if (showActionIcon) {
                IconButton(onClick = onActionClick) {
                    Icon(
                        actionIcon, "back"
                    )
                }
            }

        },

        title = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                title?.let {
                    Text(
                        text = it,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }


            }


        }, modifier = Modifier.shadow(5.dp)
    )
}
