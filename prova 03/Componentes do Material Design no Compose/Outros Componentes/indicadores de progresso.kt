/*
Site de estudo: https://developer.android.com/develop/ui/compose/components/progress?hl=pt-br

INDICADORES DE PROGRESSO 
- Exibem visualmente o status de uma operação 
- Usado para chamar a atenção do usuário para o quanto o processo está próximo da conclusão, como:
a) carregar ou processar dados 

Pode ser usados em: 
a) Carregamento de conteúdo: ao buscar conteúdo de uma rede, como o carregamento de uma imagem ou dados de um perfil de usuário.
b) Upload de arquivos: informe ao usuário quanto tempo o upload pode levar.
c) Processamento longo: enquanto um app está processando uma grande quantidade de dados, comunique ao usuário quanto do total foi concluído.

Existem dois tipos de indicadores de progresso:
a) Determinado: exibe exatamente o progresso feito.
b) Indeterminado: a animação é contínua sem considerar o progresso.

Ele pode assumir duas formas: 
a) Linear: uma barra horizontal que preenche da esquerda para a direita.
b) Circular: um círculo cujo traço cresce em comprimento até abranger o circunferência completa do círculo.

PLATAFORMA DA API 
a) progress: o progresso atual que o indicador mostra. Transmita um Float entre 0.0 e 1.0.
b) color: a cor do indicador real. Ou seja, a parte do componente que reflete o progresso e que engloba totalmente o componente quando o progresso é concluído.
c) trackColor: a cor da faixa em que o indicador é desenhado.

DETERMINAR INDICADORES (Determinado)
- Use os elementos combináveis: LinearProgressIndicator (se quiser de linha) ou CircularProgressIndicator (se quiser de círculo)
*/

@Composable
fun LinearDeterminateIndicator() {
    var currentProgress by remember { mutableStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope() 

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            loading = true
            scope.launch {
                loadProgress { progress ->
                    currentProgress = progress
                }
                loading = false 
            }
        }, enabled = !loading) {
            Text("Start loading")
        }

        if (loading) {
            LinearProgressIndicator(
                progress = { currentProgress },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}

/*
INDICADORES INDETERMINADOS (Indeterminado)
- Não reflete o quão próximo da conclusão uma operação está 
- Ele usa o movimento (do círculo) para indicar que o processo está em andamento 
- Use o elemento combinável LinearProgressIndicator ou CircularProgressIndicator
*/

@Composable
fun IndeterminateCircularIndicator() {
    var loading by remember { mutableStateOf(false) }

    Button(onClick = { loading = true }, enabled = !loading) {
        Text("Start loading")
    }

    if (!loading) return

    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}
