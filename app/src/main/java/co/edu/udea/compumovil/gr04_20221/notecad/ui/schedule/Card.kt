package co.edu.udea.compumovil.gr04_20221.notecad.ui.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.ScheduleEntity
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.ActionButtons
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.ScheduleViewModel

@Composable
fun BasicEvent(
    scheduleEntity: ScheduleEntity,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    scheduleViewModel: ScheduleViewModel = hiltViewModel()
) {
    var pickerOpen by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(end = 2.dp, bottom = 2.dp)
            .background(
                Color(color = android.graphics.Color.parseColor(scheduleEntity.color)),
                shape = RoundedCornerShape(4.dp)
            )
            .padding(4.dp)
            .clickable {
                pickerOpen = !pickerOpen
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = scheduleEntity.name,
            fontWeight = FontWeight.Bold,
        )
        if (pickerOpen) {
            ActionButtons(
                onEdit = { navController.navigate("${Screen.FORM_SCHEDULE.route}/${scheduleEntity.id}") },
                onDelete = {
                    scheduleViewModel.deleteSchedule(
                        ScheduleEntity(
                            id = scheduleEntity.id,
                            color = scheduleEntity.color,
                            idCourse = scheduleEntity.idCourse,
                            endHour = scheduleEntity.endHour,
                            startHour = scheduleEntity.startHour,
                            day = scheduleEntity.day,
                            name = scheduleEntity.name
                        )
                    )
                },
                size = 30.dp,
                spaceBy = 5.dp
            )
        }
    }
}

