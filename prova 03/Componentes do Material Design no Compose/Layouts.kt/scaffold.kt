/*
Site de estudo: https://developer.android.com/develop/ui/compose/components/scaffold?hl=pt-br

SCAFFOLD
- È um widget estrutural que oferece a base (esqueleto) para a tela inteira de um app

- Ele é responsável por reunir e organizar os principais elementos visuais que compõem a interface, como:
a) topBar (AppBar) → barra do título da tela
- Sempre fica lá em cima, no topo.
- Mostra o título da tela e ícones como voltar, pesquisar, configurações.
- É fixa: você vê ela enquanto navega naquela tela.

b) bottomBar (BottomNavigationBar ou BottomAppBar) → barra para trocar de tela/seção
- Fica lá embaixo, na borda inferior do app.
- Normalmente serve para navegar entre as seções principais do app (Home, Buscar, Perfil, etc).
- Fica fixa quando você troca de tela.

c) floatingActionButton (botão flutuante - FAB)
- É o botão circular flutuante, que normalmente aparece no canto inferior direito.
- Usado para ação principal da tela, como "Adicionar", "Criar", "Enviar".
- Passa por cima do conteúdo, chama mais atenção que botões normais.

COMO IMPLEMENTAR O SCAFFOLD COM BARRA SUPERIOR, INFERIOR E FAB 
Devemos usar:
a) topBar (TopAppBar): Mostra o título e ações rápidas no topo

b) bottomBar (BottomAppBar): Mostra navegação ou ações no rodapé

c) floatingActionButton (FAB): Ação principal da tela, flutuando sobre o conteúdo

b) innerPadding: Espaço reservado para que o conteúdo não fique escondido atrás das barras
- Preciso garantir que o conteúdo da tela (body) não fique por baixo dessas barras (appBar e bottomBar) 
- Para isso o Scaffold automaticamente calcula os espaços que essas barras ocupam e passa para o seu conteúdo um valor chamado de:
innerPadding → que é o espaço (padding) interno para você adicionar no seu conteúdo.
- Se você ignorar o innerPadding, seu conteúdo vai começar "colado" ou até embaixo da AppBar e terminar "embaixo" da BottomBar → o que fica feio e confuso para o usuário.

- O Scaffold organiza tudo e já cuida automaticamente dos espaçamentos (com innerPadding) para a interface não ficar bagunçada ou sobreposta.
