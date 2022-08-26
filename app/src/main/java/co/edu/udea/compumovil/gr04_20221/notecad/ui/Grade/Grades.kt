package co.edu.udea.compumovil.gr04_20221.notecad.ui.Course

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Grade.GradeItem
import co.edu.udea.compumovil.gr04_20221.notecad.ui.InfoText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Grades(navController: NavHostController, title: MutableState<String>) {
    title.value= "Nota"
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { navController.navigate(Screen.FORM_GRADE.route) }) {
            Icon(Icons.Filled.Add, contentDescription = "Localized description")
        }
    }, modifier = Modifier.padding(vertical = 10.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                InfoText(grade = 3.1, label = stringResource(id = R.string.partial_note), type = 1)
                InfoText(grade = 4.5, label = stringResource(id = R.string.final_note), type = 1)
                InfoText(grade = 3.1, label = stringResource(id = R.string.percentage), type = 1)
                InfoText(grade = 3.1, label = stringResource(id = R.string.missing_to_win), type = 1)
            }
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(Modifier.padding(vertical = 10.dp)) {
                item {
                    GradeItem(
                        name = "Materia 1",
                        grade = 2.5,
                        percentage = 20.0
                    )
                }
            }
        }
    }
}