package com.example.videoapplication.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.videoapplication.presentation.ui.components.utils.customTabIndicatorOffset

@Composable
fun CustomTabRow(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    containerColor: Color = Color.White,
    indicatorColor: Color,
    tabItems: List<String>
) {

    val density = LocalDensity.current
    val tabWidths = remember {
        val tabWidthStateList = mutableStateListOf<Dp>()
        repeat(tabItems.size) {
            tabWidthStateList.add(0.dp)
        }
        tabWidthStateList
    }

    TabRow(selectedTabIndex = selectedTabIndex, containerColor =containerColor, divider = {},  indicator = {
            tabPositions->
        if(selectedTabIndex<tabPositions.size){
            TabRowDefaults.SecondaryIndicator(
                Modifier.customTabIndicatorOffset(tabPositions[selectedTabIndex], tabWidths[selectedTabIndex]),
                color = indicatorColor
            )

        }
    }) {
        tabItems.forEachIndexed { index, tabItem->
            Tab(selected = index == selectedTabIndex,
                onClick = { onTabSelected(index) },
                modifier = Modifier.padding(vertical = 1.dp),
                text = {
                    if(selectedTabIndex == index){
                        Text(text = tabItem, color = Color.Blue,
                            onTextLayout = { textLayoutResult ->
                                tabWidths[index] =
                                    with(density) { textLayoutResult.size.width.toDp() }
                            }
                        )
                    }else  Text(text = tabItem, color = Color.Black, onTextLayout = {
                            textLayoutRes->
                        textLayoutRes.size.width
                    })
                })
        }
    }
}