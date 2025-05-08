/*
Site de estudo: https://developer.android.com/develop/ui/compose/components/chip?hl=pt-br

ÍCONE - CHIP 
- È um elemento de interface compacto e interativo 
- È uma peça de UI leve que combina texto e ícones para representar entidades, filtros ou ações rápidas de forma clara e padronizada.

Por exemplo:
- Assistir: orienta o usuário durante uma tarefa. Muitas vezes, aparece como um elemento temporário da interface em resposta à entrada do usuário.
- Filtro: permite que os usuários refinem o conteúdo de um conjunto de opções. Eles podem ser selecionados ou desmarcados e podem incluir um ícone de 
marca de seleção quando selecionados.
- Entrada: representa informações fornecidas pelo usuário, como seleções em um menu. Eles podem conter um ícone e texto, além de um "X" para remoção.
- Sugestão: oferece recomendações ao usuário com base na atividade ou entrada recente dele. Normalmente, aparecem abaixo de um campo de entrada para 
solicitar ações do usuário.

SUPERFÍCIE DA API 
- label: a string que aparece no ícone.
- icon: o ícone exibido no início do ícone. Alguns dos elementos combináveis específicos têm um parâmetro leadingIcon e trailingIcon separado.
- onClick: a lambda chamada pelo chip quando o usuário o pressiona.

CHIP DE ASSITÊNCIA 
- Chip utilizado para dar assistência ao usuário (vai orientar o usuário em uma direção específica)
- Usamos o parâmetro leadingIcon
*/

@Composable
fun AssistChipExample() {
    AssistChip(
        onClick = { Log.d("Assist chip", "hello world") },
        label = { Text("Assist chip") },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }
    )
}

/*
ÍCONE DE FILTRO 
- Esse ícone rastreia se o ícone está selecionado ou não 
- Usamos o elemento combinável FilterChip
*/

@Composable
fun FilterChipExample() {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text("Filter chip")
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}

/*
ÍCONE DE ENTRADA 
- Para criar ícones que resultam da interação do usuário 
- Usamos o elemento combinável InputChip
*/

@Composable
fun InputChipExample(
    text: String,
    onDismiss: () -> Unit,
) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        label = { Text(text) },
        selected = enabled,
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Default.Close,
                contentDescription = "Localized description",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
    )
}

/*
CHIP DE SUGESTÃO
- Apresentam dicas geradas dinamicamente 
- Usamos o elemento combinável SuggestionChip 
*/ 

@Composable
fun SuggestionChipExample() {
    SuggestionChip(
        onClick = { Log.d("Suggestion chip", "hello world") },
        label = { Text("Suggestion chip") }
    )
}
