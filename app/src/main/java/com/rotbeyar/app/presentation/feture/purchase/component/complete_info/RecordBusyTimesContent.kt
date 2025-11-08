package com.rotbeyar.app.presentation.feture.purchase.component.complete_info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.AppGrgDateTime
import com.rotbeyar.app.domain.model.StudyPart
import com.rotbeyar.app.presentation.common.component.main_app.CardStudyTime

import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBlack


@Composable
fun RecordBusyTimesContent(modifier: Modifier = Modifier,
                           selectedItems : Map<Int, Set<StudyPart>> = mutableStateMapOf(),
                           onStudyPartClick:(Pair<Int, StudyPart>)->Unit = {}
                           ){





    val listOfParts = StudyPart.allParts().subList(0,2)+StudyPart.allParts().subList(3,7)
    val listOfDays = AppGrgDateTime.persianWeekDays
    LazyColumn(modifier.fillMaxWidth().background(Color.Transparent,
        RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            Column(Modifier.fillMaxWidth().padding(vertical = 16.dp,horizontal = 12.dp)) {
                Text(text = stringResource(R.string.record_busy_times),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = PrimaryBlack)
                Spacer(Modifier.size(8.dp))
                Text(text = "زمان\u200Cهایی که در هفته آینده امکان مطالعه ندارید را انتخاب کنید",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f))
                Spacer(Modifier.size(12.dp))


            }
        }

        repeat(7){day->
            item{
                Card(modifier = Modifier.fillMaxWidth().padding(
                    start = 12.dp,end = 12.dp, bottom = 16.dp

                ),

                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
                    elevation = CardDefaults.cardElevation(1.dp)) {
                    Column(Modifier.padding(12.dp)) {
                        Text(listOfDays[day], fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp, color = MaterialTheme.colorScheme.onBackground)
Spacer(Modifier.size(8.dp))
                        Column(Modifier.fillMaxWidth().padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            repeat(2){x->
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)){
                                    repeat(3){y->
                                        CardStudyTime(
                                            isSelected =
                                                selectedItems[day]?.contains(listOfParts[x*3+y])?:false
                                            ,
                                            studyPart = listOfParts[x*3+y],
                                            onSelectedChange = {studyPart ->
                                                studyPart?.let { onStudyPartClick(
                                                    Pair(day,studyPart)

                                                ) }








                                            }

                                            )
                                    }


                                }
                            }
                        }



                    }


                }


            }

        }



    }


}

