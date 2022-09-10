package co.edu.udea.compumovil.gr04_20221.notecad.ui.schedule

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Grade
import androidx.compose.material.icons.rounded.WbSunny
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.ScheduleEntity
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.Button
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.InputDropDown
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.TimePicker
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Shapes
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Teal200
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.CourseViewModel
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.ScheduleViewModel

@Composable
fun FormSchedule(
    navController: NavHostController,
    title: MutableState<String>,
    viewModel: ScheduleViewModel = hiltViewModel(),
    idSchedule: Int,
    courseViewModel: CourseViewModel = hiltViewModel()
) {
    title.value = stringResource(id = R.string.add_schedule)
    val courses by courseViewModel.courses.observeAsState(arrayListOf())
    val schedule by viewModel.scheduleById(id = idSchedule).observeAsState()
    var idCourse = rememberSaveable { mutableStateOf(-1) }
    var aux = rememberSaveable { mutableStateOf(true) }
    var selectedOptionText = rememberSaveable { mutableStateOf("") }
    if (selectedOptionText.value != "") {
        val course = courses.find { item -> item.name == selectedOptionText.value }
        idCourse.value = course!!.id
    }
    var day = rememberSaveable { mutableStateOf(-1) }
    var SelectDay = rememberSaveable { mutableStateOf("") }
    var starHour = rememberSaveable { mutableStateOf("") }
    var endHour = rememberSaveable { mutableStateOf("") }
    val optionsDays = stringArrayResource(id = R.array.optionsDays).asList()
    if (SelectDay.value != "") {
        day.value = optionsDays.indexOf(SelectDay.value)
    }


    if (schedule != null && aux.value) {
        aux.value = false
        idCourse.value = schedule!!.idCourse
        selectedOptionText.value= courses.find { item -> item.id == idCourse.value }!!.name
        day.value= schedule!!.day
        SelectDay.value = optionsDays[day.value]
        starHour.value= schedule!!.startHour
        endHour.value= schedule!!.endHour
    }
    val optionsCourse = courses.map { item -> item.name }

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
            InputDropDown(
                placeholder = stringResource(id = R.string.course),
                icon = Icons.Rounded.Grade,
                contentDescription = "Grade",
                selectedOptionText = selectedOptionText,
                options = optionsCourse
            )
            Spacer(modifier = Modifier.width(10.dp))
            InputDropDown(
                placeholder = stringResource(id = R.string.day),
                icon = Icons.Rounded.WbSunny,
                contentDescription = "WbSunny",
                selectedOptionText = SelectDay,
                options = optionsDays
            )
            TimePicker(mTime = starHour, placeholder = stringResource(id = R.string.start_hour))
            Spacer(modifier = Modifier.width(10.dp))
            TimePicker(mTime = endHour, placeholder = stringResource(id = R.string.final_hour))
            val course by courseViewModel.courseById(id = idCourse.value).observeAsState()
            Spacer(modifier = Modifier.width(10.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Button(text = stringResource(id = R.string.cancel), onClick = {
                    navController.popBackStack()
                })
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    text = stringResource(id = (if (course != null) R.string.edit else R.string.save)),
                    onClick = {

                        if (schedule != null) {
                            viewModel.updateSchedule(
                                ScheduleEntity(
                                    id = schedule!!.id,
                                    name = course!!.name,
                                    color = course!!.color,
                                    day = day.value,
                                    startHour = starHour.value,
                                    endHour = endHour.value,
                                    idCourse = idCourse.value
                                )
                            )
                        } else {
                            viewModel.addSchedule(
                                ScheduleEntity(
                                    name = course!!.name,
                                    color = course!!.color,
                                    day = day.value,
                                    startHour = starHour.value,
                                    endHour = endHour.value,
                                    idCourse = idCourse.value
                                )
                            )
                        }
                        navController.popBackStack()
                    }
                )
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
    }
}