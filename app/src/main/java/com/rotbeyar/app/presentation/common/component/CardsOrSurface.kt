package com.rotbeyar.app.presentation.common.component

import android.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rotbeyar.app.ui.theme.AppStyle
import com.rotbeyar.app.ui.theme.PrimaryBlueContainer
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.cardElevationApp

@Composable
fun RotbeYarCard(
    onClick: () -> Unit={},
    modifier: Modifier = Modifier,
    shape: Shape =RoundedCornerShape(AppStyle.CornerLarge) as Shape,
    elevation: Dp = cardElevationApp,
    contentPadding: PaddingValues = PaddingValues(horizontal = 24.dp, vertical = 24.dp),
    colors: CardColors = CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color.White),
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier.clickable(true) { onClick() },
        shape = shape,
        colors = colors,
        elevation = CardDefaults.cardElevation(defaultElevation = elevation)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(contentPadding)
        ) {
            content()
        }
    }
}


@Composable
fun RotbeYarCardButton(modifier: Modifier=Modifier,
                       onClick: () -> Unit,
    //UPDATED
//                       text:String = "test",
                       elevation: CardElevation = CardDefaults.cardElevation(0.dp),
                       shape: Shape =RoundedCornerShape(8.dp) as Shape,
                       contentPadding: PaddingValues = PaddingValues(8.dp),
                       colors: CardColors = CardDefaults.cardColors(MaterialTheme.colorScheme.errorContainer),
                       content: @Composable () -> Unit = {}
)
                       {
    Card(modifier = modifier,
        elevation = elevation,
        shape = shape,
        colors = colors,
        onClick = onClick
    ) {
        Box(modifier = Modifier

            .padding(contentPadding)
        ) {
            content()
        }






    }

}