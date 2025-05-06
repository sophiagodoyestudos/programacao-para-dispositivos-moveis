/*
Site utilizado: https://developer.android.com/develop/ui/compose/components/fab?hl=pt-br

BOTÃO FLUTUANTE 
- permite ao usuário realizar uma ação principal em um aplicativo
-  Promove uma ação única e focada esse é o caminho mais comum que um usuário pode seguir e geralmente é encontrado fixado no canto inferior direito da tela.

Exemplos de quando usar:
a) Criar novo item: em um app de anotações, um FAB pode ser usado para rapidamente criar uma nota.
b) Adicionar novo contato: em um app de chat, um FAB pode abrir uma interface que permite o usuário adiciona alguém a uma conversa.
c) Localização central: em uma interface de mapa, um FAB pode centralizar o mapa no local atual do usuário.

Existem quatro tipos de botão flutuante:
a) Botão de ação flutuante: um botão de ação flutuante de tamanho normal.
b) FAB pequeno: um botão de ação flutuante menor.
c) FAB grande: um botão de ação flutuante maior.
d) FAB estendido: um botão de ação flutuante que contém mais do que apenas um ícone.

PLATAFORMA DE API 
Para criar um botão flutuante é necessário:
- onClick: a função chamada quando o usuário pressiona o botão.
- containerColor: a cor do botão.
- contentColor: a cor do ícone.

BOTÃO NORMAL x BOTÃO FLUTUANTE
Botão Normal:
- Faz parte do fluxo da interface.
- Normalmente aparece em listas, formulários, barras ou onde for necessário uma ação complementar (exemplos: "Salvar", "Cancelar", "Próximo").

Botão Flutuante 
- Destaca-se visualmente — normalmente é um botão circular que "flutua" acima do conteúdo.
- Foco em ação primária — é usado para a ação mais importante da tela, como "Adicionar", "Criar", "Compor".EXEMPLOS DE BOTÕES QUE MOSTRAM UM + DENTRO 

BOTÃO DE AÇÃO FLUTUANTE 
- Utilize o método FloatingActionButton

Exemplo:
*/

@Composable
fun Example(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}

/*
BOTÃO PEQUENO 
- Utilize o método SmallFloatingActionButton

Exemplo:
*/

@Composable
fun SmallExample(onClick: () -> Unit) {
    SmallFloatingActionButton(
        onClick = { onClick() },
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.secondary
    ) {
        Icon(Icons.Filled.Add, "Small floating action button.")
    }
}

/*
BOTÃO GRANDE 
- Utilize o método LargeFloatingActionButton

Exemplo:
*/

@Composable
fun LargeExample(onClick: () -> Unit) {
    LargeFloatingActionButton(
        onClick = { onClick() },
        shape = CircleShape,
    ) {
        Icon(Icons.Filled.Add, "Large floating action button")
    }
}

/*
BOTÃO EXTENDIDO 
- Utilize o método ExtendedFloatingActionButton
- A diferença dele para os outros é que ele tem Icon e Text, ou seja, um ícone e um texto dentro do botão 

Exemplos: 
*/

@Composable
fun ExtendedExample(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
        text = { Text(text = "Extended FAB") },
    )
}
