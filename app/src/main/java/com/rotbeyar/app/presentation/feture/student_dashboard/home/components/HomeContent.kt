package com.rotbeyar.app.presentation.feture.student_dashboard.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.subscription.StudentSubscription
import com.rotbeyar.app.domain.model.subscription.SubscriptionStatus
import com.rotbeyar.app.domain.model.subscription.SubscriptionType
import com.rotbeyar.app.domain.model.user.User
import com.rotbeyar.app.domain.model.user.UserRole
import com.rotbeyar.app.presentation.common.AppValues
import com.rotbeyar.app.presentation.common.component.ColumnBlurContent
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.component.main_app.AdvisorIsPlanning
import com.rotbeyar.app.presentation.common.component.main_app.CardCurrentLessonPlan
import com.rotbeyar.app.presentation.common.component.main_app.CardExamItem
import com.rotbeyar.app.presentation.common.component.main_app.CardNullListStudyLessonNoPlan
import com.rotbeyar.app.presentation.common.component.main_app.CardShortTimeTargets
import com.rotbeyar.app.presentation.common.component.main_app.CardToDoLessonItem
import com.rotbeyar.app.presentation.common.component.main_app.CardTodayDevelopment
import com.rotbeyar.app.presentation.common.component.main_app.CardFirstCallAdvisor
import com.rotbeyar.app.presentation.common.component.main_app.CardNullableLessonDetailsNoPlan
import com.rotbeyar.app.presentation.common.component.main_app.CardPsychologistInHome
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ExamUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.SampleStudentDashboardData
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ShortTimeTargetUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyLessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.TodayDevelopUi
import com.rotbeyar.app.presentation.feture.student_dashboard.home.screens.HomeScreen
import com.rotbeyar.app.presentation.feture.student_dashboard.report.components.StudentReportContent
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.utils.plus

@Composable
fun StudentHomeContent(
    modifier: Modifier = Modifier,
    currentLesson: StudyLessonUi? = null,
    todayDevelop: TodayDevelopUi? = null,
    studyLessonList: List<StudyLessonUi>? = null,
    nextExamsList: List<ExamUi>? = null,
    shortTimeTarget: ShortTimeTargetUi?= null,
    studentSubscription: StudentSubscription  = StudentSubscription(
        type = SubscriptionType.VIP,
        status = SubscriptionStatus.NONE,
    expiresAt = "",
    startDate = 12,
    expiryDate = 12,
    daysRemaining =8
    ),





    user: User? = null,
    contentPaddingValues: PaddingValues = PaddingValues(0.dp),


    onClickProfile: () -> Unit = {},

    )


{
    
    LazyColumn(contentPadding = contentPaddingValues  + PaddingValues( 16.dp)) {
        item {
            NameProfileStudentRow(


            profileIconOnClick = onClickProfile)
            Spacer(Modifier.size(16.dp))
        }


        item {
            if(studentSubscription.status == SubscriptionStatus.ACTIVE && currentLesson == null){
                CardFirstCallAdvisor()
            }else if(currentLesson != null){
                CardCurrentLessonPlan(
                    lessonStudy = currentLesson

                )
            }
            else{
                CardNullableLessonDetailsNoPlan()
            }

            Spacer(Modifier.size(24.dp))
        }



        item { CardTodayDevelopment(
            todayDevelop = todayDevelop?: TodayDevelopUi(0,"0","0")
        )
        Spacer(Modifier.size(24.dp))}



        item {

            Column {

                Text(text = stringResource(R.string.today_plan),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold)
                    Spacer(Modifier.size(16.dp))

studyLessonList?.let {repeat(studyLessonList.size) {
    CardToDoLessonItem(lessonsStudy = studyLessonList[it])
    Spacer(Modifier.size(12.dp))}

}?: CardNullListStudyLessonNoPlan()


                Spacer(Modifier.size(24.dp))


            }

        }





        item {


                Row {
                    Text(text = stringResource(R.string.next_exams),
                        fontWeight = FontWeight.SemiBold,
                        fontSize =16.sp
                    )
                    Spacer(Modifier.weight(1f))
                    nextExamsList?.let {   Text(text = stringResource(R.string.see_all), fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary) }


                }

                Spacer(Modifier.size(12.dp))
            if (studentSubscription.status == SubscriptionStatus.ACTIVE && nextExamsList == null) {
                AdvisorIsPlanning()
            }else{
                Card(colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(16.dp)) {
                    Box(){



                        Column(Modifier.blur(if(studentSubscription.status == SubscriptionStatus.NONE) AppValues.blurCount else 0.dp)) {
                            repeat(nextExamsList?.size ?: 2){
                                CardExamItem(
                                    nextExamsList?.get(it) ?: SampleStudentDashboardData.sampleExam1
                                )
                                HorizontalDivider()
                            }

                        }
                        if( studentSubscription.status == SubscriptionStatus.NONE)   ColumnBlurContent()

                    }


                }




            }
            Spacer(Modifier.size(24.dp))

        }

        item {
            Text(text = stringResource(R.string.short_targets),
                fontWeight = FontWeight.SemiBold,
                fontSize =16.sp
            )
           Column{


               Spacer(Modifier.size(12.dp))
               when(studentSubscription.status){
                   SubscriptionStatus.NONE  -> CardShortTimeTargets(subscriptionStatus = studentSubscription.status,
                       ShortTimeTargetUi(0,0,0,0,
                           0,0))

                   SubscriptionStatus.ACTIVE -> CardShortTimeTargets(subscriptionStatus = studentSubscription.status,
                       shortTimeTarget = shortTimeTarget)
                   SubscriptionStatus.EXPIRED -> TODO()
               }


           }
            Spacer(Modifier.size(24.dp))

        }

        item { CardPsychologistInHome() }

    }

}
@Composable
fun NameProfileStudentRow(

    user: User? = User(
        firstName = "امیر حسین",
        lastName = "moradi",
        id = 22,
        phone = "",
        email = "",
        role = UserRole.STUDENT,
        subscription = null,
    relatedStudents = emptyList(),
    assignedStudents = emptyList(),
    ),
                              profileIconOnClick: () -> Unit = {}
)

{
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column {
            Text(text = "سلام، ${user?.firstName} \uD83D\uDC4B",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold)
            Text(text = "۱۸ تیر ۱۴۰۴ | سه\u200Cشنبه",
                fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(Modifier.clickable(enabled = true,
            onClick = profileIconOnClick)){
            Image(


                painter = painterResource(id = R.drawable.person_icon),
                contentDescription = "Circular PNG Image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
        }

    }

}

@Preview(showBackground = true, locale = "fa")
@Composable
fun show3(){
    AppTheme {
        StandardBoxPage(modifier = Modifier.background(MaterialTheme.colorScheme.secondary)) {
            StudentHomeContent()
        }
    }
}


