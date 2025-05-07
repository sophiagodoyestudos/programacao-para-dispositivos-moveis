package br.com.ibm.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
import android.content.res.Configuration
import br.com.ibm.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

// Ponto de partida da Main Activity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Conversation(SampleData.conversationSample)
            }
        }
    }
}

// Modelo de dados
data class Message(val author: String, val body: String)

// Função que exibe cada mensagem e autor na tela
// Não posso adicionar essa função como Preview pois ela recebe parâmetros, por isso criei a PreviewMessageCard
@Composable
fun MessageCard(msg: Message) {
    // Cria um contêiner horizontal
    Row(modifier = Modifier.padding(all = 8.dp)) { // diciona 8 dp de espaçamento em volta de todo o Row
        // Exibo uma imagem carregada do profile_picture
        Image(
            painter = painterResource(R.drawable.profile_picture), // Mostra uma imagem carregada do recurso profile_picture
            contentDescription = null, //  indica que não há descrição para leitores de tela
            modifier = Modifier
                .size(40.dp) // define largura e altura da foto de 40 dp.
                .clip(CircleShape) // recorta a imagem em um círculo
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape) // adiciona borda de 1.5 dp com a cor secundária do tema, mantendo o formato circular
        )

        // Inserindo um espaço horizontalmente de 8 dp entre o avatar e o conteúdo de texto
        Spacer(modifier = Modifier.width(8.dp))

        // Declarando variáveis
        // Define se o texto foi aberto (true) ou não (false)
        var isExpanded by remember { mutableStateOf(false) }

        // Cria uma cor que transita quando o isExpanded mudar
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        )

        // Agrupa verticalmente autor + corpo da mensagem
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) { // a cada toque na mensagem dispara a animação e a recomposição

            // Exibe o nome do autor em cor secundária e estilo de título pequeno
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            // Espaço vertical de 4 dp entre o autor e o corpo da mensagem
            Spacer(modifier = Modifier.height(4.dp))

            // Criando um contêiner em volta do texto
            Surface(
                shape = MaterialTheme.shapes.medium, // definindo a forma
                shadowElevation = 1.dp, // definindo a sombra
                color = surfaceColor, // definidno a cor de fundo do cartão
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {

                // Inserindo o texto dentro do contêiner
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp), // Espaçamento interno para o texto
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1, // vê se o texto é expandido
                    style = MaterialTheme.typography.bodyMedium // define o estilo da fonte
                )
            }
        }
    }
}

// Função que cria a lista de mensagens
// Não posso colocar Preview aqui pois essa função recebe parâmetros, por isso crio a PreviewConversation
@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

// Definindo um Preview para ver o meu aplicativo no modo claro
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

// Função criada para eu poder vizualizar a função MenssageCard
@Preview
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme {
        Surface {
            MessageCard(
                msg = Message("Lexi", "Take a look at Jetpack Compose, it's great!")
            )
        }
    }
}

// Função criada para eu poder vizualizar a função Conversation
@Preview
@Composable
fun PreviewConversation() {
    ComposeTutorialTheme {
        Conversation(SampleData.conversationSample)
    }
}
