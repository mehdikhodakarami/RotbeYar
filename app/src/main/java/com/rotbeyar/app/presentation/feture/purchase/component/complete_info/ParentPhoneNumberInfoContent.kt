package com.rotbeyar.app.presentation.feture.purchase.component.complete_info



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.RotbeYarCardIconContainer
import com.rotbeyar.app.presentation.common.component.RotbeYarTextField
import com.rotbeyar.app.ui.theme.PrimaryBlue
import com.rotbeyar.app.ui.theme.PrimaryBlueContainer
import com.rotbeyar.app.ui.theme.PrimaryError


@Composable
fun ParentPhoneNumberInfoContent(modifier: Modifier =  Modifier,
errorMessage : String = "",
                                 fatherPhoneNumber : String = "",
                                 motherPhoneNumber : String = "",
fatherFirstName : String = "",
                                 motherFirstName : String = "",
                                 onFatherPhoneNumberChange : (String)-> Unit = {},
                                 onMotherPhoneNumberChange : (String)-> Unit = {},
                                 onFatherFirstNameChange : (String)-> Unit = {},
                                 onMotherFirstNameChange : (String)-> Unit = {}

){
    Column(modifier = modifier){
Surface(shape = RoundedCornerShape(14.dp),
    color = PrimaryBlueContainer,
    modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)){
    Row(Modifier.padding(24.dp), verticalAlignment = Alignment.CenterVertically) {
        RotbeYarCardIconContainer(imageResVector = R.drawable.info_icon,
            iconSize = 20.dp,
            containerSize = 20.dp,
            iconTint = PrimaryBlue,
            cardColor = CardDefaults.cardColors(containerColor = PrimaryBlueContainer),
        )
        Spacer(Modifier.size(12.dp))
        Text(text ="وارد کردن حداقل یک شماره تماس از والدین برای فعال شدن پنل والدین الزامی است" ,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = PrimaryBlue)

    }

}
        Spacer(Modifier.size(32.dp))

        repeat(2){
            Column {
                RotbeYarTextField(
                    value = when(it){
                        0->fatherPhoneNumber
                        1->motherPhoneNumber
                        else -> ""
                    },
                    shape = RoundedCornerShape(24.dp),


                    leadingIcon = ImageVector.vectorResource(R.drawable.icon_mobile),
                    label = stringResource(when(it){

                        0->R.string.father_phone_number
                        1->R.string.mother_phone_number
                        else->TODO()

                    }),

                    onValueChange = {phoneNumber->
                        when(it){
                            0->onFatherPhoneNumberChange(phoneNumber)
                            1->onMotherPhoneNumberChange(phoneNumber)
                        }

                    }
                )
                Spacer(Modifier.size(12.dp))

                RotbeYarTextField(value = when(it){
                    0->fatherFirstName
                    1->motherFirstName
                    else->""
                },
                    shape = RoundedCornerShape(24.dp),


                    leadingIcon = ImageVector.vectorResource(when(it){
                        0->R.drawable.man_icon
                        1->R.drawable.woman_icon
                        else -> TODO()
                    }),
                    label = stringResource(when(it){

                        0->R.string.father_first_name
                        1->R.string.mother_first_name
                        else->TODO()

                    }),

                    onValueChange = {name->
                        when(it){
                            0->onFatherFirstNameChange(name)
                            1->onMotherFirstNameChange(name)
                        }

                    }
                )
            }

            Spacer(Modifier.size(16.dp))





        }
        Spacer(Modifier.size(8.dp))
        if(errorMessage.isNotEmpty()){
            Text(modifier = Modifier.align(Alignment.CenterHorizontally),text = errorMessage, fontSize = 14.sp,
                color = PrimaryError)
        }

    }

}


