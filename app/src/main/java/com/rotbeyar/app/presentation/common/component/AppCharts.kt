package com.rotbeyar.app.presentation.common.component

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.AppGrgDateTime
import com.rotbeyar.app.domain.model.Exam
import com.rotbeyar.app.domain.model.ExamResult
import com.rotbeyar.app.domain.model.LessonResultExam
import com.rotbeyar.app.domain.model.grgToPersianDate
import com.rotbeyar.app.presentation.common.model.Lesson
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryGray
import io.github.dautovicharis.charts.LineChart
import io.github.dautovicharis.charts.model.toChartDataSet
import io.github.dautovicharis.charts.style.ChartViewDefaults
import io.github.dautovicharis.charts.style.LineChartDefaults

object ChartLists{

    val sampleExamResults: List<ExamResult> = listOf(
        ExamResult(
            exam = Exam(id = 1, title = R.string.exam_ghalamchi),
            date = AppGrgDateTime(2023, 10, 1),
            totalScore = 6800,
            lessonResultExams = listOf(
                LessonResultExam(Lesson.CHEMISTRY, scorePercentage = 80, developPercentage = 10),
                LessonResultExam(Lesson.BIOLOGY, scorePercentage = 90, developPercentage = 4),
                LessonResultExam(Lesson.MATH, scorePercentage = 100, developPercentage = 9),
                LessonResultExam(Lesson.PHYSICS, scorePercentage = 39, developPercentage = 11)
            )
        ),
        ExamResult(
            exam = Exam(id = 2, title = R.string.exam_gozine2),
            date = AppGrgDateTime(2023, 10, 15),
            totalScore = 7200,
            lessonResultExams = listOf(
                LessonResultExam(Lesson.CHEMISTRY, scorePercentage = 85, developPercentage = 6),
                LessonResultExam(Lesson.BIOLOGY, scorePercentage = 78, developPercentage = 12),
                LessonResultExam(Lesson.MATH, scorePercentage = 92, developPercentage = 8),
                LessonResultExam(Lesson.PHYSICS, scorePercentage = 70, developPercentage = 15)
            )
        ),
        ExamResult(
            exam = Exam(id = 3, title = R.string.exam_maz),
            date = AppGrgDateTime(2023, 11, 5),
            totalScore = 6900,
            lessonResultExams = listOf(
                LessonResultExam(Lesson.CHEMISTRY, scorePercentage = 76, developPercentage = 14),
                LessonResultExam(Lesson.BIOLOGY, scorePercentage = 88, developPercentage = 9),
                LessonResultExam(Lesson.MATH, scorePercentage = 95, developPercentage = 11),
                LessonResultExam(Lesson.PHYSICS, scorePercentage = 65, developPercentage = 17)
            )
        ),
        ExamResult(
            exam = Exam(id = 4, title = R.string.exam_gaj),
            date = AppGrgDateTime(2023, 11, 20),
            totalScore = 7100,
            lessonResultExams = listOf(
                LessonResultExam(Lesson.CHEMISTRY, scorePercentage = 90, developPercentage = 7),
                LessonResultExam(Lesson.BIOLOGY, scorePercentage = 82, developPercentage = 13),
                LessonResultExam(Lesson.MATH, scorePercentage = 97, developPercentage = 10),
                LessonResultExam(Lesson.PHYSICS, scorePercentage = 72, developPercentage = 16)
            )
        ),
        ExamResult(
            exam = Exam(id = 5, title = R.string.exam_ghalamchi),
            date = AppGrgDateTime(2023, 12, 10),
            totalScore = 7400,
            lessonResultExams = listOf(
                LessonResultExam(Lesson.CHEMISTRY, scorePercentage = 88, developPercentage = 9),
                LessonResultExam(Lesson.BIOLOGY, scorePercentage = 91, developPercentage = 6),
                LessonResultExam(Lesson.MATH, scorePercentage = 96, developPercentage = 12),
                LessonResultExam(Lesson.PHYSICS, scorePercentage = 77, developPercentage = 14)
            )
        ),
        ExamResult(
            exam = Exam(id = 6, title = R.string.exam_gozine2),
            date = AppGrgDateTime(2023, 12, 25),
            totalScore = 7000,
            lessonResultExams = listOf(
                LessonResultExam(Lesson.CHEMISTRY, scorePercentage = 82, developPercentage = 11),
                LessonResultExam(Lesson.BIOLOGY, scorePercentage = 85, developPercentage = 8),
                LessonResultExam(Lesson.MATH, scorePercentage = 93, developPercentage = 9),
                LessonResultExam(Lesson.PHYSICS, scorePercentage = 68, developPercentage = 18)
            )
        ),
        ExamResult(
            exam = Exam(id = 7, title = R.string.exam_maz),
            date = AppGrgDateTime(2024, 1, 12),
            totalScore = 7600,
            lessonResultExams = listOf(
                LessonResultExam(Lesson.CHEMISTRY, scorePercentage = 91, developPercentage = 5),
                LessonResultExam(Lesson.BIOLOGY, scorePercentage = 89, developPercentage = 7),
                LessonResultExam(Lesson.MATH, scorePercentage = 98, developPercentage = 10),
                LessonResultExam(Lesson.PHYSICS, scorePercentage = 80, developPercentage = 12)
            )
        )
    )
    val  weekStudyData: List<Map<Lesson, Float>> = listOf(
        mapOf( // شنبه
            Lesson.CHEMISTRY to 3f,
            Lesson.BIOLOGY to 2f,
            Lesson.MATH to 4f,
            Lesson.PHYSICS to 1f
        ),
        mapOf( // یکشنبه
            Lesson.CHEMISTRY to 2f,
            Lesson.BIOLOGY to 3f,
            Lesson.MATH to 2f,
            Lesson.PHYSICS to 2f
        ),
        mapOf( // دوشنبه
            Lesson.CHEMISTRY to 4f,
            Lesson.BIOLOGY to 2f,
            Lesson.MATH to 3f,
            Lesson.PHYSICS to 1f
        ),
        mapOf( // سه‌شنبه
            Lesson.CHEMISTRY to 1f,
            Lesson.BIOLOGY to 2f,
            Lesson.MATH to 3f,
            Lesson.PHYSICS to 2f
        ),
        mapOf( // چهارشنبه
            Lesson.CHEMISTRY to 2f,
            Lesson.BIOLOGY to 1f,
            Lesson.MATH to 4f,
            Lesson.PHYSICS to 2f
        ),
        mapOf( // پنجشنبه
            Lesson.CHEMISTRY to 3f,
            Lesson.BIOLOGY to 3f,
            Lesson.MATH to 2f,
            Lesson.PHYSICS to 1f
        ),
        mapOf( // جمعه
            Lesson.CHEMISTRY to 2f,
            Lesson.BIOLOGY to 2f,
            Lesson.MATH to 2f,
            Lesson.PHYSICS to 2f
        )
    )

    val lessonOrder = listOf(
        Lesson.CHEMISTRY,
        Lesson.BIOLOGY,
        Lesson.MATH,
        Lesson.PHYSICS
    )

}
fun normalizeLessonOrder(inputMap: List<Map<Lesson, Float>>): List<Map<Lesson, Float>> {
    val newInput = mutableListOf<Map<Lesson, Float>>()
    for (dayMap in inputMap) {
        val normalized = ChartLists.lessonOrder.associateWith { lesson ->
            dayMap[lesson] ?: 0f
        }
        newInput.add(normalized)
    }
    return newInput
}
@Composable
fun CardChartDailyStudy(modifier: Modifier= Modifier,
                        weekStudyData: List<Map<Lesson, Float>> = ChartLists.weekStudyData) {



    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Column(Modifier.height(400.dp)) {
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
                AppBarChart(modifier = Modifier.padding(start = 24.dp)

                ,weekStudyData =normalizeLessonOrder(weekStudyData))



            }
            Row(Modifier.fillMaxWidth().padding(start = 24.dp),
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
                            text = stringResource(ChartLists.lessonOrder[lessonIndex].displayName),
                        )

                        Spacer(Modifier.size(4.dp))

                        Box(
                            Modifier
                                .size(16.dp)
                                .background(
                                    color = ChartLists.lessonOrder[lessonIndex].iconColor
                                )
                        )
                    }
                }
            }


        }

    }
}
@Composable
fun BoxScope.AppBarChart(modifier: Modifier = Modifier,
                         weekStudyData: List<Map<Lesson, Float>> = ChartLists.weekStudyData



){
    Box(modifier.fillMaxSize()){
        Column(Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween) {
            repeat(7){
                HorizontalDivider(Modifier.fillMaxWidth())

            }
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()) {
            repeat(7){day->
                SingleBarChart(timesInDayList = weekStudyData[day] )

            }

        }
    }

}
@Composable
fun SingleBarChart(timesInDayList : Map<Lesson, Float> = mapOf<Lesson, Float>(
    Lesson.CHEMISTRY to 3f,
    Lesson.BIOLOGY to 2f,
    Lesson.MATH to 4f,
    Lesson.PHYSICS to 1f
)




                   , maxSum : Int= 12) {
    val sumTimes = timesInDayList.values.sum()
    val spaceWeight  = 12 - sumTimes

    val weights =  listOf(spaceWeight) + timesInDayList.values
    Column(Modifier.fillMaxHeight().width(24.dp)) {
        repeat(5){
                index->
            if(index == 0){
                Spacer(Modifier.weight(weights[0].toFloat()))
            }
            else{
                Box(Modifier.weight(weights[index].toFloat()).fillMaxWidth().
                background(
                    when(index){
                        1 -> timesInDayList.keys.toList()[index-1].iconColor.copy(alpha = 0.8f)
                        2 -> timesInDayList.keys.toList()[index-1].iconColor.copy(alpha = 0.8f)
                        3 ->timesInDayList.keys.toList()[index-1].iconColor.copy(alpha = 0.8f)
                        4 -> timesInDayList.keys.toList()[index-1].iconColor.copy(alpha = 0.8f)
                        else -> Color.Transparent
                    }



                ))
            }


        }

    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LineChart(examResults:List<ExamResult> = ChartLists.sampleExamResults){
val shamsiExamDates = examResults.map { it.date.appLocalDate().grgToPersianDate() }

    val style = LineChartDefaults.style(

        lineColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
        pointColor = MaterialTheme.colorScheme.primary,
        pointSize = 14f,
        bezier = true,
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


    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {

        Box(Modifier.wrapContentSize()){
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

}
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, locale = "fa")
@Composable
fun show(){
    AppTheme(){
        StandardBoxPage (modifier = Modifier.padding(16.dp).fillMaxWidth().background(Color.Transparent)){

            LineChart()
        }}

}