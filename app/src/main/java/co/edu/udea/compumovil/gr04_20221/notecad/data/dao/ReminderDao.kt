package co.edu.udea.compumovil.gr04_20221.notecad.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.ReminderEntity

@Dao
interface ReminderDao {

    @Query("SELECT * FROM reminder_table")
    fun getAllReminder(): LiveData<List<ReminderEntity>>

    @Query("SELECT * FROM reminder_table WHERE id = :id")
    fun getById(id: Int): LiveData<ReminderEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(reminder: ReminderEntity)

    @Update
    fun update(reminder: ReminderEntity)

    @Delete
    fun delete(reminder: ReminderEntity)
}
