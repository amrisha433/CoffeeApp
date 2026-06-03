package com.example.my_coffee_app.Screens.DetailsScreen

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_coffee_app.ui.theme.CharcoalGray
import com.example.my_coffee_app.ui.theme.LightBrown
import com.example.my_coffee_app.ui.theme.LightGray

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SelectSizeChip(
    sizeText: String,
    selected: Boolean,
    onClick:() ->Unit,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = if (selected) Color(0xFFF7F0EB) else Color(0xFFFDFDFD),
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                color = if (selected) Color(0xFFC67C4E) else Color(0xFFE1E1E1),
                RoundedCornerShape(12.dp)
            )
            //.width(80.dp)
            .height(46.dp)
            .clickable{onClick()},
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = sizeText,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (selected) LightBrown else CharcoalGray
        )
    }
}

