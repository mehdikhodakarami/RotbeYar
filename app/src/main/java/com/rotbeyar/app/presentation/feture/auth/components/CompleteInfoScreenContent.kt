package com.rotbeyar.app.presentation.feture.auth.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.RotbeYarCardIconContainer
import com.rotbeyar.app.presentation.common.component.RotbeYarButton
import com.rotbeyar.app.presentation.common.component.RotbeYarCard
import com.rotbeyar.app.presentation.common.component.RotbeYarTextField
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryError

@Composable
fun CompleteInfoScreenContent(
    errorMessage : String = "",
    isLoading : Boolean = false,
    name : String = "",
    lastName :String = "",
    onNameChanged : (String)->Unit  = {},
    onLastNameChanged:(String)->Unit = {},
    onCompleteButtonClick : () ->Unit={},
    modifier: Modifier = Modifier

) {
    Column(
        modifier = modifier, horizontalAlignment =
            Alignment.CenterHorizontally
    ) {
        RotbeYarCardIconContainer(
            iconSize = 32.dp,
            imageResVector = R.drawable.person_icon, containerSize = 64.dp
        )
        Text(
            fontWeight = FontWeight.Bold,
            text = stringResource(R.string.complete_information),
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(fontSize = 14.sp,
            text = stringResource(R.string.please_insert_first_name_and_last_name),
            modifier = Modifier.padding(top = 8.dp)
        )
        Spacer(Modifier.size(32.dp))
        RotbeYarTextField(
            isError = errorMessage.isNotEmpty(),
            value = name,
            label = stringResource(R.string.name),
            placeholder = stringResource(R.string.insert_your_name),
            onValueChange = onNameChanged,
            leadingIcon = Icons.Outlined.Person,
            modifier = Modifier.padding(bottom = 0.dp)
        )
        Spacer(Modifier.size(8.dp))

        RotbeYarTextField(
            value = lastName,
            isError = errorMessage.isNotEmpty(),
            label = stringResource(R.string.last_name),
            placeholder = stringResource(R.string.insert_your_last_name),
            onValueChange = onLastNameChanged,
            leadingIcon = Icons.Outlined.Person
        )
        Spacer(Modifier.size(4.dp))

        errorMessage.takeIf { it.isNotEmpty() }.let { errorMessage ->
            if (errorMessage != null) {
                Text(fontSize = 14.sp,
                    modifier = Modifier.
                    align(Alignment.Start).padding(start = 12.dp),
                    text = errorMessage,
                    color = PrimaryError
                )
            }

        }
        Spacer(Modifier.size(16.dp))
        RotbeYarButton(
            loading = isLoading,
            fontWeight = FontWeight.Bold,
            text = stringResource(R.string.complete_sign_up),
            onClick = onCompleteButtonClick,
            modifier = Modifier.fillMaxWidth()

        )
        Spacer(Modifier.size(24.dp))
        RotbeYarCard(elevation = 4.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = stringResource(R.string.welcome),
                fontWeight = FontWeight.Bold )
            Spacer(Modifier.size(8.dp))
            Text(textAlign = TextAlign.Center,text = stringResource(R.string.after_sign_up_navigate), fontSize = 14.sp)
        }
        }




        }

    }




