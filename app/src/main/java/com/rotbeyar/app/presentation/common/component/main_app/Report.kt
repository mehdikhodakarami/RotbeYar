package com.rotbeyar.app.presentation.common.component.main_app

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.subscription.StudentSubscription
import com.rotbeyar.app.domain.model.subscription.SubscriptionStatus
import com.rotbeyar.app.presentation.common.AppValues
import com.rotbeyar.app.presentation.common.component.ColumnBlurContent
import com.rotbeyar.app.presentation.common.component.RotbeYarCardIconContainer
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ShortTimeTargetUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.DetailedLessonReportUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.ExamResultUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.LessonResultExamUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.OverallDevelopUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.SampleResultReportData
import com.rotbeyar.app.ui.theme.GreenGradientBrushContainer
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryBlue
import com.rotbeyar.app.ui.theme.PrimaryBlueContainer
import com.rotbeyar.app.ui.theme.PrimaryError
import com.rotbeyar.app.ui.theme.PrimaryErrorContainer
import com.rotbeyar.app.ui.theme.PrimaryGray
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryGreenContainer
import com.rotbeyar.app.ui.theme.PrimaryPurpleContainer
import kotlin.math.abs


@Composable
fun CardOverallDevelopment(

    overallDevelop: OverallDevelopUi  = SampleResultReportData.sampleOverallDevelop,
    title:String = stringResource(R.string.overall_development),
    period:String = stringResource(R.string.last_week))

{
    Card (shape = RoundedCornerShape(16.dp)
        , colors = CardDefaults.cardColors(Color.Transparent)
        , modifier = Modifier.fillMaxWidth()
    ){
        Box(modifier = Modifier
            .background(brush = GreenGradientBrushContainer)
            .padding(16.dp)) {

            Column {
                Row {

                    Column {
                        Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                        Text(
                            text = period, fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSecondary
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))


                    Column {
                        Text(
                            text = "${overallDevelop.developPercentage}٪",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Text(
                            fontSize = 12.sp, text = stringResource(R.string.complete_target),
                            color = MaterialTheme.colorScheme.onSecondary
                        )


                    }


                }
                Spacer(Modifier.size(16.dp))

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {

                    repeat(3) { index ->
                        Card(colors = CardDefaults.cardColors(
                            MaterialTheme.colorScheme.secondary),
                            shape = RoundedCornerShape(16.dp)




                        ){
                            Column(horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(12.dp)) {
                                Text(text = when (index) {
                                    0 -> overallDevelop.testCountInLastWeek.toString()
                                    1 -> overallDevelop.studyHoursTime.toString()
                                    2 -> overallDevelop.quizCount.toString()
                                    else -> ""
                                }, color = PrimaryBlack,
                                    fontWeight = FontWeight.Bold, fontSize = 18.sp)
                                Text(text = when(index){
                                    0 -> stringResource(R.string.test_solved)
                                    1 -> stringResource(R.string.study_hours)
                                    2 -> stringResource(R.string.attend_an_exam)
                                    else -> ""
                                }

                                    ,
                                    fontSize = 12.sp, color = MaterialTheme.colorScheme.onSecondary)


                            }



                        }





                    }


                }


            }


        }}
}
@Composable
private fun CardLessonDevelopPercentage(modifier: Modifier = Modifier,

                                lessonResultExam: LessonResultExamUi

)


{
    Card(modifier = modifier,
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(16.dp)




    ) {Column(Modifier.padding(16.dp)) {
        Row { Text(text=stringResource(lessonResultExam.lessonDevelopUi.lesson.title),
     fontSize = 14.sp,
            fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.weight(1f))
            Text(text="${lessonResultExam.scorePercentage}%",
                fontWeight = FontWeight.Bold,
                color = lessonResultExam.lessonDevelopUi.lesson.iconColor,
                fontSize = 18.sp
            )
        }
Spacer(Modifier.size(8.dp))
        LinearProgressIndicator(
            progress = {
                lessonResultExam.scorePercentage/100f
            },
            modifier = Modifier
                .height(8.dp)
                .fillMaxWidth(),
            color = lessonResultExam.lessonDevelopUi.lesson.iconColor,
            trackColor = PrimaryGray.copy(alpha=0.3f),
            strokeCap = ProgressIndicatorDefaults.CircularIndeterminateStrokeCap,
        )
        Spacer(Modifier.size(4.dp))
        Row { Text(text=stringResource(lessonResultExam.lessonDevelopUi.developStatus.stringRes),
            fontSize = 12.sp, color = MaterialTheme.colorScheme.onSecondary)

            Spacer(modifier = Modifier.weight(1f))
            Text(text=
                "${abs(lessonResultExam.lessonDevelopUi.developPercentage)}%${if (lessonResultExam.lessonDevelopUi.developPercentage>0) "+" else "-"}",
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = 12.sp
            )
        }



    }



    }




}


@Composable
 fun LessonDevelopItems(lastExamResult: ExamResultUi =
                           SampleResultReportData.sampleExamResult1){
Column {
    Row {
        CardLessonDevelopPercentage(
            lessonResultExam = lastExamResult.lessonResultExams[0],
            modifier = Modifier.weight(1f),
        )
        Spacer(modifier = Modifier.width(12.dp))
        CardLessonDevelopPercentage(
            lessonResultExam = lastExamResult.lessonResultExams[1],

            modifier = Modifier.weight(1f)

        )
    }
    Spacer(Modifier.size(12.dp))
    Row {
        CardLessonDevelopPercentage(
            lessonResultExam = lastExamResult.lessonResultExams[2],

            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(12.dp))
        CardLessonDevelopPercentage(
            lessonResultExam = lastExamResult.lessonResultExams[3],

            modifier = Modifier.weight(1f)

        )
    }
}

}
@Composable
fun CompareWithTargets(
    studentSubscription: StudentSubscription,
    shortTimeTargetUi: ShortTimeTargetUi = ShortTimeTargetUi(
    72,
    54,
    8,
    80,7000,50)){
    Surface(modifier = Modifier.fillMaxWidth(),
        shadowElevation = 1.dp,
        shape = RoundedCornerShape(16.dp),
        color = Color.White){
       Box(Modifier.fillMaxWidth()){
           Column(Modifier.padding(16.dp).blur(studentSubscription.status.let { if(it == SubscriptionStatus.NONE) AppValues.blurCount
           else 0.dp }),
               verticalArrangement = Arrangement.spacedBy(16.dp)) {
               repeat(3){
                   Row(verticalAlignment = Alignment.CenterVertically) {
                       when(it){
                           0-> RotbeYarCardIconContainer(
                               imageResVector = R.drawable.time_icon,
                               iconSize = 14.dp,
                               containerSize = 32.dp,
                               cardColor = CardDefaults.cardColors(
                                   PrimaryGreenContainer),
                               iconTint = PrimaryGreen



                           )
                           1->RotbeYarCardIconContainer(
                               imageResVector = R.drawable.test_icon,
                               iconSize = 14.dp,
                               containerSize = 32.dp,
                               cardColor = CardDefaults.cardColors(
                                   PrimaryBlueContainer),
                               iconTint = PrimaryBlue



                           )
                           2->RotbeYarCardIconContainer(
                               imageResVector = R.drawable.cup_icon,
                               iconSize = 14.dp,
                               containerSize = 32.dp,
                               cardColor = CardDefaults.cardColors(
                                   PrimaryPurpleContainer),



                               )
                       }


                       Spacer(Modifier.size(12.dp))
                       Column {

                           Text(text = stringResource(when(it){
                               0->R.string.daily_study_hours
                               1->R.string.daily_test
                               2->R.string.exam_score
                               else -> R.string.exam_score
                           }), fontSize = 14.sp,
                               fontWeight = FontWeight.Medium, color = PrimaryBlack)


                           Text(text ="هدف : "+when(it){
                               0->"${shortTimeTargetUi.studyHourTarget} ساعت"
                               1->"${shortTimeTargetUi.studyHourTarget} تست"
                               2->"بالای ${shortTimeTargetUi.examScoreTarget}"
                               else -> ""
                           },







                               fontSize = 12.sp,
                               color = MaterialTheme.colorScheme.onBackground)
                       }
                       Spacer(Modifier.weight(1f))
                       Column(horizontalAlignment = Alignment.End) {
                           Text(text = when(it){
                               0->"${shortTimeTargetUi.studyHourTarget*shortTimeTargetUi.studyHourTargetPercentage/100} ساعت"
                               1->"${shortTimeTargetUi.testCountTarget*shortTimeTargetUi.testTargetPercentage/100} تست"
                               2->"${shortTimeTargetUi.examScoreTarget*shortTimeTargetUi.examScoreTargetPercentage/100}"
                               else -> "${shortTimeTargetUi.studyHourTarget*shortTimeTargetUi.studyHourTargetPercentage/100}"


                           }, fontWeight = FontWeight.Bold, fontSize = 14.sp,
                               color = PrimaryBlack)
                           Text(text = when(it){

                               0->"${shortTimeTargetUi.studyHourTargetPercentage}٪ تحقق"
                               1->"${shortTimeTargetUi.testTargetPercentage}٪ تحقق"
                               2->"${shortTimeTargetUi.examScoreTargetPercentage}٪ تحقق"
                               else -> "${shortTimeTargetUi.studyHourTarget*shortTimeTargetUi.studyHourTargetPercentage/100}"



                           } ,fontSize = 12.sp,
                               color = MaterialTheme.colorScheme.onBackground)

                       }



                   }
               }


           }
           if(studentSubscription.status == SubscriptionStatus.NONE) ColumnBlurContent(textRes = R.string.plan_setting_by_advisor)
       }
    }

}
@Composable
fun CardExpandableDetailedReports(
isExpanded : Boolean = false,
detailedLessonReport: DetailedLessonReportUi = SampleResultReportData.detailedBiologyReport
) {
    var expanded by remember { mutableStateOf(isExpanded) }

    Card(colors = CardDefaults.cardColors(Color.White),

        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.clip(RoundedCornerShape(16.dp))
            .fillMaxWidth().clickable( ){expanded = !expanded },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp).clip(RoundedCornerShape(4.dp))) {
            Row(
                Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RotbeYarCardIconContainer(
                    shape = RoundedCornerShape(16.dp),
                    containerSize = 40.dp,
                    iconTint = detailedLessonReport.lessonResultExam.lessonDevelopUi.lesson.iconColor,
                    cardColor =
                        CardDefaults.cardColors(detailedLessonReport.lessonResultExam.lessonDevelopUi.lesson.iconContainerColor),
                    imageResVector = detailedLessonReport.lessonResultExam.lessonDevelopUi.lesson.icon)
                Spacer(Modifier.size(12.dp))
              Column(                    modifier = Modifier.weight(1f)
              ) {
                  Text(
                      text = stringResource(detailedLessonReport.
                      lessonResultExam.lessonDevelopUi.lesson.title),
                      fontWeight = FontWeight.Medium,
                      fontSize = 14.sp,
                  )
                  Text(
                      text =stringResource( detailedLessonReport.
                      lessonResultExam.lessonDevelopUi.developStatus.stringRes),
                      fontSize = 12.sp,
                  )
              }

                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = null
                )
            }

           Column(Modifier
               .fillMaxWidth()
               .animateContentSize(),
               verticalArrangement = Arrangement.spacedBy(12.dp)

           ) {
               if (expanded){
                   Spacer(Modifier.size(4.dp))
                   repeat(3){index->
    Card(colors = when(index){
    0 -> CardDefaults.cardColors(PrimaryGreenContainer)
    1-> CardDefaults.cardColors(PrimaryErrorContainer)
    2-> CardDefaults.cardColors(PrimaryBlueContainer)
    else -> CardDefaults.cardColors(MaterialTheme.colorScheme.secondary)
},
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
)

{
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)) {
        Text(text = when(index){
            0 -> stringResource(R.string.strengths)
            1 -> stringResource(R.string.need_to_improve)
            2 -> stringResource(R.string.suggestions)
            else -> ""

        }, fontSize = 14.sp,fontWeight = FontWeight.SemiBold,
            color = when(index){
                0 -> PrimaryGreen
                1 -> PrimaryError
                2 -> PrimaryBlue
                else -> PrimaryGray

            }

        )
        repeat(when(index){
            0 -> detailedLessonReport.strengths.size
            1 -> detailedLessonReport.needToImprove.size
            2 -> 1
            else -> 0
        }){index2->
            Text(
                color = when(index){
                    0->PrimaryGreen
                    1->PrimaryError
                    2->PrimaryBlue
                    else -> PrimaryGray
                }
                ,fontSize = 12.sp,
                text = when(index){
                    0 -> detailedLessonReport.strengths[index2]
                    1-> detailedLessonReport.needToImprove[index2]
                    2-> detailedLessonReport.description
                    else -> ""


                })
        }



    }


}

                   }



               }

           }
        }
    }
}


