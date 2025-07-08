package com.rotbeyar.app.presentation.auth.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.rotbeyar.app.presentation.common.component.RotbeYarCodeInput
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.GrayTextColor
import com.rotbeyar.app.ui.theme.PrimaryPurple

@Composable
fun VerifyScreenContent(time:Int,codeInput: String = "", onCodeInputChange: (String) -> Unit = {}
){
    Box(modifier = Modifier.fillMaxWidth()) {
        Column (modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally){
            RotbeYarCardIconContainer(imageResVector = R.drawable.icon_mobile,
                size = 64.dp)
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = stringResource(R.string.verify_phone_number), fontSize = 20.sp,
                fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterHorizontally) )
            Spacer(modifier = Modifier.size(75.dp))
            Text(text = stringResource(R.string.insert_verify_code), fontSize = 14.sp, color = GrayTextColor,
                fontWeight = FontWeight.Normal, modifier = Modifier.align(Alignment.CenterHorizontally) )
            Spacer(Modifier.size(12.dp))
            RotbeYarCodeInput(code = codeInput, onCodeChange = onCodeInputChange,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(Modifier.size(24.dp))
            RotbeYarButton(text = stringResource(R.string.verify_code), onClick = {}, backgroundColor = PrimaryPurple,
                modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Row (modifier = Modifier.padding(top = 24.dp))
            {

                if(time>0){
                    Text(text = stringResource(R.string.send_code_again), fontSize = 14.sp, color = PrimaryPurple,)
                }else
                    Text(text = stringResource(R.string.send_code_again_now), fontSize = 14.sp, color =
                        MaterialTheme.colorScheme.primary)


            }

        }


    }

}

@Preview(showBackground = true, locale = "fa")
@Composable
fun show1(){
    AppTheme{    VerifyScreenContent(time=0)
    }

}