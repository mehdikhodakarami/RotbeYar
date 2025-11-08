package com.rotbeyar.app.presentation.feture.purchase.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.RotbeYarCardIconContainer
import com.rotbeyar.app.presentation.common.component.RotbeYarTextField
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.model.PurchaseDetailsUi
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBackgroundGradient
import com.rotbeyar.app.ui.theme.PrimaryBlack
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryGreenContainer
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.PrimaryPurpleContainer
import com.rotbeyar.app.utils.formatNumberWithCommas

@Composable
fun PurchasePriceDetailCard(purchaseDetail : PurchaseDetailsUi = PurchaseDetailsUi(
    2000000,500000,1500000
) ){
    Card(modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),

        colors = CardDefaults.cardColors(Color.White)){

        Column(modifier = Modifier.padding(24.dp)) {
            Row{
                RotbeYarCardIconContainer(imageResVector = R.drawable.package_icon,
                    shape = RoundedCornerShape(20.dp),
                    iconSize = 15.dp,
                    containerSize = 48.dp,
                    iconTint = MaterialTheme.colorScheme.onPrimary,
                    cardColor = CardDefaults.cardColors(PrimaryPurple)
                )
                Spacer(Modifier.size(16.dp))
                Column {
                    Text(text = stringResource(R.string.full_package),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = PrimaryBlack

                    )


                    Text(text = stringResource(R.string.full_access_to_all_courses),
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSecondary

                        )

                }
            }

            Spacer(Modifier.size(16.dp))
            HorizontalDivider()
            Spacer(Modifier.size(17.dp))
            Row{
                Text(text = "قیمت پکیج",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSecondary

                    )
                Spacer(Modifier.weight(1f))
                Text(text = "${formatNumberWithCommas(purchaseDetail.originalPrice.toLong())} تومان",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,

                    color = PrimaryBlack

                )



            }
            Spacer(Modifier.size(8.dp))
            Row{
                Text(text = "تخفیف",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSecondary

                )
                Spacer(Modifier.weight(1f))
                Text(text = "${formatNumberWithCommas(purchaseDetail.discountAmount.toLong())} تومان",
                    fontSize = 14.sp,

                    color = PrimaryGreen

                )




            }


            Spacer(Modifier.size(16.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally){
                RotbeYarTextField(
                    shape = RoundedCornerShape(20.dp),
                    label = "کد تخفیف",
                    onValueChange = {}
                )
                Spacer(Modifier.size(8.dp))
                RotbeYarButton(
                    onClick = {},
modifier = Modifier
    .fillMaxWidth()
    .height(40.dp),
                    text =stringResource(R.string.apply),
                    backgroundColor = PrimaryGreenContainer,
                    contentColor = PrimaryGreen

                )
                Spacer(Modifier.size(16.dp))
                HorizontalDivider()
                Spacer(Modifier.size(8.dp))


                Row{
                    Text(text = "مبلغ قابل پرداخت",
                        fontSize = 18.sp,
                        color = PrimaryBlack,
                        fontWeight = FontWeight.SemiBold

                    )
                    Spacer(Modifier.weight(1f))
                    Text(text = "${formatNumberWithCommas(purchaseDetail.finalPrice)} تومان",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,

                        color = PrimaryPurple

                    )



                }






            }
        }
    }


}

@Composable
fun PurchaseWayCard(){
    Card(modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)){
        Column(Modifier.padding(24.dp)) {
            Text(text = stringResource(R.string.purchase_ways), fontWeight = FontWeight.Bold,
                color = PrimaryBlack, fontSize = 18.sp)
            Spacer(Modifier.size(16.dp))
            SelectableCard(isSelected = true){
                Row(verticalAlignment = Alignment.CenterVertically) {
                    

                    RotbeYarCardIconContainer(
                        containerSize = 40.dp,
                        iconSize = 18.dp,
cardColor = CardDefaults.cardColors(PrimaryPurpleContainer),
                        imageResVector = R.drawable.bank_icon)

                    Spacer(Modifier.size(12.dp))


                    Column {
                        Text(text ="درگاه بانکی",
                            fontSize = 16.sp,
                            color = PrimaryBlack,
                            fontWeight = FontWeight.Medium)


                        Text(text = "پرداخت امن با کارت بانکی",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSecondary)
                    }


                }

            }
            Spacer(Modifier.size(16.dp))
            Text(text = "اطلاعات شما با بالاترین سطح امنیت محافظ می شود",
                color = PrimaryGreen,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp, modifier = Modifier.align(Alignment.CenterHorizontally))

        }

}}
@Composable
fun SelectableCard(
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    val borderColor by animateColorAsState(
        if (isSelected) MaterialTheme.colorScheme.primary else Color.LightGray
    )

    val backgroundColor by animateColorAsState(
        if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
        else Color.White
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = isSelected,
                onClick = onClick
            ),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, borderColor),
        colors = CardDefaults.cardColors(backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(Modifier.weight(1f)) {
                content()
            }

            RadioButton(
                selected = isSelected,
                onClick = null,
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}




