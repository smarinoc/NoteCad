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
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Course.DetailCourseCalculare
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Course.DetailsCourse
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Grade.FormGrade
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Grade.FormGradeCalculate
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Menu
import co.edu.udea.compumovil.gr04_20221.notecad.ui.reminder.FormReminder
import co.edu.udea.compumovil.gr04_20221.notecad.ui.reminder.Map
import co.edu.udea.compumovil.gr04_20221.notecad.ui.reminder.ReminderItem
import co.edu.udea.compumovil.gr04_20221.notecad.ui.reminder.Reminders
import co.edu.udea.compumovil.gr04_20221.notecad.ui.schedule.FormSchedule
import co.edu.udea.compumovil.gr04_20221.notecad.ui.schedule.Schedule

@Composable
fun NavGraph(title: MutableState<String>, navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.MENU.route) {
        composable(Screen.COURSES.route) { Courses(navController, title) }
        composable(
            route = "${Screen.FORM_COURSE.route}/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        )
        { backStackEntry ->
            val idCourse = backStackEntry.arguments?.getInt("id")
            FormCourse(
                idCourse = idCourse!!,
                navController = navController,
                title = title
            )
        }
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
            route = "${Screen.FORM_GRADE.route}/{idCourse}&{id}",
            arguments = listOf(navArgument("idCourse") {
                type = NavType.IntType
            }, navArgument("id"){
                type = NavType.IntType
            })
        )
        { backStackEntry ->
            val idCourse = backStackEntry.arguments?.getInt("idCourse")
            val id = backStackEntry.arguments?.getInt("id")
            FormGrade(
                idCourse = idCourse!!,
                id = id!!,
                navController = navController,
                title = title
            )
        }
        composable(Screen.FORM_GRADE_CALCULATE.route) { FormGradeCalculate(navController, title) }
        composable(Screen.DETAILS_COURSE_CALCULATE.route) { DetailCourseCalculare(navController, title) }
        composable(Screen.SCHEDULE.route) { Schedule(navController, title) }
        composable(
            route = "${Screen.FORM_SCHEDULE.route}/{idSchedule}",
            arguments = listOf(navArgument("idSchedule") {
                type = NavType.IntType
            })
        )
        { backStackEntry ->
            val idSchedule = backStackEntry.arguments?.getInt("idSchedule")
            FormSchedule(
                idSchedule = idSchedule!!,
                navController = navController,
                title = title
            )
        }
        composable(
            route = "${Screen.FORM_REMINDER.route}/{idReminder}",
            arguments = listOf(navArgument("idReminder") {
                type = NavType.IntType
            })
        )
        { backStackEntry ->
            val idReminder = backStackEntry.arguments?.getInt("idReminder")
            FormReminder(
                idReminder = idReminder!!,
                navController = navController,
                title = title
            )
        }
        composable(Screen.REMINDERS.route) { Reminders(navController, title)}
    }
}