package com.rotbeyar.app.presentation.feture.purchase.component.complete_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.SelectableField
import com.rotbeyar.app.presentation.common.model.StudyMethodUi
import com.rotbeyar.app.presentation.feture.purchase.component.SelectableCard
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.RotbeYarTheme

@Composable
fun SchoolInfoContent(modifier: Modifier = Modifier,
                      studyMethodUi: StudyMethodUi = StudyMethodUi.SCHOOL,
                      selectStudyMethod : (StudyMethodUi)-> Unit = {}
){

    val listOfTitle = listOf(
        stringResource(R.string.study_with_school),
       stringResource (R.string.online_school),
       stringResource (R.string.self_study)
    )
    val listOfDescription = listOf(
        "ترکیب برنامه مدرسه با برنامه\u200Cریزی کنکور",
        "کلاس\u200Cهای آنلاین با اساتید مجرب",
        "مطالعه مستقل با منابع اختصاصی"



    )

    LazyColumn(modifier = modifier,verticalArrangement = Arrangement.spacedBy(16.dp)){
        repeat(3){
            item {
                SelectableCard(isSelected = studyMethodUi == StudyMethodUi.entries[it],
                    onClick = {selectStudyMethod(StudyMethodUi.entries[it]) }) {
                    Column(
                        Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier.size(80.dp),
                            painter = painterResource(
                                when (it) {
                                    0 -> R.drawable.school_icon
                                    1 -> R.drawable.online_school_icon
                                    2 -> R.drawable.self_study_icon
                                    else -> R.drawable.self_study_icon


                                }
                            ),
                            contentDescription = "",
                        )
                        Spacer(Modifier.size(12.dp))
                        Text(
                            listOfTitle[it], fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlack
                        )
                        Spacer(Modifier.size(8.dp))
                        Text(
                            listOfDescription[it],
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSecondary
                        )


                    }


                }


            }
        }




        }


    }
