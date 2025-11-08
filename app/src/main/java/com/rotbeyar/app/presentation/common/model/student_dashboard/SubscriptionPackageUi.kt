package com.rotbeyar.app.presentation.common.model.student_dashboard

import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.subscription.SubscriptionType

data class SubscriptionPackageUi(
    val subscriptionType : SubscriptionType,
    val titleRes : Int = when(subscriptionType){
        SubscriptionType.BASIC -> R.string.basic_package_name
        SubscriptionType.PRO ->  R.string.pro_package_name
        SubscriptionType.VIP ->  R.string.vip_package_name
    }
    ,
    val isGoodForTitle : String = when(subscriptionType){
        SubscriptionType.BASIC -> "مناسب برای شروع"
        SubscriptionType.PRO -> "محبوب‌ ترین انتخاب"
        SubscriptionType.VIP -> "کامل‌ترین پکیج"
    }
    ,
    val price : Long = when(subscriptionType){
        SubscriptionType.BASIC -> 1500000
        SubscriptionType.PRO -> 2000000
        SubscriptionType.VIP -> 2500000
    },
    val listDescriptions : List<String> = when(subscriptionType){
        SubscriptionType.BASIC -> listOf(
            "برنامه‌ریزی هفتگی",
            "۲ جلسه مشاوره تلفنی",
            "گزارش و ارزشیابی همه‌جانبه"


        )
        SubscriptionType.PRO -> listOf(
            "تمام امکانات پکیج پایه",
            "۴ جلسه مشاوره تلفنی",
            "یک جلسه با دکتر روانشناس"


        )
        SubscriptionType.VIP -> listOf(
            "تمام امکانات پکیج حرفه ای",
            "دو جلسه با دکتر روانشناس",
            "مشاوره تلفن روزانه"


        )
    }
)
