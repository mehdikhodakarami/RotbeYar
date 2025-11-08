package com.rotbeyar.app.presentation.common.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp



@Composable
fun RotbeYarCardIconContainer(
    shape: Shape = CircleShape,
    @DrawableRes imageResVector: Int,
    iconSize : Dp = 24.dp,
    modifier: Modifier = Modifier,
clickable : Boolean = false,
    onClick: () -> Unit = {},

    containerSize: Dp=60.dp,
    cardColor: CardColors =CardDefaults.cardColors(containerColor = Color.White),
    iconTint: Color = MaterialTheme.colorScheme.primary,
    cardElevation: CardElevation =CardDefaults.cardElevation(defaultElevation = 0.dp) )

{
    Card(
        modifier = modifier.size(containerSize).clickable(enabled = clickable , onClick = onClick),

        shape = shape,
        elevation = cardElevation,
        colors = cardColor,
    ) {Box(modifier = Modifier.background(Color.Transparent).fillMaxSize()){
        Icon(modifier = Modifier.align(Alignment.Center).size(iconSize),


            imageVector = ImageVector.vectorResource(imageResVector), contentDescription = "", tint = iconTint
        )
    }
    }}