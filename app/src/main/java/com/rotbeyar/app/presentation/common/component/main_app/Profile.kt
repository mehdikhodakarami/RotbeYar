package com.rotbeyar.app.presentation.common.component.main_app


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import com.rotbeyar.app.domain.model.grgToPersianDate
import com.rotbeyar.app.domain.model.subscription.StudentSubscription
import com.rotbeyar.app.domain.model.subscription.SubscriptionStatus
import com.rotbeyar.app.domain.model.subscription.SubscriptionType
import com.rotbeyar.app.domain.model.user.EducationLevel
import com.rotbeyar.app.domain.model.user.EducationMajor
import com.rotbeyar.app.domain.model.user.User
import com.rotbeyar.app.domain.model.user.UserRole
import com.rotbeyar.app.presentation.common.component.AppStudyPartIndicator
import com.rotbeyar.app.presentation.common.component.CircleStepWithNumber
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.RotbeYarCardIconContainer
import com.rotbeyar.app.presentation.common.component.RotbeYarTextField
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.model.EducationLevelUi
import com.rotbeyar.app.presentation.common.model.EducationMajorUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.SubscriptionPackageUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.LessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.SampleStudentDashboardData
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyLessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyPartStatusUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.plan.LessonDevelopmentInWeekUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.plan.PlanDevelopmentInWeekUi
import com.rotbeyar.app.presentation.feture.purchase.component.complete_info.CurrentMajorInfoContent
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryBlue
import com.rotbeyar.app.ui.theme.PrimaryBlueContainer
import com.rotbeyar.app.ui.theme.PrimaryError
import com.rotbeyar.app.ui.theme.PrimaryErrorContainer
import com.rotbeyar.app.ui.theme.PrimaryGray
import com.rotbeyar.app.ui.theme.PrimaryGrayLight
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryGreenContainer
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.PrimaryPurpleContainer
import com.rotbeyar.app.ui.theme.PrimaryYellow
import com.rotbeyar.app.ui.theme.PrimaryYellowContainer
import com.rotbeyar.app.ui.theme.Surface
import com.rotbeyar.app.ui.theme.VipGradientColor
import com.rotbeyar.app.ui.theme.VipGradientColorContainer
import saman.zamani.persiandate.PersianDate


@Composable
fun CardStudentProfile(user : User = User(
    id = 12,
    firstName ="مهدی",
    lastName = "خداکرمی",
    phone = "09168660768",
    email = "mehdikhodakarami02@Gmail.com",
    role = UserRole.STUDENT,
    subscription = null

)){
    Surface(modifier = Modifier.fillMaxWidth()){

        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically){
            RotbeYarCardIconContainer(
                imageResVector = R.drawable.profile_icon,
                containerSize = 80.dp,


            )
            Spacer(Modifier.size(16.dp))
            Column {
                Text(text = "${user.firstName} ${user.lastName}" ,
                    fontSize = 18.sp, fontWeight = FontWeight.Bold)

                Text(text = "پایه دوازدهم",
                    fontSize = 14.sp
                    )


            }


        }
    }
}
@Composable
fun CardSubscriptionStatus(
    studentSubscription: StudentSubscription = StudentSubscription(
        type = SubscriptionType.VIP,
        status = SubscriptionStatus.ACTIVE,
    expiresAt = "230,2",
    startDate = 12,
    expiryDate = 13,
    daysRemaining = 12
    )

){

    Surface( color = Color.Transparent, shape = RoundedCornerShape(16.dp)){
        Box(Modifier.fillMaxWidth().let{
            if(studentSubscription.status ==
                SubscriptionStatus.NONE){
                it.background(PrimaryGrayLight.copy(0.5f))
            } else if(studentSubscription.type ==
                SubscriptionType.VIP

            ){
                it.background(brush = VipGradientColorContainer)

            }else{
                it.background(when(studentSubscription.type){
                    SubscriptionType.BASIC -> PrimaryYellowContainer.copy(0.5f)
                    SubscriptionType.PRO -> PrimaryBlueContainer.copy(0.5f)
                    SubscriptionType.VIP -> TODO()
                    null -> TODO()
                })
            }







        } ){

            Column (Modifier.padding(16.dp)){
                Row(verticalAlignment = Alignment.CenterVertically){
                    RotbeYarCardIconContainer(iconSize = 24.dp,
                        cardColor = CardDefaults.cardColors(if(studentSubscription.status ==
                            SubscriptionStatus.NONE) PrimaryGrayLight else  when(studentSubscription.type){
                            SubscriptionType.PRO -> PrimaryBlueContainer
                            SubscriptionType.VIP -> PrimaryPurpleContainer
                            SubscriptionType.BASIC ->PrimaryYellowContainer

                            null -> TODO()



                        } ),
                        imageResVector = if(studentSubscription.status == SubscriptionStatus.NONE) R.drawable.profile_icon else
                            when(studentSubscription.type){
                                SubscriptionType.PRO -> R.drawable.pro_icon
                                SubscriptionType.VIP ->R.drawable.vip_icon
                                SubscriptionType.BASIC -> R.drawable.shield_icon

                                null -> TODO()



                            }
                            ,
                        containerSize = 60.dp,
                        iconTint = if(studentSubscription.status == SubscriptionStatus.NONE)
                            MaterialTheme.colorScheme.onSecondary
                        else when(studentSubscription.type){
                            SubscriptionType.PRO -> PrimaryBlue
                            SubscriptionType.VIP ->PrimaryPurple
                            SubscriptionType.BASIC -> PrimaryYellow

                            null -> TODO()



                        }

                    )
                    Spacer(Modifier.size(12.dp))
                    Column {
                        Text(text = stringResource(if(studentSubscription.status ==
                            SubscriptionStatus.NONE) R.string.none_package_name else
                                when(studentSubscription.type){
                                    SubscriptionType.PRO -> R.string.pro_package_name
                                    SubscriptionType.VIP -> R.string.vip_package_name
                                    SubscriptionType.BASIC ->  R.string.basic_package_name

                                    null -> TODO()



                                }), fontWeight = FontWeight.Medium,
                            fontSize = 14.sp)
                        Text(text = stringResource(
                            R.string.limited_access_to_features),
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 12.sp)
                    }
                    Spacer(Modifier.weight(1f))
                    Surface(shape = RoundedCornerShape(24.dp),
                        color =  if(studentSubscription.status ==
                            SubscriptionStatus.NONE) PrimaryGray else
                            PrimaryGreenContainer){
                        Text(modifier = Modifier.padding(vertical = 2.dp,
                            horizontal = 8.dp),text= stringResource(


                            if(studentSubscription.status ==
                                SubscriptionStatus.NONE) R.string.free else
                            R.string.active),
                            color = if(studentSubscription.status ==
                                SubscriptionStatus.NONE) PrimaryGrayLight else
                                PrimaryGreen,
                            fontSize = 12.sp)



                    }

                }
                Spacer(Modifier.size(16.dp))
                Surface(modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    color = Color.White) {
                    Row(Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically){
                        RotbeYarCardIconContainer(imageResVector =
                            if(studentSubscription.status
                                == SubscriptionStatus.NONE)
                                R.drawable.info_icon else R.drawable.shield_icon,
                            iconTint = if(studentSubscription.status
                                == SubscriptionStatus.NONE)
                                MaterialTheme.colorScheme.onBackground else PrimaryGreen
                            ,
                            containerSize = 32.dp,
                            iconSize = 15.dp,
                            cardColor = CardDefaults.cardColors(


                                if(studentSubscription.status
                                    == SubscriptionStatus.NONE)
                                    PrimaryGrayLight else PrimaryGreenContainer
                            )
                        )
                        Spacer(Modifier.size(8.dp))
                        Column {

                            Text(
                                text = stringResource(if(studentSubscription.status == SubscriptionStatus.NONE)
                                    R.string.upgrade_to_vip_package else

                                    when(studentSubscription.type){
                                        SubscriptionType.PRO ->R.string.access_to_pro_feature
                                        SubscriptionType.VIP -> R.string.full_access_to_all_feature
                                        SubscriptionType.BASIC -> R.string.access_to_basic_feature

                                        null -> TODO()
                                    }




                                ),
                                color = PrimaryBlack,
                                fontSize = 14.sp,
                            )
                            Text(
                                text = stringResource(if(studentSubscription.status == SubscriptionStatus.NONE)
                                    R.string.buy_vip_package else

                                    when(studentSubscription.type){
                                        SubscriptionType.PRO ->R.string.you_have_access_to_pro
                                        SubscriptionType.VIP -> R.string.you_have_access_to_vip
                                        SubscriptionType.BASIC -> R.string.you_have_access_to_basic

                                        null -> TODO()
                                    }




                                ),
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 12.sp,
                            )
                        }


                    }

                }

                Spacer(Modifier.size(12.dp))
                RotbeYarButton(modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(),
                    onClick = {},
                    backgroundColor = if(studentSubscription.status == SubscriptionStatus.NONE)
                        PrimaryPurple else when(studentSubscription.type){
                        SubscriptionType.BASIC -> PrimaryYellow
                        SubscriptionType.PRO -> PrimaryBlue
                        SubscriptionType.VIP ->Color.Transparent
                        null -> TODO()
                    },
                    gradient = if(studentSubscription.type == SubscriptionType.VIP) VipGradientColor else null,


                    icon = ImageVector.vectorResource(if(studentSubscription.status
                        == SubscriptionStatus.NONE) R.drawable.king_icon else R.drawable.renew_icon),
                    text = stringResource(if(studentSubscription.status ==
                        SubscriptionStatus.NONE

                    ) R.string.buy_subscription else R.string.renew_subscription)
                )


            }



        }
    }
}


@Composable
fun CardBasicProfileInfo(){

Surface(shape = RoundedCornerShape(16.dp),
    shadowElevation = 1.dp){
Column (Modifier.padding(16.dp),verticalArrangement = Arrangement.spacedBy(16.dp)){

    repeat(5){

     Column {
         Row(){
             Text(text =when(it){
0->"${stringResource(R.string.name)}" +
        " ${stringResource(R.string.last_name)}"
    1->stringResource(R.string.phone_number)

                     2->stringResource(R.string.education_major)


                     3->stringResource(R.string.education_level)
                     4->stringResource(R.string.favorite_major)

                 else -> ""
             } ,
                 fontSize = 14.sp)
             Spacer(Modifier.weight(1f))

         }

         if(it != 4) {  Spacer(Modifier.size(8.dp))
             HorizontalDivider(Modifier.fillMaxWidth())}
     }
    }


}

}


}

@Composable
fun SurfaceEditProfileInfo(
    modifier: Modifier = Modifier,
    name : String = "مهدی",
    lastName : String = "خداکرمی",

    phoneNumber : String = "09168660768",
    educationLevelUi: EducationLevelUi = EducationLevelUi.TEN,
    educationMajor: EducationMajorUi = EducationMajorUi.NATURAL_SCIENCE,
    favoriteMajor : String = "پزشکی",
    onNameChange  : (String)-> Unit = {} ,
    onLastNameChange  : (String)-> Unit = {} ,
    isEditing : Boolean = false





    ){
    var isEdit by remember { mutableStateOf(isEditing) }




    Surface(modifier = modifier.fillMaxWidth(),
        color = Color.White.copy(alpha = 0.7f),
        shape = RoundedCornerShape(12.dp)) {
        Column(
            Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row {   Text(text = stringResource(R.string.basic_info),
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp)
Spacer(Modifier.weight(1f))
                Row(modifier = Modifier
                    .clip(
                        shape =
                            RoundedCornerShape(16.dp)
                    )
                    .clickable {


                        isEdit = !isEdit

                    }
                    .padding(end = 4.dp),
                    verticalAlignment = Alignment.CenterVertically){


                    Icon(modifier = Modifier.size(16.dp),
                        imageVector =if(isEdit) Icons.Default.Check else Icons.Default.Edit,
                        contentDescription = ""
                    )
                    Spacer(Modifier.size(4.dp))
                    Text(text = stringResource(
                        if(isEdit) R.string.apply else R.string.edit


                    ), fontSize = 16.sp


                    )


                }

            }


            repeat(6) {


                val (label, value ) = when (it) {
                    0 -> stringResource(R.string.name) to name
                    1 ->   stringResource(R.string.last_name) to lastName
                    2 ->  stringResource(R.string.phone_number) to phoneNumber
                    3-> stringResource(R.string.education_major) to stringResource(educationMajor.title)
                    4->stringResource(R.string.favorite_major) to favoriteMajor
                    else ->  stringResource(R.string.education_level) to stringResource(educationLevelUi.title)
                }



                RotbeYarTextField(value = value,
                    label = label,
                    enabled = if(it < 2) isEdit else false ,
                    onValueChange = if(it == 1) onNameChange else onLastNameChange
                )

            }


        }
    }
        }




@Preview(showBackground = true , locale = "fa")
@Composable
fun show(){

    AppTheme {
        SurfaceEditProfileInfo()
    }
}
