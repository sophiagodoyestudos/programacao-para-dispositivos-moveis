/*
JETPACK COMPOSE: CUSTOM VIEW 
- Em Compose não há classes que herdam de View. 
- Em vez disso, você escreve funções anotadas com @Composable que descrevem o que aparecerá na tela.

O que é um “Custom View” em Compose?
- Quando alguém fala em Custom View no contexto de Compose, geralmente quer dizer seu próprio Composable. Ou seja, você cria uma função @Composable que:
a) Encapsula uma combinação de componentes (Text, Button, Image, etc.).
b) Recebe parâmetros para ser customizável (cores, textos, cliques...).
c) Pode aplicar modificadores (Modifier) para layout, cores, cliques, etc.
- É o equivalente a antes, quando você criava uma classe que estendia View e sobrescrevia onDraw() e onMeasure(), mas de forma declarativa e mais simples.

No composable para montar uma View: 
- Não tem herança de View
- É uma função que monta a UI usando outros composables (Box, Text, Modifier…)

Resumindo:
- Custom View = seu próprio Composable
- É uma função @Composable, não uma classe Java/Kotlin que estende View.
- Você monta sua UI de forma declarativa, combinando funções e Modifier.
- Só precisa de Canvas ou Layout customizado se for algo realmente fora do comum.
*/

/*
- Site de estudo: https://medium.com/@alexruskovski/jetpack-compose-custom-views-c5fe3d6cbb03

O que é uma View no Composable?
- No Jetpack Compose, uma ‘view personalizada’ é simplesmente uma função anotada com @Composable que encapsula layout e comportamento. Não há classes herdeiras de View nem construtores complexos.”

Como funcionava as view antigamente?
- Antes, criar uma view customizada no Android era como fabricar uma peça de LEGO do zero: você precisava escrever diversas classes, sobrecargas de construtor, métodos de medição e desenho (onMeasure(), onDraw()), além de lidar manualmente com atributos XML e atributos de estilo. Já no Compose, é como seguir uma ‘receita de LEGO’ simples: você escreve uma função curta dizendo ‘quero um botão azul arredondado, que ocupe toda a largura e reaja ao toque’, e o framework faz o resto

Vantagens de uma View no Composable:
- Menos boilerplate: não há múltiplas classes ou XML para configurar.
- Tudo em um só lugar: tamanho, cor, forma e eventos de clique são declarados juntos via Modifier.
- Maior legibilidade e reuso: basta parametrizar sua função @Composable para obter variações do mesmo componente.

Resumindo:
- No Compose a criação de componentes personalizados fica muito mais intuitiva e enxuta: você ‘molda’ sua interface com poucas linhas de código, tal como montar um móvel de LEGO usando instruções precisas ao invés de fabricar as peças manualmente.

CONVERTENDO DE WIDGET-BASED PARA COMPOSE 
Exemplo de uma view utilizado antigamente:
*/

class StyledTextView constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) : AppCompatTextView(context, attributeSet) {

    private var isBold: Boolean = false

    init {
        try {
            val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.StyledTextView)
            isBold = typedArray.hasValue(R.styleable.StyledTextView_useBold) &&
                     typedArray.getBoolean(R.styleable.StyledTextView_useBold, false)
            typedArray.recycle()
            if (isBold) {
                setTypeface(null, Typeface.BOLD)
            }
        } catch (npe: NullPointerException) {
        }
    }
}

/*
- acima temos uma custom view que possui apenas um atributo personalizado useBold do tipo booleano
- Para ter uma view assim, você precisa implementar tudo o que foi mostrado acima e, além disso, adicionar um arquivo XML extra onde você irá descrever os atributos da view.

Como seria essa mesmo view no Compose:
*/

@Composable
fun StyledTextView(
    text: String,
    useBold: Boolean = false
) {
    Text(
        text = text,
        fontWeight = if (useBold) FontWeight.Bold else FontWeight.Normal
    )
}

/*
- Agora não temos mais arquivos separados para declarar atributos, está tudo junto em um único arquivo 

Resumindo:
- Em outras palavras, antes você precisava construir toda a “máquina” do componente. Agora, basta escrever uma “receita” simples que diga “se useBold for verdadeiro, usa negrito; senão, usa normal” — e o Compose cuida do resto para você

O QUE É O CANVA?
- O Canvas no Jetpack Compose é um espaço de desenho “bruto” (um drawing surface) onde você pode desenhar formas, linhas, textos ou qualquer coisa que precise de renderização manual, usando uma API de baixo nível.
*/
