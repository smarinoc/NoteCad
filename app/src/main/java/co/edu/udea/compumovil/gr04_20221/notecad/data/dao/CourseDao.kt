package co.edu.udea.compumovil.gr04_20221.notecad.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.CourseEntity

@Dao
interface CourseDao {

    @Query("SELECT * FROM course_table")
    fun getAllCourse(): LiveData<List<CourseEntity>>

    @Query("SELECT * FROM course_table WHERE id = :id")
    fun getById(id: Int): LiveData<CourseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(course: CourseEntity)

    @Update
    fun update(course: CourseEntity)

    @Delete
    fun delete(course: CourseEntity)

}