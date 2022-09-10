package co.edu.udea.compumovil.gr04_20221.notecad.data

import androidx.room.Database
import androidx.room.RoomDatabase
import co.edu.udea.compumovil.gr04_20221.notecad.data.dao.CourseDao
import co.edu.udea.compumovil.gr04_20221.notecad.data.dao.GradeDao
import co.edu.udea.compumovil.gr04_20221.notecad.data.dao.ScheduleDao
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.CourseEntity
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.GradeEntity
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.ScheduleEntity


@Database(
    entities = [CourseEntity::class, GradeEntity::class, ScheduleEntity::class],
    version = 2
)
abstract class DataBase() : RoomDatabase() {
    abstract fun getCourseDao(): CourseDao
    abstract fun getGradeDao(): GradeDao
    abstract fun getScheduleDao(): ScheduleDao
}