package com.rotbeyar.app.presentation.common.component.main_app

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import com.rotbeyar.app.domain.model.ShortTimeTarget
import com.rotbeyar.app.domain.model.StudyPart
import com.rotbeyar.app.domain.model.subscription.StudentSubscription
import com.rotbeyar.app.domain.model.subscription.SubscriptionStatus
import com.rotbeyar.app.presentation.common.AppValues
import com.rotbeyar.app.presentation.common.component.CardEmptyItem
import com.rotbeyar.app.presentation.common.component.ColumnBlurContent
import com.rotbeyar.app.presentation.common.component.RotbeYarCardIconContainer
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.RotbeYarCardButton
import com.rotbeyar.app.presentation.common.component.RotbeYarTextField
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ExamUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.SampleStudentDashboardData
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ShortTimeTargetUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyLessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyPartStatusUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.TodayDevelopUi
import com.rotbeyar.app.presentation.feture.purchase.screens.SelectPackageDialog
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.GreenGradientBrush
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
import com.rotbeyar.app.ui.theme.PrimaryGray
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.PrimaryPurpleContainer
import com.rotbeyar.app.ui.theme.Surface
import com.rotbeyar.app.ui.theme.VipGradientColor
import com.rotbeyar.app.ui.theme.VipGradientColorContainer
import com.rotbeyar.app.utils.clockFromSec


@Composable
fun CardCurrentLessonPlan(
    modifier: Modifier = Modifier,
    lessonStudy : StudyLessonUi?,
    subscriptionStatus: SubscriptionStatus? = SubscriptionStatus.NONE,

                          contentPadding: PaddingValues= PaddingValues(16.dp),
                          )


{

    Card(colors = CardDefaults.cardColors(Color.Transparent)


        , modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(size = 16.dp)) {
        Box(Modifier
            .fillMaxWidth()
            .background(brush = PrimaryBackgroundGradient)
            .padding(contentPadding)){
            Column{
                Row{
                    Column { Text(text = lessonStudy?.let { stringResource(R.string.current_lesson)} ?:
                    stringResource(R.string.add_your_first_lesson) ,
                        fontSize = 16.sp
                        , fontWeight = FontWeight.SemiBold )
                    Text(text = stringResource(R.string.based_on_today_time), fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSecondary )}
                    Spacer(modifier = Modifier.weight(1f))
                    if (lessonStudy != null)
                        CardStudyTime(
                            time = "${lessonStudy.startTime} - ${lessonStudy.endtime}"
                        )

                    }

Spacer(Modifier.size(12.dp))
                lessonStudy?.let {
                    CardLessonDetails(lessonStudy = it)
                }?: ColumnNullableLessonDetailsNoPlan()
                Spacer(Modifier.size(16.dp))
                RotbeYarButton(
                    text = lessonStudy?.let
                    { stringResource(R.string.start_study) } ?:stringResource(R.string.add_your_first_lesson),
                    onClick = {}
                   ,
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = MaterialTheme.colorScheme.primary,
                 icon = lessonStudy?.let { ImageVector.
                 vectorResource(R.drawable.start_icon) }?: ImageVector.vectorResource(R.drawable.increase_icon))




                }
            }
        }
    }
@Composable
fun CardStudyTime(
    studyPart: StudyPart? = StudyPart.PART_1,
    modifier: Modifier = Modifier,
    time: String = "۸:۰۰ - ۹:۳۰",
    cornerRadiusValue: Dp = 16.dp,
    isSelected: Boolean = false,
    onSelectedChange: (StudyPart?) -> Unit = {}
) {
    val backgroundColor =
        if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
        else MaterialTheme.colorScheme.secondary

    val borderColor =
        if (isSelected) MaterialTheme.colorScheme.primary
        else PrimaryGrayLight

    Card(
        modifier = modifier
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(cornerRadiusValue)
            )
            .clip(RoundedCornerShape(cornerRadiusValue))
            .clickable { onSelectedChange(studyPart) },
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )) {
        Text(
            text = studyPart?.let { "${studyPart.startTime} - ${studyPart.endTime} " }?:time,
            fontSize = 12.sp,
            style = TextStyle(
                fontFamily = VazirFamily,
                textDirection = TextDirection.Ltr
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 14.dp, vertical = 10.dp)
        )
    }
}@Composable
fun CardNullableLessonDetailsNoPlan() {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .background(PrimaryBackgroundGradient, RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {

            Column {
                Text(text = stringResource(R.string.add_your_first_lesson),
                    fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = PrimaryBlack)
                Text(text = stringResource(R.string.for_smart_study),
                    fontSize = 12.sp, color = MaterialTheme.colorScheme.onBackground)
                Spacer(Modifier.size(12.dp))
                ColumnNullableLessonDetailsNoPlan()
                Spacer(Modifier.size(16.dp))
                RotbeYarButton(
                    text = stringResource(R.string.add_first_lesson),
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    icon = Icons.Default.Add
                )
            }

        }
    }
}
@Composable
private fun ColumnNullableLessonDetailsNoPlan(modifier: Modifier = Modifier){
    Card(modifier = Modifier.
    fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
        Color.Transparent)){
     Box(Modifier
         .fillMaxWidth()
         .background(Color.White)){
         Column(modifier = Modifier
             .padding(16.dp)
             .fillMaxWidth(),
             horizontalAlignment = Alignment.CenterHorizontally)
         {

             RotbeYarCardIconContainer(
                 imageResVector = R.drawable.page_icon,
                 iconSize =20.dp,
                 containerSize = 64.dp,
                 cardColor = CardDefaults.cardColors(PrimaryPurpleContainer),

                 )
             Spacer(Modifier.size(16.dp))
             Text(text = stringResource(R.string.no_lesson_planned_yet),
                 fontSize = 14.sp, fontWeight = FontWeight.Medium,
                 color = PrimaryBlack)
             Spacer(Modifier.size(12.dp))

             Text(text = stringResource(R.string.with_add_lesson_start_good_trip),
                 fontSize = 12.sp,
                 color = MaterialTheme.colorScheme.onBackground)




         }



     }
     }
}
@Composable
fun CardLessonDetails(lessonStudy: StudyLessonUi,

                      contentPadding: PaddingValues=PaddingValues(16.dp)){
Card(shape = RoundedCornerShape(16.dp),
    modifier = Modifier.
fillMaxWidth(), colors = CardDefaults.cardColors(
    MaterialTheme.colorScheme.secondary)) {
   Box(Modifier.padding(contentPadding)){
Column {
    Row {


        RotbeYarCardIconContainer(
            cardElevation = CardDefaults.cardElevation(defaultElevation = 0.dp),


            imageResVector = R.drawable.biology_icon,



        containerSize = 40.dp,
            iconTint =PrimaryGreen,cardColor = CardDefaults.cardColors(PrimaryGreenContainer))
Spacer(Modifier.size(12.dp))

Column { Text(text = stringResource(lessonStudy.lesson.title),
        fontSize = 16.sp, color = PrimaryBlack, fontWeight = FontWeight.Medium)
        Text(text = lessonStudy.subject, fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSecondary)
}

    }
    Spacer(Modifier.size(8.dp))
    Row(verticalAlignment = Alignment.CenterVertically) { Icon(painter = painterResource(id = R.drawable.test_icon),
        contentDescription = "Test Icon" )
        Spacer(Modifier.size(4.dp))
        Text(text =lessonStudy.testsCount.toString(), color = PrimaryBlack,
            fontSize = 12.sp)
        Spacer(Modifier.size(4.dp))
        Text(text = "تست", fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground)
        Spacer(Modifier.size(12.dp))
        Icon(painter = painterResource(id = R.drawable.page_icon),
            contentDescription = "Page Icon" )
        Spacer(Modifier.size(4.dp))
        Text(text =lessonStudy.pageCount.toString(), color = PrimaryBlack,
            fontSize = 12.sp)
        Spacer(Modifier.size(4.dp))
        Text(text = stringResource(R.string.page), fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground)
Spacer(Modifier.weight(1f))
        Icon(painter = painterResource(id = R.drawable.time_icon),
            contentDescription = "Time Icon")
Spacer(Modifier.size(4.dp))

        Text(text = clockFromSec(lessonStudy.durationMinutes*60), fontSize = 12.sp,
            color = PrimaryBlack)


    }


}


    }








}
   }










@Composable
fun CardTodayDevelopment(
    todayDevelop: TodayDevelopUi = TodayDevelopUi(0,
        "0","0"),




    title:String = stringResource(R.string.today_improvement),
    seeMore:String=stringResource(R.string.see_details))

{
Card (shape = RoundedCornerShape(16.dp), elevation = CardDefaults.cardElevation(2.dp)
, colors = CardDefaults.cardColors(Color.White)
    , modifier = Modifier.fillMaxWidth()
)


{

    val developLimitPercent = todayDevelop!!.progress.coerceIn(0,100)/100f
    Column(Modifier.padding(16.dp)) {
        Row {
            Text(text = title,
                fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.weight(1f))
            Text(seeMore, color = MaterialTheme.colorScheme.primary,
                fontSize = 12.sp, fontWeight = FontWeight.Medium)
        }
        Spacer(Modifier.size(12.dp))
       Row (verticalAlignment = Alignment.CenterVertically){
LinearProgressIndicator(
progress = { developLimitPercent },
modifier = Modifier
    .height(10.dp)
    .weight(1f),
color = ProgressIndicatorDefaults.linearColor,
trackColor = ProgressIndicatorDefaults.linearTrackColor,
strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
)
           Spacer(Modifier.size(12.dp))
       Text(text = "${todayDevelop.progress}٪", fontWeight = FontWeight.Medium
       , fontSize = 18.sp, color = PrimaryBlack)

       }

        Spacer(Modifier.size(16.dp))
        Row {
            CardMiniTitleWithNumberStudy(

                numberColor = PrimaryBlue,color = PrimaryBlueContainer,
                number = todayDevelop.studyTime,
                title=stringResource(R.string.study_hours),
                modifier = Modifier.weight(1f))
            Spacer(Modifier.size(8.dp))
            CardMiniTitleWithNumberStudy(
number = todayDevelop.testCount,
                title=stringResource(R.string.test_solved),

                numberColor =
                PrimaryGreen,modifier = Modifier.weight(1f))


        }

    }

}
}


@Composable
fun CardMiniTitleWithNumberStudy(
    modifier: Modifier= Modifier.fillMaxWidth(),
    numberColor :Color = PrimaryBlue,


    color: Color=PrimaryGreenContainer,
                                 title:String="تست ها",
                                 number: String="120"){
Card(modifier=modifier,colors = CardDefaults.cardColors(color),shape = RoundedCornerShape(16.dp)){
Column(Modifier
    .padding(8.dp)
    .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text =title, fontSize = 12.sp )
    Text(text = number, fontWeight = FontWeight.Bold,color= numberColor)

}
}
}



@Composable
fun CardToDoLessonItem(

    modifier: Modifier = Modifier,
    lessonsStudy: StudyLessonUi?,



    onCheckedChange: (Boolean) -> Unit = {},

    backGroundCardColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(16.dp),
    cardElevation: CardElevation = CardDefaults.cardElevation(2.dp)
                       ){
Card(
    colors = CardDefaults.cardColors(backGroundCardColor),
    shape = shape,elevation = cardElevation, modifier = modifier
        .background(Color.Transparent)
        .fillMaxWidth()) {
    Row(Modifier
        .padding(16.dp)
        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = (lessonsStudy!!.status == StudyPartStatusUi.DONE ||
                lessonsStudy.status == StudyPartStatusUi.IN_PROGRESS),






            onCheckedChange = onCheckedChange)
        RotbeYarCardIconContainer(

            imageResVector = lessonsStudy.lesson.icon,
            shape = RoundedCornerShape(16.dp),
            cardElevation = CardDefaults.cardElevation(0.dp),
            containerSize = 40.dp,
            iconTint = lessonsStudy.lesson.iconColor
            , cardColor = CardDefaults.cardColors(lessonsStudy.lesson.iconContainerColor)
        )

        Spacer(Modifier.size(12.dp))
        Column(modifier = Modifier.width(80.dp)) {
            Text(fontWeight = FontWeight.SemiBold,
               modifier =  Modifier.width(80.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                text=stringResource(lessonsStudy.lesson.title),
                fontSize = 13.sp, color = PrimaryBlack
            )
            Text(text=lessonsStudy.subject, fontSize = 12.sp
                , color = MaterialTheme.colorScheme.onBackground,
                modifier =  Modifier.width(80.dp),

                overflow = TextOverflow.Ellipsis
                , maxLines = 1


            )
            Text(text="${lessonsStudy.startTime}-${lessonsStudy.endtime}", fontSize = 12.sp,
                maxLines = 1,
                modifier =  Modifier.width(80.dp),

                overflow = TextOverflow.Ellipsis
                , color = MaterialTheme.colorScheme.onBackground

            )

        }
        Spacer(Modifier.size(8.dp))
CardItemCounter(
count = lessonsStudy.testsCount


)
        Spacer(Modifier.weight(1f))
        Box(
            modifier = Modifier
                .width(4.dp)
                .height(32.dp)
                .background(
                    lessonsStudy.status.color,
                    shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                ),

        )




    }
}




}

@Composable
fun CardItemCounter(
    onIncreaseTestCount: () -> Unit = {},
                    onDecreaseTestCount: () ->Unit = {},


    iconTintCounter : Color = MaterialTheme.colorScheme.onSecondary,
                    count : Int = 0, cardColors: CardColors= CardDefaults.cardColors(PrimaryWhite)
                    , cardElevation: CardElevation = CardDefaults.cardElevation(0.dp)
                    , radius : Dp = 9999.dp){
    Card (colors = cardColors,elevation = cardElevation,shape = RoundedCornerShape(radius)){

        Row(Modifier.padding(horizontal = 8.dp, vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
            RotbeYarCardIconContainer(
                onClick = onDecreaseTestCount,

                iconTint = iconTintCounter ,cardElevation = CardDefaults.cardElevation(0.dp),
                    imageResVector = R.drawable.decrase_icon,shape = RectangleShape,
                cardColor = CardDefaults.cardColors(Color.Transparent)
           , modifier = Modifier.size(24.dp) )
            Spacer(Modifier.size(8.dp))
            Text(textAlign = TextAlign.Center,fontWeight = FontWeight.SemiBold, fontSize = 16.sp,modifier = Modifier.width(48.dp), text = count.toString())
            Spacer(Modifier.size(8.dp))
            RotbeYarCardIconContainer(onClick = onIncreaseTestCount,
                iconTint = iconTintCounter ,cardElevation = CardDefaults.cardElevation(0.dp),
                imageResVector = R.drawable.increase_icon,shape = RectangleShape,
                cardColor = CardDefaults.cardColors(Color.Transparent)
                , modifier = Modifier.size(24.dp) )








        }

    }
}


@Composable
fun CardNullListStudyLessonNoPlan(
addStudyClick : () -> Unit = {}

){
    Card(modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ){
      Box(Modifier
          .fillMaxWidth()
          .background(PrimaryBackgroundGradient)){
          Column(horizontalAlignment = Alignment.CenterHorizontally,
              modifier = Modifier
                  .padding(24.dp)
                  .fillMaxWidth()

          ) {
              RotbeYarCardIconContainer(
                  iconSize = 25.dp,
                  containerSize = 80.dp,
                  cardColor = CardDefaults.cardColors(Color.White),
                  iconTint = MaterialTheme.colorScheme.onSecondary,

                  imageResVector = R.drawable.plan_icon)
              Spacer(Modifier.size(16.dp))
              Text(fontSize = 16.sp,
                  fontWeight = FontWeight.Medium,
                  text = stringResource(R.string.no_study_plan_yet))
              Spacer(Modifier.size(8.dp))
              Text(fontSize = 14.sp,
                  textAlign = TextAlign.Center,
                  color = MaterialTheme.colorScheme.onBackground,
                  text = stringResource(R.string.for_start_add_first_lesson))
              Spacer(Modifier.size(16.dp))
              RotbeYarButton(
                  text = stringResource(R.string.add_your_first_lesson),
                  onClick = {},
                  modifier = Modifier.fillMaxWidth(),
                  backgroundColor = MaterialTheme.colorScheme.primary,
                  icon = ImageVector.vectorResource(R.drawable.increase_icon)
              )

          }
      }
    }
}







@Composable
fun CardExamItem(

    exam : ExamUi,

                 dayLeftClick : ()-> Unit = {},





                 iconElevation: CardElevation = CardDefaults.cardElevation(0.dp),



                 ){
    Row (Modifier
        .fillMaxWidth()
        .padding(16.dp),verticalAlignment = Alignment.CenterVertically) {
        RotbeYarCardIconContainer(
            iconSize = 20.dp,
            containerSize = 40.dp, cardElevation = iconElevation,
            imageResVector = exam.icon,
            cardColor = CardDefaults.cardColors(exam.iconContainerColor),
            iconTint = exam.iconColor
        )
        Spacer(Modifier.size(12.dp))
        Column {
            Text(
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                text = stringResource(exam.title),
                fontSize = 14.sp,
                color = PrimaryBlack
            )
            Text(
                text = exam.formattedDate, fontSize = 12.sp, color = MaterialTheme.colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis, maxLines = 1


            )
            Text(
                text = exam.formattedHour, fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis, color = MaterialTheme.colorScheme.onBackground

            )

        }
        Spacer(Modifier.weight(1f))

        RotbeYarCardButton(
            modifier = Modifier,
            colors = CardDefaults.cardColors(if(exam.daysLeft <=3)(MaterialTheme.colorScheme.errorContainer)
            else PrimaryBlueContainer),
            onClick = dayLeftClick,
        ) {
            Text(
                text = "${exam.daysLeft} روز",
                color = if(exam.daysLeft <=3)(MaterialTheme.colorScheme.error)
                else PrimaryBlue,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium
            )

        }
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.left_arrow_icon),

            contentDescription = "",
            tint = MaterialTheme.colorScheme.onBackground
        )
        Spacer(Modifier.size(16.dp))

   RotbeYarCardButton(colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
       ,onClick = {}
   ){
       Row(verticalAlignment = Alignment.CenterVertically) {
           Icon(
           imageVector = ImageVector.vectorResource(R.drawable.record_resault),
           contentDescription = ""
       )
           Spacer(Modifier.size(4.dp))
           Text(
               text = stringResource(R.string.record_result),
               color = Color.White,
               fontSize = 13.sp,
               fontWeight = FontWeight.Medium
           )}
   }



    }}
@Composable
fun CardTargetItem(

    @StringRes titleRes: Int=R.string.reach_daily_tests,
    countTarget:Int=1000,
    progressPercentage: Int=70,

    @DrawableRes iconRes : Int = R.drawable.test_icon,
    iconColor : Color = MaterialTheme.colorScheme.primary,
    colorIconContainer: Color = MaterialTheme.colorScheme.primaryContainer

){
    Card (
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),


        shape = RoundedCornerShape(16.dp)){
        Row (verticalAlignment = Alignment.CenterVertically,
        modifier =     Modifier
            .fillMaxWidth()
            .padding(12.dp)){
            RotbeYarCardIconContainer(
                containerSize = 32.dp,
                iconSize = 20.dp,
                iconTint = iconColor,
                imageResVector = iconRes,
                cardColor = CardDefaults.cardColors(colorIconContainer),
                cardElevation = CardDefaults.cardElevation(0.dp),)
            Spacer(Modifier.size(12.dp))
            Column {
                Text(color = PrimaryBlack,
                    text = stringResource(titleRes,
                    countTarget
                ), fontWeight = FontWeight.Medium, fontSize = 14.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .padding()
                            .padding(vertical = 5.dp)
                            .height(6.dp),
                        progress = { progressPercentage.coerceIn(0, 100) / 100f },
                        color = iconColor,
                        trackColor = ProgressIndicatorDefaults.linearTrackColor,
                        strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
                    )
                    Spacer(Modifier.size(12.dp))
                    Text(text = "$progressPercentage٪"
                        , fontSize = 18.sp, color = MaterialTheme.colorScheme.onBackground)
                }



            }
        }
    }




}

@Composable
fun CardShortTimeTargets(
    subscriptionStatus: SubscriptionStatus = SubscriptionStatus.NONE,
    shortTimeTarget: ShortTimeTargetUi? = ShortTimeTargetUi(0,0,0,
        0,0,0)





    ){


    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ){
        Box(
            modifier = Modifier
                .background(brush = PrimaryBackgroundGradient)
                .fillMaxWidth()
               ){
            if(shortTimeTarget == null && subscriptionStatus == SubscriptionStatus.ACTIVE){
                AdvisorIsPlanning()
            }

            else if( shortTimeTarget!=null){

            Column (modifier = Modifier
                .padding(16.dp)
                .blur(if (subscriptionStatus == SubscriptionStatus.NONE) AppValues.blurCount else 0.dp)){
                Row {
                    RotbeYarCardIconContainer(
                        imageResVector = R.drawable.target,
                        containerSize = 40.dp,
                        iconTint = MaterialTheme.colorScheme.primary,
                        cardColor = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
                        cardElevation = CardDefaults.cardElevation(0.dp)

                    )
                    Spacer(Modifier.size(12.dp))
                    Column {
                        Text(color = PrimaryBlack,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            text =stringResource(R.string.targets_set_by_consultant))

                        Text(color = MaterialTheme.colorScheme.onSecondary,
                            fontSize = 12.sp,
                            text = stringResource(R.string.for_next_two_weeks))
                    }
                }
                Spacer(Modifier.size(16.dp))
CardTargetItem(countTarget = shortTimeTarget.testCountTarget,
    progressPercentage = shortTimeTarget.testTargetPercentage,
    colorIconContainer = PrimaryBlueContainer ,
    iconColor = PrimaryBlue
    )
                Spacer(Modifier.size(12.dp))
                CardTargetItem(
                    countTarget = shortTimeTarget.studyHourTarget,
                    progressPercentage = shortTimeTarget.studyHourTargetPercentage,
                    titleRes = R.string.reach_daily_study_hours,
                    colorIconContainer = PrimaryGreenContainer ,
                    iconColor = PrimaryGreen,
                    iconRes = R.drawable.time_icon)
                Spacer(Modifier.size(12.dp))
                CardTargetItem(countTarget = shortTimeTarget.examScoreTarget,
                    progressPercentage = shortTimeTarget.examScoreTargetPercentage,
                    titleRes = R.string.achieve_score_in_test,
                    colorIconContainer = MaterialTheme.colorScheme.primaryContainer,
                    iconColor = MaterialTheme.colorScheme.primary,
                    iconRes = R.drawable.cup_icon)
                Spacer(Modifier.size(12.dp))
Text(color = MaterialTheme.colorScheme.onSecondary,
    fontSize = 12.sp,
    text = stringResource(
        R.string.with_effort_and_perseverance))




            }

            }




            if(subscriptionStatus == SubscriptionStatus.NONE)
                ColumnBlurContent()
        }




    }


  }
@Composable
fun CardFirstCallAdvisor(){
    Card(colors = CardDefaults.cardColors(Color.Transparent),
        modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)){
Box(Modifier
    .fillMaxWidth()
    .background(brush = PrimaryBackgroundGradient)){
    Column(Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically){
            RotbeYarCardIconContainer(imageResVector = R.drawable.advisor_icon ,
                cardColor = CardDefaults.cardColors(PrimaryPurpleContainer)


                ,
            )
            Spacer(Modifier.size(12.dp))
            Column {
                Text(text = stringResource(R.string.first_advisor_call),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = PrimaryBlack)
                Text(text = stringResource(R.string.advisor_call_you),
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSecondary)

            }
        }
        Spacer(Modifier.size(16.dp))

        CardAdvisorWaitingTime()



    }

}
}}
@Composable
fun CardAdvisorWaitingTime(){
    Card(modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary)
        ,shape = RoundedCornerShape(16.dp)){
            Column (Modifier.padding(16.dp)){
                Row {
RotbeYarCardIconContainer(imageResVector = R.drawable.time_icon,
    containerSize = 25.dp,
    iconSize = 15.dp)
                    Spacer(Modifier.size(12.dp))
                    Text(stringResource(R.string.waiting_time_12_hours),
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp)

                }
                Spacer(Modifier.size(8.dp))
                Text(stringResource(R.string.please_be_patient),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 12.sp)



            }
    }
}


@Composable
fun AdvisorIsPlanning(){
    CardEmptyItem(Modifier,R.string.advisor_is_planning,null,R.drawable.plan_icon)

//Card(modifier = Modifier.fillMaxWidth(),
//    colors = CardDefaults.cardColors(Color.LightGray.copy(alpha = 0.3f)),
//    shape = RoundedCornerShape(16.dp)) {
//    Column(Modifier
//        .fillMaxWidth()
//        .padding(24.dp),horizontalAlignment = Alignment.CenterHorizontally) {
//        RotbeYarCardIconContainer(iconSize = 25.dp,
//            containerSize = 80.dp,
//            imageResVector = R.drawable.plan_icon,
//            cardColor = CardDefaults.cardColors(PrimaryGrayLight),
//            iconTint = MaterialTheme.colorScheme.onSecondary)
//        Spacer(Modifier.size(16.dp))
//        Text(fontSize = 16.sp,
//            color = MaterialTheme.colorScheme.onBackground,
//            fontWeight = FontWeight.Medium,
//            text = stringResource(R.string.advisor_is_planning))
//
//    }
//
//}
}

@Composable
fun CardExclusiveConsultation(
    modifier: Modifier = Modifier,
    lessonStudy: StudyLessonUi = SampleStudentDashboardData.sampleStudyLesson1,
    getCounselingClick :()->Unit = {}
){
    Card(modifier = modifier.fillMaxWidth(), colors = CardDefaults.cardColors(Color.White)){
        Box(Modifier
            .fillMaxWidth()
            .background(PrimaryBackgroundGradient)){
            Column(Modifier
                .fillMaxWidth()
                .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RotbeYarCardIconContainer(imageResVector = R.drawable.advisor_icon,
                        iconSize = 24.dp, containerSize = 40.dp)
                    Spacer(Modifier.size(12.dp))
                    Column { Text(text = stringResource(R.string.exlusive_advisor), fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp, color = PrimaryBlack)
                    Text(text = stringResource(R.string.personalized_plan), color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 14.sp)}
                }
                Spacer(Modifier.size(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) { repeat(2){
                    Surface(Modifier.weight(1f),color = Color.White, shape = RoundedCornerShape(16.dp)){
                        Column(Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                            RotbeYarCardIconContainer(imageResVector = when(it){
                                0->R.drawable.time_icon
                                1->R.drawable.focus_icon
                                else -> R.drawable.time_icon
                            },
                                iconSize = 15.dp,
                                containerSize = 20.dp)
                            Text(text = stringResource(when(it){
                                0->R.string.smart_timing
                                1->R.string.focus_on_study
                                else->R.string.focus_on_study
                            }
                            ), fontSize = 12.sp, color = MaterialTheme.colorScheme.onSecondary)

                        }
                    }
                }



                }
                Spacer(Modifier.size(16.dp))
                RotbeYarButton(text = stringResource(R.string.get_Exlusive_counseling),
                    backgroundColor = PrimaryBlue,
                    onClick = getCounselingClick)




                }


            }
        }
    }


@Composable
fun DialogAddLessonFreePackageContent(){

   Dialog(onDismissRequest = {},
       properties = DialogProperties(
           usePlatformDefaultWidth = false,
           dismissOnBackPress = true,
           dismissOnClickOutside = true
       )
   ) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical =
                    48.dp, horizontal = 24.dp
            ),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(Color.White)) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(R.string.add_new_lesson), fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold, color = PrimaryBlack
                    )
                    Spacer(Modifier.size(16.dp))
                    CardExclusiveConsultation()
                    Spacer(Modifier.size(16.dp))

                    RotbeYarTextField(
                        label = stringResource(R.string.lesson_name),
                        leadingIcon = ImageVector.vectorResource(R.drawable.page_icon),
                        placeholder = "مثال: زیست\u200Cشناسی",

                        onValueChange = {})
                    Spacer(Modifier.size(24.dp))
                    RotbeYarTextField(
                        label = stringResource(R.string.subject),
                        leadingIcon = ImageVector.vectorResource(R.drawable.package_icon),
                        placeholder = "مثال: فصل گردش مواد",
                        onValueChange = {})
                    Spacer(Modifier.size(24.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                        repeat(2) {
                            RotbeYarTextField(
                                modifier = Modifier.weight(1f), label = stringResource(
                                    when (it) {
                                        0 -> R.string.start_clock
                                        1 -> R.string.end_clock
                                        else -> R.string.start_study
                                    }
                                ),
                                leadingIcon = ImageVector.vectorResource(when (it) {
                                    0 -> R.drawable.time_icon
                                    1 -> R.drawable.time_icon
                                    else -> R.drawable.time_icon
                                }),
                                onValueChange = {})
                        }

                    }
                    Spacer(Modifier.size(12.dp))
                    Row(
                        modifier = Modifier.height(40.dp),
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Spacer(Modifier.weight(3f))

                        RotbeYarButton(
                            fontSize = 12.sp, modifier = Modifier.weight(2f),
                            text = stringResource(R.string.add),
                            onClick = {})

                    }
                }
            }

        }
    }
}
@Composable
fun CardPsychologistInHome(
    modifier: Modifier  = Modifier,
    subscriptionStatus: SubscriptionStatus = SubscriptionStatus.NONE,
    psychologistName : String = "دکتر سارا احمدی",){
    Card(modifier = Modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.Transparent)) {
        Box(Modifier
            .fillMaxWidth()
            .background(PinkGradientBrush)) {
            Column(Modifier.padding(16.dp)) {
                Row { RotbeYarCardIconContainer(imageResVector = R.drawable.psychologist_icon,
                    iconSize = 20.dp,
                    containerSize = 40.dp,
                    cardColor = CardDefaults.cardColors(PrimaryPurpleContainer),
                    iconTint = PrimaryPurple
                )
                    Spacer(Modifier.size(12.dp))
                    Column {
                        Text(text = stringResource(R.string.psychologist),
                            fontSize = 16.sp,
                            color = PrimaryBlack,
                            fontWeight = FontWeight.Medium)
                        Text(text = psychologistName,
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                          )
                    }

                }
                Spacer(Modifier.size(12.dp))
                Surface(modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)){
                    Column(Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        repeat(2){
                            Row(verticalAlignment = Alignment.CenterVertically){
                                RotbeYarCardIconContainer(containerSize = 20.dp,
                                    iconSize = 16.dp,
                                    iconTint = PrimaryGray,
                                    imageResVector = when(it){
                                        0->R.drawable.time_icon
                                        1->R.drawable.plan_icon
                                        else -> TODO()
                                    },
                                    cardColor = CardDefaults.cardColors(Color.Transparent))
                                Spacer(Modifier.size(8.dp))
                                Text(text = stringResource(when(it){
                                    0->R.string.next_meet_time
                                    1->R.string.reserveation_status
                                    else->TODO()
                                }),
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onSecondary)
                                Spacer(Modifier.weight(1f))
                                Text(text = stringResource(when(it){
                                    0->if(subscriptionStatus == SubscriptionStatus.NONE) R.string.locked else R.string.improve_focus
                                    1->R.string.reserveation_status
                                    else->TODO()
                                }),
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onBackground)

                            }
                        }
                    }


                }
                Spacer(Modifier.size(12.dp))
                Surface(modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)){
                    Column(Modifier.padding(12.dp)) {
                        Text(text = "${stringResource(R.string.points_of_counseling)}:",
                            fontSize = 12.sp,
                            color = PrimaryBlack)
                        Spacer(Modifier.size(16.dp))
                        repeat(3){
                            Row(
                                Modifier.padding(start = 12.dp),
                                verticalAlignment = Alignment.CenterVertically) { RotbeYarCardIconContainer(containerSize = 15.dp,
                                imageResVector = when(it){
                                0->R.drawable.psychologist_icon
                                1->R.drawable.focus_icon
                                2->R.drawable.smile_icon
                                else -> TODO()
                            }, iconSize = 15.dp,
                                cardColor = CardDefaults.cardColors(Color.Transparent))
                                Spacer(Modifier.size(12.dp))
                                Text(text = stringResource(when(it){
                                    0->R.string.reduce_stress
                                    1->R.string.improve_focus
                                    2->R.string.boost_motivation_confidence
                                    else -> TODO()
                                }),
                                    fontSize = 12.sp,
                                    color = MaterialTheme.colorScheme.onBackground,
                                )

                            }
                            if(it !=2){
                                Spacer(Modifier.size(8.dp))
                            }

                        }

                    }

                }

            }

        }
    }
}

