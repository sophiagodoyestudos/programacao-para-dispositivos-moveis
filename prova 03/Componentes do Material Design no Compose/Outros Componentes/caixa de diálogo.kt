/*
Site de estudo: https://developer.android.com/develop/ui/compose/components/dialog?hl=pt-br

CAIXA DE DIÁLOGO 
- Exibe uma mensagem pop-up ou solicita a entrada do usuário em uma acima do conteúdo principal do app
- Ele cria uma experiência de interface interruptiva para capturar a atenção do usuário.

Exemplos: 
a) Confirmar a ação do usuário, como ao excluir um arquivo.
b) Solicitar entrada do usuário, como em um app de lista de tarefas.
c) Apresentar uma lista de opções para seleção do usuário, como escolher um país na configuração de perfil.

CAIXA DE DIÁLOGO DE ALERTA 
- Utilizamos o AlertDialog → componente pronto para criar diálogos bonitos no padrão Material Design.
- Nele existe os seguintes parâmetros: 

a) title: o texto que aparece na parte de cima da caixa de diálogo.
- Geralmente usado para resumir o motivo do alerta 

b) text: o texto que aparece centralizado na caixa de diálogo.
- Texto para explicar melhor a situação

c) icon: o gráfico que aparece na parte superior da caixa de diálogo.
- Para reforço cisual, como um ícone de erro ou alerta 

d) onDismissRequest: a função chamada quando o usuário dispensa a caixa de diálogo, como tocando fora dela.
- Ação ao fechar sem apertar botões — Chamado quando o usuário toca fora ou aperta voltar.

e) dismissButton: um elemento combinável que serve como o botão de dispensar.
- 	Botão de cancelar ou dispensar — Botão opcional para sair sem confirmar.

f) confirmButton: um elemento combinável que serve como botão de confirmação.
- 	Botão de confirmação — Botão principal para confirmar a ação.

Exemplo:
*/

@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}

@Composable
fun DialogExamples() {
    // ...
    val openAlertDialog = remember { mutableStateOf(false) }

    // ...
        when {
            // ...
            openAlertDialog.value -> {
                AlertDialogExample(
                    onDismissRequest = { openAlertDialog.value = false },
                    onConfirmation = {
                        openAlertDialog.value = false
                        println("Confirmation registered") // Add logic here to handle confirmation.
                    },
                    dialogTitle = "Alert dialog example",
                    dialogText = "This is an example of an alert dialog with buttons.",
                    icon = Icons.Default.Info
                )
            }
        }
    }
}

/*
ELEMENTOS COMBINÁVEIS NA CAIXA DE DIÁLOGO 
- O Dialog é um elemento combinável básico que não oferece nenhum estilo ou slots predefinidos para o conteúdo
- É um contêiner relativamente simples que precisa ser preenchido com um contêiner como Card.

Nele precisamos: 
a) onDismissRequest: o lambda chamado quando o usuário fecha a caixa de diálogo.
b) properties: uma instância de DialogProperties que oferece um escopo adicional para personalização.
- 	Permite ajustar opções extras como: se o diálogo pode ser fechado tocando fora, se usa a barra de status, comportamento em tela cheia, entre outros.

Exemplo: 
*/

@Composable
fun MinimalDialog(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = "This is a minimal dialog",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
            )
        }
    }
}

// Sem o Card nesse caso o componente Text seria mostrado sozinho acima do conteúdo principal do app

// Se eu quiser colocar uma imagem dentro do Card:
@Composable
fun DialogWithImage(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    painter: Painter,
    imageDescription: String,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        // Draw a rectangle shape with rounded corners inside the dialog
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painter,
                    contentDescription = imageDescription,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(160.dp)
                )
                Text(
                    text = "This is a dialog with buttons and an image.",
                    modifier = Modifier.padding(16.dp),
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Dismiss")
                    }
                    TextButton(
                        onClick = { onConfirmation() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text("Confirm")
                    }
                }
            }
        }
    }
}

/*
ALERTDIALOG X DIALOG 
1) AlertDialog 
- Vem pronto no Material Design (título, texto, botões, etc)
- Fácil de usar para mostrar alertas simples
- Possui parâmetros como title, text, confirmButton...

2) Dialog 
- É cru, só é uma "janela vazia"
- Você que monta tudo dentro dele
- Não possui — só mostra o que você colocar dentro

Resumindo: 
- Dialog → é só uma "caixa" → você decide o que colocar dentro.
- AlertDialog → já vem estilizado e pronto para uso com título, texto e botões
*/
