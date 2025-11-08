package com.rotbeyar.app.presentation.feture.purchase.component.complete_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.ExamType
import com.rotbeyar.app.presentation.feture.purchase.component.SelectableCard
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.RotbeYarTheme


@Composable
fun ExamInfoContent(modifier: Modifier = Modifier,
                    selectedExams : Set<ExamType> = emptySet(),
                    onClickCard : (ExamType)-> Unit = {}){
    LazyColumn(modifier = modifier,verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item {
            SelectableCard(onClick = { onClickCard(ExamType.GHALAMCHI) },isSelected =
                selectedExams.contains(ExamType.GHALAMCHI)) {
                Row {
                    Image(
                        painter = painterResource(R.drawable.ghalamchi_logo),
                        contentDescription = "", modifier = Modifier.size(60.dp),


                        )
                    Spacer(Modifier.size(8.dp))

                    Column {
                        Text(
                            text = "آزمون ${stringResource(R.string.exam_ghalamchi)}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = PrimaryBlack
                        )
                        Spacer(Modifier.size(8.dp))

                        Text(
                            text = "• مناسب برای رشته\u200Cهای ریاضی و تجربی",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground

                        )
                        Text(
                            text = "• جامعه آماری بالا",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground

                        )
                        Text(
                            text = "• سطح بالاتر از کنکور",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground

                        )


                    }
                }


            }
        }

        item {
            SelectableCard(onClick = { onClickCard(ExamType.MAZ) },isSelected =
                selectedExams.contains(ExamType.MAZ)) {
                Row {
                    Image(
                        painter = painterResource(R.drawable.maz_logo),
                        contentDescription = "", modifier = Modifier.size(60.dp)

                    )
                    Spacer(Modifier.size(8.dp))

                    Column {
                        Text(
                            text = "آزمون ${stringResource(R.string.exam_maz)}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = PrimaryBlack
                        )
                        Spacer(Modifier.size(8.dp))

                        Text(
                            text = "• مناسب برای همه دانش\u200Cآموزان",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground

                        )
                        Text(
                            text = "• تست\u200Cهای سخت و چالش\u200Cبرانگیزا",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground

                        )
                        Text(
                            text = "• نگاه متفاوت به منابع",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground

                        )


                    }
                }


            }
        }


        item {
            SelectableCard(onClick = { onClickCard(ExamType.GOZINEH_2) },isSelected =
                selectedExams.contains(ExamType.GOZINEH_2)) {
                Row {
                    Image(
                        painter = painterResource(R.drawable.gozineh2_logo2),
                        contentDescription = "", modifier = Modifier.size(60.dp)

                    )
                    Spacer(Modifier.size(8.dp))

                    Column {
                        Text(
                            text = "آزمون ${stringResource(R.string.exam_gozine2)}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = PrimaryBlack
                        )
                        Spacer(Modifier.size(8.dp))

                        Text(
                            text = "• مناسب برای شروع آمادگی کنکور",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground

                        )
                        Text(
                            text = "• تست\u200Cهای آموزشی و توضیحات کامل",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground

                        )
                        Text(
                            text = "• تقویت پایه\u200Cهای درسی",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onBackground

                        )


                    }
                }


            }
        }
    }
}

