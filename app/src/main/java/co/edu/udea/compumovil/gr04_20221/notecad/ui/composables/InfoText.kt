package co.edu.udea.compumovil.gr04_20221.notecad.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.udea.compumovil.gr04_20221.notacad.utils.calculateColor
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Typography


@Composable
fun InfoText(grade: Double, label: String, type: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Text(
            text = grade.toString(),
            style = Typography.labelLarge,
            color = calculateColor(grade = grade),
            fontSize = if (type == 1) 24.sp else 16.sp
        )
        Text(text = label, style = Typography.labelMedium, fontSize = if (type == 1) 16.sp else 14.sp)
    }
}
