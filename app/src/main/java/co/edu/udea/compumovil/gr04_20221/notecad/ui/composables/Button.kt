package co.edu.udea.compumovil.gr04_20221.notecad.ui.composables


import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.secondary

@Composable
fun Button(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.width(150.dp),
        colors = ButtonDefaults.buttonColors (
            containerColor = secondary
        )
    ) {
        Text(text = text)
    }
}