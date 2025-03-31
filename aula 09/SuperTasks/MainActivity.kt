// OLHAR AULA 09 NO ONE DRIVE 

// Pacote do projeto - Isso define o "local" onde o código está. Pense nisso como o endereço de uma pasta onde todos os arquivos do projeto estão organizados
package br.com.ibm.supertasks

// Imports de bibliotecas e pacotes que fornecem funcionalidades essenciais para o desenvolvimento desse projeto
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.* // Importamos para usar Column, Row, etc
import androidx.compose.material3.* // Importamos para usar Button, OutlinedTextField, etc
import androidx.compose.runtime.* // Importamos para usar remember e mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ibm.supertasks.ui.theme.SuperTasksTheme
import com.google.firebase.firestore.ktx.firestore // Para acessar o Firestore
import com.google.firebase.ktx.Firebase

// Definindo a Activity principal do aplicativo (tela principal do aplicativo)
class MainActivity : ComponentActivity() { // Aqui, criamos a "MainActivity", que é a tela principal do aplicativo. Pense nela como a página inicial de um site
    override fun onCreate(savedInstanceState: Bundle?) { // Este é o método que o sistema Android chama quando o aplicativo é iniciado. É como a “porta de entrada” do app.
        super.onCreate(savedInstanceState) // Chama o comportamento padrão que já vem pronto no Android. Assim, o aplicativo sabe como se iniciar corretamente.
        enableEdgeToEdge() // Configura a tela para usar toda a área disponível do dispositivo, inclusive as partes próximas às bordas.
        // Aqui, dizemos “o que será mostrado na tela”. Dentro dessas chaves { } é onde definimos a interface usando uma nova forma de construir telas chamada Jetpack Compose.
        setContent {
            SuperTasksTheme { // Aplica um conjunto de cores e estilos pré-definidos para deixar o app com uma aparência consistente.
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> // Cria uma estrutura básica para a tela, ajudando a organizar os elementos. O innerPadding garante que o conteúdo não fique escondido por outras partes do sistema, como a barra de status
                    // Chamando a função TaskApp que constrói o conteúdo principal do aplicativo
                    TasksApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Criando a função saveNewTask que adiciona uma tarefa no Firestore
fun saveNewTask(name: String, description: String) {

    // Obtendo a instância db (singleton)
    // Pegamos o “acesso” ao banco de dados na nuvem (Firestore), para que possamos enviar dados para ele
    val db = Firebase.firestore

    // Criação do documento que irá armazenar os dados
    // Criar um documento que representa uma tarefa
    // De maneira simples usando HashMap
    // Monta um pacote de dados (como um envelope) com as informações da tarefa, associando o nome e a descrição
    val newTask = hashMapOf(
        "name" to name,
        "description" to description
    )

    // Enviando para o banco de dados
    db.collection("tasks").add(newTask)
}

@Composable // Essa anotação indica que a função cria uma parte da interface (a tela) do aplicativo, usando o Jetpack Compose.

// Criando a função FormTasksApp que irá construir o formulário onde o usuário pode inserir os seus dados
fun FormTasksApp(modifier: Modifier = Modifier) {
    // Criando variáveis para guardar o que o usuário digita
    // A função remember faz com que esses valores sejam lembrados enquanto o aplicativo está aberto
    var nome by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }

    // Cria uma coluna (uma lista vertical) onde todos os elementos serão colocados um abaixo do outro
    Column(
        // Adiciona um espaço (padding) ao redor da coluna para que nada fique grudado nas bordas da tela
        modifier = modifier.padding(16.dp),
        // Centraliza os elementos dentro da coluna
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Exibe o texto "Salvar" na tela
        Text(
            text = "Salvar", // Texto exibido
            fontSize = 30.sp, // Define o tamanho da fonte
            fontWeight = FontWeight.Bold // Deixa o texto em negrito
        )

        // Cria um campo de texto onde o usuário pode digitar o seu nome
        OutlinedTextField(
            modifier = Modifier.padding(10.dp), // Espaço interno para separar dos demais elementos
            value = nome, // // Valor atual do campo, controlado pela variável de estado 'nome'
            onValueChange = { nome = it }, // Atualiza a variável 'nome' conforme o usuário digita
            label = { Text(text = "Nome") } //  Rótulo que indica o que deve ser digitado
        )

        // Cria um campo de texto onde o usuário pode digitar a sua descrição
        OutlinedTextField(
            modifier = Modifier.padding(10.dp),  // Espaço interno para separar dos demais elementos
            value = descricao, // Valor atual do campo, controlado pela variável 'descricao'
            onValueChange = { descricao = it }, // Atualiza a variável 'descricao' conforme o usuário digita
            label = { Text(text = "Descricao") } // Rótulo que indica o que deve ser digitado
        )

        // Cria um botão para salvar as informações do usuário
        Button(
            onClick = {
                // Chama a função que salva a tarefa no Firestore, passando os dados digitados
                saveNewTask(nome, descricao)
            }
        ) {
            // Exibe o texto dentro do botão
            Text(text = "Salvar")
        }
    }
}

// Função composable para agrupar e exibir o formulário, permitindo também a visualização no Android Studio:
@Preview(showBackground = true)
@Composable

// Cria a função TasksApp que é responsável por posicionar esse formulário corretamente dentro da tela do aplicativo
// Essa função age como um contêiner que agrupa e organiza o conteúdo principal da tela. Ela chama a função FormTasksApp e aplica modificadores que garantem que o formulário ocupe todo o espaço disponível e fique centralizado na tela, garantindo uma apresentação adequada da interface.
fun TasksApp(modifier: Modifier = Modifier) {

    // Chama a função FormTasksApp
    // Esta função cria o formulário propriamente dito. Ela define os campos onde o usuário digita o nome e a descrição da tarefa e inclui o botão para salvar esses dados. Em resumo, ela monta a parte interativa da tela onde o usuário insere as informações.
    FormTasksApp(
        modifier = modifier
            .fillMaxSize() // Ocupa todo o espaço disponível na tela
            .wrapContentSize(Alignment.Center) // Centraliza o conteúdo dentro do espaço disponível
    )
}
