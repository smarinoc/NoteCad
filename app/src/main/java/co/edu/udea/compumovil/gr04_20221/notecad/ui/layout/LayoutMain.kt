package co.edu.udea.compumovil.gr04_20221.notecad.ui.layout


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import co.edu.udea.compumovil.gr04_20221.notecad.navigation.NavGraph
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.Teal200


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutMain() {
    val navController = rememberNavController()
    var title = rememberSaveable { mutableStateOf("") }
    Scaffold(
        topBar = {
            SmallTopAppBar(title = {
                Text(text = title.value)
            }, navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Rounded.ArrowBack, contentDescription = "ArrowBack")
                }
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Teal200
                )
            )
        },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Box(modifier = Modifier.padding(top = 20.dp)) {
                NavGraph(title = title, navController = navController)
            }

        }

    }
}