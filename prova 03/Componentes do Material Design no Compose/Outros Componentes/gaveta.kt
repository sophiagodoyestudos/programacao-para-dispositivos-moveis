/*
Site de estudo: https://developer.android.com/develop/ui/compose/components/drawer?hl=pt-br

GAVETA DE NAVEGAÇÃO
- é um menu deslizante que permite que os usuários naveguem por várias seções do app
- Os usuários podem ativar esse recurso deslizando para o lado ou tocando em um ícone de menu.

Exemplo de uso:
a) Organização de conteúdo:permita que os usuários alternem entre diferentes categorias, como em apps de notícias ou blogs.
b) Gerenciamento de contas:forneça links rápidos para as configurações da conta e as seções do perfil em apps com contas de usuário.
c) Descoberta de recursos:organize vários recursos e configurações em um único menu para facilitar a descoberta e o acesso do usuário em apps complexos.

Existem dois tipos de gaveta de navegação:
a) Padrão:compartilha espaço em uma tela com outro conteúdo.
- Quando aberta, empurra o conteúdo da tela para o lado e fica fixa enquanto aberta.

b) Modal:aparece sobre outros conteúdos em uma tela.
- O conteúdo da tela fica por trás e escurecido → só volta quando a gaveta for fechada.

Exemplo:
Podemos utilizar os seguintes elementos:
a) ModalNavigationDrawer → Gerencia a gaveta e o conteúdo da tela principal.
b) drawerContent → É o "menu" que aparece na gaveta. Usamos o ModalDrawerSheet para deixar com a cara do Material.
c) rememberDrawerState + CoroutineScope → Para abrir/fechar a gaveta quando o usuário clica no botão.
d) clickable → Para fazer os itens do menu fecharem a gaveta quando clicados.
*/

ModalNavigationDrawer(
    drawerContent = {
        ModalDrawerSheet {
            Text("Drawer title", modifier = Modifier.padding(16.dp))
            HorizontalDivider()
            NavigationDrawerItem(
                label = { Text(text = "Drawer Item") },
                selected = false,
                onClick = { /*TODO*/ }
            )
            // ...other drawer items
        }
    }
) {
    // Screen content
}

/*
- No ModalNavigationDrawer a gnt tem outros comportamentos como o gesturesEnabled , que permite habilitar ou desabilitar esse gesto de abrir/fechar por arrastar.

Quando o gesturesEnabled  está true, o usuário pode: 
- Deslizar o dedo a partir da borda lateral da tela → para abrir a gaveta.
- Deslizar o dedo na gaveta → para fechar a gaveta.

Quano ele está false: 
- O usuário NÃO pode abrir ou fechar a gaveta com gesto.
- Somente o app (via código → botão ou evento) pode abrir/fechar.

Exemplo:
*/

ModalNavigationDrawer(
    drawerContent = {
        ModalDrawerSheet {
            // Drawer contents
        }
    },
    gesturesEnabled = false
) {
    // Screen content
}

/*
CONTROLAR O COMPORTAMENTO 
- O DrawerState é quem sabe se a gaveta está aberta ou fechada, para usar esse método preciso usar junto com ele o CoroutineScope

Estados da gaveta
- open(): Abre a gaveta
- close(): Fecha a gaveta
- currentValue: Diz se a gaveta está aberta ou fechada (DrawerValue.Open ou DrawerValue.Closed)

Exemplo:
*/

val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
val scope = rememberCoroutineScope()
ModalNavigationDrawer(
    drawerState = drawerState,
    drawerContent = {
        ModalDrawerSheet { /* Drawer content */ }
    },
) {
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show drawer") },
                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
            )
        }
    ) { contentPadding ->
        // Screen content
    }
}

/*
CRIAR GRUPOS EM UMA GAVETA DE NAVEGAÇÃO
*/

@Composable
fun DetailedDrawerExample(
    content: @Composable (PaddingValues) -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(12.dp))
                    Text("Drawer Title", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleLarge)
                    HorizontalDivider()

                    Text("Section 1", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
                    NavigationDrawerItem(
                        label = { Text("Item 1") },
                        selected = false,
                        onClick = { /* Handle click */ }
                    )
                    NavigationDrawerItem(
                        label = { Text("Item 2") },
                        selected = false,
                        onClick = { /* Handle click */ }
                    )

                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    Text("Section 2", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
                    NavigationDrawerItem(
                        label = { Text("Settings") },
                        selected = false,
                        icon = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                        badge = { Text("20") }, // Placeholder
                        onClick = { /* Handle click */ }
                    )
                    NavigationDrawerItem(
                        label = { Text("Help and feedback") },
                        selected = false,
                        icon = { Icon(Icons.AutoMirrored.Outlined.Help, contentDescription = null) },
                        onClick = { /* Handle click */ },
                    )
                    Spacer(Modifier.height(12.dp))
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Navigation Drawer Example") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            content(innerPadding)
        }
    }
}

/*
PONTOS PRINCIPAIS SOBRE ESSE CÓDIGO 
a) Preenche o drawerContent com um Column que contém seções, divisores e itens de navegação.

b) ModalDrawerSheet fornece o estilo do Material Design para a gaveta.
- É o componente principal. Ele que gerencia o estado da gaveta (aberta/fechada) e integra ela ao conteúdo da tela.

c) HorizontalDivider separa as seções dentro da gaveta.
- Serve para organizar visualmente os grupos de itens da gaveta.

Exemplo: 
- separar itens de navegação principal de itens secundários (como "Configurações").

d) ModalNavigationDrawer cria a gaveta.

e) drawerContent define o conteúdo da gaveta.
- É onde você coloca o que vai aparecer dentro da gaveta.
Pode ser simples (Text) ou complexo (listas, imagens, menus...).

f) Dentro da ModalDrawerSheet, um Column organiza os elementos da gaveta verticalmente.

- Dá aquele visual bonito com:
a) Fundo colorido ou branco.
b) Sombra.
c) Canto superior arredondado (dependendo do tema).
-Ou seja, é o container visual da gaveta.

g) Os elementos combináveis NavigationDrawerItem representam itens individuais na gaveta.
- Cada item clicável do menu → Exemplo:
a) "Página inicial"
b) "Perfil"
c) "Configurações"
- Eles já vêm com estilos prontos para mostrar qual está selecionado.

h) O Scaffold fornece a estrutura básica da tela, incluindo o TopAppBar.
- É o esqueleto da tela principal, que geralmente tem:
a) TopAppBar
b) Conteúdo principal
c) Snackbar
d) FloatingActionButton (se quiser)

i) O navigationIcon no TopAppBar controla o estado de abertura e fechamento da gaveta.
- Normalmente é o ícone do "menu" (☰) → quando o usuário clica:
- Abre a gaveta → drawerState.open()
- Ele é o gatilho principal para abrir a gaveta na maioria dos apps.
*/
