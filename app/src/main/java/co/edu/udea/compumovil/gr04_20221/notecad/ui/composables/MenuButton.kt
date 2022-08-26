package co.edu.udea.compumovil.gr04_20221.notecad.ui.composables


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Teal200


@Composable
fun MenuButton(
    imageVector: ImageVector,
    contentDescription: String?,
    text: String,
    onClick: () -> Unit, ) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = onClick, modifier = Modifier.width(100.dp).height(100.dp)) {
            Icon(imageVector = imageVector, contentDescription = contentDescription, modifier = Modifier.fillMaxSize(), tint = Teal200)
        }
        Text(text = text)
    }
}