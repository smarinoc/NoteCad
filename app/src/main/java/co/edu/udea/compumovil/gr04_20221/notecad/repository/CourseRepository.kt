package co.edu.udea.compumovil.gr04_20221.notecad.repository

import androidx.lifecycle.LiveData
import co.edu.udea.compumovil.gr04_20221.notecad.data.dao.CourseDao
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.CourseEntity
import javax.inject.Inject

interface CourseRepository {
    fun getAllCourse(): LiveData<List<CourseEntity>>
    fun getById(id: Int) : LiveData<CourseEntity>
    suspend fun insert(course: CourseEntity)
    suspend fun update(course: CourseEntity)
    suspend fun delete(course: CourseEntity)
}

class CourseRepositoryRoom @Inject constructor(
    private val courseDao: CourseDao
): CourseRepository {
    override fun getAllCourse(): LiveData<List<CourseEntity>> {
        return courseDao.getAllCourse()
    }

    override fun getById(id: Int): LiveData<CourseEntity> {
        return courseDao.getById(id)
    }

    override suspend fun insert(course: CourseEntity) {
        return courseDao.insert(course)
    }

    override suspend fun update(course: CourseEntity) {
        return courseDao.update(course)
    }

    override suspend fun delete(course: CourseEntity) {
        return courseDao.delete(course)
    }
}