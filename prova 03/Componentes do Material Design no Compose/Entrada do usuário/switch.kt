/*
Site utilizado: https://developer.android.com/develop/ui/compose/components/switch?hl=pt-br

2) SWITCH 
- Permite que o usuário alternem entre dois estados: marcado e desmarcado 
- Ele pode ser usado para:
a) Ative ou desative uma configuração.
b) Ativar ou desativar um recurso.
c) Selecione uma opção.

- O componente tem duas partes: o ícone e a faixa
Faixa:
- É o plano de fundo do switch: um retângulo arredondado que mostra visualmente a zona de deslize.
- Geralmente muda de cor de acordo com o estado:
a) Cinza claro quando está desligado (OFF).
b) Cor de destaque (por exemplo, verde ou azul) quando está ligado (ON).

Botão:
- É a parte arrastável, um círculo que desliza de uma extremidade à outra dentro da faixa.
- Representa o “polegar” que você empurra para mudar o estado.
- Ao deslizar da esquerda para a direita, ativa o switch (liga). Ao deslizar de volta, desativa (desliga).

IMPLEMENTAÇÃO BÁSICA 
- Na implementação básica utilizamos:
a) checked: o estado inicial do switch.
- O que é: um Boolean que indica se o switch está ligado (true) ou desligado (false) quando a UI é renderizada.
- sincroniza o aspecto visual do switch com o seu estado interno.
*/

var ligado by remember { mutableStateOf(false) }
Switch(
  checked = ligado,
  onCheckedChange = { /* … */ }
)

/*
b) onCheckedChange: um callback que é chamado quando o estado da mudanças no interruptor.
- um callback (função lambda) que é chamado sempre que o usuário toca ou arrasta o thumb, mudando o estado do switch. Recebe como parâmetro o novo valor (true ou false).
- atualiza o estado do seu app quando o usuário interage com o switch.
*/

Switch(
  checked = ligado,
  onCheckedChange = { novoEstado ->
    ligado = novoEstado
  }
)

/*
c) enabled: indica se a chave está ativada ou desativada.
- um Boolean que define se o switch está ativo (true) ou desativado (false).

Efeito visual:
- true (padrão): o switch aparece com cores normais e responde a toques/arrastes.
- false: o switch fica esmaecido e não permite interação.
*/

Switch(
  checked = ligado,
  onCheckedChange = { ligado = it },
  enabled = canToggle  // só pode tocar se canToggle for true
)

/*
d) colors: as cores usadas para a troca.
- um objeto do tipo SwitchColors que determina as cores usadas para o track (faixa) e o thumb (botão) nos estados ligado, desligado e desabilitado.
- Como obter: via SwitchDefaults.colors(...).
- personaliza o visual do switch para combinar com o tema do seu app.
*/

Switch(
  checked = ligado,
  onCheckedChange = { ligado = it },
  colors = SwitchDefaults.colors(
    checkedThumbColor   = Color.Green,
    uncheckedThumbColor = Color.LightGray,
    checkedTrackColor   = Color(0xFFAAFFAA),
    uncheckedTrackColor = Color(0xFFEEEEEE),
    disabledThumbColor  = Color.Gray,
    disabledTrackColor  = Color.LightGray
  )
)

// Resumindo:
var ligado by remember { mutableStateOf(false) }

Switch(
  checked          = ligado,               // estado atual
  onCheckedChange  = { ligado = it },      // ação ao mudar
  enabled          = true,                 // ativo ou não
  colors           = SwitchDefaults.colors(
                        checkedThumbColor   = Color.Green,
                        uncheckedTrackColor = Color.Gray
                     )
)

// Exemplo de implementação básica:
@Composable
fun SwitchMinimalExample() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
}

/*
IMPLEMENTAÇÃO AVANÇADA 
- Na implementação avançada utilizamos:
a) thumbContent: use para personalizar a aparência do polegar quando ele estiver marcado.
- um bloco @Composable opcional que você pode passar para desenhar conteúdo dentro do próprio thumb (o círculo arrastável).
- Quando usar: se, ao ligar o switch, você quiser mostrar um ícone, número ou qualquer outro composable dentro do polegar. Por exemplo, um ícone de “check” ou um emoji.

Exemplo:
*/

Switch(
  checked = ligado,
  onCheckedChange = { ligado = it },
  thumbContent = {
    if (ligado) {
      Icon(
        imageVector = Icons.Default.Check,
        contentDescription = "Ligado",
        modifier = Modifier.size(16.dp)
      )
    }
  }
)

// Aqui, quando ligado == true, o polegar exibe um check

// b) colors: use para personalizar a cor da faixa e do ícone.

// Exemplo de implementação avançada:

@Composable
fun SwitchWithIconExample() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            null
        }
    )
}

// CORES PERSONALIZADAS 
// Exemplo de como mudar a cor do botão, considerando que ele está marcado: 
@Composable
fun SwitchWithCustomColors() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.primary,
            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
        )
    )
}
