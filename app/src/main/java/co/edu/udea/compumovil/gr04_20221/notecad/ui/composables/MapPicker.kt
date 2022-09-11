package co.edu.udea.compumovil.gr04_20221.notecad.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun MapPicker(onButton: () -> Unit, placeholder: String, state: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10))
            .border(
                1.dp,
                MaterialTheme.colorScheme.onBackground.copy(alpha = 0.75f),
                RoundedCornerShape(10)
            )
            .clickable(onClick = onButton)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Rounded.DateRange, contentDescription = "DateRange")
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                modifier = Modifier.width(100.dp),
                text = placeholder,
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = state,
            )
        }
    }
}