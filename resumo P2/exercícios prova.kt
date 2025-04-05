// TELA DE LOGIN
fun login (modifier: Modifier = Modifier) {
    var email by remember {mutableStateOf("")}
    var senha by remember {mutableSateteOf("")}
    
    Column (
    	modifier = modifier.padding(16.dp)
        horizontal.Aligment.CenterHorizontally
    ) {
        Text (
        	text = "Entrar"
            fontSize = 30.sp
            fontWeight = FontWeight.Bold 
        )
        
        OutlinedTextField (
        	modifier = Modifier.padding(10.dp),
            value = email,
            onValueChange = {email = it},
            label = {Text(text = "email")}
        )
        
        OutlinedTextField (
        	modifier = Modifier.padding(10.dp)
            value = senha, 
            onValueChange = {senha = it}
            label = {Text(text = "senha")}
        )
        
        Button (
        	onClick = {
                // lógica para clicar no botão 
            }
        ) {
            Text(text = "Entrar")
        }
    }   
}

// SIMULADOR DE CONTADOR 
@Composable
fun TelaContador(modifier: Modifier = Modifier) {
    var contador by remember { mutableStateOf(0) } // Guarda quantas vezes o botão foi clicado

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center // Centraliza verticalmente
    ) {
        Text(
            text = "Você clicou $contador vezes",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Button(
            onClick = {
                contador++
            }
        ) {
            Text(text = "Clique aqui")
        }
    }
}

/*
Exercício 1: Tela de Contador Simples
- Crie uma função composable chamada ContadorSimples que:
- Exiba um número (inicialmente 0) na tela.
- Possua um botão que, ao ser clicado, incremente o valor do número.
- Utilize remember { mutableStateOf(0) } para manter o estado do contador.
*/

@Composable
fun ContadorSimples() {
    var contador by remember { mutableStateOf(0) }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Contador: $contador",
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                contador++
            }
        ) {
            Text(text = "Contar mais um número")
        }
    }
}
    
/*
Exercício 2: Layout com Column, Row e Box
- Crie uma função composable chamada LayoutExemplo que organize os componentes da seguinte forma:
- Use uma Column para empilhar os elementos verticalmente.
- Dentro da Column, adicione uma Row com três elementos de texto (por exemplo, "Item 1", "Item 2" e "Item 3") dispostos horizontalmente.
- Abaixo da Row, use uma Box para sobrepor um texto centralizado sobre um fundo (pode ser um fundo colorido ou outro componente simples).
*/

@Composable
fun LayoutExemplo(modifier: Modifier = Modifier) {
    // Se desejar, pode usar variáveis de estado, mas neste exemplo usaremos textos fixos.
    // var item1 by remember { mutableStateOf("Item 1") }
    // var item2 by remember { mutableStateOf("Item 2") }
    // var item3 by remember { mutableStateOf("Item 3") }
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row com três elementos de texto dispostos horizontalmente
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Item 1")
            Text(text = "Item 2")
            Text(text = "Item 3")
        }
        
        Spacer(modifier = Modifier.height(20.dp))
        
        // Box com fundo colorido e texto centralizado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Texto centralizado sobre o fundo")
        }
    }
}

/*
Crie uma função composable chamada TelaLogin que contenha:
- Dois campos de texto (OutlinedTextField): um para inserir o e-mail e outro para a senha.
- Dois botões: um para "Login" e outro para "Criar Conta".
- Utilize remember para armazenar os valores dos campos.
- Implemente funções fictícias (por exemplo, usando Log.d ou println) para simular a ação de login e criação de conta.
*/

@Composable 
fun TelaLogin(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    
    Column (
    	modifier = Modifier 
        .fillMaxSize()
        .padding(16.dp)
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Títulos de Login e Cadastro
        Text (
        	text = "Login"
            fontSize = 30.sp 
            fontWeight = FontWeight.Bold 
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text (
        	text = "Cadastro"
            fontSize = 30.sp 
            fontWeight = FontWeight.Bold 
        )
        
        Spacer(modifier = Modifier.height(8.dp))
         
        // Campo de texto para e-mail
        OutlinedTextField (
        	modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            value = email, 
            onValueChange = { email = it },
            label = { Text (text = "Email")}
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Campo de texto para senha com visualização protegida
        OutlinedTextField (
        	modifer = Modifier
            .fillMaxWidth()
            .padding(110.dp),
            value = senha, 
            onValueChange = { senha = it },
            label = { Text (text = "senha")},
            visualTransformation = PasswordVisualTransformation()

        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Linha com os botões "Login" e "Cadastro"
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    // Simula a ação de login
                    Log.d("TelaLogin", "Realizando login com email: $email e senha: $senha")
                }
            ) {
                Text(text = "Login")
            }
            Button(
                onClick = {
                    // Simula a ação de criação de conta
                    Log.d("TelaLogin", "Criando conta com email: $email e senha: $senha")
                }
            ) {
                Text(text = "Cadastro")
            }
        }
    }
}

/*
Exercício 4: Formulário de Cadastro de Tarefa com Firestore
- Crie uma função composable chamada FormularioTarefa que faça o seguinte:
- Possua dois campos de texto (OutlinedTextField): um para o nome da tarefa e outro para a descrição.
- Inclua um botão "Salvar" que, ao ser clicado, chame a função saveNewTask(nome, descricao).
- Utilize remember para gerenciar o estado dos campos e organize os componentes dentro de uma Column.
- Se preferir, você pode simular a função saveNewTask com um simples log para demonstrar a ação.
*/

@Composable
fun FormularioTarefa(modifier: Modifier = Modifier) {
    var nome by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }
    
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Cadastro de Tarefa",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = nome,
            onValueChange = { nome = it },
            label = { Text(text = "Nome") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            value = descricao,
            onValueChange = { descricao = it }, // Atualiza o valor de email sempre que o usuário altera o texto.
            label = { Text(text = "Descrição") } // Define um rótulo (label) para o campo com o texto "email".
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = {
                saveNewTask(nome, descricao)
                Log.d("FormularioTarefa", "Tarefa salva: Nome: $nome, Descricao: $descricao")
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Salvar")
        }
    }
}

/*
Em um determinado projeto Android, no arquivo AndroidManifest.xml, você se deparou com a seguinte permissão:
*/
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

/*
Qual é o objetivo dela?
- Se o objetivo do aplicativo é usar a permissão de acesso à internet, muito provavelmente é para monitorar ou verificar conexões dentro do aplicativo.
*/
