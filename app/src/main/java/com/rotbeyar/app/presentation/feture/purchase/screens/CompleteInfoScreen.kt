package com.rotbeyar.app.presentation.feture.purchase.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.StepProgressBar
import com.rotbeyar.app.presentation.feture.purchase.screens.complete_info.CurrentMajorInfoScreen
import com.rotbeyar.app.presentation.feture.purchase.screens.complete_info.ExamInfoScreen
import com.rotbeyar.app.presentation.feture.purchase.screens.complete_info.ParentPhoneNumberInfoScreen
import com.rotbeyar.app.presentation.feture.purchase.screens.complete_info.RecordBusyTimesScreen
import com.rotbeyar.app.presentation.feture.purchase.screens.complete_info.SchoolInfoScreen
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBlack

@Composable
fun CompleteInfoAfterPurchaseScreen(){
val backGround = Color.White
    var currentStep by remember { mutableStateOf(1) }

    Scaffold(
        Modifier.background(PrimaryBlack),
        topBar = { TopBarCompleteInfo(currentStep, totalStep = 5) },
        bottomBar = {
            BottomBarCompleteInfo(currentStep = currentStep,
                totalStep = 5, onNext = {currentStep++}, onBack = {currentStep--})




        }
    )

    { padding ->









                when (currentStep) {
                    1 -> ExamInfoScreen(modifier = Modifier.padding(padding).background(backGround))
                    2 -> SchoolInfoScreen(modifier = Modifier.padding(padding).background(backGround))
                    3 -> CurrentMajorInfoScreen(modifier = Modifier.padding(padding).background(backGround))
                    4 -> ParentPhoneNumberInfoScreen(modifier = Modifier.padding(padding).background(backGround))
                    5 -> RecordBusyTimesScreen(modifier = Modifier.padding(padding).background(backGround))
                    else -> {}
                }




    }








}
@Composable
fun TopBarCompleteInfo(currentStep : Int = 2,
                       totalStep: Int = 5){
    Box(Modifier
        .fillMaxWidth()
        .background(Color.White)){
        Column(Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(modifier = Modifier.align(Alignment.Start

            ),text = when(currentStep){
                1->stringResource(R.string.select_exam)
                2->stringResource(R.string.study_type)
                3->stringResource(R.string.education_status)
                4->stringResource(R.string.parent_phone_information)
                5->stringResource(R.string.weekly_schedule)
                else -> ""




            },
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = PrimaryBlack
            )
            Spacer(Modifier.size(16.dp))
            StepProgressBar(modifier = Modifier,
                totalSteps = totalStep,
                currentStep = currentStep
            )
        }
        HorizontalDivider(Modifier
            .align(
                Alignment.BottomCenter
            )
            .fillMaxWidth())

    }
}

@Composable
fun BottomBarCompleteInfo(currentStep : Int = 2,totalStep : Int = 5,
             onNext:()->Unit = {},onBack:()->Unit={}  ,onFinished : ()->Unit={}           ){
    Box(Modifier
        .fillMaxWidth()
        .background(Color.White)){
        HorizontalDivider(Modifier.fillMaxWidth())
        Row(Modifier.padding(16.dp)) {


            RotbeYarButton(enabled = (currentStep != 1),
                backgroundColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                modifier = Modifier.weight(1f),onClick = onBack,
                text = stringResource(R.string.back))
            Spacer(Modifier.size(16.dp))
            RotbeYarButton(modifier = Modifier.weight(1f),


                onClick = if(currentStep <totalStep) onNext else onFinished






                ,text = stringResource(if(currentStep <totalStep) R.string.next else R.string.complete_signup))



        }
    }
}

