package com.rotbeyar.app.domain.mapper

import com.rotbeyar.app.R
import com.rotbeyar.app.domain.model.DailyStudyPlan
import com.rotbeyar.app.domain.model.DetailedLessonReport
import com.rotbeyar.app.domain.model.EvaluationType
import com.rotbeyar.app.domain.model.Exam
import com.rotbeyar.app.domain.model.ExamResult
import com.rotbeyar.app.domain.model.ExamType
import com.rotbeyar.app.domain.model.Lesson
import com.rotbeyar.app.domain.model.LessonDevelop
import com.rotbeyar.app.domain.model.LessonResultExam
import com.rotbeyar.app.domain.model.OverallDevelop
import com.rotbeyar.app.domain.model.ShortTimeTarget
import com.rotbeyar.app.domain.model.StudyInDay
import com.rotbeyar.app.domain.model.StudyLesson
import com.rotbeyar.app.domain.model.StudyMethod
import com.rotbeyar.app.domain.model.StudyPartStatus
import com.rotbeyar.app.domain.model.TodayDevelop
import com.rotbeyar.app.domain.model.grgToPersianDate
import com.rotbeyar.app.domain.model.user.EducationMajor
import com.rotbeyar.app.presentation.common.model.EducationMajorUi
import com.rotbeyar.app.presentation.common.model.StudyMethodUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.DailyStudyPlanUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ExamUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.LessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.ShortTimeTargetUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyLessonUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.StudyPartStatusUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.home.TodayDevelopUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.DetailedLessonReportUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.EvaluationTypeUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.ExamResultUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.LessonDevelopUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.LessonResultExamUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.OverallDevelopUi
import com.rotbeyar.app.presentation.common.model.student_dashboard.report.StudyInDayUi
import com.rotbeyar.app.ui.theme.PrimaryBlue
import com.rotbeyar.app.ui.theme.PrimaryBlueContainer
import com.rotbeyar.app.ui.theme.PrimaryError
import com.rotbeyar.app.ui.theme.PrimaryErrorContainer
import com.rotbeyar.app.ui.theme.PrimaryGreen
import com.rotbeyar.app.ui.theme.PrimaryGreenContainer
import com.rotbeyar.app.ui.theme.PrimaryPurple
import com.rotbeyar.app.ui.theme.PrimaryPurpleContainer
import com.rotbeyar.app.ui.theme.PrimaryWhite
import com.rotbeyar.app.utils.clockFromSec
import java.time.LocalDate
import java.time.format.DateTimeFormatter


fun ShortTimeTarget.toUi() = ShortTimeTargetUi(
    testCountTarget = this.testCountTarget,
    studyHourTarget = this.studyHourTarget,
    examScoreTarget = this.scoreTarget,
    testTargetPercentage = this.testTargetPercentage,
    studyHourTargetPercentage = this.studyHourTargetPercentage,
    examScoreTargetPercentage = this.scoreTargetPercentage
)
fun TodayDevelop.toUi() = TodayDevelopUi(
    progress = this.developPercentage,
    studyTime = clockFromSec(this.studyMinuteTime*60).substring(0,4),
    testCount = this.testCount.toString()
)
fun StudyLesson.toUi() = StudyLessonUi(
    lesson = this.lesson.toUi(),
    subject = this.subject,
    durationMinutes = this.durationSeconds,
    testsCount = this.tests,
    pageCount = this.pageCount,
    startTime = this.studyPart.startTime,
    endtime =this.studyPart.endTime,
    status = when(this.status) {
        StudyPartStatus.NOT_STARTED -> StudyPartStatusUi.NOT_STARTED
        StudyPartStatus.MISSED -> StudyPartStatusUi.MISSED
        StudyPartStatus.IN_PROGRESS -> StudyPartStatusUi.IN_PROGRESS
        StudyPartStatus.DONE -> StudyPartStatusUi.DONE
    },
    notes = this.notes)
fun DailyStudyPlan.toUi() = DailyStudyPlanUi(
 this.lessonsInDayPlan.map { it.toUi() }
)

fun Lesson.toUi() = when(this) {
    Lesson.BIOLOGY -> LessonUi(
        R.string.lesson_biology,
        R.drawable.biology_icon,
        PrimaryPurple,
        PrimaryPurpleContainer


    )
    Lesson.CHEMISTRY -> LessonUi(
        R.string.lesson_chemistry,
        R.drawable.chemistry_icon,
        PrimaryGreen,
        PrimaryGreenContainer
    )
    Lesson.PHYSICS -> LessonUi(
        R.string.lesson_physics,
        R.drawable.physics_icon,
        PrimaryPurple,
        PrimaryPurpleContainer
    )
    Lesson.MATH -> LessonUi(
        R.string.lesson_math,
        R.drawable.math_icon,
        PrimaryError,
        PrimaryWhite
    )
}
fun Exam.toUi(currentDate: LocalDate = LocalDate.now()): ExamUi {
    val titleRes = when(exam) {
        ExamType.GHALAMCHI -> R.string.exam_ghalamchi
        ExamType.MAZ -> R.string.exam_maz
        ExamType.GOZINEH_2 -> R.string.exam_gozine2
        ExamType.GAJ -> R.string.exam_gaj
    }
    val examPersianDate  =examDateWithHours.grgToPersianDate()

    val formattedDate = "${examPersianDate.dayName()} " +
            "${examPersianDate.shDay} ${examPersianDate.monthName()} "

    val formattedHour = examDateWithHours.format(DateTimeFormatter.ofPattern("HH:mm"))
    val iconColor= when(exam) {
        ExamType.GAJ ->( PrimaryError to PrimaryErrorContainer)
        ExamType.GHALAMCHI -> (PrimaryGreen to PrimaryGreenContainer)
        ExamType.MAZ -> (PrimaryPurple to PrimaryPurpleContainer)
        ExamType.GOZINEH_2 -> (PrimaryBlue to PrimaryBlueContainer)
    }


    return ExamUi(
        id = this.id,
        title = titleRes,
        formattedDate = formattedDate,
        formattedHour = formattedHour,

        daysLeft = daysLeft,
        icon = R.drawable.test_icon,
        iconColor = iconColor.first,
        iconContainerColor = iconColor.second
    )
}






// -----------------------Report to Ui Mappers -----------------------


fun OverallDevelop.toUi() = OverallDevelopUi(
    developPercentage = this.developPercentage,
    studyHoursTime = clockFromSec(this.studyMinuteTime*60).substring(0,4),
    testCountInLastWeek = this.testCountInLastWeek.toString(),
    quizCount = this.quizCount.toString()
)


fun StudyInDay.toUi() = StudyInDayUi(
    lessonsProgress = this.lessonsProgress.mapKeys { it.key.toUi() }.toMap()
)

fun EvaluationType.toUi(): EvaluationTypeUi {
    return when (this) {
        EvaluationType.STRENGTH -> EvaluationTypeUi.STRENGTH
        EvaluationType.ACCEPTABLE -> EvaluationTypeUi.ACCEPTABLE
        EvaluationType.NEEDS_IMPROVEMENT -> EvaluationTypeUi.NEEDS_IMPROVEMENT
        EvaluationType.WEAKNESS -> EvaluationTypeUi.WEAKNESS
    }
}

fun LessonDevelop.toUi() = LessonDevelopUi(
    lesson = this.lesson.toUi(),
    developStatus = this.developStatus.toUi(),
    developPercentage = this.developPercentage
)
fun LessonResultExam.toUi() = LessonResultExamUi(
    lessonDevelopUi = this.lessonDevelop.toUi(),
    scorePercentage = this.scorePercentage
)

fun ExamResult.toUi() = ExamResultUi(
    exam = this.exam.toUi(),
    date = this.date,
    totalScore = this.totalScore,
    lessonResultExams = this.lessonResultExams.map { it.toUi() }
)

fun DetailedLessonReport.toUi() = DetailedLessonReportUi(
    lessonResultExam = this.lessonResultExam.toUi(),
    strengths = this.strengths,
    needToImprove = this.needToImprove,
    description = this.description

)
fun EducationMajor.toUi()  : EducationMajorUi=
    when(this){
        EducationMajor.NATURAL_SCIENCE -> EducationMajorUi.NATURAL_SCIENCE
        EducationMajor.MATHEMATICS -> EducationMajorUi.MATHEMATICS
    }


fun StudyMethod.toUi() : StudyMethodUi =
    when(this){
        StudyMethod.SCHOOL -> StudyMethodUi.SCHOOL
        StudyMethod.ONLINE_SCHOOL -> StudyMethodUi.ONLINE_SCHOOL
        StudyMethod.SELF_STUDY -> StudyMethodUi.SELF_STUDY
    }