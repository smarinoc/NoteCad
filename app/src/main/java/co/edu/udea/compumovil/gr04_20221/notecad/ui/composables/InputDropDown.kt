package co.edu.udea.compumovil.gr04_20221.notecad.ui.composables


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputDropDown(
    options: List<String>,
    icon: ImageVector,
    contentDescription: String?,
    placeholder: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    selectedOptionText: MutableState<String>
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        OutlinedTextField(
            value = selectedOptionText.value, onValueChange = { selectedOptionText.value = it },
            leadingIcon = {
                Icon(imageVector = icon, contentDescription = contentDescription)
            },
            placeholder = {
                          Text(text = placeholder)
            },
            readOnly= true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            modifier = modifier,
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText.value = selectionOption
                        expanded = false
                    },
                    text = {
                        Text(text = selectionOption)
                    }
                )
            }
        }
    }
}
