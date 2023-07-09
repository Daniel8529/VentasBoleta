package com.example.ventasboletas

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.ventasboletas.ui.theme.VentasBoletasTheme
import com.example.ventasboletas.ui.List.ListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VentasBoletasTheme() {val context = LocalContext.current
                val navController = rememberNavController()
                if (!compruebaConexion(context)) {
                    androidx.compose.material.Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = androidx.compose.material.MaterialTheme.colors.background
                    ) {
                        DefaultPreview()
                    }
                } else {


                    ListScreen()
                }


            }
        }
    }
}
fun compruebaConexion(context: Context): Boolean {
    var connected = false
    val connec = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    // Recupera todas las redes (tanto móviles como wifi)
    val redes = connec.allNetworkInfo
    for (i in redes.indices) {
        // Si alguna red tiene conexión, se devuelve true
        if (redes[i].state == NetworkInfo.State.CONNECTED) {
            connected = true
        }
    }
    return connected
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Scaffold(
        topBar = {

            TopAppBar(title = { Text(text = "Hello no hay Internet") }, modifier = Modifier.padding(2.dp), actions = {})

        }

    ) {
    }


}

