package com.example.coffeapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SlideIndicator(size: Int = 1, position: Int = 0) {
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        repeat(size) {
            if (position == it) {
                Surface(
                    modifier = Modifier
                        .height(10.dp)
                        .width(30.dp),
                    shape = RoundedCornerShape(10.dp),
                    color = Color.Blue
                ) {}
            } else {
                Surface(
                    modifier = Modifier.size(10.dp),
                    shape = RoundedCornerShape(10.dp),
                    color = Color.Gray
                ) {}
            }
        }
    }
}