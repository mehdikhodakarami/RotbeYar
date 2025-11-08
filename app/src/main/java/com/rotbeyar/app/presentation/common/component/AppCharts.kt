//package com.rotbeyar.app.presentation.common.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.mapper.toUi
import com.rotbeyar.app.domain.model.AppGrgDateTime
import com.rotbeyar.app.domain.model.Lesson
import com.rotbeyar.app.domain.model.grgToPersianDate
import com.rotbeyar.app.domain.model.subscription.StudentSubscription
import com.rotbeyar.app.domain.model.subscription.SubscriptionStatus
import com.rotbeyar.app.presentation.common.AppValues
import com.rotbeyar.app.presentation.common.component.ColumnBlurContent
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.LessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.ExamResultUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.SampleResultReportData
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.StudyInDayUi
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryGray
import com.rotbeyar.app.ui.theme.PrimaryGrayLight
import io.github.dautovicharis.charts.LineChart
import io.github.dautovicharis.charts.model.toChartDataSet
import io.github.dautovicharis.charts.style.ChartViewDefaults
import io.github.dautovicharis.charts.style.LineChartDefaults

object ChartLists{

    val weeklyStudyInDayData: List<StudyInDayUi> = listOf(
        StudyInDayUi(
            lessonsProgress = mapOf(
                SampleResultReportData.lessonMath to 0,
                SampleResultReportData.lessonPhysics to 0,
                SampleResultReportData.lessonBiology to 0,
                SampleResultReportData.lessonChemistry to 2
            )
        ),
        StudyInDayUi(
            lessonsProgress = mapOf(
                SampleResultReportData.lessonMath to 2,
                SampleResultReportData.lessonPhysics to 2,
                SampleResultReportData.lessonBiology to 4,
                SampleResultReportData.lessonChemistry to 1
            )
        ), StudyInDayUi(
            lessonsProgress = mapOf(
                SampleResultReportData.lessonMath to 2,
                SampleResultReportData.lessonPhysics to 2,
                SampleResultReportData.lessonBiology to 1,
                SampleResultReportData.lessonChemistry to 2
            )
        ), StudyInDayUi(
            lessonsProgress = mapOf(
                SampleResultReportData.lessonMath to 2,
                SampleResultReportData.lessonPhysics to 3,
                SampleResultReportData.lessonBiology to 1,
                SampleResultReportData.lessonChemistry to 2
            )
        ), StudyInDayUi(
            lessonsProgress = mapOf(
                SampleResultReportData.lessonMath to 2,
                SampleResultReportData.lessonPhysics to 3,
                SampleResultReportData.lessonBiology to 4,
                SampleResultReportData.lessonChemistry to 2
            )
        ), StudyInDayUi(
            lessonsProgress = mapOf(
                SampleResultReportData.lessonMath to 2,
                SampleResultReportData.lessonPhysics to 3,
                SampleResultReportData.lessonBiology to 4,
                SampleResultReportData.lessonChemistry to 2
            )
        ), StudyInDayUi(
            lessonsProgress = mapOf(
                SampleResultReportData.lessonMath to 2,
                SampleResultReportData.lessonPhysics to 3,
                SampleResultReportData.lessonBiology to 4,
                SampleResultReportData.lessonChemistry to 2
            )
        ),

    )

    val examResultsForLineChart = listOf(
        SampleResultReportData.sampleExamResult1.copy(
            exam = SampleResultReportData.sampleExam.copy(formattedDate = "1403/07/05"),
            totalScore = 6400
        ),
        SampleResultReportData.sampleExamResult1.copy(
            exam = SampleResultReportData.sampleExam.copy(formattedDate = "1403/07/19"),
            totalScore = 6700
        ),
        SampleResultReportData.sampleExamResult1.copy(
            exam = SampleResultReportData.sampleExam.copy(formattedDate = "1403/08/02"),
            totalScore = 7100
        ),
        SampleResultReportData.sampleExamResult1.copy(
            exam = SampleResultReportData.sampleExam.copy(formattedDate = "1403/08/16"),
            totalScore = 7300
        ),
        SampleResultReportData.sampleExamResult1.copy(
            exam = SampleResultReportData.sampleExam.copy(formattedDate = "1403/09/01"),
            totalScore = 7150
        )
    )
}


//



//fun normalizeLessonOrder(inputMap: List<Map<Lesson, Float>>): List<Map<Lesson, Float>> {
//    val newInput = mutableListOf<Map<Lesson, Float>>()
//    for (dayMap in inputMap) {
//        val normalized = ChartLists.lessonOrder.associateWith { lesson ->
//            dayMap[lesson] ?: 0f
//        }
//        newInput.add(normalized)
//    }
//    return newInput
//}


@Composable
fun CardChartDailyStudy(modifier: Modifier= Modifier,
                        studentSubscription: StudentSubscription,
maxSum : Int = 12,
                        studyInDayUiList :List<StudyInDayUi> = ChartLists.weeklyStudyInDayData,
) {
if(studyInDayUiList.size !=7 ||
    studyInDayUiList.any { day -> day.lessonsProgress.values.sum() > maxSum }


) return

    Surface(modifier = Modifier.fillMaxWidth(),
        color = Color.White,

        shape = RoundedCornerShape(12.dp)
    ){
        Box(modifier = Modifier.fillMaxWidth().background(Color.Transparent)){
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                Column(Modifier.height(400.dp).padding(vertical = 24.dp, horizontal = 16.dp).blur(
                    if(studentSubscription.status == SubscriptionStatus.NONE) AppValues.blurCount
                else 0.dp)) {
                    Box(Modifier.weight(1f)){

                        Column(Modifier.fillMaxHeight(),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.SpaceBetween) {
                            repeat(7){
                                    index->
                                Row {
                                    Text(text = (12-index*2).toString() )



                                }
                            }


                        }
                        AppBarChart(modifier = Modifier.padding(start = 24.dp),
                            maxSum = maxSum

                            ,studyInDayUiList =studyInDayUiList)



                    }
                    Row(Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        repeat(7){index->
                            Text(fontSize = 12.sp,text = AppGrgDateTime.persianWeekDays[index]


                            )

                        }
                    }
                    Spacer(Modifier.size(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        repeat(4) { lessonIndex ->
                            Row(
                                modifier = Modifier.weight(1f),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    color = MaterialTheme.colorScheme.onSurface,
                                    fontWeight = FontWeight.Light,
                                    fontSize = 10.sp,
                                    text = stringResource(studyInDayUiList[0].lessonsProgress.keys.toList()[lessonIndex].title),
                                )

                                Spacer(Modifier.size(4.dp))

                                Box(
                                    Modifier
                                        .size(16.dp)
                                        .background(
                                            color = studyInDayUiList[0].lessonsProgress.keys.toList()[lessonIndex].iconColor
                                        )
                                )
                            }
                        }
                    }


                }

            }

           if(studentSubscription.status == SubscriptionStatus.NONE) ColumnBlurContent(textRes = R.string.daily_study_analysis)


        }

    }


}


@Composable
fun BoxScope.AppBarChart(modifier: Modifier = Modifier,
                         maxSum: Int = 12,
                         studyInDayUiList: List<StudyInDayUi>?,





){
    Box(modifier.fillMaxSize()){
        Column(Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween) {
            repeat(7){
                HorizontalDivider(Modifier.fillMaxWidth(),
                    color = PrimaryGrayLight)

            }
        }
        if(!studyInDayUiList.isNullOrEmpty())
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()) {
            repeat(7){day->
                SingleBarChart(maxSum =maxSum ,
                    studyInDayUi = studyInDayUiList[day])

            }

        }
    }

}

@Composable
fun SingleBarChart(
    studyInDayUi: StudyInDayUi?,
    maxSum: Int = 12
) {
val lessonOrder2 = listOf(
    Lesson.CHEMISTRY.toUi(),
    Lesson.BIOLOGY.toUi(),

    Lesson.MATH.toUi(),

    Lesson.PHYSICS.toUi(),



    )


    val sortedListOfLesson: List<Pair<LessonUi, Float>> = lessonOrder2.map { lessonOrder ->

        val lesson = studyInDayUi?.lessonsProgress?.keys?.find { it.title == lessonOrder.title }
        val value = studyInDayUi?.lessonsProgress[lesson]?.toFloat() ?: 0f
        lesson?.let {
            lesson to value
        } ?: (lessonOrder to 0f)
    }

    val sumTimes = studyInDayUi?.lessonsProgress?.values?.sum()?:0
    val spaceWeight = (maxSum - sumTimes)

    val weights = listOf(spaceWeight.toFloat()) + sortedListOfLesson.map { it.second }
    Log.i("WEIGHHHHTTT", "$weights")
    Column(
        Modifier
            .fillMaxHeight()
            .width(24.dp)
    ) {
        repeat(weights.size) { index ->
            if (index == 0) {
                if(weights[index] > 0)
                    Spacer(Modifier.weight(weights[0]))
            } else {
                if(weights[index] > 0)
                    Box(
                        Modifier.width(12.dp).align(Alignment.CenterHorizontally
                        )
                            .weight(weights[index])
                            .fillMaxWidth()
                            .background(sortedListOfLesson[index - 1].first.iconColor.copy(alpha = 0.8f))
                    )


            }
        }
    }
}



@Composable
fun LineChartExamResult(
    bezier : Boolean = false,
    studentSubscription: StudentSubscription ,

    examResults:List<ExamResultUi>  = ChartLists.examResultsForLineChart ){
val shamsiExamDates = examResults.map { it.date.appLocalDate().grgToPersianDate() }

    val style = LineChartDefaults.style(

        lineColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
        pointColor = MaterialTheme.colorScheme.primary,
        pointSize = 14f,
        bezier = bezier,
        dragPointColor = PrimaryGray,
        dragPointVisible = true,
        dragPointSize = 8f,
        dragActivePointSize = 15f,
        chartViewStyle = ChartViewDefaults.style(shadow = 0.dp
            ,backgroundColor = Color.Transparent,
            innerPadding = 12.dp,
            outerPadding = 0.dp)
    )

    val dataSet = examResults.map { it.totalScore }
        .toChartDataSet(
            title = "آزمون ها",
            prefix = "تراز "
        )

    Surface(modifier = Modifier.fillMaxWidth(),
        color = Color.White,

        shape = RoundedCornerShape(12.dp)
    ){
        Box(modifier = Modifier.fillMaxWidth().background(Color.Transparent)){

            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {

                Box(Modifier.wrapContentSize().blur(if (studentSubscription.status
                    == SubscriptionStatus.NONE) AppValues.blurCount else 0.dp).padding(vertical = 24.dp, horizontal = 16.dp)){
                    Column {
                        LineChart(dataSet = dataSet, style = style)
                        HorizontalDivider(Modifier.fillMaxWidth())
                        Row(Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween)
                        { repeat(shamsiExamDates.size){indexExam->
                            Row {
                                Text("${shamsiExamDates[indexExam].monthName}",
                                    fontSize = 12.sp,color = PrimaryBlack,
                                    fontWeight = FontWeight.Light)


                                Spacer(Modifier.width(1.5.dp))


                                Text("${shamsiExamDates[indexExam].shDay}",fontSize = 12.sp,color = PrimaryBlack,
                                    fontWeight = FontWeight.Light)

                            }


                        }

                        }
                    }




                }


            }

        }}
}

