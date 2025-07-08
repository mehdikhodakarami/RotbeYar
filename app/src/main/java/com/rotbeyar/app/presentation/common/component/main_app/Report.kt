package com.rotbeyar.app.presentation.common.component.main_app

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.AppGrgDateTime
import com.rotbeyar.app.domain.model.Exam
import com.rotbeyar.app.domain.model.ExamResult
import com.rotbeyar.app.presentation.common.component.LineChart
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.model.Lesson
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.GreenGradientBrush
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryGray
import io.github.dautovicharis.charts.LineChart
import io.github.dautovicharis.charts.model.toChartDataSet
import io.github.dautovicharis.charts.style.ChartViewDefaults
import io.github.dautovicharis.charts.style.LineChartDefaults


@Composable
fun CardOverallDevelopment(
    testCount: Int = 5,
    quizCount: Int = 10,
    studyHours:String="15:30",
    developLimit:Int=70,
    title:String = stringResource(R.string.overall_development),
    period:String = stringResource(R.string.last_week))

{
    Card (shape = RoundedCornerShape(16.dp)
        , colors = CardDefaults.cardColors(Color.Transparent)
        , modifier = Modifier.fillMaxWidth()
    ){
        Box(modifier = Modifier.background(brush = GreenGradientBrush).padding(16.dp)) {

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
                            text = "$developLimit٪",
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
                                    0 -> testCount.toString()
                                    1 -> studyHours.toString()
                                    2 -> quizCount.toString()
                                    else -> ""
                                }, color = PrimaryBlack,
                                    fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
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
fun CardLessonDevelopPercentage(modifier: Modifier = Modifier,
    developPercentage : Int = 3,
                                
                     developStatusTitle:String = "نقطه ضعف" ,
                     lessonScore: Map<Lesson, Int> = mapOf(
    Lesson.BIOLOGY to 78
)

)


{
    Card(modifier = modifier,
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(16.dp)




    ) {Column(Modifier.padding(16.dp)) {
        Row { Text(text=stringResource(lessonScore.keys.first().displayName),
     fontSize = 14.sp,
            fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.weight(1f))
            Text(text="${lessonScore.values.first()}%",
                fontWeight = FontWeight.Bold,
                color = lessonScore.keys.first().iconColor,
                fontSize = 18.sp
            )
        }
Spacer(Modifier.size(8.dp))
        LinearProgressIndicator(
            progress = {
                lessonScore.values.first()/100f
            },
            modifier = Modifier.height(8.dp).fillMaxWidth(),
            color = lessonScore.keys.first().iconColor,
            trackColor = PrimaryGray.copy(alpha=0.3f),
            strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
        )
        Spacer(Modifier.size(4.dp))
        Row { Text(text=developStatusTitle,
            fontSize = 12.sp, color = MaterialTheme.colorScheme.onSecondary)

            Spacer(modifier = Modifier.weight(1f))
            Text(text= "$developPercentage%",
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = 12.sp
            )
        }



    }



    }




}


@Composable
fun LessonDevelopItems(){
Column {
    Row {
        CardLessonDevelopPercentage(
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(12.dp))
        CardLessonDevelopPercentage(
            modifier = Modifier.weight(1f)

        )
    }
    Spacer(Modifier.size(12.dp))
    Row {
        CardLessonDevelopPercentage(
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(12.dp))
        CardLessonDevelopPercentage(
            modifier = Modifier.weight(1f)

        )
    }
}

}



@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, locale = "fa")
@Composable
fun show9(){
    AppTheme(){
        StandardBoxPage (modifier = Modifier.padding(16.dp).fillMaxWidth().background(Color.Transparent)){

            LessonDevelopItems()

        }}

}