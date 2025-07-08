package com.rotbeyar.app.presentation.student_dashboard.home.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.User
import com.rotbeyar.app.presentation.common.component.main_app.CardCurrentLessonPlan
import com.rotbeyar.app.presentation.common.component.main_app.CardExamItem
import com.rotbeyar.app.presentation.common.component.main_app.CardToDoLessonItem
import com.rotbeyar.app.presentation.common.component.main_app.CardTodayDevelopment
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.utils.plus

@Composable
fun StudentHomeContent(user: User? = null,
                       contentPaddingValues: PaddingValues = PaddingValues(0.dp),

                       monthDate:String = "۱۸ تیر ۱۴۰۴",
                       weekDate : String = "سه شنبه",
                       firstName:String = "امیر حسین",
                       onClickProfile: () -> Unit = {},
                       onClickStartStudy: () -> Unit = {},
                       onClickSeeDevelopment: () -> Unit = {},
                       )


{
    
    LazyColumn(contentPadding = contentPaddingValues  + PaddingValues( 16.dp)) {
        item {         NameProfileStudentRow(


            profileIconOnClick = onClickProfile)
            Spacer(Modifier.size(16.dp))
        }
        item {
            CardCurrentLessonPlan()
            Spacer(Modifier.size(24.dp))
        }
        item { CardTodayDevelopment()
        Spacer(Modifier.size(24.dp))}

        item {
            Column {
                Text("برنامه امروز",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold)
                    Spacer(Modifier.size(16.dp))

                repeat(5) {
                    CardToDoLessonItem()
                    Spacer(Modifier.size(12.dp))
                } } }



        item {
            Spacer(Modifier.size(12.dp))
            Row { Text(text = "آزمون های پیش رو",
                fontWeight = FontWeight.SemiBold,
                fontSize =16.sp
                )
                Spacer(Modifier.weight(1f))
                Text(text = "مشاهده همه", fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary)


            }
            Spacer(Modifier.size(12.dp))
            Card(colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(16.dp)) {
                Column {
                    repeat(4){
                        CardExamItem()
                        HorizontalDivider()
                    }

                }

            }




        }

    }

}
@Composable
fun NameProfileStudentRow(

    user: User? = User("امیر حسین",
    "moradi",
    "mehdikhodakarami",
    "09123456789"
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


                painter = painterResource(id = R.drawable.profile_sample),
                contentDescription = "Circular PNG Image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
        }

    }

}
@Preview(showBackground = true,locale = "fa")
@Composable
fun show4(){
    AppTheme{
        Box{
            StudentHomeContent()

        }
    }

}


