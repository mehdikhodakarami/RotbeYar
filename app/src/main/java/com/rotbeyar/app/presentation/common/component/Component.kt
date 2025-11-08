package com.rotbeyar.app.presentation.common.component


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.ui.theme.PrimaryGrayLight
import com.rotbeyar.app.ui.theme.VazirFamily

@Composable
fun RotbeYarText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    fontWeight: androidx.compose.ui.text.font.FontWeight? = null,
    fontFamily: FontFamily = VazirFamily,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        maxLines = maxLines,
        overflow = overflow,
    )
}
@Composable
fun CircleStepWithNumber(modifier: Modifier = Modifier,
                           number :Int = 12,
                         boxColor: Color = PrimaryGrayLight
){
    Box(
        modifier = modifier
            .size(36.dp)
            .background(boxColor, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun CardEmptyItem(modifier : Modifier = Modifier,
                  @StringRes titleRes : Int?  = R.string.no_exam_taken_yet,
                  @StringRes subTitleRes : Int? = R.string.progress_will_show_after_first_exam,
                  @DrawableRes iconRes : Int = R.drawable.test_icon ){

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(PrimaryGrayLight.copy(alpha = 0.5f)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            RotbeYarCardIconContainer(
                iconSize = 28.dp,
                containerSize = 85.dp,
                imageResVector = iconRes,
                cardColor = CardDefaults.cardColors(PrimaryGrayLight),
                iconTint = MaterialTheme.colorScheme.onSecondary
            )

            Spacer(Modifier.size(16.dp))

            titleRes?.let { Text(
                text = stringResource(titleRes),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSecondary,
            ) }

            Spacer(Modifier.size(8.dp))
            subTitleRes?.let { Text(
                text = stringResource(subTitleRes),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground,
            ) }


            Spacer(Modifier.size(20.dp))


        }
    }
}

