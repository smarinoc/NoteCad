package co.edu.udea.compumovil.gr04_20221.notecad.ui.reminder

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ConfirmationNumber
import androidx.compose.material.icons.rounded.School
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
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
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.ReminderEntity
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.*
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Shapes
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Teal200
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.White200
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.ReminderViewModel


@Composable
fun FormReminder(
    navController: NavHostController,
    title: MutableState<String>,
    reminderViewModel: ReminderViewModel = hiltViewModel(),
    idReminder: Int

) {
    title.value = stringResource(id = R.string.add_reminder)
    val reminder by reminderViewModel.reminderById(id = idReminder).observeAsState()
    var name = rememberSaveable { mutableStateOf("") }
    var note = rememberSaveable { mutableStateOf("") }
    var date = rememberSaveable { mutableStateOf("") }
    var time = rememberSaveable { mutableStateOf("") }
    var latitude = rememberSaveable { mutableStateOf(0.0) }
    var longitude = rememberSaveable { mutableStateOf(0.0) }
    var pickerOpen by rememberSaveable { mutableStateOf(false) }
    var dialogOpen by rememberSaveable { mutableStateOf(false) }
    var aux = rememberSaveable { mutableStateOf(false) }
    if (reminder != null) {
        name.value = reminder!!.name
        note.value = reminder!!.note
        date.value = reminder!!.date
        time.value = reminder!!.time
        latitude.value = reminder!!.latitude
        longitude.value = reminder!!.longitude
        aux.value=true

    }
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
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            InputForm(
                placeholder = stringResource(id = R.string.name),
                icon = Icons.Rounded.School,
                contentDescription = "School",
                value = name,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
            TextArea(
                placeholder = stringResource(id = R.string.note),
                icon = Icons.Rounded.ConfirmationNumber,
                contentDescription = "numbers",
                value = note,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Default,
            )
            DatePicker(placeholder = stringResource(id = R.string.date), date = date)
            TimePicker(mTime = time, placeholder = stringResource(id = R.string.time))
            MapPicker(
                onButton = { pickerOpen = true },
                placeholder = stringResource(id = R.string.location),
                if (aux.value) stringResource(id = R.string.saved) else ""
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Button(text = stringResource(id = R.string.cancel), onClick = {
                        navController.popBackStack()
                    })
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(
                        text = stringResource(id = (if (reminder != null) R.string.edit else R.string.save)),
                        onClick = {
                            if (reminder != null) {
                                reminderViewModel.updateReminder(
                                    ReminderEntity(
                                        id = reminder!!.id,
                                        name = name.value,
                                        note = note.value,
                                        date = date.value,
                                        time = time.value,
                                        latitude = latitude.value,
                                        longitude = longitude.value,

                                        )
                                )
                            } else {
                                reminderViewModel.addReminder(
                                    ReminderEntity(
                                        name = name.value,
                                        note = note.value,
                                        date = date.value,
                                        time = time.value,
                                        latitude = latitude.value,
                                        longitude = longitude.value,
                                    )
                                )
                            }

                            navController.popBackStack()
                        })
                }
                if (reminder != null) {
                    Button(text = stringResource(id = R.string.delete), onClick = {
                       dialogOpen = true
                    }
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }

        }
        if (pickerOpen) {
            AlertDialog(
                onDismissRequest = { pickerOpen = false },
                confirmButton = {
                    androidx.compose.material3.Button(
                        onClick = { pickerOpen = false }) {
                        Text(text = stringResource(id = R.string.save))
                    }
                },
                dismissButton = {
                    androidx.compose.material3.Button(

                        onClick = { pickerOpen = false }) {
                        Text(text = stringResource(id = R.string.cancel))
                    }
                },
                text = {
                    Map(
                        latitude = latitude, longitude = longitude, aux = aux
                    )
                },
                shape = RoundedCornerShape(10.dp),
                containerColor = White200,
            )
        }
    }

    if (dialogOpen) {
        AlertDialog(
            onDismissRequest = { dialogOpen = false },
            confirmButton = {
                androidx.compose.material3.Button(
                    onClick = {
                        reminderViewModel.deleteReminder(
                            ReminderEntity(
                                id = idReminder,
                                name = "",
                                note = "",
                                date = "",
                                time = "",
                                latitude = 0.0,
                                longitude = 0.0,
                            )
                        )
                        pickerOpen = false
                        navController.popBackStack()
                        }) {
                    Text(text = stringResource(id = R.string.delete))
                }
            },
            dismissButton = {
                androidx.compose.material3.Button(

                    onClick = { dialogOpen = false }) {
                    Text(text = stringResource(id =R.string.cancel))
                }
            },
            text = {
                Text(text = stringResource(id =R.string.delete_question))
            },
            shape = RoundedCornerShape(20.dp),
            containerColor = White200,
        )
    }
}