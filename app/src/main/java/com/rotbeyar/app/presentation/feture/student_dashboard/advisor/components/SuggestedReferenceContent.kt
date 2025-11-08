package com.rotbeyar.app.presentation.feture.student_dashboard.advisor.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
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
import com.rotbeyar.app.domain.model.AppGrgDateTime
import com.rotbeyar.app.domain.model.ShortTimeTarget
import com.rotbeyar.app.domain.model.StudyPart
import com.rotbeyar.app.domain.model.grgToPersianDate
import com.rotbeyar.app.domain.model.subscription.StudentSubscription
import com.rotbeyar.app.domain.model.subscription.SubscriptionStatus
import com.rotbeyar.app.presentation.common.component.ColumnBlurContent
import com.rotbeyar.app.presentation.common.component.RotbeYarCardIconContainer
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.RotbeYarCardButton
import com.rotbeyar.app.presentation.common.component.RotbeYarTextField
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.component.main_app.CardSuggestedReference
import com.rotbeyar.app.presentation.common.model.SuggestedReferenceUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ExamUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.SampleStudentDashboardData
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ShortTimeTargetUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyLessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyPartStatusUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.TodayDevelopUi
import com.rotbeyar.app.presentation.feture.purchase.screens.SelectPackageDialog
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.GreenGradientBrush
import com.rotbeyar.app.ui.theme.GreenGradientBrushLight
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
import com.rotbeyar.app.ui.theme.PrimaryError
import com.rotbeyar.app.ui.theme.PrimaryErrorContainer
import com.rotbeyar.app.ui.theme.PrimaryGray
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.PrimaryPurpleContainer
import com.rotbeyar.app.ui.theme.Surface
import com.rotbeyar.app.ui.theme.VipGradientColor
import com.rotbeyar.app.ui.theme.VipGradientColorContainer
import com.rotbeyar.app.utils.clockFromSec


@Composable
fun SuggestedReferenceContent(modifier: Modifier = Modifier,
                                    listOfSuggestedReferenceUi: List<SuggestedReferenceUi>  = listOf(
       SuggestedReferenceUi(
            SampleStudentDashboardData.sampleMathLesson,
            "مبتکران",
            textBookFeature ="عالیه",
            testBookTitle = "نشر الگو",
            testBookFeature ="عالیه تست"
        ),
  SuggestedReferenceUi(
            SampleStudentDashboardData.samplePhysicsLesson,
            "مبتکران",
            textBookFeature ="عالیه",
            testBookTitle = "نشر الگو",
            testBookFeature ="عالیه تست"
        ),
       SuggestedReferenceUi(
            SampleStudentDashboardData.sampleBiologyLesson,
            "مبتکران",
            textBookFeature ="عالیه",
            testBookTitle = "نشر الگو",
            testBookFeature ="عالیه تست"
        ),
      SuggestedReferenceUi(
            SampleStudentDashboardData.sampleChemistryLesson,
            "مبتکران",
            textBookFeature ="عالیه",
            testBookTitle = "نشر الگو",
            testBookFeature ="عالیه تست"
        )

            )


    ) {
    Surface(color = Color.White, shape = RoundedCornerShape(12.dp),
        modifier = modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.suggested_reference),
                fontWeight = FontWeight.SemiBold,
                color = PrimaryBlack,
                fontSize = 18.sp
            )
            Spacer(Modifier.size(16.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {

                items(listOfSuggestedReferenceUi) {
                    CardSuggestedReference(
                        suggestedReferenceUi = it
                    )


                }

            }


        }


    }
}


