package co.edu.udea.compumovil.gr04_20221.notecad.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.udea.compumovil.gr04_20221.notacad.ui.FormCourse
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Course.Courses
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Course.Grades
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Grade.FormGrade
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Menu

@Composable
fun NavGraph(title: MutableState<String>, navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.MENU.route) {
        composable(Screen.COURSES.route) { Courses(navController, title) }
        composable(Screen.FORM_COURSE.route) { FormCourse(navController, title) }
        composable(Screen.GRADES.route) { Grades(navController, title) }
        composable(Screen.FORM_GRADE.route) { FormGrade(navController, title) }
        composable(Screen.MENU.route) { Menu(navController, title) }
    }
}