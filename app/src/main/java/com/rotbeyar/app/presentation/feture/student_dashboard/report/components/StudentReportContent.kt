package com.rotbeyar.app.presentation.feture.student_dashboard.report.components

import CardChartDailyStudy
import LineChartExamResult
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable

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
import com.rotbeyar.app.domain.model.subscription.StudentSubscription
import com.rotbeyar.app.domain.model.subscription.SubscriptionStatus
import com.rotbeyar.app.domain.model.subscription.SubscriptionType
import com.rotbeyar.app.presentation.common.component.CardEmptyItem
import com.rotbeyar.app.presentation.common.component.ColumnBlurContent
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.component.main_app.AdvisorIsPlanning
import com.rotbeyar.app.presentation.common.component.main_app.CardExpandableDetailedReports
import com.rotbeyar.app.presentation.common.component.main_app.CardOverallDevelopment
import com.rotbeyar.app.presentation.common.component.main_app.CompareWithTargets
import com.rotbeyar.app.presentation.common.component.main_app.LessonDevelopItems
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.SampleStudentDashboardData
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ShortTimeTargetUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyPartStatusUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.DetailedLessonReportUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.ExamResultUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.OverallDevelopUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.SampleResultReportData
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.StudyInDayUi
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBlack
import kotlin.collections.get


@Composable
fun StudentReportContent(modifier: Modifier = Modifier,
                         studentSubscription: StudentSubscription =StudentSubscription(
                             type = SubscriptionType.VIP,
                             status = SubscriptionStatus.ACTIVE,
                             expiresAt = "",
                             startDate = 12,
                             expiryDate = 12,
                             daysRemaining =8
                         ),
                         overallDevelop: OverallDevelopUi = SampleResultReportData.sampleOverallDevelop,
                         studyInDayList: List<StudyInDayUi> =ChartLists.weeklyStudyInDayData,

                         listOfExamResult  : List<ExamResultUi> = listOf(
//                             SampleResultReportData.sampleExamResult1,
//                             SampleResultReportData.sampleExamResult1,
//                             SampleResultReportData.sampleExamResult1,
//                             SampleResultReportData.sampleExamResult2,
//
//                             SampleResultReportData.sampleExamResult3,
//
//                             SampleResultReportData.sampleExamResult4,
//                             SampleResultReportData.sampleExamResult5

                         ),
                         shortTimeTarget: ShortTimeTargetUi = SampleStudentDashboardData.sampleShortTimeTargetHigh,
                         listOfDetailedLessonReportUi: List<DetailedLessonReportUi> = listOf(
                             SampleResultReportData.detailedBiologyReport,
                             SampleResultReportData.detailedMathReport,
                            SampleResultReportData.detailedPhysicsReport,

                             SampleResultReportData.detailedChemistryReport


                         )
){
    LazyColumn(modifier.fillMaxWidth()) {

        item {
            Spacer(Modifier.size(4.dp))
            CardOverallDevelopment(overallDevelop = overallDevelop)
            Spacer(Modifier.size(24.dp))
        }
        item {
            Column {
                Row { Text(text = stringResource(R.string.daily_study_report

                ), fontSize = 16.sp, color = PrimaryBlack,
                    fontWeight = FontWeight.SemiBold)
                    Spacer(Modifier.weight(1f))
                    Text(text = stringResource(R.string.current_week),
                        fontSize = 12.sp, color = MaterialTheme.colorScheme.onBackground,
                        )
                    Spacer(Modifier.size(12.dp))


                }
                Spacer(Modifier.size(12.dp))
                studentSubscription.let {
if(it.status == SubscriptionStatus.NONE) CardChartDailyStudy(
    studentSubscription = studentSubscription) else CardChartDailyStudy(
        studentSubscription = studentSubscription, studyInDayUiList = studyInDayList)

                }

                Spacer(Modifier.size(24.dp))


            }


        }

        item { Column {
            Row {
                Text(text = stringResource(R.string.exams_performance_analysis

                ), fontSize = 16.sp, color = PrimaryBlack,
                    fontWeight = FontWeight.SemiBold)
            }
            Spacer(Modifier.size(12.dp))
            if(studentSubscription.status == SubscriptionStatus.ACTIVE &&
                listOfExamResult.isNullOrEmpty()){
                CardEmptyItem(titleRes = R.string.no_exam_taken_yet,
                   subTitleRes =  R.string.progress_will_show_after_first_exam,
                   iconRes =  R.drawable.test_icon)
            } else
            Box(Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)
            ).background(Color.Transparent)){
                Column(Modifier.blur(studentSubscription.status.let { if(it == SubscriptionStatus.NONE) 3.dp else 0.dp })){
                    studentSubscription.let {
                        if(it.status == SubscriptionStatus.NONE)   LineChartExamResult(
                            studentSubscription = studentSubscription,)else   LineChartExamResult( studentSubscription = studentSubscription,
                            examResults = listOfExamResult)

                    }
                    Spacer(Modifier.size(16.dp))
                    if(studentSubscription.status == SubscriptionStatus.NONE) LessonDevelopItems() else LessonDevelopItems(listOfExamResult.last())


                }
                if(studentSubscription.status == SubscriptionStatus.NONE) ColumnBlurContent( textRes = R.string.record_exams_development)
            }
            Spacer(Modifier.size(16.dp))



        }
        }

        item {
            Column {
                Text(text = stringResource(R.string.compare_with_targets

                ), fontSize = 16.sp, color = PrimaryBlack,
                    fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.size(12.dp))
                if(studentSubscription.status == SubscriptionStatus.NONE &&
                    listOfExamResult.isNullOrEmpty()
                    ) AdvisorIsPlanning()
                else{
                    studentSubscription.status.let {

                        if(it == SubscriptionStatus.NONE)
                            CompareWithTargets(studentSubscription)
                        else CompareWithTargets(studentSubscription,
                            shortTimeTarget) }
                }


                Spacer(Modifier.size(24.dp))

            }

        }

        item{
            Column {
                Text(text = stringResource(R.string.detailed_reports

                ), fontSize = 16.sp, color = PrimaryBlack,
                    fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.size(12.dp))
                if(studentSubscription.status == SubscriptionStatus.ACTIVE
                    &&
                   listOfDetailedLessonReportUi.isNullOrEmpty() &&
                    !listOfExamResult.isNullOrEmpty()  ){
                    AdvisorIsPlanning()

                }else if(studentSubscription.status == SubscriptionStatus.ACTIVE
                    &&
                    listOfDetailedLessonReportUi.isNullOrEmpty() &&
                    listOfExamResult.isNullOrEmpty() ){
                    CardEmptyItem(modifier = Modifier ,
                         titleRes = R.string.no_exam_taken_yet,
                       subTitleRes = R.string.progress_will_show_after_first_exam,
                        iconRes = R.drawable.test_icon)
                } else {
                    Box(Modifier.fillMaxWidth().background(Color.Transparent).clip(
                        RoundedCornerShape(16.dp))){
                        Column(modifier = Modifier.blur(if (studentSubscription.status == SubscriptionStatus.NONE) 3.dp else 0.dp)) {
                            repeat(4){
                                if(it == 0){
                                    if(studentSubscription.status == SubscriptionStatus.NONE)
                                        CardExpandableDetailedReports(true
                                            ,detailedLessonReport
                                            =listOfDetailedLessonReportUi[it]) else
                                        CardExpandableDetailedReports(false
                                            ,detailedLessonReport
                                            =listOfDetailedLessonReportUi[it])

                                }else{
                                    CardExpandableDetailedReports(
                                        detailedLessonReport
                                        =listOfDetailedLessonReportUi[it])
                                }

                                if(it != 3){
                                    Spacer(Modifier.size(12.dp))
                                }


                            }
                        }
                        if(studentSubscription.status == SubscriptionStatus.NONE) ColumnBlurContent(textRes = R.string.strengths_weaknesses_analysis_from_exams)
                    }



                }

            }
            Spacer(Modifier.size(8.dp))

        }
    }


}


