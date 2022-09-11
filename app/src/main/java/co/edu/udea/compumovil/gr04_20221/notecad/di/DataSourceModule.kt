package co.edu.udea.compumovil.gr04_20221.notecad.di

import android.content.Context
import androidx.room.Room
import co.edu.udea.compumovil.gr04_20221.notecad.data.DataBase
import co.edu.udea.compumovil.gr04_20221.notecad.data.dao.CourseDao
import co.edu.udea.compumovil.gr04_20221.notecad.data.dao.GradeDao
import co.edu.udea.compumovil.gr04_20221.notecad.data.dao.ReminderDao
import co.edu.udea.compumovil.gr04_20221.notecad.data.dao.ScheduleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun dbDataSource(@ApplicationContext context: Context): DataBase {
        return Room.databaseBuilder(context, DataBase::class.java, "noteCad_dataBase")
            .fallbackToDestructiveMigration()
            .build()
    }


    @Singleton
    @Provides
    fun courseDao(db: DataBase): CourseDao = db.getCourseDao()

    @Singleton
    @Provides
    fun dradeDao(db: DataBase): GradeDao = db.getGradeDao()

    @Singleton
    @Provides
    fun scheduleDao(db: DataBase): ScheduleDao = db.getScheduleDao()

    @Singleton
    @Provides
    fun reminder(db: DataBase): ReminderDao = db.getReminder()

}