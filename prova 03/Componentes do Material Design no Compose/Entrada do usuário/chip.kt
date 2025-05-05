/*
Site utilizado: https://developer.android.com/develop/ui/compose/components/chip?hl=pt-br

4) ÍCONE (CHIP)
- Existem quatro tipos de ícones:
a) Assistir: orienta o usuário durante uma tarefa. Muitas vezes, aparece como um elemento temporário da interface em resposta à entrada do usuário.
- O que faz: Guia o usuário durante uma tarefa ou processo.
- Quando aparece: Normalmente surge de forma temporária, em resposta a alguma ação do usuário, para mostrar dicas, progressos ou orientações.
- Exemplo: Uma pequena mensagem “Arraste para atualizar” que aparece quando o usuário puxa a lista para baixo.

b) Filtro: permite que os usuários refinem o conteúdo de um conjunto de opções. Eles podem ser selecionados ou desmarcados e podem incluir um ícone de marca de seleção quando selecionados.
- O que faz: Permite ao usuário refinar o conteúdo exibido, marcando ou desmarcando opções.
Comportamento:
- Ao ser selecionado, mostra um ícone de “check” ou mudança visual (cor de fundo diferente).
- Ao ser desmarcado, retorna ao estado padrão.
- Exemplo: Chips “Hoje”, “Última semana” e “Último mês” em um calendário, que filtram eventos conforme a escolha.

c) Entrada: representa informações fornecidas pelo usuário, como seleções em um menu. Eles podem conter um ícone e texto, além de um "X" para remoção.
- O que faz: Representa um dado fornecido pelo usuário, como uma tag ou seleção de menu.
Elementos:
- Ícone ou avatar (opcional) + texto.
- Um “X” ou ícone de remoção, permitindo apagar esse item.
- Exemplo: Em um campo de destinatários de e-mail, cada e-mail aparece como um chip com o endereço e um “X” para remover.

d) Sugestão: oferece recomendações ao usuário com base na atividade ou entrada recente dele. Normalmente, aparecem abaixo de um campo de entrada para solicitar ações do usuário.
- O que faz: Oferece recomendações ao usuário com base em sua atividade recente ou no que ele digitou.
- Localização: Geralmente aparece logo abaixo de um campo de entrada de texto.
- Exemplo: Ao começar a digitar “Novo Po”, surge o chip “Novo Pedido” como sugestão de ação rápida.

SUPERFÍCIE DA API 
- Elementos utilizados para a construção 
a) label: a string que aparece no ícone.
- É a string exibida como texto principal dentro do chip.
- Deve ser curta e descritiva, pois é o que o usuário vê imediatamente.
- Exemplo: "Hoje", "Arquivos", "Novo Pedido".

b) icon: o ícone exibido no início do ícone. Alguns dos elementos combináveis específicos têm um parâmetro leadingIcon e trailingIcon separado.
- É um composable que renderiza um ícone dentro do chip.
- leadingIcon aparece antes do texto; trailingIcon aparece depois (útil, por exemplo, para um “X” de remoção).

c) onClick: a lambda chamada pelo chip quando o usuário o pressiona.
- É a lambda que será executada quando o usuário tocar no chip.
- Recebe o evento de clique e permite disparar ações como filtrar listas, adicionar/remover itens, navegar para outra tela etc.

CHIP DE ASSISTÊNCIA 
- O elemento combinável AssistChip oferece uma maneira simples de criar um chip de assistência que orienta o usuário em uma direção específica.
- orienta o usuário a uma direção específica
- o parâmetro leadingIcon, que permite exibir um ícone no lado esquerdo do ícone.


Exemplo:
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
- O elemento combinável FilterChip exige que você rastreie se o ícone está selecionado ou não
- O exemplo a seguir demonstra como mostrar um ícone marcado apenas quando o usuário selecionou o ícone:

Exemplo: 
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
- É possível usar o elemento combinável InputChip para criar ícones que resultam da interação do usuário. 
- or exemplo, em um cliente de e-mail, quando o usuário está escrevendo um e-mail, um ícone de entrada pode representar uma pessoa cujo endereço o usuário inseriu no campo "para:".
- A implementação a seguir demonstra um ícone de entrada que já está em um estado selecionado. O usuário dispensa o ícone ao pressioná-lo.

Exemplo:
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
- O elemento combinável SuggestionChip é o mais básico dos elementos combináveis listados nesta página, tanto na definição da API quanto nos casos de uso comuns. 
- Os ícones de sugestão apresentam dicas geradas dinamicamente.
- Por exemplo, em um app de chat com IA, você pode usar ícones de sugestão para apresentar possíveis respostas à mensagem mais recente.

Exemplo:
*/

@Composable
fun SuggestionChipExample() {
    SuggestionChip(
        onClick = { Log.d("Suggestion chip", "hello world") },
        label = { Text("Suggestion chip") }
    )
}
