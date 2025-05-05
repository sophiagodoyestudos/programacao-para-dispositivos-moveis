/*
Site utilizado: https://developer.android.com/develop/ui/compose/components/slider?hl=pt-br

3) CONTROLE DESLIZANTE (SLIDER)
- Permite que os usuários façam seleções em um intervalo de valores
- Posso usar para as seguintes funções: 
a) Ajuste as configurações que usam diversos valores, como volume e brilho.
b) Filtrar dados em um gráfico, como ao definir um intervalo de preços.
c) Entrada do usuário, como definir uma nota em uma avaliação. 

- Ele é composto por: 
a) Faixa: é a barra horizontal que representa o intervalo de valores que o controle deslizante pode assumir.
- É a barra horizontal sobre a qual o thumb se move.
- Representa todo o intervalo de valores possíveis (por exemplo, de 0 a 100).

Geralmente tem duas cores:
- Uma parte (antes do thumb) com a cor de progresso, indicando o valor selecionado.
- restante da faixa, com cor mais clara ou neutra, mostrando o intervalo ainda não selecionado.

b) Polegar: o polegar é um elemento de controle arrastável no controle deslizante que permite que o usuário selecione um valor específico dentro do intervalo definido pelo trilhos.
- É o círculo arrastável que o usuário ‘pega’ e move ao longo da faixa.
- Posiciona-se exatamente no ponto que corresponde ao valor atual.
- Seu movimento atualiza dinamicamente o valor selecionado.

c) Marcas de seleção: são marcadores ou indicadores visuais opcionais que aparecem ao longo da faixa do controle deslizante.
- Pequenos indicadores fixos ao longo da faixa, que servem como referência visual.
- Podem ser usados para destacar valores “chave” (por exemplo, intervalos de 10 em 10).
- Ajudam o usuário a ter noção de quantos passos existem e onde estão esses pontos.

IMPLEMENTAÇÃO BÁSICA 
- Principais componentes: 
a) value: o valor atual do controle deslizante.
- O que é: um Float que representa o valor atual do slider dentro do intervalo definido (por exemplo, de 0f a 100f).
- Para que serve: mantém a posição do thumb sincronizada com o estado da sua UI.

b) onValueChange: uma lambda que é chamada sempre que o valor é mudou.
- O que é: uma função lambda (Float) -> Unit que é chamada sempre que o usuário arrasta o thumb e altera o valor.
- Para que serve: permite que você atualize seu estado interno (e, consequentemente, a posição do thumb) conforme o usuário interage.

c) enabled: um valor booleano que indica se o usuário pode interagir com o controle deslizante.
- O que é: um Boolean que indica se o slider está ativo (true) ou desativado (false).

Efeito visual e comportamental:
- Quando true, o usuário pode arrastar o thumb normalmente.
- Quando false, o slider fica esmaecido e não responde a toques/arrastes.

Exemplo de uma implementação básica: 
*/

@Preview
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

/*
IMPLEMENTAÇÃO AVANÇADA
- Principais componentes: 
a) colors: uma instância de SliderColors que permite controlar o cores do controle deslizante.
- O que é: um objeto do tipo SliderColors que controla as cores usadas pelo slider em seus diferentes elementos e estados.
- Como obter: normalmente via SliderDefaults.colors() onde você pode

b) valueRange: o intervalo de valores que o controle deslizante pode assumir.
- O que é: um ClosedFloatingPointRange<Float> (por exemplo, 0f..100f) que define o intervalo mínimo e máximo de valores que o slider pode assinalar.
- Para que serve: limita a posição do thumb, garantindo que value nunca saia desse intervalo.

c) steps: o número de entalhes no controle deslizante ao qual o polegar é ajustado.
- O que é: um Int que indica quantos “entalhes” intermediários (ticks) o slider terá entre o valor mínimo e o máximo.

Como funciona:
- Se steps = 0, o slider é contínuo (sem marcas intermediárias).
- Se steps = n > 0, ele terá n posições intermediárias, criando n + 2 “paradas” possíveis (incluindo mínimo e máximo).

Exemplo de uma implementação avançada:
*/

@Preview
@Composable
fun SliderAdvancedExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 3,
            valueRange = 0f..50f
        )
        Text(text = sliderPosition.toString())
    }
}

/*
CONTROLE DESLIZANTE DE INTERVALO 
- Podemos utilizar o elemento "RangeSlider", que permite ao usuário selecionar dois valores 
-  Isso pode ser útil em casos como quando o usuário deseja selecione um preço mínimo e máximo.

Exemplo de controle deslizante de intervalo:
*/

@Preview
@Composable
fun RangeSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Column {
        RangeSlider(
            value = sliderPosition,
            steps = 5,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
        )
        Text(text = sliderPosition.toString())
    }
}
