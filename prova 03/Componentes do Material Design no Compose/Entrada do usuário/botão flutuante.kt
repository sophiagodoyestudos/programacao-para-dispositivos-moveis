/*
Site de estudo: https://developer.android.com/develop/ui/compose/components/fab?hl=pt-br

BOTÃO DE AÇÃO FLUTUANTE (FAB)
- È um botão de alta ênfase que permite ao usuário realizar uma ação principal em um aplicativo 

Por exemplo: 
- Criar novo item: em um app de anotações, um FAB pode ser usado para rapidamente criar uma nota.
- Adicionar novo contato: em um app de chat, um FAB pode abrir uma interface que permite o usuário adiciona alguém a uma conversa.
- Localização central: em uma interface de mapa, um FAB pode centralizar o mapa no local atual do usuário.

Existem quatro tipos de botão flutuante: 
a) Botão de ação flutuante: um botão de ação flutuante de tamanho normal.
- Usamos o elemento combinável FloatingActionButton
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
b) FAB pequeno: um botão de ação flutuante menor.
- Usamos o elemento combinável SmallFloatingActionButton
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
c) FAB grande: um botão de ação flutuante maior.
- Usamos o elemento combinável LargeFloatingActionButton
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
d) FAB estendido: um botão de ação flutuante que contém mais do que apenas um ícone.
- Usamos o elemento combinável ExtendedFloatingActionButton 
- A diferença dele para os outros é que ele tem icon e text (uma foto e um texto)
*/

@Composable
fun ExtendedExample(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
        text = { Text(text = "Extended FAB") },
    )
}

/*
PLATAFORMA DA API 
- onClick: a função chamada quando o usuário pressiona o botão.
- containerColor: a cor do botão.
- contentColor: a cor do ícone.
*/
