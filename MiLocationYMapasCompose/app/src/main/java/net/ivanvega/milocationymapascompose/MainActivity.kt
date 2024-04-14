package net.ivanvega.milocationymapascompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.platform.location.locationupdates.LocationUpdatesScreen
import com.example.platform.location.permission.LocationPermissionScreen
import net.ivanvega.milocationymapascompose.ui.location.CurrentLocationScreen
import net.ivanvega.milocationymapascompose.ui.maps.Controllingmapscamera
import net.ivanvega.milocationymapascompose.ui.maps.Controllingthemapdiretly
import net.ivanvega.milocationymapascompose.ui.maps.Customizing
import net.ivanvega.milocationymapascompose.ui.maps.DrawingonMaps
import net.ivanvega.milocationymapascompose.ui.maps.MiMapa
import net.ivanvega.milocationymapascompose.ui.maps.Recomposingelements
import net.ivanvega.milocationymapascompose.ui.theme.MiLocationYMapasComposeTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiLocationYMapasComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    //LocationPermissionScreen()
                    //CurrentLocationScreen()
                    //LocationUpdatesScreen()
                    //MiMapa()

                    // desde aqui comienza las funciones de la practica
                    //Controllingmapscamera()
                    //DrawingonMaps()
                    //Recomposingelements()
                    //Customizing()
                    Controllingthemapdiretly()
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiLocationYMapasComposeTheme {
        Greeting("Android")
    }
}