/*
Site de estudo: https://developer.android.com/develop/ui/compose/components/switch?hl=pt-br

SWITCH
- Permite que os usuários alternem entre dois estados: marcado e desmarcado 
- O usuário pode arrastar o polegar para a esquerda ou direita para mudar o estado da chave.

Por exemplo:
- Ative ou desative uma configuração.
- Ativar ou desativar um recurso.
- Selecione uma opção.

Ele é dividido em duas partes: 
a) Ìcone 
- O botão é a parte arrastável do botão

b) Faixa 
- A faixa é o plano de fundo (ativado ou desativado)

IMPLEMENTAÇÃO BÁSICA 
- checked: o estado inicial do switch.
- onCheckedChange: um callback que é chamado quando o estado da mudanças no interruptor.
- enabled: indica se a chave está ativada ou desativada.
- colors: as cores usadas para a troca.
*/

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
