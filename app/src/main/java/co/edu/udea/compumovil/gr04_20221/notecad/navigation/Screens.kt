package co.edu.udea.compumovil.gr04_20221.notecad.navigation


sealed class Screen(val route: String) {
    object COURSES : Screen("COURSES")
    object FORM_COURSE : Screen("FORM_COURSE")
    object DETAILS_COURSE : Screen("DETAILS_COURSE")
    object FORM_GRADE : Screen("FORM_GRADE")
    object FORM_GRADE_CALCULATE : Screen("FORM_GRADE_CALCULATE")
    object DETAILS_COURSE_CALCULATE : Screen("DETAILS_COURSE_CALCULATE")
    object MENU : Screen("MENU")
    object MAP : Screen("MAP")
    object SCHEDULE : Screen("SCHEDULE")
    object FORM_SCHEDULE : Screen("FORM_SCHEDULE")
}