package co.edu.udea.compumovil.gr04_20221.notecad.ui.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Shapes
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Typography

@Composable
fun LayoutInfo(title: String, content: @Composable ColumnScope.() -> Unit) {
    Surface(
        shadowElevation = 5.dp,
        shape = Shapes.large,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, style = Typography.labelLarge, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Column(content = content)
        }
    }
}