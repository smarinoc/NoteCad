package co.edu.udea.compumovil.gr04_20221.notecad.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.CourseEntity
import co.edu.udea.compumovil.gr04_20221.notecad.repository.CourseRepositoryRoom
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(
    private val courseRepositoryRoom: CourseRepositoryRoom
):  ViewModel(){
    val courses: LiveData<List<CourseEntity>> by lazy {
        courseRepositoryRoom.getAllCourse()
    }
    fun courseById(id: Int): LiveData<CourseEntity> {
            return courseRepositoryRoom.getById(id)
    }

    fun addCourse( course: CourseEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            courseRepositoryRoom.insert(course)
        }
    }

    fun deleteCourse( course: CourseEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            courseRepositoryRoom.delete(course)
        }
    }

    fun updateCourse( course: CourseEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            courseRepositoryRoom.update(course)
        }
    }

}