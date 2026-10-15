package com.futboldata.ejerciciossem9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.futboldata.ejerciciossem9.ui.theme.EjerciciosSem9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjerciciosSem9Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        ControlAforo()
                    }
                }
            }
        }
    }
}

@Composable
fun ControlAforo() {
    var entradaTexto by remember { mutableStateOf("") }
    var personasAdentro by remember { mutableStateOf(0) }
    var ultimoRegistrado by remember { mutableStateOf("Ninguno") }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Control de Aforo")
        Text("Personas adentro: $personasAdentro")
        Text("Último registrado: $ultimoRegistrado")

        TextField(
            value = entradaTexto,
            onValueChange = {
                entradaTexto = it
            },
            label = { Text("Nombre del invitado") }
        )
        Button(onClick = {
            ultimoRegistrado = entradaTexto
            personasAdentro = personasAdentro + 1
            entradaTexto = ""
        }) {
            Text("Registrar e Ingresar")
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {
                if (personasAdentro > 0) {
                    personasAdentro = personasAdentro - 1
                }
            }) {
                Text("Salida (-1)")
            }
            Button(onClick = {
                personasAdentro = 0
                ultimoRegistrado = "Ninguno"
            }) {
                Text("Reiniciar")
            }
        }
    }
}