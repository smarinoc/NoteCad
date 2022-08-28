package co.edu.udea.compumovil.gr04_20221.notecad.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.ScheduleEntity
import co.edu.udea.compumovil.gr04_20221.notecad.repository.ScheduleRepositoryRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val scheduleRepositoryRoom: ScheduleRepositoryRoom
) : ViewModel() {

    val schedules: LiveData<List<ScheduleEntity>> by lazy {
        scheduleRepositoryRoom.getAllSchedule()
    }
    fun addSchedule(schedule: ScheduleEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            scheduleRepositoryRoom.insert(schedule)
        }
    }
    fun deleteSchedule(schedule: ScheduleEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            scheduleRepositoryRoom.delete(schedule)
        }
    }
    fun updateSchedule(schedule: ScheduleEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            scheduleRepositoryRoom.update(schedule)
        }
    }

}