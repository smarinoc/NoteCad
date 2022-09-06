package co.edu.udea.compumovil.gr04_20221.notecad.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.White200

@Composable
fun ActionButtons(onEdit: () -> Unit, onDelete: () -> Unit) {
    var pickerOpen by rememberSaveable { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onEdit) {
            Icon(
                imageVector = Icons.Rounded.Edit,
                contentDescription = stringResource(id = R.string.edit),
                modifier = Modifier.size(50.dp),
                tint = Color(0xFFFF9801)
            )
        }
        IconButton(onClick = { pickerOpen = true }) {
            Icon(
                imageVector = Icons.Rounded.Delete,
                contentDescription = stringResource(id = R.string.delete),
                modifier = Modifier.size(50.dp),
                tint = Color.Red
            )
        }
    }

    if (pickerOpen) {
        AlertDialog(
            onDismissRequest = { pickerOpen = false },
            confirmButton = {
                androidx.compose.material3.Button(
                    onClick = { onDelete(); pickerOpen = false }) {
                    Text(text = stringResource(id = R.string.delete))
                }
            },
            dismissButton = {
                androidx.compose.material3.Button(

                    onClick = { pickerOpen = false }) {
                    Text(text = stringResource(id =R.string.cancel))
                }
            },
            text = {
                Text(text = stringResource(id =R.string.delete_question))
            },
            shape = RoundedCornerShape(20.dp),
            containerColor = White200,
        )
    }

}