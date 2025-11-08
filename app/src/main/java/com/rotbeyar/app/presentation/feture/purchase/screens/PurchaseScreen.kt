package com.rotbeyar.app.presentation.feture.purchase.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.rotbeyar.app.presentation.feture.purchase.component.PurchaseDetailScreenContent
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBackgroundGradient
import com.rotbeyar.app.ui.theme.PrimaryBlack

@Composable
fun PurchaseScreen(){

    Scaffold(Modifier
        .fillMaxSize()
        .background(PrimaryBackgroundGradient)


, bottomBar = {Box(Modifier.fillMaxWidth()){

    HorizontalDivider(
        modifier = Modifier.height(2.dp).align(Alignment.TopCenter))
            RotbeYarButton(modifier = Modifier.padding(16.dp).fillMaxWidth(),
                text = stringResource(R.string.pay),
                onClick = {  },
                shape = RoundedCornerShape(8.dp)



            )
        }


}

        , topBar = {
            Box(Modifier.fillMaxWidth().background(Color.White)) {
                Column(
                    horizontalAlignment =Alignment.CenterHorizontally) {
                    Text(modifier = Modifier.padding(vertical = 12.dp),text = stringResource(R.string.pay), fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = PrimaryBlack
                    )
                    HorizontalDivider(Modifier.fillMaxWidth())
                }
            }
        }

    ) { contentPadding->

        PurchaseDetailScreenContent(
            contentPaddingValues =
                contentPadding)



    }



}
