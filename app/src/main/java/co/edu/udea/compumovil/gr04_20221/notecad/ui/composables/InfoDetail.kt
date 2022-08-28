package co.edu.udea.compumovil.gr04_20221.notecad.ui.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Typography

@Composable
fun InfoDetail(label: String, text: String, color: Color) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            modifier = Modifier.weight(1f),
            style = Typography.labelMedium,
            fontSize = 20.sp
        )
        Text(
            text = text,
            color = color,
            modifier = Modifier.weight(1f),
            style = Typography.labelMedium,
            fontSize = 20.sp
        )
    }
}