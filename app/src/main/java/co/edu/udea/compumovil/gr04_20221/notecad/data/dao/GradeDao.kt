package co.edu.udea.compumovil.gr04_20221.notecad.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.GradeEntity

@Dao
interface GradeDao {

    @Query("SELECT * FROM grade_table WHERE id_course = :id_course")
    fun getGradesByCourse(id_course: Int): LiveData<List<GradeEntity>>

    @Query("SELECT * FROM grade_table")
    fun getAllGrade(): LiveData<List<GradeEntity>>

    @Query("SELECT * FROM grade_table WHERE id = :id")
    fun getById(id: Int): LiveData<GradeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(grade: GradeEntity)

    @Update
    fun update(grade: GradeEntity)

    @Delete
    fun delete(grade: GradeEntity)
}