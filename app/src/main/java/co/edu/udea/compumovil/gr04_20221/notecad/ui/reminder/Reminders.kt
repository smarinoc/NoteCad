package co.edu.udea.compumovil.gr04_20221.notecad.ui.reminder

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.secondary
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.ReminderViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Reminders(
    navController: NavHostController,
    title: MutableState<String>,
    reminderViewModel: ReminderViewModel = hiltViewModel(),
) {
    title.value = stringResource(id = R.string.reminders)
    val reminders by reminderViewModel.reminders.observeAsState(arrayListOf())

    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = { navController.navigate("${Screen.FORM_REMINDER.route}/${-1}") },
            shape = Shapes.Full,
            containerColor = secondary
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Localized description")
        }
    }) { innerPadding ->
        LazyColumn(Modifier.padding(top = 10.dp, bottom = 50.dp)) {
            items(reminders) { reminder ->
                ReminderItem(
                    name = reminder.name,
                    time = reminder.time,
                    date = reminder.date,
                    navController = navController,
                    idReminder = reminder.id
                )
            }
        }

    }

}

