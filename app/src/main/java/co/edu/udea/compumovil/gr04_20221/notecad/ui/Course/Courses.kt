package co.edu.udea.compumovil.gr04_20221.notecad.ui.Course

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notacad.ui.CourseItem
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.CourseViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.InfoNumber
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.GradeViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Courses(
    navController: NavHostController,
    title: MutableState<String>,
    courseViewModel: CourseViewModel = hiltViewModel(),
    gradeViewModel: GradeViewModel = hiltViewModel()
) {
    title.value = stringResource(R.string.subjects)
    val courses by courseViewModel.courses.observeAsState(arrayListOf())
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { navController.navigate(Screen.FORM_COURSE.route) }) {
            Icon(Icons.Filled.Add, contentDescription = "Localized description")
        }
    }) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                InfoNumber(
                    number = 3.1,
                    label = stringResource(id = R.string.partial_average),
                    type = 1
                )
                InfoNumber(
                    number = 4.5,
                    label = stringResource(id = R.string.final_average),
                    type = 1
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(Modifier.padding(vertical = 10.dp)) {
                items(courses) { course ->
                    val grades by gradeViewModel.grades(course.id).observeAsState(arrayListOf())
                    CourseItem(
                        idCourse = course.id,
                        grades = grades,
                        navController = navController,
                        name = course.name,
                        creditsNumber = course.credits,
                        color = Color.Cyan
                    )
                }
            }
        }
    }

}