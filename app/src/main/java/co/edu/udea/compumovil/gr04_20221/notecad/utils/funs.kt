package co.edu.udea.compumovil.gr04_20221.notacad.utils

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.graphics.Color
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.CourseEntity
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.GradeEntity

fun calculateColor(number: Double): Color {
    if (number > 4) {
        return Color.Green
    }
    if (number < 3) {
        return Color.Red
    }
    return Color.Blue
}

fun calculateColorMissingToWin(number: Double): Color {
    if (number > 4) {
        return Color.Red
    }
    if (number < 2) {
        return Color.Green
    }
    return Color.Blue
}

fun calculatePartialGrade(grades: List<GradeEntity>): Double {
    var average: Double = 0.0
    var percentage: Double = 0.0
    grades.forEach { grade ->
        average += grade.grade * (grade.percentage / 100)
        percentage += grade.percentage
    }
    average = average * 100 / percentage
    return if(percentage != 0.0) average else 5.0
}

fun calculateFinalGrade(grades: List<GradeEntity>): Double {
    var average: Double = 0.0
    grades.forEach { grade ->
        average += grade.grade * (grade.percentage / 100)
    }
    return average
}

fun countPercentage(grades: List<GradeEntity>): Double {
    var percentage: Double = 0.0
    grades.forEach { grade ->
        percentage += grade.percentage
    }
    return percentage
}

fun missingToWin(grades: List<GradeEntity>): Double {
    var average: Double = 0.0
    var percentage: Double = 0.0
    grades.forEach { grade ->
        average += grade.grade * (grade.percentage / 100)
        percentage += grade.percentage
    }
    average = 3 -average
    percentage = 100.0 - percentage
    return average*100/percentage
}

fun countCredits(courses: List<CourseEntity>): Int {
    var credits = 0
    courses.forEach { course ->
        credits+= course.credits
    }
    return credits
}

fun calculatePartialAverage(courses: List<CourseEntity>, grades: List<GradeEntity>): Double {
    var partialAverageState = 0.0
    var credits = 0
    courses.forEach { course ->
        val gradesByCourse = grades.filter { it.id_course==course.id }
        partialAverageState+=calculatePartialGrade(gradesByCourse)*course.credits
        credits+=course.credits
    }
    return if(credits!=0) partialAverageState/credits else 0.0
}

fun calculateFinalAverage(courses: List<CourseEntity>, grades: List<GradeEntity>): Double {
    var finalAverage = 0.0
    var credits = 0
    courses.forEach { course ->
        val gradesByCourse = grades.filter { it.id_course==course.id }
        finalAverage+= calculateFinalGrade(gradesByCourse) *course.credits
        credits+=course.credits
    }
    return if(credits!=0) finalAverage/credits else 0.0
}

fun colourSaver() = Saver<MutableState<Color>, String>(
    save = { state -> state.value.toHexString() },
    restore = { value -> mutableStateOf(value.toColor()) }
)

fun Color.toHexString(): String {
    return String.format(
        "#%02x%02x%02x%02x", (this.alpha * 255).toInt(),
        (this.red * 255).toInt(), (this.green * 255).toInt(), (this.blue * 255).toInt()
    )
}

fun String.toColor(): Color {
    return Color(android.graphics.Color.parseColor(this))
}