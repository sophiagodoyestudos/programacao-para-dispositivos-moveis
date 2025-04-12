package br.com.ibm.composeintentsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import br.com.ibm.composeintentsapp.ui.theme.ComposeIntentsAppTheme

/**
 * Esta Activity representa a segunda tela do aplicativo, sendo exibida ao usuário após o disparo de um Intent explícito feito na MainActivity.
 */
class SecondActivity : ComponentActivity() {

    /**
     * Chamado quando a Activity é criada pela primeira vez.
     * É onde configuramos e inicializamos os componentes de UI e quaisquer recursos necessários para esta tela.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o conteúdo da tela usando Jetpack Compose.
        // Aqui, aplicamos o ComposeIntentsAppTheme para dar estilo (cores, tipografia etc.)
        // e dentro dele, exibimos apenas um texto simples na tela.
        setContent {
            ComposeIntentsAppTheme {
                Text(text = "Bem-vindo a segunda Activity!")
            }
        }
    }
}


