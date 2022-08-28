package co.edu.udea.compumovil.gr04_20221.notecad.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.GradeEntity
import co.edu.udea.compumovil.gr04_20221.notecad.repository.GradeRepositoryRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class GradeViewModel @Inject constructor(
    private val gradeRepositoryRoom: GradeRepositoryRoom
):  ViewModel(){
    fun grades(id_course: Int): LiveData<List<GradeEntity>>{
        return gradeRepositoryRoom.getGradesByCourse(id_course)
    }
    fun addGrade( grade: GradeEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            gradeRepositoryRoom.insert(grade)
        }
    }
    fun deleteGrade( grade: GradeEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            gradeRepositoryRoom.delete(grade)
        }
    }
    fun updateGrade( grade: GradeEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            gradeRepositoryRoom.update(grade)
        }
    }

}