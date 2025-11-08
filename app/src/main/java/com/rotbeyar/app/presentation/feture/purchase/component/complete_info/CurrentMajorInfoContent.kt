package com.rotbeyar.app.presentation.feture.purchase.component.complete_info



import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.SelectableField
import com.rotbeyar.app.presentation.common.model.EducationLevelUi
import com.rotbeyar.app.presentation.common.model.EducationMajorUi
import com.rotbeyar.app.ui.theme.RotbeYarTheme



@Composable
fun CurrentMajorInfoContent(
    modifier: Modifier = Modifier,
    currentMajor : EducationMajorUi? = null,
    majorForExam : EducationMajorUi? = null,
    educationLevel: EducationLevelUi? = null,
    selectMajor : (EducationMajorUi)-> Unit = {},
    selectEducationLevel : (EducationLevelUi)-> Unit = {},
    selectMajorForExam : (EducationMajorUi)-> Unit = {},
){
    val context :Context = LocalContext.current


    val listOfMajor = listOf(
        stringResource(EducationMajorUi.MATHEMATICS.title),
        stringResource(EducationMajorUi.NATURAL_SCIENCE.title)


    )
    val listOfMajorForExam =
        listOf(
            stringResource(EducationMajorUi.MATHEMATICS.title),
            stringResource(EducationMajorUi.NATURAL_SCIENCE.title)


        )


    val listOfEducationLevel = listOf(
        stringResource(EducationLevelUi.TEN.title),
        stringResource(EducationLevelUi.ELEVEN.title),
        stringResource(EducationLevelUi.TWELVE.title)    )


    LazyColumn(verticalArrangement = Arrangement.spacedBy(24.dp), modifier = modifier.padding(16.dp)
    ) {
        repeat(3){index->
            item {
                Card(modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(Color.White)) {
                    SelectableField(modifier = Modifier.padding(24.dp),
                        label = when(index){
                            0->"رشته تحصیلی فعلی"
                            1->"پایه تحصیلی"
                            2->"رشته مورد نظر برای کنکور"
                            else -> TODO()
                        }
                        , options = when(index){
                            0->listOfMajor
                            1->listOfEducationLevel
                            2->listOfMajorForExam
                            else->TODO()
                        }, selectedOption = when(index){
                            0->currentMajor?.let { stringResource(currentMajor.title) }
                            1->educationLevel?.let { stringResource(educationLevel.title) }
                            2->majorForExam?.let { stringResource(majorForExam.title) }
                            else->TODO()

                        }, onOptionSelected = {string->
                            when(index){
                                0->{
                                    EducationMajorUi.entries.find { context.getString(it.title)== string }?.let { selectMajor(it) }


                                }

                                1->{
                                    EducationLevelUi.entries.find { context.getString(it.title)== string }?.let { selectEducationLevel(it) }
                                }
                                2->{
                                    EducationMajorUi.entries.find { context.getString(it.title)== string }?.let { selectMajorForExam(it)}
                                }
                                else->TODO()


                        }


                })}
            }


        }

    }
}


