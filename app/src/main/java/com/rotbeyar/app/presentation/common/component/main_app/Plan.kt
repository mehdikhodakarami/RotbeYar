package com.rotbeyar.app.presentation.common.component.main_app


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.AppGrgDateTime
import com.rotbeyar.app.domain.model.Week
import com.rotbeyar.app.domain.model.grgToPersianDate
import com.rotbeyar.app.domain.model.subscription.StudentSubscription
import com.rotbeyar.app.domain.model.subscription.SubscriptionStatus
import com.rotbeyar.app.presentation.common.AppValues
import com.rotbeyar.app.presentation.common.component.AppStudyPartIndicator
import com.rotbeyar.app.presentation.common.component.CircleStepWithNumber
import com.rotbeyar.app.presentation.common.component.ColumnBlurContent
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.RotbeYarCardIconContainer
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.LessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.SampleStudentDashboardData
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyLessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyPartStatusUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.plan.LessonDevelopmentInWeekUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.plan.PlanDevelopmentInWeekUi
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryError
import com.rotbeyar.app.ui.theme.PrimaryErrorContainer
import com.rotbeyar.app.ui.theme.PrimaryGrayLight
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryGreenContainer
import com.rotbeyar.app.ui.theme.PrimaryPurple
import saman.zamani.persiandate.PersianDate


@Composable
fun TopBorPlanScreen(seeAllDaysOfWeek :() -> Unit = {},
                     week: Week =Week(startDay = AppGrgDateTime (2004,2,4),
                         endDay =AppGrgDateTime (2004,2,10) )

){
   Row(Modifier.fillMaxWidth(),
       verticalAlignment = Alignment.CenterVertically) {
       Column { Text(text = stringResource(R.string.week_plan),
           fontSize = 18.sp, fontWeight = FontWeight.Bold, color = PrimaryBlack


       )

           Text(text ="${week.startDay.appLocalDate().grgToPersianDate().shDay} ${week.startDay.appLocalDate().grgToPersianDate().monthName} " +
                   "تا ${week.endDay.appLocalDate().grgToPersianDate().shDay} ${week.endDay.appLocalDate().grgToPersianDate().monthName}",
               fontSize = 14.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onBackground


           )
       }
       Spacer(Modifier.weight(1f))
       Text(modifier = Modifier.clickable{   },
           text = stringResource(R.string.complete_view),
           color = MaterialTheme.colorScheme.primary,
           fontSize = 14.sp
       )



   }

}

@Composable
fun CardWeekStatus(currentDay : Int = 14
                   ,firstDay:Int = 10){
    Surface(modifier = Modifier.fillMaxWidth(),
        shadowElevation = 2.dp,
        shape = RoundedCornerShape(12.dp),
        color = Color.White) {
        Row(Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            repeat(7){
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = AppGrgDateTime.persianWeekDays[it],
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontSize = 12.sp)
                    Spacer(Modifier.size(4.dp))
                    CircleStepWithNumber(number = firstDay+it,
                        boxColor = if(firstDay + it == currentDay) PrimaryPurple else PrimaryGrayLight

                    )



                }
            }


        }

    }
}
@Composable
fun CardPlanLessonItem(
    studyLessonUi: StudyLessonUi = SampleStudentDashboardData.sampleStudyLesson1

){
    Surface(modifier = Modifier
        .fillMaxWidth()

       ,
        shape = RoundedCornerShape(16.dp),

        color =  if(studyLessonUi.status == StudyPartStatusUi.IN_PROGRESS) PrimaryPurple else Color.White
        )

    {
        Box(Modifier
            .fillMaxWidth()
            .padding(
                if (studyLessonUi.status == StudyPartStatusUi.IN_PROGRESS)
                    PaddingValues(end = 6.dp) else PaddingValues(0.dp)
            )
            .background(Color.White, RoundedCornerShape(16.dp))
            ){
            Row (Modifier.padding(16.dp)) {
                AppStudyPartIndicator(status = studyLessonUi.status)
                Spacer(Modifier.size(12.dp))
                RotbeYarCardIconContainer(imageResVector = studyLessonUi.lesson.icon,
                    iconSize = 15.dp,
                    containerSize = 40.dp,
                    iconTint = studyLessonUi.lesson.iconColor,
                    cardColor = CardDefaults.cardColors(studyLessonUi.lesson.iconContainerColor))
                Spacer(Modifier.size(12.dp))
                Column {
                    Text(text = studyLessonUi.subject,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = PrimaryBlack)
                    Text(text = "${studyLessonUi.startTime} - ${studyLessonUi.endtime}",
                        fontSize = 12.sp,

                        color = MaterialTheme.colorScheme.onBackground)
                }
                Spacer(Modifier.weight(1f))
                Surface(modifier = Modifier.height(20.dp),color = when(studyLessonUi.status){
                    StudyPartStatusUi.NOT_STARTED -> PrimaryGrayLight
                    StudyPartStatusUi.MISSED -> PrimaryErrorContainer
                    StudyPartStatusUi.IN_PROGRESS -> PrimaryPurple
                    StudyPartStatusUi.DONE -> PrimaryGreenContainer
                }
                    , shape = RoundedCornerShape(8.dp)


                )


                { Text(textAlign = TextAlign.Center ,modifier = Modifier.padding(horizontal = 8.dp,),text = stringResource(when(studyLessonUi.status){
                    StudyPartStatusUi.NOT_STARTED -> R.string.not_started
                    StudyPartStatusUi.MISSED -> R.string.missed
                    StudyPartStatusUi.IN_PROGRESS -> R.string.in_progress
                    StudyPartStatusUi.DONE -> R.string.done
                }),
                    color = when(studyLessonUi.status){
                        StudyPartStatusUi.NOT_STARTED -> PrimaryBlack
                        StudyPartStatusUi.MISSED -> PrimaryError
                        StudyPartStatusUi.IN_PROGRESS -> Color.White
                        StudyPartStatusUi.DONE -> PrimaryGreen
                    },
                    fontSize = 10.sp




                ) }





            }





Box(Modifier
    .matchParentSize()
    .background(
        when (
            studyLessonUi.status
        ) {
            StudyPartStatusUi.NOT_STARTED -> Color.Transparent
            StudyPartStatusUi.MISSED -> PrimaryErrorContainer.copy(alpha = 0.4f)
            StudyPartStatusUi.IN_PROGRESS -> Color.Transparent
            StudyPartStatusUi.DONE -> PrimaryGrayLight.copy(alpha = 0.4f)
        }
    ))
        }




    }

}

@Composable
fun CardReportProblem(studentSubscription: StudentSubscription){
    Surface(shape = RoundedCornerShape(16.dp),
        color = Color.White){

        Box(Modifier.fillMaxWidth().background(Color.Transparent)){
            Column(Modifier.padding(16.dp).blur(if(studentSubscription.status
                == SubscriptionStatus.NONE) AppValues.blurCount else 0.dp)) {
                Row(Modifier.fillMaxWidth()){
                    RotbeYarCardIconContainer(
                        shape = RoundedCornerShape(12.dp),

                        imageResVector = R.drawable.info_icon,
                        iconSize = 15.dp,
                        containerSize = 40.dp,
                        iconTint = PrimaryError,
                        cardColor = CardDefaults.cardColors(PrimaryErrorContainer)


                    )
                    Spacer(Modifier.size(12.dp))
                    Column {
                        Text(text = stringResource(R.string.problem_in_study),
                            fontSize = 14.sp,
                            color = PrimaryBlack,
                            fontWeight = FontWeight.Medium
                        )
                        Text(text = stringResource(R.string.report_plan_for_update),
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground)
                    }

                }
                Spacer(Modifier.size(16.dp))
                RotbeYarButton(modifier = Modifier.fillMaxWidth(), onClick = {},
                    text = stringResource(R.string.record_new_problem),
                    contentColor = PrimaryError,
                    backgroundColor = PrimaryErrorContainer,
                    icon = ImageVector.vectorResource(R.drawable.increase_icon)

                )



            }
            if(studentSubscription.status == SubscriptionStatus.NONE) ColumnBlurContent(textRes = R.string.report_problem_for_edit)
        }


    }
}


@Composable
fun CardLessonDevelopmentInWeek(
    studentSubscription: StudentSubscription,
    planDevelopmentInWeek: PlanDevelopmentInWeekUi = PlanDevelopmentInWeekUi(
    listOfStudy =  listOf(
        LessonDevelopmentInWeekUi(SampleStudentDashboardData.sampleMathLesson,10,10),
        LessonDevelopmentInWeekUi(SampleStudentDashboardData.sampleChemistryLesson,10,10),
        LessonDevelopmentInWeekUi(SampleStudentDashboardData.samplePhysicsLesson,10,10),
        LessonDevelopmentInWeekUi(SampleStudentDashboardData.sampleBiologyLesson,10,10)



    ),
    overallCountTest = 1000,
    overallCountStudyHour =18
)

){
    Surface(shadowElevation = 2.dp,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Color.White
        ){

        Box(Modifier.fillMaxWidth().background(Color.Transparent)){
            Column(Modifier.padding(16.dp).blur(if(studentSubscription.status == SubscriptionStatus.NONE)
                AppValues.blurCount else 0.dp)) {
                Row(Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround) {

                    repeat(2){
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text =  when(it){
                                0->planDevelopmentInWeek.overallCountStudyHour.toString()
                                else->planDevelopmentInWeek.overallCountTest.toString()
                            },
                                fontWeight = FontWeight.Bold,

                                fontSize = 24.sp,
                                color = when(it){
                                    0->PrimaryPurple
                                    else->PrimaryGreen
                                })

                            Text(text =  stringResource(when(it){
                                0->R.string.study_hours
                                else->R.string.test_solved
                            }),
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.onBackground)

                        }
                    }


                }
                Spacer(Modifier.size(16.dp
                ))

                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

                    repeat(4){lessonIndex ->


                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier
                                .size(14.dp)
                                .background(
                                    planDevelopmentInWeek.listOfStudy[lessonIndex].lesson.iconColor,
                                    CircleShape
                                ))
                            Spacer(Modifier.size(8.dp))
                            Text(text = stringResource(planDevelopmentInWeek.listOfStudy[lessonIndex].lesson.title)
                                , fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSecondary
                            )
                            Spacer(Modifier.weight(1f))
                            Text(text = "${planDevelopmentInWeek.listOfStudy[lessonIndex].countTestInWeek.toString()} تست"
                                , fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )


                        }


                    }
                }


            }

            if(studentSubscription.status == SubscriptionStatus.NONE) ColumnBlurContent()
        }

    }
}

