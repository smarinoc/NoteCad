package co.edu.udea.compumovil.gr04_20221.notecad.ui.Course

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notacad.utils.calculateFinalGrade
import co.edu.udea.compumovil.gr04_20221.notacad.utils.calculatePartialGrade
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.ui.InfoText
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.InfoNumber
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Shapes
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Typography
import co.edu.udea.compumovil.gr04_20221.notecad.viewModel.GradeViewModel

@Composable
fun CourseItem(
    name: String,
    creditsNumber: Int,
    color: Color,
    navController: NavHostController,
    idCourse: Int,
    gradeViewModel: GradeViewModel = hiltViewModel()
) {
    val grades by gradeViewModel.grades(idCourse).observeAsState(arrayListOf())
    Surface(
        shadowElevation = 5.dp,
        shape = Shapes.large,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .height(65.dp)
            .fillMaxWidth()
            .clickable(onClick = { navController.navigate("${Screen.DETAILS_COURSE.route}/${idCourse}") })
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(0.8f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Canvas(
                    modifier = Modifier
                        .width(20.dp)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(20))
                        .border(
                            1.dp,
                            MaterialTheme.colorScheme.onBackground.copy(alpha = 0.75f),
                            RoundedCornerShape(20)
                        )
                        .background(color)
                ) {}
                Text(
                    text = name,
                    style = Typography.labelLarge,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Left
                )

            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier
                    .padding(end = 10.dp)
                    .weight(1.2f)
            ) {
                InfoText(
                    text = creditsNumber.toString() ,
                    label = stringResource(R.string.credits),
                    type = 2,
                    modifier = Modifier.weight(1f)
                )
                InfoNumber(
                    number = calculatePartialGrade(grades),
                    label = stringResource(R.string.partial_note),
                    type = 2,
                    modifier = Modifier.weight(1f)
                )
                InfoNumber(
                    number = calculateFinalGrade(grades),
                    label = stringResource(R.string.final_note),
                    type = 2,
                    modifier = Modifier.weight(1f)
                )
            }

        }
    }

}