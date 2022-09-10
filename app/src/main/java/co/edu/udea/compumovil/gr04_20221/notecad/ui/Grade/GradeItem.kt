package co.edu.udea.compumovil.gr04_20221.notecad.ui.Grade

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.GradeEntity
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.ui.InfoText
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.ActionButtons
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.InfoNumber
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Typography
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.GradeViewModel

@Composable
fun GradeItem(
    name: String,
    percentage: Double,
    grade: Double,
    id: Int,
    gradeViewModel: GradeViewModel = hiltViewModel(),
    idCourse: Int,
    navController: NavHostController
) {
    var pickerOpen by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.End
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().clickable(onClick = {pickerOpen= !pickerOpen})
        ) {
            Text(
                text = name,
                style = Typography.labelLarge,
                fontSize = 18.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .weight(1f)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .padding(end = 20.dp)
                    .weight(1f)
            ) {
                InfoText(
                    text = "$percentage%",
                    label = stringResource(id = R.string.percentage),
                    type = 2,
                    modifier = Modifier.weight(1.2f)
                )
                InfoNumber(
                    number = grade,
                    label = stringResource(id = R.string.note),
                    type = 2,
                    modifier = Modifier.weight(0.8f)
                )
            }
        }
        if (pickerOpen) {
            ActionButtons(
                onEdit = { navController.navigate("${Screen.FORM_GRADE.route}/${idCourse}&${id}") },
                onDelete = {
                    gradeViewModel.deleteGrade(
                        GradeEntity(
                            id = id,
                            grade = grade,
                            percentage = percentage,
                            name = name,
                            id_course = idCourse
                        )
                    )
                },
                size = 50.dp,
                spaceBy = 20.dp
            )
        }
    }

}
