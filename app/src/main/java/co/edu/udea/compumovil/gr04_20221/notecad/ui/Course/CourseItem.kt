package co.edu.udea.compumovil.gr04_20221.notacad.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notacad.utils.calculateFinalGrade
import co.edu.udea.compumovil.gr04_20221.notacad.utils.calculatePartialGrade
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.data.entites.GradeEntity
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.ui.InfoText
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.InfoNumber
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Shapes
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Typography

@Composable
fun CourseItem(
    name: String,
    creditsNumber: Int,
    color: Color,
    navController: NavHostController,
    grades: List<GradeEntity>,
    idCourse: Int
) {
    val partialGrade = calculatePartialGrade(grades)
    val finalGrade = calculateFinalGrade(grades)
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
                Spacer(
                    modifier = Modifier
                        .width(20.dp)
                        .fillMaxHeight()
                        .background(color = color)
                )
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
                    text = creditsNumber.toString(),
                    label = stringResource(R.string.credits),
                    type = 2,
                    modifier = Modifier.weight(1f)
                )
                InfoNumber(
                    number = partialGrade,
                    label = stringResource(R.string.partial_note),
                    type = 2,
                    modifier = Modifier.weight(1f)
                )
                InfoNumber(
                    number = finalGrade,
                    label = stringResource(R.string.final_note),
                    type = 2,
                    modifier = Modifier.weight(1f)
                )
            }

        }
    }

}