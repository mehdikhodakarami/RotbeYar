package com.rotbeyar.app.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.ui.theme.PrimaryGray
import com.rotbeyar.app.ui.theme.RotbeYarTheme

@Composable
fun RotbeYarTextField(
    value: String="",
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String = "",
    enabled: Boolean = true,
    isError: Boolean = false,
    supportingText: String? = null,
    leadingIcon: ImageVector? = null,
    shape: Shape = RoundedCornerShape(8.dp),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Text
    )
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        isError = isError,
        label = { RotbeYarText(text = label,modifier= Modifier.background(Color.Transparent)) },
        placeholder = { if (placeholder.isNotEmpty())RotbeYarText(text = placeholder, color = PrimaryGray.copy(alpha = ContentAlpha.medium)) },
        supportingText = {
            if (supportingText != null) {
              RotbeYarText(supportingText)
            }
        },
        singleLine = true,
        shape = shape,
        leadingIcon = leadingIcon?.let {
            {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = if (enabled)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                )
            }
        },
        keyboardOptions = keyboardOptions,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
            disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),

            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,

            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = Color.LightGray,
            disabledBorderColor = Color.LightGray.copy(alpha = 0.3f),

            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            disabledLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),

            focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
            disabledLeadingIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),

            disabledPlaceholderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
        )
    )
}



@Composable
fun RotbeYarCodeInput(
    code: String,
    onCodeChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    length: Int = 4,
    isError: Boolean = false,
    onFilled: (() -> Unit)? = null,
) {
    val focusRequesters = remember { List(length) { FocusRequester() } }
    val localFocusManager = LocalFocusManager.current

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.background(Color.Transparent)
    ) {
        repeat(length) { index ->
            val char = code.getOrNull(index)?.toString() ?: ""
            OutlinedTextField(
                value = char,
                onValueChange = { newChar ->
                    if (newChar.length <= 1 && newChar.all { it.isDigit() }) {
                        val newCode = buildString {
                            append(code.take(index))
                            append(newChar)
                            append(code.drop(index + 1))
                        }.take(length)

                        onCodeChange(newCode)

                        if (newChar.isNotEmpty()) {
                            if (index < length - 1) {
                                focusRequesters[index + 1].requestFocus()
                            } else {
                                localFocusManager.clearFocus()
                                if (newCode.length == length) {
                                    onFilled?.invoke()
                                }
                            }
                        }
                    }
                },
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .focusRequester(focusRequesters[index])
                    .border(
                        width = 0.5f.dp,
                        color = if (isError) MaterialTheme.colorScheme.error else Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    disabledBorderColor = Color.LightGray,
                    errorBorderColor = MaterialTheme.colorScheme.error
                )
            )
        }
    }

}
@Composable
fun CodeInput (onCodeChange: (String) -> Unit,
               modifier: Modifier = Modifier,isError: Boolean,
               onFilled: (() -> Unit)? = null,
               length: Int,
               code: String,
               focusRequesters: List<FocusRequester>){
    val focusRequesters = remember { List(length){ FocusRequester() } }
    val localFocusManager = LocalFocusManager.current

    Row(horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.background(Color.Transparent)){
        repeat(length){ index ->
            val char = code.getOrNull(index)?.toString() ?: ""
            OutlinedTextField(
                value = char,
                onValueChange = {newChar ->
                    if(newChar.length <= 1 && newChar.all { it.isDigit() }){
                        val newCode = buildString {
                            append(code.take(index))
                            append(newChar)
                            append(newChar.drop(index+1))
                        }
                        onCodeChange?.invoke(newCode)
                        if(newChar.isNotEmpty()){
                            if(index < length-1){
                                focusRequesters[index+1].requestFocus()
                            }else{
                                localFocusManager.clearFocus()
                                if(newCode.length == length){
                                    onFilled?.invoke()
                                }
                            }
                        }
                    }

                }
            )


}


    }}




@Preview(showBackground = true, locale = "fa")
@Composable
fun MyBigComposablePreview() {
    RotbeYarTheme {
val code = remember { mutableStateOf("") }
        Box(modifier = Modifier.fillMaxSize()){
            RotbeYarCodeInput(
                code = code.value,
                onCodeChange = { code.value = it },
                modifier = Modifier.align(Alignment.Center)
            )
        }
            }
}
