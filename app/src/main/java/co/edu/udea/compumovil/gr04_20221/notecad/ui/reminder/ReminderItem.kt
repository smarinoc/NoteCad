package co.edu.udea.compumovil.gr04_20221.notecad.ui.reminder

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.ui.InfoText
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Shapes
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Typography


@Composable
fun ReminderItem(
    name: String,
    time: String,
    date: String,
    navController: NavHostController,
    idReminder: Int,
) {

    Surface(
        shadowElevation = 5.dp,
        shape = Shapes.large,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .height(65.dp)
            .fillMaxWidth()
            .clickable(onClick = { navController.navigate("${Screen.FORM_REMINDER.route}/${idReminder}") })
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
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
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(end = 20.dp)
                    .weight(1.5f)
            ) {
                InfoText(
                    text = time,
                    label = stringResource(id = R.string.time),
                    type = 2,
                    modifier = Modifier.weight(1f)
                )
                InfoText(
                    text = date,
                    label = stringResource(id = R.string.date),
                    type = 2,
                    modifier = Modifier.weight(1f)
                )
            }
        }

    }
}


