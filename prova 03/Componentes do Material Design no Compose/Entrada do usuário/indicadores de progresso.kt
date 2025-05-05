/*
Site de estudo: https://developer.android.com/develop/ui/compose/components/progress?hl=pt-br

INDICADORES DE PROGRESSO 
- Exibem o status (progresso) de uma operação 
- Utilizado para carregamento ou processamento de dados 
- Indica o quão perto o processo pode estar de conclusão 

Três principais utilizações
- Carregamento de conteúdo: ao buscar conteúdo de uma rede, como o carregamento de uma imagem ou dados de um perfil de usuário
- Upload de arquivos: informe ao usuário quanto tempo o upload pode levar
- Processamento longo: enquanto um app está processando uma grande quantidade de dados, comunique ao usuário quanto do total foi concluído 

No Material Design, há dois tipos de indicador de progresso:
a) Determinado: exibe exatamente o progresso feito.
- mostra exatamente quanto do trabalho já foi concluído, geralmente como uma porcentagem.
- Quando usar: sempre que você souber o tamanho total do trabalho 
Exemplo:
- upload de arquivo, carregamento de página com número conhecido de itens

b) Indeterminado: a animação é contínua sem considerar o progresso.
- exibe uma animação contínua (movimento repetido) sem indicar o quanto já foi concluído
- Quando usar: quando não se sabe antecipadamente quanto tempo ou quanto trabalho resta (por exemplo, aguardar resposta de rede onde não há tamanho de payload conhecido, operações de inicialização genéricas).

O indicador de progresso pode assumir duas formas: 
- Linear: uma barra horizontal que preenche da esquerda para a direita.
- Circular: um círculo cujo traço cresce em comprimento até abranger o circunferência completa do círculo.

PLATAFORMA DA API
Os principais parâmetros para criar indicadores de progresso são:
a) progress: Valor atual que indica o andamento. Deve ser um número decimal (float) entre 0.0 (nenhum progresso) e 1.0 (progresso completo).
b) color: Cor usada para representar visualmente o progresso atingido no indicador. Quando o progresso chega em 1.0, essa cor preenche todo o componente.
c) trackColor: Cor utilizada na faixa de fundo onde o indicador de progresso é exibido, indicando visualmente o espaço que ainda precisa ser preenchido.

DETERMINAR INDICADORES 
- No Compose, os indicadores determinados são feitos com os componentes:
a) LinearProgressIndicator → mostra o progresso em uma barra horizontal.
b) CircularProgressIndicator → mostra o progresso em formato circular.
- Ambos recebem o parâmetro progress (um valor entre 0.0 e 1.0) para definir o nível de conclusão.

Exemplo:
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
INDICADORES INDETERMINADOS 
No Compose, os indicadores indeterminados são feitos com os componentes:
a) LinearProgressIndicator
b) CircularProgressIndicator
- Podem ser usados sem passar o parâmetro progress para funcionar como indeterminados.

Exemplos:
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
