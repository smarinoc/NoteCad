package co.edu.udea.compumovil.gr04_20221.notecad.ui.Grade

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ConfirmationNumber
import androidx.compose.material.icons.rounded.Grade
import androidx.compose.material.icons.rounded.Note
import androidx.compose.material3.Surface
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
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.GradeEntity
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.Button
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.InputForm
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Shapes
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.primary
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.GradeViewModel

@Composable
fun FormGradeCalculate(
    navController: NavHostController,
    title: MutableState<String>,
    gradeViewModel: GradeViewModel = hiltViewModel(),
) {
    var grade = rememberSaveable { mutableStateOf("") }
    var percentage = rememberSaveable { mutableStateOf("") }
    var name = rememberSaveable { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    title.value = stringResource(R.string.add_note)
    Surface(
        shadowElevation = 5.dp,
        shape = Shapes.large,
        border = BorderStroke(width = 1.dp, color = primary),
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
                placeholder = stringResource(id = R.string.name),
                icon = Icons.Rounded.Note,
                contentDescription = "Note",
                value = name,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
            InputForm(
                placeholder = stringResource(id = R.string.note),
                icon = Icons.Rounded.Grade,
                contentDescription = "Grade",
                value = grade,
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next,
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
            InputForm(
                placeholder = stringResource(id = R.string.percentage),
                icon = Icons.Rounded.ConfirmationNumber,
                contentDescription = "numbers",
                value = percentage,
                keyboardType = KeyboardType.Decimal,
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
                    focusManager.clearFocus()
                })
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    text = stringResource(id = R.string.save),
                    onClick = {
                        gradeViewModel.addGrade(
                            GradeEntity(
                                id_course = 99,
                                grade = grade.value.toDouble(),
                                percentage = percentage.value.toDouble(),
                                name = name.value
                            )
                        )
                        navController.popBackStack()
                        focusManager.clearFocus()
                    })

            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}