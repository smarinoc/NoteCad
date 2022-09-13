package co.edu.udea.compumovil.gr04_20221.notecad.ui.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.secondary
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.ScheduleViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Schedule(
    navController: NavHostController,
    title: MutableState<String>,
    scheduleViewModel: ScheduleViewModel = hiltViewModel(),
) {
    title.value = stringResource(id = R.string.schedule)
    val schedules by scheduleViewModel.schedules.observeAsState(arrayListOf())
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = { navController.navigate("${Screen.FORM_SCHEDULE.route}/${-1}") },
            shape = Shapes.Full,
            containerColor = secondary
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Localized description")
        }
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            LayoutSchedule(events = schedules, navController= navController)
        }
    }
}

