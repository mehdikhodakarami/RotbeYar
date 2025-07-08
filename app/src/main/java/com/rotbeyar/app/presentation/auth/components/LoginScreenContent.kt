package com.rotbeyar.app.presentation.auth.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.RotbeYarCardIconContainer
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.RotbeYarTextField
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.RotbeYarTheme

@Composable
fun LoginScreenContent(modifier: Modifier){
    Box(modifier = modifier.fillMaxWidth()) {
        Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            RotbeYarCardIconContainer(imageResVector =  R.drawable.logo_empty,
                size = 80.dp)
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = stringResource(R.string.title_login), fontSize = 24.sp,
                fontWeight = FontWeight.Bold )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = stringResource(R.string.hint_enter_phone), fontSize = 14.sp, color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Normal )
            Spacer(Modifier.size(48.dp))
            RotbeYarTextField(label = stringResource(R.string.label_phone_number).toString(),
                leadingIcon = Icons.Outlined.Phone ,
                onValueChange = {})
            Spacer(Modifier.size(16.dp))
            RotbeYarButton(text = stringResource(R.string.btn_continue), onClick = {}, backgroundColor = PrimaryPurple,
                modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold, fontSize = 16.sp)

        }


    }
}

@Preview(showBackground = true, locale = "fa")
@Composable
fun show(){
    RotbeYarTheme {
LoginScreenContent(Modifier)
    }
}