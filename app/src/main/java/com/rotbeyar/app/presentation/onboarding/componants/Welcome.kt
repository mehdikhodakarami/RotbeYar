package com.rotbeyar.app.presentation.onboarding.componants

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.RotbeYarCard
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.ui.theme.AppStyle
import com.rotbeyar.app.ui.theme.AppTheme
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.RotbeYarTheme
import com.rotbeyar.app.ui.theme.cardElevationApp

@Composable
fun WelcomeScreen(){
val context = LocalContext.current

        Column(modifier = Modifier) {
            RotbeYarCard (
                modifier = Modifier.padding(start = 24.dp).align(Alignment.Start).size(96.dp),
                onClick = {},
                shape = CircleShape,
                elevation = cardElevationApp,

            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_empty),
                    contentDescription = "Logo",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .fillMaxSize()
                )



            }
            Spacer(Modifier.height(24.dp))
            Text(text = context.getText(R.string.welcome_to_rotbe_yar).toString(), fontSize = 30.sp,
                fontWeight = FontWeight.Bold,  modifier = Modifier.align (Alignment.CenterHorizontally))
            Spacer(Modifier.size(8.dp))
            Text(

                text = context.getText(R.string.smart_assistant_for_success).toString(),
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)


                )
            Spacer(Modifier.size(32.dp))

            CardIntroWithNum(modifier = Modifier.align(Alignment.CenterHorizontally))

            }
        }





@Composable
private fun IntroBoxWelcome(target: Int, pastText: String, color: Color, secondDec : String ){
Column(horizontalAlignment = Alignment.CenterHorizontally) {
AnimatedPercentage(target,color,pastText)
    Text(
        text = secondDec,
        fontSize = 12.sp,
    )
}
}

@Composable
fun CardIntroWithNum(modifier: Modifier){
    val context = LocalContext.current
    Card (
        modifier = modifier.fillMaxWidth().padding(horizontal = 24.dp),
        shape = RoundedCornerShape(AppStyle.CornerLarge) ,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = cardElevationApp)
    ) {
        Row(
                    modifier = Modifier.padding(24.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly


        ) {
                    repeat(3){it->
                        when(it){
                            0 ->IntroBoxWelcome(50,"K+", PrimaryPurple,
                                context.getText(R.string.successful_student).toString()
                            )


                            1 ->
                                IntroBoxWelcome(98,"٪", PrimaryGreen,
                                    context.getText(R.string.user_satisfaction).toString()
                                )
                            2->

                                IntroBoxWelcome(24,"/7", PrimaryPurple,
                                    context.getText(R.string.support).toString()
                                )
                            else -> throw Error("error")
                        }
                    }


        }

        }}

@Composable
fun AnimatedPercentage(
    targetValue: Int,
    color: Color,
    pastText: String
) {
    var currentTarget by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        currentTarget = targetValue
    }

    val animatedValue by animateIntAsState(
        targetValue = currentTarget,
        animationSpec = tween(durationMillis = 1500),
        label = "percentage"
    )

    Text(
        text = "$animatedValue$pastText",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = color
    )
}


@Preview(showBackground = true, locale = "fa")
@Composable
fun showPre(){
    AppTheme{
        WelcomeScreen()

    }
}