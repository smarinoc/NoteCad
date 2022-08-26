package co.edu.udea.compumovil.gr04_20221.notecad.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material.icons.rounded.RememberMe
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.rounded.Subject
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import co.edu.udea.compumovil.gr04_20221.notecad.R
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.Screen
import co.edu.udea.compumovil.gr04_20221.notecad.ui.composables.MenuButton

@Composable
fun Menu(navController: NavHostController, title: MutableState<String>) {
    title.value=""
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            MenuButton(
                imageVector = Icons.Rounded.Subject,
                contentDescription = "Subject",
                text = stringResource(R.string.subjects),
                onClick = {
                    navController.navigate(Screen.COURSES.route)
                }
            )
            MenuButton(
                imageVector = Icons.Rounded.Schedule,
                contentDescription = "Schedule",
                text = stringResource(R.string.schedule),
                onClick = {
                    navController.navigate(Screen.COURSES.route)
                }
            )
        }

        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            MenuButton(
                imageVector = Icons.Rounded.Calculate,
                contentDescription = "Calculate",
                text = stringResource(R.string.quick_calculation),
                onClick = {
                    navController.navigate(Screen.COURSES.route)
                }
            )
            MenuButton(
                imageVector = Icons.Rounded.RememberMe,
                contentDescription = "RememberMe",
                text = stringResource(R.string.reminders),
                onClick = {
                    navController.navigate(Screen.COURSES.route)
                }
            )
        }
    }
}