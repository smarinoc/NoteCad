package co.edu.udea.compumovil.gr04_20221.notecad.repository

import androidx.lifecycle.LiveData
import co.edu.udea.compumovil.gr04_20221.notecad.data.dao.ScheduleDao
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.ScheduleEntity
import javax.inject.Inject

interface ScheduleRepository {
    fun getAllSchedule(): LiveData<List<ScheduleEntity>>
    fun getById(id: Int) : LiveData<ScheduleEntity>
    suspend fun insert(schedule: ScheduleEntity)
    suspend fun update(schedule: ScheduleEntity)
    suspend fun delete(schedule: ScheduleEntity)
}

class ScheduleRepositoryRoom @Inject constructor(
    private val scheduleDao: ScheduleDao
): ScheduleRepository {
    override fun getAllSchedule(): LiveData<List<ScheduleEntity>> {
        return scheduleDao.getAllSchedule()
    }

    override  fun getById(id: Int): LiveData<ScheduleEntity> {
        return scheduleDao.getById(id)
    }

    override suspend fun insert(schedule: ScheduleEntity) {
        return scheduleDao.insert(schedule)
    }

    override suspend fun update(schedule: ScheduleEntity) {
        return scheduleDao.update(schedule)
    }

    override suspend fun delete(schedule: ScheduleEntity) {
        return scheduleDao.delete(schedule)
    }
}