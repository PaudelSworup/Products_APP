package com.example.videoapplication.presentation.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun CustomText(
    text: String,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    color: Color = style.color,
    letterSpacing: TextUnit = style.letterSpacing,
    lineHeight: TextUnit = style.lineHeight,
    textAlign: TextAlign? = null,
    fontWeight: FontWeight?= null
) {
    Text(
        text = text,
        style = style,
        letterSpacing = letterSpacing,
        color = color,
        textAlign = textAlign,
        lineHeight = lineHeight,
        fontWeight = fontWeight

    )

}