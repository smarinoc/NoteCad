package co.edu.udea.compumovil.gr04_20221.notecad.ui.Course


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notacad.utils.*
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.ActionButtons
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.InfoDetail
import co.edu.udea.compumovil.gr04_20221.notecad.ui.layout.LayoutInfo
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.secondary
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.CourseViewModel
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.GradeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsCourse(
    id: Int = -1,
    navController: NavHostController,
    gradeViewModel: GradeViewModel = hiltViewModel(),
    courseViewModel: CourseViewModel = hiltViewModel(),
    title: MutableState<String>,
) {
    val course by courseViewModel.courseById(id = id).observeAsState()
    val grades by gradeViewModel.grades(id_course = id).observeAsState(arrayListOf())
    val parcialGrade = calculatePartialGrade(grades)
    val finalGrade = calculateFinalGrade(grades)
    val percentage = countPercentage(grades)
    val missingToWin = missingToWin(grades)
    title.value = course?.name.toString()
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = { navController.navigate("${Screen.FORM_GRADE.route}/${id}&${-1}") },
            shape = Shapes.Full,
            containerColor = secondary
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Localized description")
        }
    }) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(top = 10.dp, bottom = 50.dp)
        ) {
            item {
                LayoutInfo(title = stringResource(id = R.string.information)) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        InfoDetail(
                            label = stringResource(id = R.string.name),
                            text = course?.name.toString(),
                            color = Color.Black
                        )
                        Divider(thickness = 0.5.dp, modifier = Modifier.background(Color.LightGray))
                        InfoDetail(
                            label = stringResource(id = R.string.credits),
                            text = course?.credits.toString(),
                            color = Color.Black
                        )
                        Divider(thickness = 0.5.dp, modifier = Modifier.background(Color.LightGray))
                        InfoDetail(
                            label = stringResource(id = R.string.percentage),
                            text = String.format("%.1f", percentage) + "%",
                            color = Color.Black
                        )
                        Divider(thickness = 0.5.dp, modifier = Modifier.background(Color.LightGray))
                        InfoDetail(
                            label = stringResource(id = R.string.partial_note),
                            text = String.format("%.1f", parcialGrade),
                            color = calculateColor(parcialGrade)
                        )
                        Divider(thickness = 0.5.dp, modifier = Modifier.background(Color.LightGray))
                        InfoDetail(
                            label = stringResource(id = R.string.final_note),
                            text = String.format("%.1f", finalGrade),
                            color = calculateColor(finalGrade)
                        )
                        Divider(thickness = 0.5.dp, modifier = Modifier.background(Color.LightGray))
                        InfoDetail(
                            label = stringResource(id = R.string.missing_to_win),
                            text = String.format("%.2f", missingToWin),
                            color = calculateColorMissingToWin(missingToWin)
                        )
                        Divider(thickness = 0.5.dp, modifier = Modifier.background(Color.LightGray))
                        Spacer(modifier = Modifier.height(10.dp))
                        ActionButtons(
                            onEdit = { navController.navigate("${Screen.FORM_COURSE.route}/${id}") },
                            onDelete = {
                                course?.let { it1 ->
                                    courseViewModel.deleteCourse(
                                        it1
                                    )
                                }; navController.popBackStack()
                            },
                            size = 50.dp,
                            spaceBy = 20.dp
                        )
                    }
                }
            }
            item {
                LayoutInfo(title = stringResource(id = R.string.grades)) {
                    Grades(grades = grades, navController = navController)
                }
            }
        }

    }

}