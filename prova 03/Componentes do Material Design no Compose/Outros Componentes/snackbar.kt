/*
Site de estudo: https://developer.android.com/develop/ui/compose/components/snackbar?hl=pt-br

SNACKBAR 
- Serve como uma notificação breve que aparece na parte de baixo da tela
- Ele fornece feedback sobre uma operação ou ação sem interromper a experiência do usuário
- As barras de informações desaparecem após alguns segundos.
- O usuário também pode dispensar o alerta com uma ação, como tocar em um botão.

Podemos usar eles em: 
a) Confirmação de ação:depois que um usuário exclui um e-mail ou uma mensagem, uma snackbar aparece para confirmar a ação e oferecer a opção "Desfazer".
b) Status da rede:quando o app perde a conexão de Internet, uma snackbar aparece para informar que ele está off-line.
c) Envio de dados:ao enviar um formulário ou atualizar as configurações, uma barra de informações informa que a alteração foi salva.

EXEMPLO BÁSICO 
Para exibir um Snackbar é necessário: 
a) Scaffold → É quem gerencia e mostra a Snackbar na tela.
b) SnackbarHost → Onde as Snackbars realmente aparecem.
c) SnackbarHostState → Onde você chama .showSnackbar() para exibir uma mensagem.
d) CoroutineScope → Porque .showSnackbar() é uma função de suspensão → precisa ser chamada dentro de uma coroutine.
*/

val scope = rememberCoroutineScope()
val snackbarHostState = remember { SnackbarHostState() }
Scaffold(
    snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    },
    floatingActionButton = {
        ExtendedFloatingActionButton(
            text = { Text("Show snackbar") },
            icon = { Icon(Icons.Filled.Image, contentDescription = "") },
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("Snackbar")
                }
            }
        )
    }
) { contentPadding ->
    // Screen content
}

/*
SNACKBAR COM AÇÃO 
- Você pode fornecer uma ação opcional e ajustar a duração da Snackbar. A função snackbarHostState.showSnackbar() aceita outros parâmetros actionLabel e duration e retorna um SnackbarResult.

Exemplo:
*/

val scope = rememberCoroutineScope()
val snackbarHostState = remember { SnackbarHostState() }
Scaffold(
    snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    },
    floatingActionButton = {
        ExtendedFloatingActionButton(
            text = { Text("Show snackbar") },
            icon = { Icon(Icons.Filled.Image, contentDescription = "") },
            onClick = {
                scope.launch {
                    val result = snackbarHostState
                        .showSnackbar(
                            message = "Snackbar",
                            actionLabel = "Action",
                            // Defaults to SnackbarDuration.Short
                            duration = SnackbarDuration.Indefinite
                        )
                    when (result) {
                        SnackbarResult.ActionPerformed -> {
                            /* Handle snackbar action performed */
                        }
                        SnackbarResult.Dismissed -> {
                            /* Handle snackbar dismissed */
                        }
                    }
                }
            }
        )
    }
) { contentPadding ->
    // Screen content
}

/*
PONTOS PRINCIPAIS 
a) actionLabel = "Action": define o texto do botão de ação.
b) withDismissAction = true: fornece uma cruz na snackbar. Toque nele para fechar a barra de informações.
c) duration = SnackbarDuration.Indefinite: mantém a snackbar mostrada até que o usuário ou o programa a descarte.
d) SnackbarResult.ActionPerformed: significa que o usuário clicou no botão de ação da barra de informações.
e) SnackbarResult.Dismissed: significa que o usuário dispensou a snackbar sem clicar no botão de ação.
*/
