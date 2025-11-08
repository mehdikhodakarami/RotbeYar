package com.rotbeyar.app.presentation.feture.auth.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.RotbeYarCardIconContainer
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.RotbeYarTextField
import com.rotbeyar.app.ui.theme.RotbeYarTheme

@Composable
fun LoginScreenContent(
    loading: Boolean = false,
    modifier: Modifier,
    isError: Boolean = false,
    errorMessage: String? = "",
    onPhoneChange: (String) -> Unit = {},
    onSendButton: () -> Unit ={},
    phoneNumber: String = ""){
    Box(modifier = modifier.fillMaxWidth()) {
        Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            RotbeYarCardIconContainer(
iconSize = 48.dp,
                imageResVector =  R.drawable.main_icon,
                containerSize = 80.dp)
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = stringResource(R.string.title_login), fontSize = 24.sp,
                fontWeight = FontWeight.Bold )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = stringResource(R.string.hint_enter_phone), fontSize = 14.sp, color =
                MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Normal )
            Spacer(Modifier.size(48.dp))
            RotbeYarTextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                label = stringResource(R.string.label_phone_number).toString(),
                leadingIcon = Icons.Outlined.Phone ,
isError = isError,
                value = phoneNumber,
                supportingText = errorMessage,
                onValueChange = onPhoneChange)
            Spacer(Modifier.size(16.dp))
            RotbeYarButton(text = stringResource(R.string.btn_continue),
        loading = loading,
                onClick = onSendButton,
                backgroundColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold, fontSize = 16.sp)

        }


    }
}

