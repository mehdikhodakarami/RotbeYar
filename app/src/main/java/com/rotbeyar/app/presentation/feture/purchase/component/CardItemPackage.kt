package com.rotbeyar.app.presentation.feture.purchase.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.subscription.SubscriptionType
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.model.student_dashboard.SubscriptionPackageUi
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBackgroundGradient
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryBlue
import com.rotbeyar.app.ui.theme.PrimaryBlueContainer
import com.rotbeyar.app.ui.theme.PrimaryGray
import com.rotbeyar.app.ui.theme.PrimaryGrayLight
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.VipGradientColor
import com.rotbeyar.app.utils.formatNumberWithCommas

@Composable
fun CardItemPackage(
    packageItem : SubscriptionPackageUi =
        SubscriptionPackageUi(subscriptionType  = SubscriptionType.PRO)
,onPackageSelect : (SubscriptionType) -> Unit = {}

){

    Card(elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.Transparent)



        ){

        Box( modifier = Modifier
            .then(
                if (packageItem.subscriptionType == SubscriptionType.VIP)
                    Modifier.background(brush = PrimaryBackgroundGradient).
                    border(
                        width = 3.dp,
                        brush = VipGradientColor,
                        shape = RoundedCornerShape(16.dp),
                    )
                else
                    Modifier.background(color = when(packageItem.subscriptionType){
                        SubscriptionType.BASIC -> MaterialTheme.colorScheme.secondary
                        SubscriptionType.PRO -> PrimaryBlueContainer.copy(alpha = 0.3f)
                        else -> TODO()
                    }).border(
                        width = 2.dp,
                        color = if(packageItem.subscriptionType == SubscriptionType.BASIC)
                            PrimaryGrayLight else PrimaryBlue,
                        shape = RoundedCornerShape(16.dp),
                    )
            )


        )
        {

            Column(Modifier.padding(16.dp)){
                Row(verticalAlignment = Alignment.CenterVertically){
                    Column {
                        Text(text = stringResource(packageItem.titleRes)
                            , fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlack
                        )

                        Text(
                            text = packageItem.isGoodForTitle
                            , fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )


                    }
                    Spacer(Modifier.weight(1f))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = formatNumberWithCommas(packageItem.price)
                            , fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlack
                        )

                        Text(
                            text = "تومان / ماهانه"
                            , fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }

                }
                Spacer(Modifier.size(16.dp))
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    repeat(packageItem.listDescriptions.size){
                        Row(verticalAlignment = Alignment.CenterVertically){
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.check_icon),
                                contentDescription = "",
                                tint = PrimaryGreen,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(Modifier.size(12.dp))
                            Text(text = packageItem.listDescriptions[it],
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                        }
                    }
                }
                Spacer(Modifier.size(16.dp))
                RotbeYarButton(modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
                    text = "انتخاب ${stringResource(packageItem.titleRes)}",
                    onClick = { onPackageSelect(packageItem.subscriptionType) },
                    backgroundColor = if(packageItem.subscriptionType ==
                        SubscriptionType.BASIC)
                        PrimaryGray.copy(alpha = 0.6f) else PrimaryBlue,
                    gradient = if(packageItem.subscriptionType == SubscriptionType.VIP) VipGradientColor else null
                   ,
                    contentColor = if(packageItem.subscriptionType == SubscriptionType.BASIC)
                        PrimaryBlack else MaterialTheme.colorScheme.onPrimary,
                    height = 40.dp


                    )

            }


        }

    }
}


