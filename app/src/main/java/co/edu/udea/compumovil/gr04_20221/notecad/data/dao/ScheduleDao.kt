package co.edu.udea.compumovil.gr04_20221.notecad.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.ScheduleEntity

@Dao
interface ScheduleDao {

    @Query("SELECT * FROM schedule_table")
    fun getAllSchedule(): LiveData<List<ScheduleEntity>>

    @Query("SELECT * FROM schedule_table WHERE id = :id")
    fun getById(id: Int): LiveData<ScheduleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(schedule: ScheduleEntity)

    @Update
    fun update(schedule: ScheduleEntity)

    @Delete
    fun delete(schedule: ScheduleEntity)
}