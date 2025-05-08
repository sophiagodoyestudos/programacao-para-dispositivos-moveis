/*
Site de estudo: https://developer.android.com/develop/ui/compose/components/slider?hl=pt-br

SLIDER - CONTROLE DESLIZANTE 
- Permite que os usuários façam seleções em um intervalo de valores 

Por exemplo: 
- Ajuste as configurações que usam diversos valores, como volume e brilho.
- Filtrar dados em um gráfico, como ao definir um intervalo de preços.
- Entrada do usuário, como definir uma nota em uma avaliação.

- O controle deslizante contém: 
a) Faixa: é a barra horizontal que representa o intervalo de valores que o controle deslizante pode assumir.
b) Polegar: o polegar é um elemento de controle arrastável no controle deslizante que permite que o usuário selecione um valor específico dentro do intervalo definido pelo trilhos.
c) Marcas de seleção: são marcadores ou indicadores visuais opcionais que aparecem ao longo da faixa do controle deslizante.

IMPLEMENTAÇÃO BÁSICA
- value: o valor atual do controle deslizante.
- onValueChange: uma lambda que é chamada sempre que o valor é mudou.
- enabled: um valor booleano que indica se o usuário pode interagir com o controle deslizante.
*/

@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
    }
}
