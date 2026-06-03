package com.example.my_coffee_app.Screens.DetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_coffee_app.R
import com.example.my_coffee_app.domain.Model.Product
import com.example.my_coffee_app.ui.theme.IvoryWhite
import com.example.my_coffee_app.ui.theme.LightGray

//@Preview
@Composable
fun ProductDetailContent(product: Product, innerPadding: PaddingValues) {

    var selectedSizeText by remember { mutableStateOf("M") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 10.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = innerPadding.calculateBottomPadding()
            )
    ) {

        // 🔹 Image
        Image(
            painter = painterResource(product.imageResource),
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp) // reduced from 260
                .clip(RoundedCornerShape(20.dp))
                .shadow(10.dp, RoundedCornerShape(20.dp))
            ,
        contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(4.dp)) // reduced

        // 🔹 Title + Tag Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Text(
                    text = product.name,
                    fontSize = 26.sp, // reduced
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Ice / Hot",
                    fontSize = 14.sp, // reduced
                    color = Color.DarkGray
                )
            }

            Icon(
                painter = painterResource(R.drawable.default_bean),
                contentDescription = "Bean",
                modifier = Modifier
                    .size(44.dp)
                    .background(
                        color = IvoryWhite,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(26.dp)) // reduced

        HorizontalDivider(color = Color.Gray.copy(alpha = 0.4f))

        Spacer(modifier = Modifier.height(36.dp)) // reduced

        // 🔹 Description Section
        Text(
            text = "Description",
            fontSize = 22.sp, // reduced
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = product.description,
            fontSize = 15.sp,
            color = Color(0xFF444444),
            lineHeight = 22.sp,
            maxLines = 2 // added
        )

        Spacer(modifier = Modifier.height(26.dp)) // reduced from 24

        // 🔹 Size Section
        Text(
            text = "Size",
            fontSize = 22.sp, // reduced
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            listOf("S", "M", "L").forEach { size ->

                SelectSizeChip(
                    sizeText = size,
                    selected = selectedSizeText == size,
                    onClick = { selectedSizeText = size },
                    modifier = Modifier
                        .weight(1f)
                        .height(49.dp) // reduced from 50
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}