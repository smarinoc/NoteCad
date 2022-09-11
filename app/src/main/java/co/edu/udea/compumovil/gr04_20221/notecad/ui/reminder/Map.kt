package co.edu.udea.compumovil.gr04_20221.notecad.ui.reminder

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun Map(
    aux: MutableState<Boolean>,
    latitude: MutableState<Double>,
    longitude: MutableState<Double>
) {
    val medellin = LatLng(6.267762, -75.5721787)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(medellin, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        onMapClick = {
            aux.value=true
            latitude.value = it.latitude
            longitude.value= it.longitude
        }
    ) {

        if(aux.value){
            Marker(
                state = MarkerState(position = LatLng(latitude.value, longitude.value))
            )
        }
    }

}