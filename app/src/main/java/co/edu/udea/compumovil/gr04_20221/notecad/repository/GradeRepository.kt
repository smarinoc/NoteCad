package co.edu.udea.compumovil.gr04_20221.notecad.repository

import androidx.lifecycle.LiveData
import co.edu.udea.compumovil.gr04_20221.notecad.data.dao.GradeDao
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.GradeEntity
import javax.inject.Inject

interface GradeRepository {
    fun getGradesByCourse(id_course: Int): LiveData<List<GradeEntity>>
    suspend fun getById(id: Int) : GradeEntity
    suspend fun insert(grade: GradeEntity)
    suspend fun update(grade: GradeEntity)
    suspend fun delete(grade: GradeEntity)
}

class GradeRepositoryRoom @Inject constructor(
    private val gradeDao: GradeDao
): GradeRepository {
    override fun getGradesByCourse(id_course: Int): LiveData<List<GradeEntity>> {
        return gradeDao.getGradesByCourse(id_course)
    }

    override suspend fun getById(id: Int): GradeEntity {
        return gradeDao.getById(id)
    }

    override suspend fun insert(grade: GradeEntity) {
        return gradeDao.insert(grade)
    }

    override suspend fun update(grade: GradeEntity) {
        return gradeDao.update(grade)
    }

    override suspend fun delete(grade: GradeEntity) {
        return gradeDao.delete(grade)
    }
}