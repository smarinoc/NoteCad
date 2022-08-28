package co.edu.udea.compumovil.gr04_20221.notecad.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Course.FormCourse
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Course.Courses
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Course.DetailsCourse
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Grade.FormGrade
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Menu

@Composable
fun NavGraph(title: MutableState<String>, navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.MENU.route) {
        composable(Screen.COURSES.route) { Courses(navController, title) }
        composable(Screen.FORM_COURSE.route) { FormCourse(navController, title) }
        composable(Screen.MENU.route) { Menu(navController, title) }
        composable(
            route = "${Screen.DETAILS_COURSE.route}/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        )
        { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            DetailsCourse(
                id = id!!,
                navController = navController,
                title = title
            )
        }
        composable(
            route = "${Screen.FORM_GRADE.route}/{idCourse}",
            arguments = listOf(navArgument("idCourse") {
                type = NavType.IntType
            })
        )
        { backStackEntry ->
            val idCourse = backStackEntry.arguments?.getInt("idCourse")
            FormGrade(
                idCourse = idCourse!!,
                navController = navController,
                title = title
            )
        }
    }
}