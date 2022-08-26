package co.edu.udea.compumovil.gr04_20221.notacad.ui

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
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.ui.InputDropDown
import co.edu.udea.compumovil.gr04_20221.notecad.ui.InputForm
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.Button
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Shapes
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Teal200

@Composable
fun FormCourse(navController: NavHostController, title: MutableState<String>) {
    title.value= stringResource(R.string.add_subject)
    val optionsDays = stringArrayResource(id = R.array.optionsDays)
    val optionsHours = stringArrayResource(id = R.array.optionsHours)
    var nameOfCourse = rememberSaveable { mutableStateOf("") }
    var numberOfCredits = rememberSaveable { mutableStateOf("") }
    var color = rememberSaveable { mutableStateOf("") }
    var day = rememberSaveable { mutableStateOf("") }
    var startHour = rememberSaveable { mutableStateOf("") }
    var endHour = rememberSaveable { mutableStateOf("") }
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
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
            InputDropDown(
                options = optionsDays,
                icon = Icons.Rounded.ColorLens,
                contentDescription = "ColorLens",
                placeholder = stringResource(id = R.string.color),
                selectedOptionText = color
            )

            InputDropDown(
                options = optionsDays,
                icon = Icons.Rounded.DateRange,
                contentDescription = "DateRange",
                placeholder = stringResource(id = R.string.day),
                selectedOptionText = day
            )
            Row(
                modifier = Modifier.fillMaxWidth(1F),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InputDropDown(
                    options = optionsHours,
                    icon = Icons.Rounded.LockClock,
                    contentDescription = "LockClock",
                    placeholder = stringResource(id = R.string.start_hour),
                    modifier = Modifier.fillMaxWidth(0.5F),
                    selectedOptionText = startHour
                )
                InputDropDown(
                    options = optionsHours,
                    icon = Icons.Rounded.LockClock,
                    contentDescription = "LockClock",
                    placeholder = stringResource(id = R.string.final_hour),
                    modifier = Modifier.fillMaxWidth(1F),
                    selectedOptionText = endHour
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Button(text = stringResource(id = R.string.cancel), onClick = {})
                Spacer(modifier = Modifier.width(10.dp))
                Button(text = stringResource(id = R.string.save), onClick = {})

            }
            Spacer(modifier = Modifier.width(10.dp))

        }
    }
}