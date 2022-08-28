package co.edu.udea.compumovil.gr04_20221.notecad.ui.Course

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.CourseEntity
import co.edu.udea.compumovil.gr04_20221.notecad.ui.InputForm
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.Button
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Shapes
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Teal200
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.CourseViewModel

@Composable
fun FormCourse(navController: NavHostController, title: MutableState<String>, viewModel: CourseViewModel = hiltViewModel()) {
    title.value= stringResource(R.string.add_subject)
    var nameOfCourse = rememberSaveable { mutableStateOf("") }
    var numberOfCredits = rememberSaveable { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    Surface(
        shadowElevation = 5.dp,
        shape = Shapes.large,
        border = BorderStroke(width = 1.dp, color = Teal200),
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .wrapContentHeight()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            InputForm(
                placeholder = stringResource(id = R.string.subject_name),
                icon = Icons.Rounded.School,
                contentDescription = "School",
                value = nameOfCourse,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
            InputForm(
                placeholder = stringResource(id = R.string.number_of_credits),
                icon = Icons.Rounded.ConfirmationNumber,
                contentDescription = "numbers",
                value = numberOfCredits,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
                keyboardActions = KeyboardActions(
                     onDone = {
                         focusManager.clearFocus()
                    }
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Button(text = stringResource(id = R.string.cancel), onClick = {
                    navController.popBackStack()
                })
                Spacer(modifier = Modifier.width(10.dp))
                Button(text = stringResource(id = R.string.save), onClick = {
                    viewModel.addCourse(CourseEntity(name = nameOfCourse.value, credits = numberOfCredits.value.toInt(), color = "Amarillo"))
                    navController.popBackStack()
                })

            }
            Spacer(modifier = Modifier.width(10.dp))

        }
    }
}