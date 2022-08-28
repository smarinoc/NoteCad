package co.edu.udea.compumovil.gr04_20221.notecad.navigation


sealed class Screen(val route: String) {
    object COURSES : Screen("COURSES")
    object FORM_COURSE : Screen("FORM_COURSE")
    object DETAILS_COURSE : Screen("DETAILS_COURSE")
    object FORM_GRADE : Screen("FORM_GRADE")
    object MENU : Screen("MENU")
}