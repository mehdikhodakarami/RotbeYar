package com.rotbeyar.app.presentation.common.component.main_app

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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


import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.CardChartDailyStudy
import com.rotbeyar.app.presentation.common.component.RotbeYarCardIconContainer
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.RotbeYarCardButton
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.VazirFamily
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryBlue
import com.rotbeyar.app.ui.theme.PrimaryBlueContainer
import com.rotbeyar.app.ui.theme.PrimaryGrayLight
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryGreenContainer
import com.rotbeyar.app.ui.theme.PrimaryWhite
import com.rotbeyar.app.ui.theme.PrimaryBackgroundGradient
import com.rotbeyar.app.ui.theme.cardElevationApp


@Composable
fun CardCurrentLessonPlan(studyTime : String? = "08:00 - 09:30",
                          headText :String ="درس فعلی",
                          supportingText:String = "بر اساس زمان امروز",
                          contentPadding: PaddingValues= PaddingValues(16.dp),
                          modifier: Modifier = Modifier)


{

    Card(colors = CardDefaults.cardColors(Color.Transparent), modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(size = 16.dp)) {
        Box(Modifier.fillMaxWidth().
        background(brush = PrimaryBackgroundGradient).padding(contentPadding)){
            Column(){
                Row{
                    Column { Text(text = headText,
                        fontSize = 16.sp
                        , fontWeight = FontWeight.SemiBold )
                    Text(text = supportingText, fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSecondary )}
                    Spacer(modifier = Modifier.weight(1f))
                    if (!studyTime.isNullOrBlank())
                        CardStudyTime()

                    }
Spacer(Modifier.size(12.dp))
                CardLessonDetails()
                Spacer(Modifier.size(16.dp))
                RotbeYarButton(
                    text = "شروع مطالعه",
                    onClick = {}, modifier = Modifier.fillMaxWidth(),
                    backgroundColor = MaterialTheme.colorScheme.primary,
                 icon = ImageVector.vectorResource(R.drawable.start_icon))



                }
            }
        }
    }
@Composable
fun CardStudyTime(modifier: Modifier = Modifier, time:String="۸:۰۰ - ۹:۳۰", cornerRadiusValue : Dp = 16.dp){
    Card( modifier = modifier
        .border(
            width = 1.dp,
            color = PrimaryGrayLight,
            shape = RoundedCornerShape(cornerRadiusValue) // باید همون شکل کارت باشه
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
,
        shape = RoundedCornerShape(cornerRadiusValue)) {

        Text(text = time, fontSize = 12.sp,
            style = TextStyle(fontFamily = VazirFamily,textDirection = TextDirection.Ltr),
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(horizontal = 14.dp,
                    vertical = 10.dp))
    }
}
@Composable
fun CardLessonDetails(studyHours:String="1:00:00"
                      ,pageCount:Int=25,
                      testCount:Int= 50,lessonTitle : String = "زیست‌شناسی",
                      lessonPartDetail : String = "فصل گردش مواد", contentPadding: PaddingValues=PaddingValues(16.dp)){
Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary)) {
   Box(Modifier.padding(contentPadding)){
Column {
    Row {


        RotbeYarCardIconContainer(
            cardElevation = CardDefaults.cardElevation(defaultElevation = 0.dp),


            imageResVector = R.drawable.biology_icon,



        size = 40.dp,
            iconTint =PrimaryGreen,cardColor = CardDefaults.cardColors(PrimaryGreenContainer))
Spacer(Modifier.size(12.dp))

Column { Text(text = lessonTitle,
        fontSize = 16.sp, color = PrimaryBlack, fontWeight = FontWeight.Medium)
        Text(text = lessonPartDetail, fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSecondary)
}

    }
    Spacer(Modifier.size(8.dp))
    Row(verticalAlignment = Alignment.CenterVertically) { Icon(painter = painterResource(id = R.drawable.test_icon),
        contentDescription = "Test Icon" )
        Spacer(Modifier.size(4.dp))
        Text(text =testCount.toString(), color = PrimaryBlack,
            fontSize = 12.sp)
        Spacer(Modifier.size(4.dp))
        Text(text = "تست", fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground)
        Spacer(Modifier.size(12.dp))
        Icon(painter = painterResource(id = R.drawable.page_icon),
            contentDescription = "Page Icon" )
        Spacer(Modifier.size(4.dp))
        Text(text =pageCount.toString(), color = PrimaryBlack,
            fontSize = 12.sp)
        Spacer(Modifier.size(4.dp))
        Text(text = "صفحه", fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground)
Spacer(Modifier.weight(1f))
        Icon(painter = painterResource(id = R.drawable.time_icon),
            contentDescription = "Time Icon")
Spacer(Modifier.size(4.dp))

        Text(text = studyHours, fontSize = 12.sp,
            color = PrimaryBlack)


    }


}


    }








}
   }










@Composable
fun CardTodayDevelopment(cardElevation: CardElevation= CardDefaults.cardElevation(cardElevationApp),

                         developLimit:Int=70,title:String = "پیشرفت امروز",
                         seeMore:String="مشاهده جزئیات")

{
Card (shape = RoundedCornerShape(16.dp), elevation = CardDefaults.cardElevation(2.dp)
, colors = CardDefaults.cardColors(Color.White)
    , modifier = Modifier.fillMaxWidth()
)


{

    val developLimitPercent = developLimit.coerceIn(0,100)/100f
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
modifier = Modifier.height(10.dp).weight(1f),
color = ProgressIndicatorDefaults.linearColor,
trackColor = ProgressIndicatorDefaults.linearTrackColor,
strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
)
           Spacer(Modifier.size(12.dp))
       Text(text = "$developLimit٪", fontWeight = FontWeight.Medium
       , fontSize = 18.sp, color = PrimaryBlack)

       }

        Spacer(Modifier.size(16.dp))
        Row {
            CardMiniTitleWithNumberStudy(numberColor = PrimaryBlue,color = PrimaryBlueContainer, number = "4:30", title="ساعت مطالعه",  modifier = Modifier.weight(1f))
            Spacer(Modifier.size(8.dp))
            CardMiniTitleWithNumberStudy(numberColor = PrimaryGreen,modifier = Modifier.weight(1f))


        }

    }

}
}


@Composable
fun CardMiniTitleWithNumberStudy(numberColor :Color = PrimaryBlue, modifier: Modifier= Modifier.fillMaxWidth(), color: Color=PrimaryGreenContainer,
                                 title:String="تست ها",
                                 number: String="120"){
Card(modifier=modifier,colors = CardDefaults.cardColors(color),shape = RoundedCornerShape(16.dp)){
Column(Modifier.padding(8.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text =title, fontSize = 12.sp )
    Text(text = number, fontWeight = FontWeight.Bold,color= numberColor)

}
}
}



@Composable
fun CardToDoLessonItem(onCheckedChange: (Boolean) -> Unit = {},
                       @DrawableRes lessonIconRes : Int = R.drawable.page_icon,
                       backGroundIconColor:Color = MaterialTheme.colorScheme.primaryContainer,
                       iconColor : Color = MaterialTheme.colorScheme.primary,
                       lessonTitle: String="زیست‌شناسی",
                       partTitle: String= "گردش مواد",
                       planTime:String="۰۸:۰۰-۰۹:۳۰",
                       planStatusColor: Color = PrimaryGreen,
                       backGroundCardColor: Color = Color.White,
                       modifier: Modifier = Modifier,
                       shape: Shape = RoundedCornerShape(16.dp),
                       cardElevation: CardElevation = CardDefaults.cardElevation(2.dp)
                       , isChecked : Boolean = true
                       ){
Card(colors = CardDefaults.cardColors(backGroundCardColor),
    shape = shape,elevation = cardElevation, modifier = modifier.background(Color.Transparent).fillMaxWidth()) {
    Row(Modifier.padding(16.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = isChecked,onCheckedChange = onCheckedChange)
        RotbeYarCardIconContainer(imageResVector = lessonIconRes,
            shape = RoundedCornerShape(16.dp),
            cardElevation = CardDefaults.cardElevation(0.dp),
            size = 40.dp,
            iconTint = iconColor
            , cardColor = CardDefaults.cardColors(backGroundIconColor)
        )

        Spacer(Modifier.size(12.dp))
        Column(modifier = Modifier.width(80.dp)) {
            Text(fontWeight = FontWeight.SemiBold,
               modifier =  Modifier.width(80.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis, text=lessonTitle, fontSize = 13.sp, color = PrimaryBlack
            )
            Text(text=partTitle, fontSize = 12.sp
                , color = MaterialTheme.colorScheme.onBackground,
                modifier =  Modifier.width(80.dp),

                overflow = TextOverflow.Ellipsis
                , maxLines = 1


            )
            Text(text=planTime, fontSize = 12.sp,
                maxLines = 1,
                modifier =  Modifier.width(80.dp),

                overflow = TextOverflow.Ellipsis
                , color = MaterialTheme.colorScheme.onBackground

            )

        }
        Spacer(Modifier.size(8.dp))
CardItemCounter()
        Spacer(Modifier.weight(1f))
        Box(
            modifier = Modifier
                .width(4.dp).height(32.dp)
                .background(planStatusColor,shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)),

        )




    }
}




}

@Composable
fun CardItemCounter(iconTintCounter : Color = MaterialTheme.colorScheme.onSecondary,
                    count : Int = 0, cardColors: CardColors= CardDefaults.cardColors(PrimaryWhite)
                    , cardElevation: CardElevation = CardDefaults.cardElevation(0.dp)
                    , radius : Dp = 9999.dp){
    Card (colors = cardColors,elevation = cardElevation,shape = RoundedCornerShape(radius)){

        Row(Modifier.padding(horizontal = 8.dp, vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
            RotbeYarCardIconContainer(iconTint = iconTintCounter ,cardElevation = CardDefaults.cardElevation(0.dp),
                    imageResVector = R.drawable.decrase_icon,shape = RectangleShape,
                cardColor = CardDefaults.cardColors(Color.Transparent)
           , modifier = Modifier.size(24.dp) )
            Spacer(Modifier.size(8.dp))
            Text(textAlign = TextAlign.Center,fontWeight = FontWeight.SemiBold, fontSize = 16.sp,modifier = Modifier.width(48.dp), text = count.toString())
            Spacer(Modifier.size(8.dp))
            RotbeYarCardIconContainer(iconTint = iconTintCounter ,cardElevation = CardDefaults.cardElevation(0.dp),
                imageResVector = R.drawable.increase_icon,shape = RectangleShape,
                cardColor = CardDefaults.cardColors(Color.Transparent)
                , modifier = Modifier.size(24.dp) )








        }

    }
}







@Composable
fun CardExamItem(recordResultClick : ()-> Unit = {},
                 dayLeftClick : ()-> Unit = {},
                 dayLeftCount:String = "3",
                 dayLeftButtonBackGround:Color = MaterialTheme.colorScheme.errorContainer,
                 dayLeftTextColor:Color = MaterialTheme.colorScheme.error,



                 examHour:String="۸:۰۰",
                 examDate:String= "جمعه ۲۱ تیر ۱۴۰۳",
                 examTitle:String="قلم چی",
                 @DrawableRes examIconRes : Int = R.drawable.test_icon,
                 iconElevation: CardElevation = CardDefaults.cardElevation(0.dp),
                 iconColor: Color = MaterialTheme.colorScheme.primary,
                 backGroundIconColor : Color = MaterialTheme.colorScheme.primaryContainer,



                 ){
    Row (Modifier.fillMaxWidth().padding(16.dp),verticalAlignment = Alignment.CenterVertically) {
        RotbeYarCardIconContainer(
            size = 40.dp, cardElevation = iconElevation,
            imageResVector = examIconRes,
            cardColor = CardDefaults.cardColors(backGroundIconColor),
            iconTint = iconColor
        )
        Spacer(Modifier.size(12.dp))
        Column() {
            Text(
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                text = examTitle,
                fontSize = 14.sp,
                color = PrimaryBlack
            )
            Text(
                text = examDate, fontSize = 12.sp, color = MaterialTheme.colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis, maxLines = 1


            )
            Text(
                text = examHour, fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis, color = MaterialTheme.colorScheme.onBackground

            )

        }
        Spacer(Modifier.weight(1f))

        RotbeYarCardButton(
            modifier = Modifier,
            onClick = dayLeftClick,
        ) {
            Text(
                text = "$dayLeftCount روز",
                color = dayLeftTextColor,
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
               text = "ثبت نتایج",
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
        modifier =     Modifier.fillMaxWidth().padding(12.dp)){
            RotbeYarCardIconContainer(
                size = 32.dp,
                iconTint = iconColor,
                imageResVector = iconRes,
                cardColor = CardDefaults.cardColors(colorIconContainer),
                cardElevation = CardDefaults.cardElevation(0.dp),)
            Spacer(Modifier.size(12.dp))
            Column() {
                Text(color = PrimaryBlack,
                    text = stringResource(titleRes,
                    countTarget
                ), fontWeight = FontWeight.Medium, fontSize = 14.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    LinearProgressIndicator(
                        modifier = Modifier.padding().padding(vertical = 5.dp).height(6.dp),
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
    testCountTarget:Int=500,
    testPercentage : Int=10,
    studyCountTarget:Int=6,
    studyPercentage: Int=70,
    testScoreTarget:Int=7000,
    testScoreTargetPercentage: Int=90



){
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ){
        Box(
            modifier = Modifier.background(brush = PrimaryBackgroundGradient).fillMaxWidth().padding(16.dp)){
            Column {
                Row {
                    RotbeYarCardIconContainer(imageResVector = R.drawable.target,
                        size = 40.dp,
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
CardTargetItem(countTarget = testCountTarget,
    progressPercentage = testPercentage,
    colorIconContainer = PrimaryBlueContainer ,
    iconColor = PrimaryBlue
    )
                Spacer(Modifier.size(12.dp))
                CardTargetItem(
                    countTarget = studyCountTarget,
                    progressPercentage = studyPercentage,
                    titleRes = R.string.reach_daily_study_hours,
                    colorIconContainer = PrimaryGreenContainer ,
                    iconColor = PrimaryGreen,
                    iconRes = R.drawable.time_icon)
                Spacer(Modifier.size(12.dp))
                CardTargetItem(countTarget = testScoreTarget,
                    progressPercentage = testScoreTargetPercentage,
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



    }


  }


@Preview(showBackground = true, locale = "fa")
@Composable
fun show(){
    AppTheme(){
        StandardBoxPage (modifier = Modifier.padding(16.dp).fillMaxWidth().background(Color.Transparent)){

            CardChartDailyStudy()

    }}

}