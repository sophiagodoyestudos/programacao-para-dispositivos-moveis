/* 
1) BUTTON 
- Permitem ao usuário acionar uma ação 
- Há cinco tipos de botão:

a) Sólido 
- Fundo totalmente preenchido com a cor primária do seu app, texto em contraste. Muitas vezes com sombra sutil para “levantar” o botão.
- Ações principais, que são o foco da sua tela: “Enviar”, “Salvar”, “Confirmar”. O visual forte e a sombra deixam claro que esta é a ação que o usuário mais deve notar.

b) Tonalidade preenchida
- Semelhante ao sólido, mas usa uma variação mais suave da cor de fundo (tonalidade). Sem contraste tão forte quanto o sólido, porém ainda preenchido.
- Também para ações importantes, mas que não precisam competir visualmente com o botão sólido. Ideal para “Adicionar ao carrinho”, “Fazer login” quando há outro botão sólido na mesma tela

c) Elevada
-  Fundo preenchido (geralmente um pouco mais claro), com elevada altura visual graças à sombra mais pronunciada.
- Se você quiser dar destaque extra a uma ação (talvez num cartão dentro de uma lista, ou em camadas sobrepostas), use o elevado. A sombra mais forte sugere que o botão “flutua” acima do conteúdo.

d) Delineado 
- Sem preenchimento, apenas uma borda na cor primária; fundo transparente.
- Ações de ênfase média. Indicadas para “Cancelar”, “Voltar” ou qualquer opção secundária que precise aparecer ao lado de um botão sólido/tonal. A borda dá contraste suficiente, mas sem chamar tanto atenção.

e) Texto
- Apenas texto, sem borda ou preenchimento. Normalmente com leve mudança de cor ao passar o dedo.
- Ações de baixa ênfase, como links de navegação (“Saiba mais”, “Mais detalhes”), ou tarefas auxiliares que não são críticas. Por ser discreto, funciona bem em barras de ferramentas e diálogos.

SUPERFÍCIE DA API 
a) onClick: a função chamada quando o usuário pressiona o botão.
- dispara a ação associada ao botão.

Exemplo:
*/

Button(onClick = { /* salvar dados, navegar, chamar API… */ }) {
    Text("Enviar")
}

/*
b) enabled: quando "false", este parâmetro faz com que o botão apareça. indisponível ou inativo.
- Controla se o botão está ativo ou desativado 
- tem que ser do tipo Boolean 
- true (padrão): o botão é clicável e renderiza com as cores normais.
- false: o botão não responde a cliques e geralmente fica esmaecido (“disabled”), sinalizando que a ação não está disponível no momento.package

Exemplo:
*/

var canSubmit by remember { mutableStateOf(false) }

Button(
  onClick = { /* … */ },
  enabled = canSubmit
) {
  Text("Enviar")
}

// Aqui, só será possível clicar em “Enviar” quando canSubmit for true.

/*
c) colors: uma instância de ButtonColors que determina as cores usadas em o botão.
- Define as cores do botão em seus diferentes estados (normal, pressionado, desabilitado…).
- Tipo: ButtonColors
- Como obter: normalmente via helpers como ButtonDefaults.buttonColors()

Exemplo:
*/

Button(
  onClick = { /* … */ },
  colors = ButtonDefaults.buttonColors(
    containerColor = Color.Blue,       // cor de fundo
    contentColor   = Color.White,      // cor do texto/ícone
    disabledContainerColor = Color.Gray,
    disabledContentColor   = Color.LightGray
  )
) {
  Text("Enviar")
}

// Isso altera o visual do botão conforme seu estado.

/*
d) contentPadding: o padding dentro do botão.
- Controla o espaçamento interno entre a borda do botão e seu conteúdo (texto, ícone, etc.).
- Tipo: PaddingValues
- Como usar: geralmente com ButtonDefaults.ContentPadding ou criando seus próprios valores (PaddingValues(horizontal = 16.dp, vertical = 8.dp)).
*/

Button(
  onClick = { /* … */ },
  contentPadding = PaddingValues(
    start  = 24.dp,
    top    = 12.dp,
    end    = 24.dp,
    bottom = 12.dp
  )
) {
  Text("Comprar")
}

// O que faz: aumenta ou reduz o “tamanho” interno do botão, deixando mais espaço ao redor do texto/ícone.

// Resumindo:
Button(
  onClick        = { /* ação */ },
  enabled        = true,                       // ativo ou inativo
  colors         = ButtonDefaults.buttonColors(),      // paleta de cores
  contentPadding = PaddingValues(16.dp)        // espaçamento interno
) {
  Text("Clique aqui")
}

// Cada parâmetro permite customizar o comportamento e a aparência do seu botão de forma declarativa e consistente no Compose.

// COMO IMPLEMENTAR CADA BOTÃO:
// a) Botão preenchido 
@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(onClick = { onClick() }) {
        Text("Filled")
    }
}

// Botão tonal preenchido
@Composable
fun FilledTonalButtonExample(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Text("Tonal")
    }
}

// Botão circunscrito
@Composable
fun OutlinedButtonExample(onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick() }) {
        Text("Outlined")
    }
}

// Botão elevado
@Composable
fun ElevatedButtonExample(onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        Text("Elevated")
    }
}

// Botão de texto
@Composable
fun TextButtonExample(onClick: () -> Unit) {
    TextButton(
        onClick = { onClick() }
    ) {
        Text("Text Button")
    }
}
