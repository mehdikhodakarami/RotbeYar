package com.rotbeyar.app.presentation.feture.student_dashboard.profile.components

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
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.draw.clipToBounds
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
import com.rotbeyar.app.presentation.common.component.main_app.CardAdvisorMeet
import com.rotbeyar.app.presentation.common.component.main_app.CardAdvisorProfile
import com.rotbeyar.app.presentation.common.component.main_app.CardBasicProfileInfo
import com.rotbeyar.app.presentation.common.component.main_app.CardNextAdvisorMeet
import com.rotbeyar.app.presentation.common.component.main_app.CardStudentProfile
import com.rotbeyar.app.presentation.common.component.main_app.CardSubscriptionStatus
import com.rotbeyar.app.presentation.common.component.main_app.SurfaceEditProfileInfo
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.OverallDevelopUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.StudyInDayUi
import com.rotbeyar.app.presentation.feture.student_dashboard.advisor.components.AdvisorContent
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryBlueContainer
import com.rotbeyar.app.ui.theme.PrimaryGray
import com.rotbeyar.app.ui.theme.PrimaryGrayLight
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.Surface
import com.rotbeyar.app.utils.formatSecondsToTime
@Composable
fun StudentProfileContent(



){




    LazyColumn(modifier= Modifier.padding(16.dp)) {
        item {CardStudentProfile()
            Spacer(Modifier.size(24.dp))


        }
        item {
            CardSubscriptionStatus()
            Spacer(Modifier.size(24.dp))
        }

        item {

            Spacer(Modifier.size(12.dp))
            SurfaceEditProfileInfo()




        }

        item {  }

        item {  }

        item {  }



    }


}
