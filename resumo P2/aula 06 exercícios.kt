// AULA NÚMERO 06 - EXERCÍCIOS 
// PERGUNTAS TEÓRICAS

/*
1) Qual é a principal diferença entre setContentView() e setContent {}? Quando cada um é usado?
- setContentView() é usado em Android Tradicional XML, enquanto setContent é usado com Jetpack Compose

2) Explique com suas palavras o que acontece se você usar uma variável comum (var x = 0) dentro de uma função @Composable para controlar algo na interface. Por que isso não funciona como esperado?
- A variável será recriada toda vez que a tela for recomposta, ou seja, o valor sempre volta ao inicial 
- Isso acontece porque Compose reconstrói a interface e variáveis comuns não mantêm estado 
- Por isso devemos utilizar remember com mutableStateOf, que preserva o valor entre recomposições

3) Para que serve o @Composable? Ele pode ser usado em qualquer função Kotlin? Por quê?
- @Composable significa uma função que construi uma interface gráfica na tela 
- Ela só pode ser usada em funções que retornam interface gráfica, e só pode ser chamada dentro de outras funções @Composable ou dentro do setContent{}

4) Explique o que faz esta linha de código:
*/
var texto by remember { mutableStateOf("Olá") }

/*
- Cria uma variável reativa do tipo var chamada texto 
- Com o remember o valor dessa variável será preservado com recomposições de telas 

O QUE SIGINIFICA SER REATIVA?
- Quando o valor dessa variável muda, o Compose recompõe automaticamente a interface para refletir a mudança na tela.
*/

// EXERCÍCIOS PRÁTICOS 
/*
1) Monte uma tela com:
- Um Text centralizado escrito “Bem-vindo!”
- Um botão com o texto “Entrar”
- Ao clicar no botão, o texto deve mudar para “Você entrou no app!”
*/

@Composable 
fun TelaDeBoasVindas() {
    // Cria uma variável de esrado reativa chamada mensagem
    // Sempre que o valor mudar a tela se atualiza automaticamente 
    var mensagem by remember { mutableStateOf("Bem-vindo") }
	
    // Organiza os elemento um abaixo do outro 
    Column(
        // Faz a Column ocupar toda a tela 
        modifier = Modifier.fillMaxSize(),
        // centraliza os itens na vertical.
        verticalArrangement = Arrangement.Center,
        // centraliza na horizontal também
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostra o valor da variável mensagem na tela
        // Se mensagem mudar, o texto muda automaticamente na tela (por ser reativo).
        Text(text = mensagem)
		
        // Adiciona um espaço vazio de 16dp entre o texto e o botão.
		// Serve só pra dar um respiro visual.
        Spacer(modifier = Modifier.height(16.dp))
	
    	
       	// Cria um botão 
        Button(
            // Quando o botão 
            onClick = {
                // Isso atualiza a variável e, por ser reativa, a tela mostra esse novo texto automaticamente.
                mensagem = "Você entrou no app!"
            }
        ) {
            // O texto "Entrar" aparece no dentro botão
            Text("Entrar")
        }
    }
}


/*
2) Monte uma interface com:
- Um Text que exibe um número (contador)
- Um botão com o texto “+”
- Toda vez que clicar, aumenta 1
- Se o contador chegar em 10, exibir outro Text escrito “Limite atingido”
*/

@Composable
fun BotaoContador() {
    // numero é a variável de estado que começa em 0 e guarda o valor do contador.
    var numero by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Exibe o valor atual de numero na tela.
        Text(text = "Contador: $numero", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Botão que incrementa o contador
        Button(
            onClick = {
                if (numero < 10) {
                    numero++
                }
            }
        ) {
            Text("+")
        }

        // Se o número for 10, mostra uma mensagem
        if (numero == 10) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Limite atingido!", color = Color.Red)
        }
    }
}
