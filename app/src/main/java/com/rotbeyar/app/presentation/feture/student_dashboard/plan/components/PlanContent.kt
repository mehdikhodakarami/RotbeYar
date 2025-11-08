package com.rotbeyar.app.presentation.feture.student_dashboard.plan.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.AppGrgDateTime
import com.rotbeyar.app.domain.model.Week
import com.rotbeyar.app.domain.model.grgToPersianDate
import com.rotbeyar.app.domain.model.subscription.StudentSubscription
import com.rotbeyar.app.domain.model.subscription.SubscriptionStatus
import com.rotbeyar.app.domain.model.subscription.SubscriptionType
import com.rotbeyar.app.presentation.common.AppValues
import com.rotbeyar.app.presentation.common.component.ColumnBlurContent
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.component.main_app.AdvisorIsPlanning
import com.rotbeyar.app.presentation.common.component.main_app.CardLessonDevelopmentInWeek
import com.rotbeyar.app.presentation.common.component.main_app.CardPlanLessonItem
import com.rotbeyar.app.presentation.common.component.main_app.CardReportProblem
import com.rotbeyar.app.presentation.common.component.main_app.CardWeekStatus
import com.rotbeyar.app.presentation.common.component.main_app.TopBorPlanScreen
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.SampleStudentDashboardData
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyLessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.plan.LessonDevelopmentInWeekUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.plan.PlanDevelopmentInWeekUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.plan.ReportTest
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBlack
import saman.zamani.persiandate.PersianDate

@Composable
fun PlanContent( studentSubscription: StudentSubscription =StudentSubscription(
    type = SubscriptionType.VIP,
    status = SubscriptionStatus.NONE,
    expiresAt = "",
    startDate = 12,
    expiryDate = 12,
    daysRemaining =8
),
    currentWeek: Week =Week(startDay = AppGrgDateTime
        (2004,2,4),
        endDay =AppGrgDateTime (2004,2,10) )

    ,
    todayIndexInWeek : Int = 2,






    listOfStudyLesson : List<StudyLessonUi> = listOf(),


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
    val todayPersianDate : PersianDate = currentWeek.startDay.appLocalDate().plusDays(
        todayIndexInWeek.toLong()).grgToPersianDate()


    LazyColumn(Modifier.padding(16.dp)) {


        item{

            TopBorPlanScreen(week = currentWeek)
            Spacer(Modifier.size(8.dp))

        }

        item{
CardWeekStatus(currentDay = currentWeek.startDay.appLocalDate().
plusDays(todayIndexInWeek.toLong()).grgToPersianDate().shDay, firstDay =currentWeek.startDay.appLocalDate().grgToPersianDate().shDay )
            Spacer(Modifier.size(16.dp))

        }

        item{
            Row{
                Text(text = stringResource(R.string.today_plan), fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = PrimaryBlack
                )
                Spacer(Modifier.weight(1f))
                Text(text =
                    "${todayPersianDate.dayName()} ${todayPersianDate.shDay} ${todayPersianDate.monthName}",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onBackground)
            }
            Spacer(Modifier.size(12.dp))


        }

        item{
            Box(modifier = Modifier.clip(RoundedCornerShape(16.dp)).
            fillMaxWidth().background(Color.Transparent)){
                Column(modifier = Modifier.blur(if(
                    studentSubscription.status == SubscriptionStatus.NONE )
                    AppValues.blurCount else 0.dp),verticalArrangement =
                    Arrangement.spacedBy(12.dp)){
                    if(listOfStudyLesson.isEmpty()){
                        if(studentSubscription.status == SubscriptionStatus.NONE){
                            repeat(4){
                                CardPlanLessonItem(ReportTest.listOfStudyLesson[it])


                            }
                        }else AdvisorIsPlanning()

                    }else{

                        repeat(listOfStudyLesson.size){
                        CardPlanLessonItem(listOfStudyLesson[it])


                    }

                    }


                }
                if(studentSubscription.status == SubscriptionStatus.NONE )
                    ColumnBlurContent(textRes = R.string.personalized_plan)



            }
            Spacer(Modifier.size(24.dp))



        }

        item{
            Row{

                Text(text = stringResource(R.string.report_problem),
                    fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                    color = PrimaryBlack


                )
            }
            Spacer(Modifier.size(12.dp))
            CardReportProblem(studentSubscription)
            Spacer(Modifier.size(24.dp))




        }
        item {
            Row{

                Text(text = stringResource(R.string.weekly_study_numbers),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = PrimaryBlack


                )


            }
            Spacer(Modifier.size(12.dp))
            studentSubscription.status.let { if(it == SubscriptionStatus.NONE)
                CardLessonDevelopmentInWeek(studentSubscription) else
                CardLessonDevelopmentInWeek(studentSubscription ,planDevelopmentInWeek)


            }
            CardLessonDevelopmentInWeek(studentSubscription)
            Spacer(Modifier.size(8.dp))

        }




    }


}
@Composable
@Preview(showBackground = true,locale = "fa")

fun show1(){

    AppTheme {
        StandardBoxPage(Modifier.background(MaterialTheme.colorScheme.secondary)) {
            PlanContent()

        }

    }
}
