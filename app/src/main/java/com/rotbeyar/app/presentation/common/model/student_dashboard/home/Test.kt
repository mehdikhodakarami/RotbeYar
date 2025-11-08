package com.rotbeyar.app.presentation.common.model.student_dashboard.home

import androidx.compose.ui.graphics.Color
import com.rotbeyar.app.R
object SampleStudentDashboardData {

    // ============ Sample Lessons ============

    val sampleMathLesson = LessonUi(
        title = R.string.lesson_math, // "ریاضی"
        icon = R.drawable.math_icon,
        iconColor = Color(0xFF6C63FF),
        iconContainerColor = Color(0xFFE8E7FF)
    )

    val samplePhysicsLesson = LessonUi(
        title = R.string.lesson_physics, // "فیزیک"
        icon = R.drawable.physics_icon,
        iconColor = Color(0xFFFF6584),
        iconContainerColor = Color(0xFFFFE5EA)
    )

    val sampleChemistryLesson = LessonUi(
        title = R.string.lesson_chemistry, // "شیمی"
        icon = R.drawable.chemistry_icon,
        iconColor = Color(0xFF00D4AA),
        iconContainerColor = Color(0xFFCCFFF5)
    )

    val sampleBiologyLesson = LessonUi(
        title = R.string.lesson_biology, // "زیست"
        icon = R.drawable.biology_icon,
        iconColor = Color(0xFF4CAF50),
        iconContainerColor = Color(0xFFE8F5E9)
    )





    // ============ Sample Study Lessons ============

    val sampleStudyLesson1 = StudyLessonUi(
        lesson = sampleMathLesson,
        subject = "حد و پیوستگی",
        durationMinutes = 90,
        testsCount = 15,
        pageCount = 12,
        startTime = "08:00",
        endtime = "09:30",
        status = StudyPartStatusUi.DONE,
        notes = "تمرین‌های صفحه 45 تا 50 حل شد"
    )

    val sampleStudyLesson2 = StudyLessonUi(
        lesson = samplePhysicsLesson,
        subject = "دینامیک",
        durationMinutes = 60,
        testsCount = 10,
        pageCount = 8,
        startTime = "10:00",
        endtime = "11:00",
        status = StudyPartStatusUi.IN_PROGRESS,
        notes = null
    )

    val sampleStudyLesson3 = StudyLessonUi(
        lesson = sampleChemistryLesson,
        subject = "اسیدها و باز‌ها",
        durationMinutes = 45,
        testsCount = 8,
        pageCount = 6,
        startTime = "11:30",
        endtime = "12:15",
        status = StudyPartStatusUi.NOT_STARTED,
        notes = null
    )

    val sampleStudyLesson4 = StudyLessonUi(
        lesson = sampleBiologyLesson,
        subject = "ژنتیک",
        durationMinutes = 120,
        testsCount = 20,
        pageCount = 15,
        startTime = "14:00",
        endtime = "16:00",
        status = StudyPartStatusUi.MISSED,
        notes = "باید جبران شود"
    )




    // ============ Sample Daily Study Plan ============

    val sampleDailyStudyPlanEmpty = DailyStudyPlanUi(
        studyLessonList = emptyList()
    )

    val sampleDailyStudyPlanSingle = DailyStudyPlanUi(
        studyLessonList = listOf(sampleStudyLesson1)
    )

    val sampleDailyStudyPlanFull = DailyStudyPlanUi(
        studyLessonList = listOf(
            sampleStudyLesson1,
            sampleStudyLesson2,
            sampleStudyLesson3,
            sampleStudyLesson4,

        )
    )

    val sampleDailyStudyPlanShort = DailyStudyPlanUi(
        studyLessonList = listOf(
            sampleStudyLesson1,
            sampleStudyLesson2,
            sampleStudyLesson3
        )
    )

    // ============ Sample Exams ============

    val sampleExam1 = ExamUi(
        id = 1,
        title = R.string.exam_ghalamchi,
        icon = R.drawable.test_icon,
        iconColor = Color(0xFF6C63FF),
        iconContainerColor = Color(0xFFE8E7FF),
        formattedDate = "1403/08/25",
        formattedHour = "09:00",
        daysLeft = 2
    )

    val sampleExam2 = ExamUi(
        id = 2,
        title = R.string.exam_gozine2, // "آزمون فیزیک"
        icon = R.drawable.test_icon,
        iconColor = Color(0xFFFF6584),
        iconContainerColor = Color(0xFFFFE5EA),
        formattedDate = "1403/08/28",
        formattedHour = "10:30",
        daysLeft = 5
    )

    val sampleExam3 = ExamUi(
        id = 3,
        title = R.string.exam_gaj, // "آزمون شیمی"
        icon = R.drawable.test_icon,
        iconColor = Color(0xFF00D4AA),
        iconContainerColor = Color(0xFFCCFFF5),
        formattedDate = "1403/09/01",
        formattedHour = "08:30",
        daysLeft = 8
    )

    val sampleExam4 = ExamUi(
        id = 4,
        title = R.string.exam_maz, // "آزمون زیست"
        icon = R.drawable.test_icon,
        iconColor = Color(0xFF4CAF50),
        iconContainerColor = Color(0xFFE8F5E9),
        formattedDate = "1403/09/05",
        formattedHour = "14:00",
        daysLeft = 12
    )



    val sampleExamList = listOf(
        sampleExam1,
        sampleExam2,
        sampleExam3,
        sampleExam4
    )

    val sampleExamListShort = listOf(
        sampleExam1,
        sampleExam2
    )

    // ============ Sample Short Time Targets ============

    val sampleShortTimeTargetLow = ShortTimeTargetUi(
        testCountTarget = 50,
        testTargetPercentage = 25,
        studyHourTarget = 40,
        studyHourTargetPercentage = 30,
        examScoreTarget = 100,
        examScoreTargetPercentage = 20
    )

    val sampleShortTimeTargetMedium = ShortTimeTargetUi(
        testCountTarget = 100,
        testTargetPercentage = 60,
        studyHourTarget = 80,
        studyHourTargetPercentage = 55,
        examScoreTarget = 150,
        examScoreTargetPercentage = 65
    )

    val sampleShortTimeTargetHigh = ShortTimeTargetUi(
        testCountTarget = 150,
        testTargetPercentage = 85,
        studyHourTarget = 120,
        studyHourTargetPercentage = 90,
        examScoreTarget = 200,
        examScoreTargetPercentage = 95
    )

    val sampleShortTimeTargetComplete = ShortTimeTargetUi(
        testCountTarget = 200,
        testTargetPercentage = 100,
        studyHourTarget = 160,
        studyHourTargetPercentage = 100,
        examScoreTarget = 250,
        examScoreTargetPercentage = 100
    )

    val sampleShortTimeTargetZero = ShortTimeTargetUi(
        testCountTarget = 100,
        testTargetPercentage = 0,
        studyHourTarget = 80,
        studyHourTargetPercentage = 0,
        examScoreTarget = 150,
        examScoreTargetPercentage = 0
    )

    // ============ Sample Today Develop ============

    val sampleTodayDevelopLow = TodayDevelopUi(
        progress = 15,
        studyTime = "1:30",
        testCount = "5"
    )

    val sampleTodayDevelopMedium = TodayDevelopUi(
        progress = 50,
        studyTime = "4:15",
        testCount = "25"
    )

    val sampleTodayDevelopHigh = TodayDevelopUi(
        progress = 85,
        studyTime = "7:45",
        testCount = "50"
    )

    val sampleTodayDevelopComplete = TodayDevelopUi(
        progress = 100,
        studyTime = "8:00",
        testCount = "60"
    )

    val sampleTodayDevelopZero = TodayDevelopUi(
        progress = 0,
        studyTime = "0:00",
        testCount = "0"
    )

    // ============ Combined Samples ============

    // برای حالت خالی / کاربر جدید
    val emptyDashboardData = Triple(
        sampleDailyStudyPlanEmpty,
        emptyList<ExamUi>(),
        sampleTodayDevelopZero
    )

    // برای حالت شروع کار
    val beginnerDashboardData = Triple(
        sampleDailyStudyPlanShort,
        sampleExamListShort,
        sampleTodayDevelopLow
    )

    // برای حالت پیشرفت متوسط
    val mediumDashboardData = Triple(
        sampleDailyStudyPlanFull,
        sampleExamList,
        sampleTodayDevelopMedium
    )

    // برای حالت پیشرفت عالی
    val advancedDashboardData = Triple(
        sampleDailyStudyPlanFull,
        sampleExamList,
        sampleTodayDevelopHigh
    )
}