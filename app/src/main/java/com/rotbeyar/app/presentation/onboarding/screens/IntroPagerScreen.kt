package com.rotbeyar.app.presentation.onboarding.screens



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rotbeyar.app.R
import com.rotbeyar.app.presentation.common.component.StandardBoxPage
import com.rotbeyar.app.presentation.onboarding.componants.IntroScreenCardPhoto
import com.rotbeyar.app.presentation.onboarding.componants.WelcomeScreen
import com.rotbeyar.app.ui.theme.RotbeYarTheme
import com.rotbeyar.app.ui.theme.PrimaryBackgroundGradient
import kotlinx.coroutines.launch

@Composable
fun IntroPage(onSkip:()->Unit){
    val scope = rememberCoroutineScope ()
    val pagerState = rememberPagerState (pageCount = {7})
    StandardBoxPage(modifier = Modifier.background(brush = PrimaryBackgroundGradient)) {
        val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
        IntroPageContent(pagerState)
        Text(text =LocalContext.current.getText(R.string.skip).toString()
            , modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = statusBarHeight +24.dp, end = 24.dp)
                .clickable {
                    scope.launch { onSkip()}
                })


    }
    }




@Composable
fun BoxScope.IntroPageContent(pagerState: PagerState){

    val context = LocalContext.current
    val titles = context.resources.getStringArray(R.array.introduction_titles)
    val descriptions = context.resources.getStringArray(R.array.descriptions_intro)
    val imageResList = listOf(
        R.drawable.intro_1,
        R.drawable.intro_2,
        R.drawable.intro_3,
        R.drawable.intro_4,
        R.drawable.intro_5,
        R.drawable.intro_6
    )


    StandardBoxPage(modifier = Modifier){
        HorizontalPager(state = pagerState) {page->
            when(page){
                0-> WelcomeScreen()
                in 1..6-> IntroScreenCardPhoto(
                    imageResList[page - 1],
                    titles[page - 1], descriptions[page - 1]
                )
            }

        }

    }

    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center
    )
    {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(8.dp)
            )
        }


    }
}

@Preview(showBackground = true, locale = "fa")
@Composable
fun Show(){
    RotbeYarTheme { IntroPage{}
    }
    }