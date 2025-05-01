/*
AULA 12

1) O QUE SÃO OS MODIFICADORES?
- Objetos que alteram aparência, comportamento ou posição de um Composable

Exemplo: 
- fillMaxSize() faz o componente ocupar toda a área disponível
- padding(…) define margens internas

2) O QUE SÃO AS FONTES CONSTUMIZADAS (arquivo .ttf em res/font)
- Para usar uma fonte que não é nativa do sistema, deve-se colocar o arquivo .ttf em res/font e referenciá-lo em FontFamily.
- Garantir que o app carregue a fonte desejada em qualquer dispositivo

3) BOX E SOBREPOSIÇÃO DE FILHOS
- Contêiner onde os elementos filhos ficam empilhados, na ordem em que são declarados
- Permitir colocar uma imagem de fundo (primeiro filho) e, sobre ela, textos ou botões
- Nele os elementos podem se sobrepor 

4) O QUE É AGREGAÇÃO DE COMPOSABLE?
- Dividir uma tela em várias funções Composable menores e reutilizáveis.
- Facilitar a manutenção, leitura e reaproveitamento de código.

- Podemos e devemos  dividir uma UI complexa em várias funções pequenas (Composable functions), cada uma responsável por uma parte específica da tela, pois:
a) Facilitar a leitura e manutenção do código.
b) Reaproveitar componentes em outras telas.
c) Permitir teste e depuração isolados.

5) O QUE É O ALPHA 
- È a transparência 
- Valor de 0.0 (totalmente transparente) a 1.0 (totalmente opaco) que define a opacidade de um componente.
- Ajustar o destaque visual ou criar efeitos de translucidez
- Quanto mais eu diminuo a cor do Alpha mais transparente fica

6) ROW E DEFINIÇÃO DE PESO (WEIGHT)
- Quando tempo um composable row  podemos definir o peso dos elementos na linha package
- Row é um contêiner que coloca os filhos lado a lado, horizontalmente.
- weight: distribuir o espaço disponível no eixo horizontal entre os filhos de forma proporcional ao valor de peso de cada um
- Qualquer composable que estiver dentro da row você pode informar o peso porque ele é um modificador  

7) PORQUE TEM QUE TER A LETRA F QUANDO É FLOAT? 
Exemplo:
- 1f, 2f

- Literal de ponto flutuante em Kotlin
- Indicar que o valor é do tipo Float, exigido pelo parâmetro weight

8) O QUE É FLOWROW E ROW?
- Row: ordena itens em uma única linha; ao exceder espaço, os itens “vazam” para fora da tela.
- FlowRow: quebra automaticamente os itens para a próxima linha quando não cabem, controlando maxLines e comportamento de overflow.

9) O QUE É @DRAWABLERES?
- Anotação que garante que o parâmetro é um recurso de imagem (R.drawable.*).
- Ajudar o compilador a checar tipos e prevenir erros de recurso inválido.

10) O QUE ACONTECE QUANTO MENOR FOR O PESO E QUANTO MAIOR ELE FOR?
- Menor peso: ocupa uma fração menor do espaço disponível.
- Maior peso: ocupa uma fração maior.
*/
