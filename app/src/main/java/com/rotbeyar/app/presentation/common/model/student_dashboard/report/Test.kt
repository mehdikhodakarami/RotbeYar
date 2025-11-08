package com.rotbeyar.app.presentation.common.model.student_dashboard.report

import androidx.compose.ui.graphics.Color
import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.AppGrgDateTime
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ExamUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.LessonUi

object SampleResultReportData {




    // ====================== Sample Lessons ======================
    val lessonMath = LessonUi(
        title = R.string.lesson_math,
        icon = R.drawable.math_icon,
        iconColor = Color(0xFF6C63FF),
        iconContainerColor = Color(0xFFE8E7FF)
    )

    val lessonPhysics = LessonUi(
        title = R.string.lesson_physics,
        icon = R.drawable.physics_icon,
        iconColor = Color(0xFFFF6584),
        iconContainerColor = Color(0xFFFFE5EA)
    )

    val lessonBiology = LessonUi(
        title = R.string.lesson_biology,
        icon = R.drawable.biology_icon,
        iconColor = Color(0xFF4CAF50),
        iconContainerColor = Color(0xFFE8F5E9)
    )

    val lessonChemistry = LessonUi(
        title = R.string.lesson_chemistry,
        icon = R.drawable.chemistry_icon,
        iconColor = Color(0xFF00A4FF),
        iconContainerColor = Color(0xFFE1F5FF)
    )


    // ====================== Lesson Develop Samples ======================
    val developMath = LessonDevelopUi(
        lesson = lessonMath,
        developStatus = EvaluationTypeUi.STRENGTH,
        developPercentage = 75
    )

    val developPhysics = LessonDevelopUi(
        lesson = lessonPhysics,
        developStatus = EvaluationTypeUi.ACCEPTABLE,
        developPercentage = 45
    )

    val developBiology = LessonDevelopUi(
        lesson = lessonBiology,
        developStatus = EvaluationTypeUi.NEEDS_IMPROVEMENT,
        developPercentage = 22
    )

    val developChemistry = LessonDevelopUi(
        lesson = lessonChemistry,
        developStatus = EvaluationTypeUi.WEAKNESS,
        developPercentage = 10
    )


    // ====================== Lesson Result in Exam ======================
    val mathResult = LessonResultExamUi(
        lessonDevelopUi = developMath,
        scorePercentage = 92
    )

    val physicsResult = LessonResultExamUi(
        lessonDevelopUi = developPhysics,
        scorePercentage = 67
    )

    val biologyResult = LessonResultExamUi(
        lessonDevelopUi = developBiology,
        scorePercentage = 54
    )

    val chemistryResult = LessonResultExamUi(
        lessonDevelopUi = developChemistry,
        scorePercentage = 40
    )

    val lessonResultsList = listOf(
        mathResult,
        physicsResult,
        biologyResult,
        chemistryResult
    )


    // ====================== Exam Result ======================
    val sampleExam = ExamUi(
        id = 1,
        title = R.string.exam_ghalamchi,
        icon = R.drawable.test_icon,
        iconColor = Color(0xFF6C63FF),
        iconContainerColor = Color(0xFFE8E7FF),
        formattedDate = "1403/09/15",
        formattedHour = "09:00",
        daysLeft = 3
    )

    val sampleExamResult1 = ExamResultUi(
        exam = sampleExam,
        date = AppGrgDateTime(1403, 9, 15),
        totalScore = 7150,
        lessonResultExams = lessonResultsList
    )
    val sampleExamResult2 = ExamResultUi(
        exam = sampleExam,
        date = AppGrgDateTime(1403, 10, 15),
        totalScore = 6200,
        lessonResultExams = lessonResultsList
    )
    val sampleExamResult3 = ExamResultUi(
        exam = sampleExam,
        date = AppGrgDateTime(1403, 12, 15),
        totalScore = 6000,
        lessonResultExams = lessonResultsList
    )
    val sampleExamResult4 = ExamResultUi(
        exam = sampleExam,
        date = AppGrgDateTime(1404, 1, 15),
        totalScore = 7500,
        lessonResultExams = lessonResultsList
    )
    val sampleExamResult5 = ExamResultUi(
        exam = sampleExam,
        date = AppGrgDateTime(1404, 2, 15),
        totalScore = 5900,
        lessonResultExams = lessonResultsList
    )


    // ====================== Detailed Report For One Lesson ======================
    val detailedBiologyReport = DetailedLessonReportUi(
        lessonResultExam = biologyResult,
        strengths = listOf(
            "تسلط روی مفاهیم فصل اول",
            "بهبود در تست‌های شمارشی"
        ),
        needToImprove = listOf(
            "مطالعه‌ی بیشتر فصل ژنتیک",
            "تمرکز روی زمان‌بندی حل تست"
        ),
        description = "پیشرفت قابل قبوله، ولی نیاز به تمرین زمان‌دار بیشتر وجود دارد."
    )

    val detailedMathReport = DetailedLessonReportUi(
        lessonResultExam = SampleResultReportData.mathResult,
        strengths = listOf(
            "تسلط روی مفاهیم حد و پیوستگی",
            "توانایی حل سریع تست‌های تمرینی"
        ),
        needToImprove = listOf(
            "تمرین بیشتر مسائل چالش‌برانگیز",
            "تمرکز روی تست‌های زمان‌دار"
        ),
        description = "پیشرفت خوب است، ولی نیاز به تمرین تست زمان‌دار دارد."
    )

    val detailedPhysicsReport = DetailedLessonReportUi(
        lessonResultExam = SampleResultReportData.physicsResult,
        strengths = listOf(
            "تسلط بر مفاهیم دینامیک",
            "درک بالا در مسائل حرکت شناسی"
        ),
        needToImprove = listOf(
            "تمرین بیشتر مسائل مقاومتی",
            "بهبود سرعت حل تست"
        ),
        description = "پیشرفت متوسط است، باید تمرین بیشتری انجام شود."
    )



    val detailedChemistryReport = DetailedLessonReportUi(
        lessonResultExam = SampleResultReportData.chemistryResult,
        strengths = listOf(
            "تسلط روی واکنش‌های شیمیایی پایه",
            "درک خوب از اسید و بازها"
        ),
        needToImprove = listOf(
            "تمرین مسائل استوکیومتری",
            "تمرکز روی حل تست‌های زمان‌بندی شده"
        ),
        description = "نیاز به تمرین بیشتر در حل تست‌های ترکیبی دارد."
    )



    // ====================== Overall Develop ======================
    val sampleOverallDevelop = OverallDevelopUi(
        developPercentage = 58,
        studyHoursTime = "320",
        testCountInLastWeek = "140",
        quizCount = "8"
    )


    // ====================== Study Progress in a Day ======================
    val sampleStudyInDay = StudyInDayUi(
        lessonsProgress = mapOf(
            lessonMath to 2,
            lessonPhysics to 2,
            lessonBiology to 2,
            lessonChemistry to 3
        )
    )


}