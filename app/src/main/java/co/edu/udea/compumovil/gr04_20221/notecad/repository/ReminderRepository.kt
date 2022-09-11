package co.edu.udea.compumovil.gr04_20221.notecad.repository

import androidx.lifecycle.LiveData
import co.edu.udea.compumovil.gr04_20221.notecad.data.dao.ReminderDao
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.ReminderEntity
import javax.inject.Inject

interface ReminderRepository {
    fun getAllReminder(): LiveData<List<ReminderEntity>>
    fun getById(id: Int) : LiveData<ReminderEntity>
    suspend fun insert(reminder: ReminderEntity)
    suspend fun update(reminder: ReminderEntity)
    suspend fun delete(reminder: ReminderEntity)
}

class ReminderRepositoryRoom @Inject constructor(
    private val reminderDao: ReminderDao
): ReminderRepository {
    override fun getAllReminder(): LiveData<List<ReminderEntity>> {
        return reminderDao.getAllReminder()
    }

    override  fun getById(id: Int): LiveData<ReminderEntity> {
        return reminderDao.getById(id)
    }

    override suspend fun insert(reminder: ReminderEntity) {
        return reminderDao.insert(reminder)
    }

    override suspend fun update(reminder: ReminderEntity) {
        return reminderDao.update(reminder)
    }

    override suspend fun delete(reminder: ReminderEntity) {
        return reminderDao.delete(reminder)
    }
}