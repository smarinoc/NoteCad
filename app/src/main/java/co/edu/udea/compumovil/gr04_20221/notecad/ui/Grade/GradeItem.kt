package co.edu.udea.compumovil.gr04_20221.notecad.ui.Grade

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.ui.InfoText
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.InfoNumber
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Typography

@Composable
fun GradeItem(name: String, percentage: Double, grade: Double) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
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
                text = percentage.toString(),
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
}
