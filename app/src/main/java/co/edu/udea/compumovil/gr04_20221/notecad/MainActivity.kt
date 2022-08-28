package co.edu.udea.compumovil.gr04_20221.notecad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.edu.udea.compumovil.gr04_20221.notecad.ui.layout.LayoutMain
import co.edu.udea.compumovil.gr04_20221.notecad.ui.theme.NoteCadTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteCadTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LayoutMain()
                }
            }
        }
    }
}
@Preview(
    showBackground = true,
)
@Composable
fun DefaultPreview() {
    NoteCadTheme {
    }
}