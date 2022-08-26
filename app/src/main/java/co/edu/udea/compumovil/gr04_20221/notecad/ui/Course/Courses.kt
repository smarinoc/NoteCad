package co.edu.udea.compumovil.gr04_20221.notecad.ui.Course

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notacad.ui.CourseItem
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.ui.InfoText

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Courses(navController: NavHostController, title: MutableState<String>) {
    title.value= stringResource(R.string.subjects)
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { navController.navigate(Screen.FORM_COURSE.route) }) {
            Icon(Icons.Filled.Add, contentDescription = "Localized description")
        }
    }) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                InfoText(grade = 3.1, label = stringResource(id = R.string.partial_average ), type = 1)
                InfoText(grade = 4.5, label = stringResource(id = R.string.final_average ), type = 1)
            }
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(Modifier.padding(vertical = 10.dp)) {
                item {
                    CourseItem(
                        name = "Materia 1",
                        partialGrade = 4.5,
                        finalGrade = 1.2,
                        color = Color.Red
                    )
                }
            }
        }
    }

}