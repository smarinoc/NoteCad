package co.edu.udea.compumovil.gr04_20221.notecad.ui.Course

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.CourseViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import co.edu.udea.compumovil.gr04_20221.notacad.utils.calculateFinalAverage
import co.edu.udea.compumovil.gr04_20221.notacad.utils.calculatePartialAverage
import co.edu.udea.compumovil.gr04_20221.notacad.utils.countCredits
import co.edu.udea.compumovil.gr04_20221.notecad.ui.InfoText
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.InfoNumber
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Teal200
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
    val grades by gradeViewModel.getAllGrade().observeAsState(arrayListOf())
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = { navController.navigate("${Screen.FORM_COURSE.route}/${-1}") },
            shape = Shapes.Full,
            containerColor = Teal200
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Localized description")
        }
    }) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                InfoNumber(
                    number = calculatePartialAverage(courses = courses, grades = grades),
                    label = stringResource(id = R.string.partial_average),
                    type = 1
                )
                InfoNumber(
                    number = calculateFinalAverage(courses = courses, grades = grades),
                    label = stringResource(id = R.string.final_average),
                    type = 1
                )
                InfoText(
                    text = countCredits(courses).toString(),
                    label = stringResource(id = R.string.credits),
                    type = 1
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(Modifier.padding(top = 10.dp, bottom = 50.dp)) {
                items(courses) { course ->
                    CourseItem(
                        idCourse = course.id,
                        navController = navController,
                        name = course.name,
                        creditsNumber = course.credits,
                        color = Color(color = android.graphics.Color.parseColor(course.color))
                    )
                }
            }
        }
    }

}