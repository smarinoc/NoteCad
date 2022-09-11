package co.edu.udea.compumovil.gr04_20221.notecad.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.ReminderEntity
import co.edu.udea.compumovil.gr04_20221.notecad.repository.ReminderRepositoryRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReminderViewModel @Inject constructor(
    private val reminderRepositoryRoom: ReminderRepositoryRoom
):  ViewModel(){
    val reminders: LiveData<List<ReminderEntity>> by lazy {
        reminderRepositoryRoom.getAllReminder()
    }
    fun reminderById(id: Int): LiveData<ReminderEntity> {
        return reminderRepositoryRoom.getById(id)
    }

    fun addReminder( reminder: ReminderEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepositoryRoom.insert(reminder)
        }
    }

    fun deleteReminder( reminder: ReminderEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepositoryRoom.delete(reminder)
        }
    }

    fun updateReminder( reminder: ReminderEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            reminderRepositoryRoom.update(reminder)
        }
    }

}