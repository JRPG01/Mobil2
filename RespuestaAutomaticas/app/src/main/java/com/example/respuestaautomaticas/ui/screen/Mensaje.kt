package com.example.respuestaautomaticas.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.respuestaautomaticas.ViewModel.ViewModelMensaje

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Mensaje(viewModel: ViewModelMensaje){
    Scaffold {
        Box(modifier = Modifier
            .fillMaxSize()
        , contentAlignment = Alignment.Center){
            Column(modifier = Modifier) {
                OutlinedTextField(
                    value = viewModel.Numero,
                    onValueChange ={viewModel.updateNumero(it)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    label = { Text(text = "Numero de Telefono")},
                    modifier = Modifier.size(350.dp,70.dp)
                )
                OutlinedTextField(
                    value = viewModel.Mensaje,
                    onValueChange ={viewModel.updateMensaje(it)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    label = { Text(text = "Escriba el Mensaje")},
                    modifier = Modifier.size(350.dp,100.dp)
                )
            }
        }
    }
}
