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
