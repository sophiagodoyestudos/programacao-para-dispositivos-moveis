package br.com.ibm.composeintentsapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ibm.composeintentsapp.ui.theme.ComposeIntentsAppTheme

/**
 * Esta classe representa a tela principal (MainActivity) do aplicativo.
 * Ela exibe três botões na tela inicial:
 * 1) Abrir YouTube,
 * 2) Enviar um e-mail,
 * 3) Navegar para a SecondActivity.
 */
class MainActivity : ComponentActivity() {

    /**
     * Chamado quando a Activity é criada.
     * Aqui, habilitamos o recurso edge-to-edge e definimos o layout usando Jetpack Compose.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Otimiza o layout para usar áreas próximas às bordas da tela.

        // Define o conteúdo da tela via Compose
        setContent {
            // Aplica o tema definido (cores, tipografia etc.).
            ComposeIntentsAppTheme {
                // Scaffold provê uma estrutura de layout padrão (barra superior, etc.).
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    // Chama o composable MainScreen, que contém a UI principal.
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * Este composable exibe o conteúdo principal da tela:
 * - Um botão para abrir o YouTube
 * - Um botão para enviar um e-mail
 * - Um botão para navegar para a SecondActivity
 */
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    // Obtemos o contexto atual para chamar startActivity.
    val context = LocalContext.current

    // Column organizará nossos elementos (Botões) verticalmente.
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botão para abrir o aplicativo oficial do YouTube.
        Button(
            onClick = {
                val youtubeIntent = Intent(Intent.ACTION_MAIN).apply {
                    `package` = "com.google.android.youtube"
                }
                try {
                    // Tenta abrir o app do YouTube, se instalado.
                    context.startActivity(youtubeIntent)
                } catch (e: ActivityNotFoundException) {
                    // Caso o YouTube não esteja instalado, capturamos a exceção.
                    e.printStackTrace()
                }
            }
        ) {
            Text(text = "Abrir YouTube")
        }

        // Espaço vertical entre os botões.
        Spacer(modifier = Modifier.height(16.dp))

        // Botão para enviar um e-mail
        Button(
            onClick = {
                val emailIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("youremailid@gmail.com"))
                    putExtra(Intent.EXTRA_SUBJECT, "This is the subject of the mail")
                    putExtra(Intent.EXTRA_TEXT, "This is the text part of the mail")
                }
                // Verifica se algum aplicativo consegue lidar com este Intent.
                if (emailIntent.resolveActivity(context.packageManager) != null) {
                    // Se houver um app de e-mail configurado, iniciamos a Activity.
                    context.startActivity(emailIntent)
                }
            }
        ) {
            Text(text = "Mandar Email")
        }

        // Outro espaço entre os botões
        Spacer(modifier = Modifier.height(16.dp))

        // Botão para navegar explicitamente para a SecondActivity do app
        Button(
            onClick = {
                // Criamos um Intent indicando a classe da Activity que queremos abrir.
                val secondIntent = Intent(context, SecondActivity::class.java)
                context.startActivity(secondIntent)
            }
        ) {
            Text(text = "Ir para SecondActivity")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ComposeIntentsAppTheme {
        MainScreen()
    }
}
