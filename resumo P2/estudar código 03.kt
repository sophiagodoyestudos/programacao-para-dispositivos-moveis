package com.example.meuapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aqui você pode aplicar seu tema (MaterialTheme) ou outro
            MaterialTheme {
                // Chama nosso composable que simula o layout do XML
                MyLinearLayoutExample()
            }
        }
    }
}

@Composable
fun MyLinearLayoutExample() {
    // Substituindo LinearLayout vertical por Column
    Column(
        modifier = Modifier
            .fillMaxSize(),            // Ocupa a tela toda
        verticalArrangement = Arrangement.Top, 
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Primeiro "TextView"
        Text(
            text = "Texto 1",
            modifier = Modifier
                .weight(1f)            // Equivale ao layout_weight="1"
                .fillMaxWidth()        // Equivale ao match_parent na largura
                .background(Color.Red),// Cor de fundo
            color = Color.White,       // Cor do texto
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )

        // Segundo "TextView"
        Text(
            text = "Texto 2",
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Green),
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )

        // Terceiro "TextView"
        Text(
            text = "Texto 3",
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Blue),
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}
