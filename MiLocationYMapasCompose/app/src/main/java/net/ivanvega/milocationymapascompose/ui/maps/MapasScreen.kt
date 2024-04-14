package net.ivanvega.milocationymapascompose.ui.maps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapEffect
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerInfoWindowContent
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun MiMapa(){
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = singapore),
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }
}
@Composable
fun Controllingmapscamera(){
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 11f)
    }
    Box(Modifier.fillMaxSize()) {
        GoogleMap(cameraPositionState = cameraPositionState)
        Button(onClick = {
            // Move the camera to a new zoom level
            cameraPositionState.move(CameraUpdateFactory.zoomIn())
        }) {
            Text(text = "Zoom In")
        }
    }
}
@Composable
fun DrawingonMaps(){
    GoogleMap(
        googleMapOptionsFactory = {
            GoogleMapOptions().mapId("DEMO_MAP_ID")
        },
    ) {
        AdvancedMarker(
            state = MarkerState(position = LatLng(-34.5, 151.0)),
            title = "Marker in Sydney"
        )
        AdvancedMarker(
            state = MarkerState(position = LatLng(14.598986474637554,120.98247686858909)),
            title = "Marker in Manilas"
        )
        AdvancedMarker(
            state = MarkerState(position = LatLng(35.66, 139.6)),
            title = "Marker in Tokyo"
        )
    }
}

@Composable
fun Recomposingelements(){
    val singapore = LatLng(1.35, 103.87)

    val markerState = rememberMarkerState(position = singapore)

    GoogleMap(
        googleMapOptionsFactory = {
            GoogleMapOptions().mapId("DEMO_MAP_ID")
        },
    ) {
        AdvancedMarker(
            state = MarkerState(position =markerState.position),
            title = "Marker in singapore"
        )
    }
    LaunchedEffect(Unit) {
        repeat(10) {
            delay(5.seconds)
            val old = markerState.position
            markerState.position = LatLng(old.latitude + 1.0, old.longitude + 2.0)
        }
    }
}

@Composable
fun Customizing(){
    GoogleMap(
        googleMapOptionsFactory = {
            GoogleMapOptions().mapId("DEMO_MAP_ID")
        },
    ) {
        MarkerInfoWindowContent() { marker ->
            Text(marker.title ?: "Este es el marcado mas mamalon que veras", color = Color.Black)
        }
        MarkerInfoWindow() { marker ->
            // Implement the custom info window here
            Column {
                Text(marker.title ?: "Marcador mamalon", color = Color.Blue)
                Text(marker.snippet ?: "A perro el marcador si jalo", color = Color.DarkGray)
            }
        }
    }
}

@Composable
fun Controllingthemapdiretly(){
    GoogleMap(
        googleMapOptionsFactory = {
            GoogleMapOptions().mapId("DEMO_MAP_ID")
        }
    ) {
        MapEffect { map ->

            val sydney = LatLng(-34.0, 151.0)
            map.moveCamera(CameraUpdateFactory.newLatLng(sydney))

            map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        }
    }
}