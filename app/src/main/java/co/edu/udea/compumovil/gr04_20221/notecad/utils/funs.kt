package co.edu.udea.compumovil.gr04_20221.notacad.utils

import androidx.compose.ui.graphics.Color

fun calculateColor(grade: Double): Color {
    if(grade>4){
        return Color.Green
    }
    if(grade<3){
        return Color.Red
    }
    return Color.Blue
}