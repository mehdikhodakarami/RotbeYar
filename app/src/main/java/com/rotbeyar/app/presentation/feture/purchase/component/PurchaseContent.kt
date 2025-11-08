package com.rotbeyar.app.presentation.feture.purchase.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.utils.plus

@Composable
fun PurchaseDetailScreenContent(modifier: Modifier = Modifier,
                                contentPaddingValues: PaddingValues = PaddingValues(0.dp)){


    val padding = contentPaddingValues + PaddingValues(16.dp)
    LazyColumn (contentPadding = PaddingValues(vertical = 8.dp),

        modifier = modifier.padding(padding)){

       item {

           PurchasePriceDetailCard()
           Spacer(Modifier.size(24.dp)) }

        item {

            PurchaseWayCard()

           }

    }
}


