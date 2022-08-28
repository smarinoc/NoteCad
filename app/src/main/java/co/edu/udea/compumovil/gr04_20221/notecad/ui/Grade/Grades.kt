package co.edu.udea.compumovil.gr04_20221.notecad.ui.Course


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.GradeEntity
import co.edu.udea.compumovil.gr04_20221.notecad.ui.Grade.GradeItem


@Composable
fun Grades(
    grades: List<GradeEntity>
) {
    Column(
        Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()) {
        grades.forEach { grade ->
            GradeItem(
                name = grade.name,
                grade = grade.grade,
                percentage = grade.percentage
            )
            Spacer(modifier = Modifier.height(5.dp))
            Divider(thickness = 0.5.dp, modifier = Modifier.background(Color.LightGray))
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}