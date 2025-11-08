package com.rotbeyar.app.presentation.common.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.main_app.CardExamItem
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.SampleStudentDashboardData
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryPurple

@Composable
fun BoxScope.ColumnBlurContent(
    upgradePackageClick : ()->Unit ={},
    @StringRes textRes : Int = R.string.registraition_exams
){
    Box(modifier = Modifier.matchParentSize().clickable(interactionSource = remember { MutableInteractionSource()
    },indication = null){},){

        Column(

            Modifier.fillMaxSize().align(Alignment.Center).background(PrimaryBlack.copy(alpha = 0.4f)),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            RotbeYarCardIconContainer(
                iconSize = 15.dp,
                imageResVector = R.drawable.lock_icon,
                containerSize = 40.dp,
                iconTint = Color.White,

                cardColor = CardDefaults.cardColors(Color.White.copy(alpha = 0.4f))
            )
            Text(
                text = stringResource(textRes),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,

                )
            RotbeYarButton(
                text = stringResource(R.string.upgrade_package),
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                onClick = upgradePackageClick,
                backgroundColor = Color.White,
                contentColor = PrimaryPurple,
            )

        }

    }}




@Preview(showBackground = true, locale = "fa")
@Composable
fun show2(){
    AppTheme(){
        StandardBoxPage (modifier = Modifier.padding(16.dp).fillMaxSize().background(Color.Transparent)){
            Card(colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)) {

                Box(){
                    Column (Modifier.blur(2.dp)){
                        repeat(2){
                            CardExamItem(

                                SampleStudentDashboardData.sampleExam1
                            )

                            HorizontalDivider()
                        }

                    }
                    ColumnBlurContent()
                }


            }

        }}

}
