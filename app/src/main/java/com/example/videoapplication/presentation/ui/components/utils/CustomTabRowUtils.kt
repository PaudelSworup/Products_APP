package com.example.videoapplication.presentation.ui.components.utils

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.TabPosition
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset


private val TabRowIndicatorSpec: AnimationSpec<Dp> =
    tween(durationMillis = 250, easing = FastOutSlowInEasing)

fun Modifier.customTabIndicatorOffset(currentTabPosition: TabPosition, tabWidth: Dp): Modifier =
    composed(
        inspectorInfo =
            debugInspectorInfo {
                name = "customTabIndicatorOffset"
                value = currentTabPosition
            }
    ) {
        val currentTabWidth by
        animateDpAsState(
            targetValue = tabWidth,
            animationSpec = TabRowIndicatorSpec
        )
        val indicatorOffset by
        animateDpAsState(
            targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
            animationSpec = TabRowIndicatorSpec
        )
        fillMaxWidth()
            .wrapContentSize(Alignment.BottomStart)
            .offset { IntOffset(x = indicatorOffset.roundToPx(), y = 0) }
            .width(currentTabWidth)
    }