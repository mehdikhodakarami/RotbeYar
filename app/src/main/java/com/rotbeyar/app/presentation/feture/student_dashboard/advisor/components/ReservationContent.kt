package com.rotbeyar.app.presentation.feture.student_dashboard.advisor.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.rotbeyar.app.domain.model.GrgAppTime
import com.rotbeyar.app.domain.model.Week
import com.rotbeyar.app.domain.model.grgToPersianDate
import com.rotbeyar.app.domain.model.reservation.DayReservationSlots
import com.rotbeyar.app.domain.model.reservation.ReservationSlot
import com.rotbeyar.app.domain.model.reservation.ReservationSlotStatus
import com.rotbeyar.app.domain.model.reservation.WeekReservationSchedule
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.component.main_app.SurfaceEditProfileInfo
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryBlueContainer
import com.rotbeyar.app.ui.theme.PrimaryGray
import com.rotbeyar.app.ui.theme.PrimaryGrayLight
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.Surface
import com.rotbeyar.app.utils.formatSecondsToTime

object SampleAdvisorData{
    val sampleWeekReservationWithStatus = WeekReservationSchedule(
        week = Week(
            startDay = AppGrgDateTime(2004, 2, 4),
            endDay = AppGrgDateTime(2004, 2, 10)
        ),
        day =  DayReservationSlots(
            date = AppGrgDateTime(2004, 2, 4),
            availableSlots = listOf(
                ReservationSlot(GrgAppTime(9, 0), ReservationSlotStatus.AVAILABLE),
                ReservationSlot(GrgAppTime(11, 30), ReservationSlotStatus.RESERVED),
                ReservationSlot(GrgAppTime(14, 0), ReservationSlotStatus.AVAILABLE),
                ReservationSlot(GrgAppTime(14, 0), ReservationSlotStatus.AVAILABLE)

            )
        )
    )
}
@Composable
fun ReservationContent(
    weekReservationSchedule: WeekReservationSchedule = SampleAdvisorData.sampleWeekReservationWithStatus

){

    val rows = weekReservationSchedule.day.availableSlots.chunked(3)
    Surface(color = Color.White,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()){

        Column(Modifier.padding(16.dp)) {
            Text(text = stringResource(R.string.reservation_meet_with_advisor),
                color = PrimaryBlack,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.size(32.dp))
            Row( Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically){
                Text(text = stringResource(R.string.select_meet_time),
                    color = MaterialTheme.colorScheme.onSecondary ,
                    fontSize = 14.sp,
                     fontWeight = FontWeight.Medium)
                Spacer(Modifier.weight(1f))
                Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.spacedBy(8.dp)) {


                    Icon(modifier = Modifier.size(15.dp),
                        tint = MaterialTheme.colorScheme.onSecondary,
                        imageVector = ImageVector.vectorResource(R.drawable.arrow_right),
                    contentDescription = "")

                    Text(text = "هفته ${weekReservationSchedule.week.startDay.appLocalDate().grgToPersianDate().shDay}" +
                            " ${weekReservationSchedule.week.startDay.appLocalDate().grgToPersianDate().monthName} - " +
                            "${weekReservationSchedule.week.endDay.appLocalDate().grgToPersianDate().shDay} " +
                            "${weekReservationSchedule.week.endDay.appLocalDate().grgToPersianDate().monthName}",
                        color = MaterialTheme.colorScheme.onBackground ,
                        fontSize = 14.sp,
                        )
                    Icon(modifier = Modifier.size(15.dp),
                        tint = MaterialTheme.colorScheme.onSecondary,
                        imageVector = ImageVector.vectorResource(R.drawable.left_arrow_icon),
                        contentDescription = "")



                }



            }
            Spacer(modifier = Modifier.size(12.dp))
            HorizontalDivider(Modifier.fillMaxWidth(), color = PrimaryGrayLight)
            Spacer(modifier = Modifier.size(8.dp))


            Row(Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
                ){


                repeat(7){ dayOrder->
                    Column(horizontalAlignment = Alignment.CenterHorizontally){
                        Text(text = AppGrgDateTime.persianWeekDays[dayOrder],
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 10.sp)

                        Spacer(Modifier.size(8.dp))
                        Box(
                            Modifier.background(PrimaryGrayLight, RoundedCornerShape(16.dp))
                                .clip(RoundedCornerShape(16.dp)).clickable{

                                }


                        ){
                            Column(Modifier.padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(text = weekReservationSchedule.week.startDay.appLocalDate().plusDays(
                                    dayOrder.toLong()
                                ).grgToPersianDate().shDay.toString(),
                                    color = PrimaryBlack,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 14.sp

                                )
                                Spacer(Modifier.size(4.dp))
                                Text(text = weekReservationSchedule.week.startDay.appLocalDate().plusDays(
                                    dayOrder.toLong()
                                ).grgToPersianDate().monthName,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Light)


                            }
                        }



                    }



                }





            }
            Spacer(Modifier.size(16.dp))
            Text(text = stringResource(R.string.available_hours),
                fontSize =14.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground)
            Spacer(Modifier.size(8.dp))

            rows.forEach { list->
                Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement
                    .SpaceBetween){
                    repeat(list.size){listIndex->
                        Surface(modifier = Modifier.width(90.dp), border =
                            BorderStroke( 1.dp, PrimaryGrayLight)
                            , onClick = {},
                            shape = RoundedCornerShape(16.dp)){


                            Text(modifier = Modifier.padding(12.dp),
                                textAlign = TextAlign.Center,
                                text = list[listIndex].let {
                                    formatSecondsToTime(
                                        it.time.hour*3600
                                            + it.time.minute*60).substring(0,5)

                                })



                        }

                    }


                }
                Spacer(Modifier.size(8.dp))

            }
            Spacer(Modifier.size(8.dp))
            Surface(color = PrimaryBlueContainer,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)){

                Column(Modifier.padding(12.dp
                )){
                    Row(horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()){
                        repeat(3){ rowIndex->
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically){
                                Box(
                                    Modifier.size(16.dp).background(when(rowIndex){

                                        0-> PrimaryGreen
                                            1-> PrimaryGray
                                        else-> PrimaryPurple
                                    },CircleShape

                                    )

                                )
                                Text(text = stringResource(
                                    when(rowIndex){
                                        0-> R.string.reserved
                                        1->  R.string.not_reserved
                                        else-> R.string.selected


                                    }

                                ), fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.onSecondary)
                            }
                        }


                    }
                    Spacer(Modifier.size(8.dp
                    ))
                    Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = stringResource(
                        R.string.you_can_reserve_2_meets),
                        fontSize = 12.sp,

                        color = MaterialTheme.colorScheme.onSecondary)


                }

            }
            Spacer(Modifier.size(16.dp))

            Text(text = stringResource(R.string.description),
                fontSize = 14.sp,
                color = PrimaryBlack,
                fontWeight = FontWeight.Medium)
            Spacer(Modifier.size(16.dp))

            OutlinedTextField(
                shape = RoundedCornerShape(16.dp),
                value = "",
                placeholder = {Text(text ="موضوع یا سوالات خاص خود را بنویسید...")},
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                maxLines = 5,
                singleLine = false,
            )
            Spacer(Modifier.size(16.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement
                .spacedBy(12.dp)){
                RotbeYarButton(modifier = Modifier.weight(1f),
                    onClick = {}, backgroundColor = PrimaryGrayLight,
                    contentColor = MaterialTheme.colorScheme.onSecondary,
                    text = stringResource(
                        R.string.cancel
                    ))
                RotbeYarButton(modifier = Modifier.weight(1f),
                    onClick = {},
                    text = stringResource(
                        R.string.reservation_meet
                    ))


            }










        }

    }


}

















