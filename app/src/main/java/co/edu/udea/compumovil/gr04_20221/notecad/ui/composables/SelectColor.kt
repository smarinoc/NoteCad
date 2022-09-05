package co.edu.udea.compumovil.gr04_20221.notecad.ui.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.edu.udea.compumovil.gr04_20221.notecad.R

@Composable
fun SelectColor(selectColor: MutableState<Color>) {
    val colors = listOf(
        Color(0xFFEF9A9A),
        Color(0xFFF48FB1),
        Color(0xFF80CBC4),
        Color(0xFFA5D6A7),
        Color(0xFFFFCC80),
        Color(0xFFFFAB91),
        Color(0xFF81D4FA),
        Color(0xFFCE93D8),
        Color(0xFFB39DDB)
    )

    var colorPickerOpen by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10))
            .border(
                1.dp,
                MaterialTheme.colorScheme.onBackground.copy(alpha = 0.75f),
                RoundedCornerShape(10)
            )
            .clickable {
                colorPickerOpen = true
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.color),
            )

            Canvas(
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(20))
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.onBackground.copy(alpha = 0.75f),
                        RoundedCornerShape(20)
                    )
                    .background(selectColor.value)
                    .clickable {
                        colorPickerOpen = true
                    }
            ) {}
        }

    }

    if (colorPickerOpen) {
        ColorDialog(
            colorList = colors,
            onDismiss = { colorPickerOpen = false },
            currentlySelected = selectColor.value,
            onColorSelected = {
                selectColor.value = it
            }
        )
    }
}