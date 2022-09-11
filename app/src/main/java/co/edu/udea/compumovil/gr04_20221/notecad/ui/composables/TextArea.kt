package co.edu.udea.compumovil.gr04_20221.notecad.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TextArea(
    placeholder: String,
    icon: ImageVector,
    contentDescription: String?,
    value: MutableState<String>,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardActions: KeyboardActions = KeyboardActions(
        onNext = {
        }
    ),
    imeAction: ImeAction = ImeAction.Default,
    readOnly: Boolean = false,
    modifier: Modifier = Modifier.height(200.dp),
){
    OutlinedTextField(
        value = value.value, onValueChange = { value.value = it },
        placeholder = {
            Text(text = placeholder)
        },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = contentDescription)
        },
        singleLine = false,
        modifier = modifier
            .fillMaxSize()
        ,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = keyboardActions,
        readOnly = readOnly,
    )
}
