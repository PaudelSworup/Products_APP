package com.example.videoapplication.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.videoapplication.presentation.ui.components.CustomImage
import com.example.videoapplication.presentation.ui.components.CustomScaffold
import com.example.videoapplication.presentation.ui.components.TopBar
import com.example.videoapplication.presentation.viewModel.ProductsViewModel
import org.koin.androidx.compose.koinViewModel
import com.example.videoapplication.utils.Size
import com.example.videoapplication.R
import com.example.videoapplication.presentation.ui.components.CustomTabRow
import com.example.videoapplication.presentation.ui.components.CustomText
import com.example.videoapplication.ui.theme.Typography

@Composable
fun ProductDescription(productId:String, navigation: NavHostController, viewModel: ProductsViewModel = koinViewModel()){


    val state by viewModel.stateDesc.collectAsStateWithLifecycle()

    val paddingAccordingDeviceHeight = Size().height() > 595

    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val tabItem = listOf("About Item", "Reviews", "All", )

    LaunchedEffect(productId) {
        viewModel.getProductsById(productId)
    }



    CustomScaffold(
        topBar = {  TopBar(
            "products details",
            showBackButton = true,
            onBackClick = { navigation.popBackStack() }) }
    ){padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .padding(horizontal = 10.dp, vertical = 20.dp)

        ) {
            CustomImage(
                state.selectedProduct?.image.toString(),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier

            )

            Row(
                modifier = Modifier.padding(top = if (paddingAccordingDeviceHeight) 100.dp else 30.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.outline_store_24),
                    contentDescription = "",
                )
                Text("fakestore.api", color = Color.Black, style = Typography.titleSmall)
            }

            Column(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
            ) {


                CustomText(
                    text = state.selectedProduct?.title.toString(),
                    style = Typography.titleLarge,
                    lineHeight = 30.sp,
                    color = Color.Black
                )

                CustomText(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel egestas dolor, nec dignissim metus. Donec augue elit, rhoncus ac sodales id, porttitor vitae est. Donec laoreet rutrum libero sed pharetra.\n" +
                            "\n" +
                            " Donec vel egestas dolor, nec dignissim metus. Donec augue elit, rhoncus ac sodales id, porttitor vitae est. Donec laoreet rutrum libero sed pharetra. Duis a arcu convallis, gravida purus eget, mollis diam.",
                    style = Typography.bodySmall,
                    lineHeight = 18.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Justify,

                    )


            }




            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
            ) {
                Box {
                    Row {
                        Icon(
                            Icons.Default.Star,
                            contentDescription = "star",
                            modifier = Modifier.width(20.dp),
                            tint = Color.Yellow
                        )
                        CustomText(
                            text = state.selectedProduct?.rating?.range.toString(),
                            style = Typography.labelLarge,
                            color = Color.Gray
                        )
                    }
                }

                Box {
                    Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                        CustomText(
                            text = ".",
                            style = Typography.labelLarge,
                            color = Color.Gray
                        )

                        CustomText(
                            text = "2.3k+ Reviews",
                            style = Typography.labelLarge,
                            color = Color.Gray
                        )
                    }
                }

                Box {
                    Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {

                        CustomText(
                            text = ".",
                            style = Typography.labelLarge,
                            color = Color.Gray
                        )
                        CustomText(
                            text = "2.9k+ Sold",
                            style = Typography.labelLarge,
                            color = Color.Gray
                        )

                    }
                }

            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
            ) {
                CustomTabRow(
                    selectedTabIndex = selectedTabIndex,
                    onTabSelected = { selectedTabIndex = it },
                    containerColor = Color.White,
                    indicatorColor = colorResource(id = R.color.teal_700),
                    tabItems = tabItem
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (selectedTabIndex == 0) {
                    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                        CustomText(
                            text = "Brand",
                            style = Typography.bodySmall,
                            color = Color.Gray
                        )
                        CustomText(
                            text = "storeApi",
                            style = Typography.bodySmall,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                        CustomText(
                            text = "Color:",
                            style = Typography.bodySmall,
                            color = Color.Gray,
                        )
                        CustomText(
                            text = "Black",
                            style = Typography.bodySmall,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )

                    }

                }
            }
        }




    }



}