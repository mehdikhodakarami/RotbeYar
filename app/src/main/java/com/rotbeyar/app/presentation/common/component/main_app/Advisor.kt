package com.rotbeyar.app.presentation.common.component.main_app

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.AppGrgDateTime
import com.rotbeyar.app.domain.model.ShortTimeTarget
import com.rotbeyar.app.domain.model.StudyPart
import com.rotbeyar.app.domain.model.grgToPersianDate
import com.rotbeyar.app.domain.model.subscription.StudentSubscription
import com.rotbeyar.app.domain.model.subscription.SubscriptionStatus
import com.rotbeyar.app.presentation.common.component.ColumnBlurContent
import com.rotbeyar.app.presentation.common.component.RotbeYarCardIconContainer
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.RotbeYarCardButton
import com.rotbeyar.app.presentation.common.component.RotbeYarTextField
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.model.SuggestedReferenceUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ExamUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.SampleStudentDashboardData
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ShortTimeTargetUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyLessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyPartStatusUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.TodayDevelopUi
import com.rotbeyar.app.presentation.feture.purchase.screens.SelectPackageDialog
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.GreenGradientBrush
import com.rotbeyar.app.ui.theme.GreenGradientBrushLight
import com.rotbeyar.app.ui.theme.PinkGradientBrush
import com.rotbeyar.app.ui.theme.VazirFamily
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryBlue
import com.rotbeyar.app.ui.theme.PrimaryBlueContainer
import com.rotbeyar.app.ui.theme.PrimaryGrayLight
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryGreenContainer
import com.rotbeyar.app.ui.theme.PrimaryWhite
import com.rotbeyar.app.ui.theme.PrimaryBackgroundGradient
import com.rotbeyar.app.ui.theme.PrimaryError
import com.rotbeyar.app.ui.theme.PrimaryErrorContainer
import com.rotbeyar.app.ui.theme.PrimaryGray
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.PrimaryPurpleContainer
import com.rotbeyar.app.ui.theme.Surface
import com.rotbeyar.app.ui.theme.VipGradientColor
import com.rotbeyar.app.ui.theme.VipGradientColorContainer
import com.rotbeyar.app.utils.clockFromSec

@Composable
fun CardAdvisorProfile(){

    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color.Transparent

    ){
        Box(Modifier
            .fillMaxWidth()
            .background(GreenGradientBrushLight)
            .padding(16.dp)){
            Row(Modifier.fillMaxWidth()){
                Image(painterResource(R.drawable.profile_image),
                    modifier = Modifier
                        .size(48.dp)
                        .background(Color.Transparent, shape = CircleShape),
                    contentDescription = "")
                Spacer(Modifier.size(12.dp))
                Column {
                    Text(text = "دکتر احمد محمدی", fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = PrimaryBlack)
                    Text(text = stringResource(R.string.master_advisor),
                        fontSize = 14.sp,

                        color = MaterialTheme.colorScheme.onSecondary)
                }
                Spacer(Modifier.weight(1f))
                RotbeYarCardIconContainer(modifier = Modifier.align(Alignment.CenterVertically), shape = CircleShape,
                    imageResVector = R.drawable.call_icon,
                    iconSize =12.dp,
                    containerSize = 40.dp,
                    iconTint = PrimaryGreen
                    , cardColor = CardDefaults.cardColors(PrimaryGreenContainer)
                )





            }

        }




    }


}

@Composable
fun RowReserveAndHistoryPlan(
    clickRefrence : ()->Unit = {},
    clickHistory : ()->Unit = {},
    clickReservation : ()->Unit = {}

){

    Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.spacedBy(16.dp)){

        repeat(3){


            Card(modifier = Modifier.weight(1f),
                onClick = when(it){
                    0->clickReservation
                    1->clickHistory
                    else->clickRefrence
                }
                ,
                elevation = CardDefaults
                    .cardElevation(2.dp),
                shape =RoundedCornerShape(16.dp)
                , colors = CardDefaults.cardColors(Color.White)
             ){

            Box(modifier = Modifier.fillMaxWidth()){
                Column(Modifier
                    .padding(16.dp)
                    .align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    RotbeYarCardIconContainer(containerSize = 40.dp,
                        iconSize = 15.dp,
                        imageResVector = when(it){
                            0->R.drawable.plan_icon
                            1->R.drawable.histoy_icon
                            else->R.drawable.refrence_icon


                        },
                        iconTint = when(it){
                            0->PrimaryBlue
                            1->PrimaryPurple
                            else->PrimaryGreen



                        },
                        cardColor = CardDefaults.cardColors(when(it){
                            0->PrimaryBlueContainer
                            1->PrimaryPurpleContainer
                            else->PrimaryGreenContainer
                        })


                    )
                    Spacer(Modifier.size(8.dp))
                    Text(text = stringResource(when(it){
                        0->R.string.reservation_meet
                        1->R.string.history
                        else->R.string.refrences



                    }
                    ),
                        color = PrimaryBlack)



                }

            }



            }


        }




    }
}

@Composable
fun CardNextAdvisorMeet(   grgDateTime: AppGrgDateTime,
                           subject : String ="بررسی عملکرد آزمون جامع و برنامه\u200Cریزی برای بهبود نقاط ضعف"){
    Surface(modifier = Modifier.fillMaxWidth(),
color = Color.White,
        shape = RoundedCornerShape(16.dp)

        ) {

        Column(Modifier.padding(16.dp)) {
            Row {
Text(text =stringResource(R.string.next_meet),
    fontWeight = FontWeight.SemiBold,
fontSize = 14.sp,
    color = PrimaryBlack

    )
                Spacer(Modifier.weight(1f))
                Surface(shape = RoundedCornerShape(16.dp),
                    color = PrimaryPurpleContainer){
                    Text(modifier = Modifier.padding(horizontal = 8.dp,
                        vertical = 4.dp) ,
                        fontSize = 12.sp,
                        color = PrimaryPurple,
                        text = stringResource(R.string.confirmed) )

                }


            }
            Spacer(Modifier.size(12.dp))
            Row {

                RotbeYarCardIconContainer(imageResVector = R.drawable.plan_icon,
                    iconSize = 15.dp,
                    shape = RoundedCornerShape(16.dp),
                    containerSize = 40.dp,
                    iconTint = PrimaryPurple,
                    cardColor = CardDefaults.cardColors(PrimaryPurpleContainer)

                    )
                Spacer(Modifier.size(12.dp))
                Column {
                    Text(text = "${grgDateTime.appLocalDate().grgToPersianDate().dayName()} " +
                            "${grgDateTime.appLocalDate().grgToPersianDate().shDay} "+
                            "${grgDateTime.appLocalDate().grgToPersianDate().monthName} "+
                            "${grgDateTime.appLocalDate().grgToPersianDate().shYear} "
                        ,

                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = PrimaryBlack)
                    Text(text = " ساعت ${clockFromSec().subSequence(0,5)}"
                             ,

                        fontSize = 12.sp,

                        color = MaterialTheme.colorScheme.onSecondary)


                }
            }
            Spacer(Modifier.size(12.dp))
            Surface(shape = RoundedCornerShape(16.dp),
                color = PrimaryGrayLight.copy(alpha = 0.4f),
                modifier = Modifier.fillMaxWidth()

                ){

                Column(Modifier.padding(16.dp)) {
                    Text(text = "${stringResource(R.string.meet_subject)}:",
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 12.sp)
                    Spacer(Modifier.size(4.dp))
                    Text(
                        text = subject, color = PrimaryBlack,
                        fontSize = 14.sp


                    )

                }


            }
            Spacer(Modifier.size(12.dp))
            Row(Modifier.fillMaxWidth(),


                ) {

                Spacer(Modifier.weight(2f))
                RotbeYarButton(modifier = Modifier
                    .border(
                        border = BorderStroke(0.5.dp, PrimaryGrayLight),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .height(42.dp)
                    .weight(1f),text = stringResource(R.string.change_time),
                    onClick = {},
                    backgroundColor = PrimaryGreenContainer.copy(alpha = 0.3f),
                    contentColor = PrimaryGreen,


                )



            }





        }



    }



}

@Composable
fun CardAdvisorMeet(
    meetType:String =  "نظارت روش مطالعه",
    meetSubject :String = "بررسی روش\u200Cهای مطالعه فعلی و ارائه پیشنهادات بهبود",

    grgDateTime: AppGrgDateTime = AppGrgDateTime(2004,2,4,
        1,1,1)


){
    Surface(modifier = Modifier.fillMaxWidth() , color = Color.White,
        shadowElevation = 1.dp,
        shape = RoundedCornerShape(16.dp)){

        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {

              Row(){
                  RotbeYarCardIconContainer(imageResVector = R.drawable.eye_icon,
                      shape = RoundedCornerShape(16.dp),
                      iconTint = PrimaryBlue,
                      containerSize = 40.dp,
                      iconSize = 14.dp,
                      cardColor = CardDefaults.cardColors(PrimaryBlueContainer)



                  )
                  Spacer(Modifier.size(12.dp))
                  Column { Text(text = meetType , fontSize = 14.sp,fontWeight = FontWeight.SemiBold,
                      color = PrimaryBlack)
                  Text(text = "${grgDateTime.appLocalDate().grgToPersianDate().shDay} "
                          +"${grgDateTime.appLocalDate().grgToPersianDate().monthName} "+
                          "${grgDateTime.appLocalDate().grgToPersianDate().shYear} ",
                      fontSize = 12.sp,
                      color = MaterialTheme.colorScheme.onBackground



                  )


                  }
                  Spacer(Modifier.weight(1f))
                  Surface(shape = RoundedCornerShape(16.dp),
                      color = PrimaryErrorContainer
                  ){
                      Text(modifier = Modifier.padding(horizontal = 8.dp,
                          vertical = 4.dp) ,
                          fontSize = 12.sp,
                          color = PrimaryError,
                          text = stringResource(R.string.canceled) )

                  }



              }

            Text(text = "موضوع: ${meetSubject}",
                fontSize = 12.sp,color = MaterialTheme.colorScheme.onSecondary)
            Row(){
RotbeYarButton(shape = RoundedCornerShape(24.dp),

    modifier = Modifier.height(40.dp).fillMaxWidth(), onClick = {},
    icon = ImageVector.vectorResource(R.drawable.test_icon),
    text = stringResource(R.string.see_report),
    contentColor = PrimaryPurple,
    backgroundColor = PrimaryPurpleContainer
    )

            }





        }

    }

}
@Composable
fun CardSuggestedReference(modifier: Modifier = Modifier,
                           suggestedReferenceUi: SuggestedReferenceUi  = SuggestedReferenceUi(
                               SampleStudentDashboardData.sampleMathLesson,
                               "مبتکران",
                               textBookFeature ="عالیه",
                               testBookTitle = "نشر الگو",
                               testBookFeature ="عالیه تست"
                           ) ){

    Surface(shape = RoundedCornerShape(16.dp),
        color = PrimaryPurpleContainer,
        modifier = modifier.fillMaxWidth()) {

        Column {
            Text(
                modifier = Modifier.padding(12.dp),
                text = stringResource(suggestedReferenceUi.lessonUi.title),
                fontSize = 16.sp,
                color = PrimaryBlack,
                fontWeight = FontWeight.Medium
            )

            Box(Modifier.background(Color.White).fillMaxWidth()){
                Column(Modifier.padding(16.dp).fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    repeat(2){
                        Surface(modifier = Modifier.fillMaxWidth(),
                            shadowElevation = 0.5.dp,
                            shape = RoundedCornerShape(16.dp),color = PrimaryWhite){
                            Row(
                                Modifier.padding(12.dp)
                            ){
                                RotbeYarCardIconContainer(imageResVector = when(it){
                                    0->R.drawable.page_icon
                                    else -> R.drawable.test_icon
                                },
                                    iconSize = 15.dp,
                                    containerSize = 40.dp,
                                    shape = RoundedCornerShape(16.dp),
                                    iconTint = when(it){
                                        0->PrimaryGreen
                                        else -> PrimaryBlue
                                    },
                                    cardColor = CardDefaults.cardColors(
                                        when(it){
                                            0->PrimaryGreenContainer
                                            else -> PrimaryBlueContainer
                                        }


                                    ))
                                Spacer(Modifier.size(12.dp))
                                Column {


                                    Text(color = PrimaryBlack,

                                        text = when(it){

                                            0->"درسنامه ${suggestedReferenceUi.textBookTitle}"
                                            else -> "کتاب ${suggestedReferenceUi.testBookTitle}"
                                        },
                                        fontWeight = FontWeight.Medium






                                    )
                                    Text(text = when(it){

                                        0->suggestedReferenceUi.textBookFeature
                                        else -> suggestedReferenceUi.textBookFeature
                                    },
                                        color = MaterialTheme.colorScheme.onBackground



                                    )
                                }

                            }



                        }}}

            }




        }



    }



}


