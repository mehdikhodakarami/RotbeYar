package com.rotbeyar.app.presentation.feture.student_dashboard.home.states

import com.rotbeyar.app.domain.model.StudyPart
import saman.zamani.persiandate.PersianDate

data class HomeTopBarState(val fullName : String = "",
                           val persianDate: PersianDate = PersianDate(),
                          val imageUrl: String,
    val secondsDuration :  Int = 5400,
    val testCount:Int = 50,
    val pageCount :Int = 25,
    val studyPart: StudyPart = StudyPart.PART_1

                           )

