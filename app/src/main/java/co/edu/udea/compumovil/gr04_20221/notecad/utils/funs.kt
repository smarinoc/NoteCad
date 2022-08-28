package co.edu.udea.compumovil.gr04_20221.notacad.utils

import androidx.compose.ui.graphics.Color
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

fun calculatePartialGrade(grades: List<GradeEntity>): Double {
    var average: Double = 0.0
    var percentage: Double = 0.0
    grades.forEach { grade ->
        average += grade.grade * (grade.percentage / 100)
        percentage += grade.percentage
    }
    average = average * 100 / percentage
    return if(percentage != 0.0) average else 0.0
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
    return average
}