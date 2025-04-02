// RESUMÃO DA AULA 09 PARA A PROVA 02 

package br.com.ibm.supertasks

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

class MainActivity : ComponentActivity() { 
    override fun onCreate(savedInstanceState: Bundle?) { 
        super.onCreate(savedInstanceState) 
        enableEdgeToEdge() 
        setContent {
            SuperTasksTheme { // Nome que dei para o meu projeto quando eu criei ele 
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> 
                    TasksApp( // Nome da minha função que eu criei para construir o conteúdo principal do meu aplicativo 
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


/*
PORQUE ESSA FUNÇÃO EU NÃO DECLAREI ELA COMO @COMPOSABLE?
- A função saveNewTask não é uma função composable porque ela não cria componentes da interface do usuário. 
- A função saveNewTask é responsável apenas por adicionar dados ao Firestore, ou seja, é uma função que lida com lógica de dados, não com a 
construção da interface. 
- A anotação @Composable é usada apenas para funções que geram partes da UI (interface gráfica).
*/
// Função saveNewTask: Responsável por adicionar uma nova tarefa no banco de dados Firestore
// Ela recebe nome do tipo String e description do tipo String como parâmetros 
fun saveNewTask(name: String, description: String) {

    // Obtendo a instância danco de dados do Firestore do Firebase 
    // Pegamos o “acesso” ao banco de dados na nuvem (Firestore), para que possamos enviar dados para ele
    val db = Firebase.firestore
	
    // Cria um HashMap contendo as informações do nome e descrição que serão enviados para o banco de dados 
    /*
    O QUE É HASHMAPOF?
    - È uma estrutura de dados que armazena pares de chave e valor, ou seja, uma chave associada a um valor.
    - No caso do código, hashMapOf("name" to name, "description" to description) cria um HashMap que armazena as informações da tarefa 
    (nome e descrição) que serão enviadas para o Firestore.
    */
    val newTask = hashMapOf(
        "name" to name,
        "description" to description
    )

    // Envia o newTask para a coleção "tasks" do Firestore
    db.collection("tasks").add(newTask)
}

/*
PORQUE EU DEFINI A FUNÇÃO FORMTASKAPP COMO @COMPOSABLE?
- Ela cria componentes da interface do usuário. 
- Ela monta visualmente a tela, com campos de entrada para o nome e descrição da tarefa, e um botão para salvar essas informações.
- @Composable marca a função como responsável por gerar partes da UI no Jetpack Compose. 
- Sem essa anotação, a função não seria capaz de gerar componentes da interface do usuário.
*/
@Composable

// Criando a função FormTasksApp que irá construir o formulário onde o usuário pode inserir os seus dados
fun FormTasksApp(modifier: Modifier = Modifier) {
    
    // Cria variáveis de estado para armazenar o nome e a descrição digitados pelo usuário
    /*
    O QUE O BY REMEMBER FAZ? 
    - È usada para armazenar dados que precisam ser lembrados durante a composição da interface. 
    - Ela garante que o valor das variáveis seja preservado entre recomposições da UI, o que é necessário para preservar o estado enquanto o 
    usuário interage com a interface.
    - No seu código, remember { mutableStateOf("") } é usado para armazenar e lembrar os valores de nome e descricao enquanto o formulário 
    está aberto. 
    - Isso significa que quando o usuário digitar algo no campo de texto, esses valores serão mantidos mesmo se a tela for recomposta (mudada de estado)
    */
    
    /* 
    PORQUE UESEI O MUTABLESTATEOF? 
    - mutableStateOf cria uma variável de estado que pode ser modificada dinamicamente. 
    - Em Jetpack Compose, as variáveis de estado são usadas para armazenar informações que podem mudar durante a execução da aplicação e que, 
    quando alteradas, fazem a interface ser "recompondo" (atualizada automaticamente).
    - Usar mutableStateOf("") permite que os campos de texto para o nome e descricao possam ser atualizados conforme o usuário digita, 
    e também faz com que a UI seja automaticamente atualizada quando esses valores mudam.
    */
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

/*
PORQUE EU DEFINI A FUNÇÃO FORMTASKAPP COMO @PREVIEW e @COMPOSABLE??
- A função @Preview é usada para mostrar uma pré-visualização da interface no Android Studio, o que permite que você visualize a UI 
enquanto ainda está desenvolvendo o código, sem precisar rodar o aplicativo no dispositivo.
- A anotação @Composable indica que a função é responsável por gerar a interface do usuário. 
- No caso, FormTasksApp define os campos de entrada e o botão que compõem o formulário para o usuário.
- Portanto, ao usar @Preview, você consegue ver a interface da função FormTasksApp diretamente no Android Studio sem precisar rodar o aplicativo 
em um dispositivo.
*/
@Preview(showBackground = true)
@Composable

// Cria a função TasksApp que é responsável por posicionar esse formulário corretamente dentro da tela do aplicativo
// Essa função age como um contêiner que agrupa e organiza o conteúdo principal da tela. 
// Ela chama a função FormTasksApp e aplica modificadores que garantem que o formulário ocupe todo o espaço disponível e fique centralizado na tela, garantindo uma apresentação adequada da interface.
fun TasksApp(modifier: Modifier = Modifier) {

    // Chama a função FormTasksApp, que é responsável por exibir o formulário para o usuário preencher as informações da tarefa (nome e descrição)
    FormTasksApp(
        modifier = modifier
            .fillMaxSize() // Ocupa todo o espaço disponível na tela
            .wrapContentSize(Alignment.Center) // Centraliza o conteúdo dentro do espaço disponível
    )
}

/*
PORQUE EU CHAMO A TASKAPP NA MAINACTIVITY E NÃO A OUTRA?
- TasksApp é a função que atua como o container principal para a interface do aplicativo. 
Ela organiza e posiciona o formulário gerado pela função FormTasksApp na tela.
- Dentro de TasksApp, você chama a função FormTasksApp e aplica modificadores como fillMaxSize() para garantir que o formulário ocupe 
todo o espaço disponível e wrapContentSize(Alignment.Center) para centralizar o conteúdo da tela.
- MainActivity chama a função TasksApp porque ela é responsável por exibir o conteúdo principal da tela. 
- Portanto, TasksApp é a função de topo que contém toda a lógica de posicionamento e exibição da interface do aplicativo.
*/
