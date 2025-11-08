package com.rotbeyar.app.presentation.feture.purchase.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.subscription.SubscriptionType
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.common.model.student_dashboard.SubscriptionPackageUi
import com.rotbeyar.app.presentation.feture.purchase.component.CardItemPackage
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryBlack

@Composable
fun SelectPackageDialog(
    onPackageSelect : (SubscriptionType) -> Unit = {}

){
    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {

        StandardBoxPage(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 32.dp).
        background(MaterialTheme.colorScheme.secondary,RoundedCornerShape(16.dp))){
            LazyColumn(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 24.dp), verticalArrangement = Arrangement.spacedBy(24.dp)) {
item { Text(text = stringResource(R.string.select_package),
    color = PrimaryBlack,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp

) }
                repeat(3){
                    item{
                        when(it){
                            0-> CardItemPackage(

                                SubscriptionPackageUi(SubscriptionType.BASIC),
                                onPackageSelect = onPackageSelect
                            )
                            1-> CardItemPackage(
                                SubscriptionPackageUi(SubscriptionType.PRO),
                                onPackageSelect = onPackageSelect
                            )
                            2-> CardItemPackage(
                                SubscriptionPackageUi(SubscriptionType.VIP),
                                onPackageSelect = onPackageSelect
                            )
                        }
                    }
                }


            }
        }




    }


}

