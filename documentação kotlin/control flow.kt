// FLUXO DE CONTROLE
/*
- Assim como outras linguagens de programação, o Kotlin é capaz de tomar decisões com base no resultado de uma expressão condicional.
- Essas expressões são chamadas de expressões condicionais. O Kotlin também é capaz de criar e iterar através de loops.

Expressões condicionais
- O Kotlin fornece if e when para verificar expressões condicionais.
- Se você tiver que escolher entre if e when, recomendamos usar when porque ele:

- Torna seu código mais legível.
- Facilita a adição de outro ramo.
- Leva a menos erros no seu código."
 */

// IF
// Para usar o if, adicione a expressão condicional entre parênteses () e a ação a ser executada se o resultado for verdadeiro dentro de chaves {}:
fun main() {
    val d: Int
    val check = true
    if (check) {
        d = 1
    } else {
        d = 2
    }
    println(d)
    // 1
}

// Não existe um operador ternário condition ? then : else no Kotlin. Em vez disso, o if pode ser usado como uma expressão. Se houver apenas uma linha de código
// por ação, as chaves {} são opcionais:
fun main() {
    val a = 1
    val b = 2
    println(if (a > b) a else b) // Retorna o valor: 2
}

// WHEN
/*
- Use when quando você tiver uma expressão condicional com múltiplos ramos.

Para usar o when:
- Coloque o valor que você deseja avaliar dentro de parênteses ().
- Coloque os ramos dentro de chaves {}.
- Use -> em cada ramo para separar a verificação da ação a ser tomada se a verificação for bem-sucedida.
- O when pode ser usado como uma declaração ou como uma expressão. Uma declaração não retorna nada, mas executa ações.

- Aqui está um exemplo de como usar when como uma declaração:
 */

fun main() {
    val obj = "Hello"
    when (obj) {
        // Verifica se obj é igual a "1"
        "1" -> println("One")
        // Verifica se obj é igual a "Hello"
        "Hello" -> println("Greeting")
        // Declaração padrão
        else -> println("Unknown")
    }
    // Greeting
}

/*
- Uma expressão retorna um valor que pode ser usado posteriormente no seu código.
- Aqui está um exemplo de como usar when como uma expressão. A expressão when é atribuída imediatamente a uma variável que é usada depois com a função println():
*/

fun main() {
    // sampleStart
    val obj = "Hello"

    val result = when (obj) {
        // Se obj for igual a "1", define result como "One"
        "1" -> "One"
        // Se obj for igual a "Hello", define result como "Greeting"
        "Hello" -> "Greeting"
        // Define result como "Unknown" se nenhuma das condições anteriores for satisfeita
        else -> "Unknown"
    }
    println(result)
    // Greeting
}

/*
- Os exemplos de when que você viu até agora todos tinham um sujeito: obj. Mas o when também pode ser usado sem um sujeito.
- Este exemplo usa uma expressão when sem um sujeito para verificar uma cadeia de expressões booleanas:
 */
fun main() {
    val trafficLightState = "Red" // Pode ser "Green", "Yellow" ou "Red"
    val trafficAction = when {
        trafficLightState == "Green" -> "Go"
        trafficLightState == "Yellow" -> "Slow down"
        trafficLightState == "Red" -> "Stop"
        else -> "Malfunction"
    }
    println(trafficAction)
    // Stop
}

// No entanto, você pode ter o mesmo código, mas com trafficLightState como o sujeito:
fun main() {
    val trafficLightState = "Red" // Pode ser "Green", "Yellow" ou "Red"
    val trafficAction = when (trafficLightState) {
        "Green" -> "Go"
        "Yellow" -> "Slow down"
        "Red" -> "Stop"
        else -> "Malfunction"
    }
    println(trafficAction)
    // Stop
}

/*
- Usar when com um sujeito torna seu código mais legível e fácil de manter.
- Quando você usa um sujeito com uma expressão when, isso também ajuda o Kotlin a verificar se todos os casos possíveis estão cobertos.
- Caso contrário, se você não usar um sujeito com uma expressão when, será necessário fornecer um ramo else.
 */

// EXERCÍCIOS
/*
1 - Crie um jogo simples onde você vence se o resultado de dois dados for o mesmo número.
Use if para imprimir "You win :)" se os dados coincidirem ou "You lose :(" caso contrário.
Neste exercício, você deve importar um pacote para usar a função Random.nextInt(), que gera um número inteiro aleatório.
Dica: Use o operador de igualdade == para comparar os resultados dos dados.

import	kotlin.random.Random
 fun	main()	{
 val	firstResult	=	Random.nextInt(6)
 val	secondResult	=	Random.nextInt(6)
 //	Write	your	code	here
 }
 */

import	kotlin.random.Random
fun	main()	{
    val	firstResult	=	Random.nextInt(6)
    val	secondResult	=	Random.nextInt(6)
    if	(firstResult	==	secondResult)
        println("You	win	:)")
    else
        println("You	lose	:(")
}

/*
2 - Usando uma expressão when, atualize o seguinte programa para que ele imprima as ações correspondentes ao inserir os nomes dos botões de um console de videogame:

Botão	Ação
A	    Yes
B	    No
X	    Menu
Y	    Nothing
Outro	There is no such button

fun	main()	{
    val	button	=	"A"
    println(
        //	Write	your	code	here
    )
}
*/

fun main() {
    val button = "A"

    println(
        when (button) {
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            "Y" -> "Nothing"
            else -> "There is no such button"
        }
    )
}

// INTERVALOS
/*
- Antes de falar sobre loops, é útil saber como construir intervalos para que os loops possam iterar sobre eles.
- A maneira mais comum de criar um intervalo em Kotlin é usar o operador ... Por exemplo, 1..4 é equivalente a 1, 2, 3, 4.
- Para declarar um intervalo que não inclui o valor final, use o operador ..<. Por exemplo, 1..<4 é equivalente a 1, 2, 3.
- Para declarar um intervalo em ordem reversa, use downTo. Por exemplo, 4 downTo 1 é equivalente a 4, 3, 2, 1.
- Para declarar um intervalo que incrementa com um passo diferente de 1, use step com o valor desejado. Por exemplo, 1..5 step 2 é equivalente a 1, 3, 5.

Você também pode usar intervalos com caracteres (Char):
- 'a'..'d' é equivalente a 'a', 'b', 'c', 'd'.
- 'z' downTo 's' step 2 é equivalente a 'z', 'x', 'v', 't'.
*/

// LOOPS (LAÇOS DE REPETIÇÃO)
/*
- As duas estruturas de loop mais comuns na programação são for e while.
- Use for para iterar sobre um intervalo de valores e executar uma ação.
- Use while para continuar executando uma ação até que uma determinada condição seja satisfeita.
*/

// FOR
// Com o conhecimento sobre intervalos (ranges), podemos criar um loop for que percorre os números de 1 a 5 e imprime cada número:
fun main() {
    for (number in 1..5) {
        // number é o iterador e 1..5 é o intervalo
        print(number)
    }
    // Saída: 12345
}

//INTERANDO SOBRE COLEÇÕES
// Também podemos iterar sobre listas com um for:
fun main() {
    val cakes = listOf("cenoura", "queijo", "chocolate")

    for (cake in cakes) {
        println("Delicioso, é um bolo de $cake!")
    }
    // Saída:
    // Delicioso, é um bolo de cenoura!
    // Delicioso, é um bolo de queijo!
    // Delicioso, é um bolo de chocolate!
}

// WHILE
/*
O while pode ser usado de duas formas:
- Para executar um bloco de código enquanto uma expressão condicional for verdadeira (while).
- Para executar o bloco de código primeiro e depois verificar a expressão condicional (do-while).
*/

// USO DO WHILE
/*
- Declare a expressão condicional dentro de parênteses ().
- Adicione a ação que deseja executar dentro de chaves {}.
- Exemplo com incremento (++):
*/
fun main() {
    var cakesEaten = 0
    while (cakesEaten < 3) {
        println("Comer um bolo")
        cakesEaten++
    }
    // Saída:
    // Comer um bolo
    // Comer um bolo
    // Comer um bolo
}

// USO DO DO-WHILE
/*
- O bloco de código é executado pelo menos uma vez, pois a verificação acontece depois da execução.
- Declare a ação dentro de chaves {} usando a palavra-chave do.
- Defina a condição de repetição depois da palavra while.
*/
fun main() {
    var cakesEaten = 0
    var cakesBaked = 0

    while (cakesEaten < 3) {
        println("Comer um bolo")
        cakesEaten++
    }

    do {
        println("Assar um bolo")
        cakesBaked++
    } while (cakesBaked < cakesEaten)

    // Saída:
    // Comer um bolo
    // Comer um bolo
    // Comer um bolo
    // Assar um bolo
    // Assar um bolo
    // Assar um bolo
}

// EXERCÍCIOS
/*
1 - Você tem um programa que conta fatias de pizza até formar uma pizza inteira com 8 fatias. Refatore esse programa de duas formas:
- Usando um loop while
- Usando um loop do-while

fun	main()	{
    var	pizzaSlices	=	0
    //	Start	refactoring	here
    pizzaSlices++
    println("There's	only	$pizzaSlices	slice/s	of	pizza	:(")
    pizzaSlices++
    println("There's	only	$pizzaSlices	slice/s	of	pizza	:(")
    85
    pizzaSlices++
    println("There's	only	$pizzaSlices	slice/s	of	pizza	:(")
    pizzaSlices++
    println("There's	only	$pizzaSlices	slice/s	of	pizza	:(")
    pizzaSlices++
    println("There's	only	$pizzaSlices	slice/s	of	pizza	:(")
    pizzaSlices++
    println("There's	only	$pizzaSlices	slice/s	of	pizza	:(")
    pizzaSlices++
    println("There's	only	$pizzaSlices	slice/s	of	pizza	:(")
    pizzaSlices++
    //	End	refactoring	here
    println("There	are	$pizzaSlices	slices	of	pizza.	Hooray!	We	have	a	whole	pizza!	:D")
*/

fun main() {
    var pizzaSlices = 0
    while (pizzaSlices < 7) {
        pizzaSlices++
        println("Só há $pizzaSlices fatia(s) de pizza :(")
    } // else só pode ser utilizado na condição do if 
    pizzaSlices++ // aqui resultamos em 8 fatias
    println("Agora temos $pizzaSlices fatias de pizza. Oba! Temos uma pizza inteira! :D")
}

fun main() {
    var pizzaSlices = 0
    pizzaSlices++ // contamos a fatia
    do {
        println("Só há $pizzaSlices fatia(s) de pizza :(") // Ele imprime a quantidade de fatias de pizza disponíveis.
        pizzaSlices++ // Depois de imprimir, aumenta o número de fatias
    } while (pizzaSlices < 8) // O while (pizzaSlices < 8) verifica se a pizza ainda está incompleta (menos de 8 fatias).

    println("Agora temos $pizzaSlices fatias de pizza. Oba! Temos uma pizza inteira! :D")
}

// Outro jeito de fazer:
fun main() {
    var pizzaSlices = 0
    do {
        pizzaSlices++ 
        println("Só há $pizzaSlices fatia(s) de pizza :(") 
    } while (pizzaSlices < 8) 

    println("Agora temos $pizzaSlices fatias de pizza. Oba! Temos uma pizza inteira! :D")
} 
	
/*
2 - Escreva um programa que simula o jogo FizzBuzz. O programa deve imprimir números de 1 a 100, substituindo:
- Números divisíveis por 3 por "fizz"
- Números divisíveis por 5 por "buzz"
- Números divisíveis por 3 e 5 por "fizzbuzz"

fun	main()	{
    //	Write	your	code	here
}
*/

fun main() {
    for (number in 1..100) {
        println(
            when {
                number % 15 == 0 -> "fizzbuzz"
                number % 3 == 0 -> "fizz"
                number % 5 == 0 -> "buzz"
                else -> "$number"
            }
        )
    }
}

// Outro jeito de fazer
fun main() {
    for (number in 1..100) {
        println(
            when {
                number % 3 == 0 && number % 5 == 0 -> "fizzbuzz"
                number % 3 == 0 -> "fizz"
                number % 5 == 0 -> "buzz"
                else -> "$number"
            }
        )
    }
} 

/*
3 - Você tem uma lista de palavras. Use um for e um if para imprimir apenas as palavras que começam com a letra "l".

fun	main()	{
    val	words	=	listOf("dinosaur",	"limousine",	"magazine",	"language")
    //	Write	your	code	here
}
*/

 fun	main()	{
     val	words	=	listOf("dinosaur",	"limousine",	"magazine",	"language")
     for	(w	in	words)	{ // w é uma variável que eu criei para apontar para cada elemento da lista
         if	(w.startsWith("l"))
         println(w)
    }
 }
// startsWith("l", ignoreCase = true): verifica se a palavra começa com "l", ignorando se a letra está maiúscula ou minúscula.

// EXERCÍCIOS FEITOS POR MIM 
/*
Questão: Qual a diferença entre usar if/else como declaração e como expressão em Kotlin?
Dica: Como declaração, não retorna valor; como expressão, o resultado do if pode ser atribuído a uma variável.
- 

Questão: Explique o que é o when em Kotlin e quando ele pode ser uma opção melhor do que vários if/else.
Dica: Fale sobre legibilidade do código, facilidade de adicionar casos extras e cobertura de casos.
- O when é uma expressão de múltiplas opções em Kotlin, que pode ser usada como uma alternativa mais legível ao uso de várias instruções if/else. Ele pode ser mais eficiente e limpo em situações com múltiplos casos.
- O when é mais útil quando se tem várias condições a serem verificadas para um único valor, e ele permite adicionar facilmente mais casos sem comprometer a legibilidade.

Questão: Em que situações podemos usar um when sem um “sujeito” (isto é, sem (obj) ao lado)? Dê um exemplo.
Dica: Lembre-se do caso em que avaliamos várias expressões booleanas em vez de comparar contra um único valor.
- Um when sem sujeito pode ser usado quando se deseja avaliar várias expressões booleanas ou condições. Em vez de verificar uma única variável ou valor, você pode usar condições diretamente dentro do when.

Questão: O que são intervalos (ranges) em Kotlin e para que servem? Dê exemplos de pelo menos dois operadores de intervalo.
Dica: Mostre exemplos com .., ..<, downTo, e step.
- Intervalos em Kotlin representam um conjunto de valores em uma sequência. Eles são úteis para realizar verificações e iterações em um conjunto de números ou caracteres.

Questão: Qual a diferença entre um while e um do-while?
Dica: Fale sobre a ordem de execução e se o bloco é executado ao menos uma vez ou não.
- while: O loop while executa o bloco de código enquanto a condição for verdadeira. Ele verifica a condição antes de executar o código, então pode não ser executado nenhuma vez se a condição for falsa desde o início.
- do-while: O loop do-while sempre executa o código ao menos uma vez, pois verifica a condição após a execução do bloco.

Exercício: Crie um programa que leia um valor inteiro de 1 a 7 e use uma expressão when para imprimir o dia da semana correspondente 
(por exemplo, 1 -> “Segunda-feira”, 2 -> “Terça-feira” etc.).
a) Se o valor não estiver entre 1 e 7, imprima “Dia inválido”.
*/
fun main() {
    val dia = readLine()?.toIntOrNull() ?: 0
    when (dia) {
        1 -> println("Segunda-feira")
        2 -> println("Terça-feira")
        3 -> println("Quarta-feira")
        4 -> println("Quinta-feira")
        5 -> println("Sexta-feira")
        6 -> println("Sábado")
        7 -> println("Domingo")
        else -> println("Dia inválido")
    }
}

/*
Exercício: Usando intervalos e um loop for, imprima todos os números de 10 a 1 em ordem decrescente.
Dica: Use 10 downTo 1.
*/
for (i in 10 downTo 1) {
    println(i)
}

/*
Exercício: Crie um programa que, usando um loop for e step, imprima apenas os números pares de 0 a 20.
Dica: Use 0..20 step 2.
*/
fun main() {
    for (number in 0..20 step 2) {
        println(number)
    }
}

/*
Exercício: Declare uma variável contador começando em 10. Use um loop while para continuar decrementando contador até que ele seja 0. 
A cada iteração, imprima o valor atual de contador.
Dica: Lembre de decrementar (--) o contador dentro do loop.
*/
var contador = 10
while (contador > 0) {
    println(contador)
    contador--
}


/*
Exercício: Escreva um programa que peça um valor de entrada para o usuário (por exemplo, usando readLine()?.toIntOrNull()).
a) Use um loop do-while para somar todos os valores digitados até que o usuário digite 0.
b) Quando o usuário digitar 0, exiba a soma total.
Dica: Como se trata de um laço que executa ao menos uma vez, o do-while é apropriado.
*/
fun main() {
    var soma = 0
	var numero: Int
	do {
        println("Digite um número:")
        numero = readLine()?.toIntOrNull() ?: 0
        soma += numero
	} while (numero != 0)
	println("Soma total: $soma")
}


/*
Exercício: Crie uma lista com algumas strings, por exemplo: val fruits = listOf("apple", "banana", "cherry", "avocado"). 
Use um loop for e um if para imprimir apenas as frutas que não contêm a letra “a”.
Dica: Você pode usar !fruta.contains("a") no if.
*/
fun main() {
    val fruits = listOf("apple", "banana", "cherry", "avocado")
	for (fruit in fruits) {
   		if (!fruit.contains("a")) {
        	println(fruit)
    	}
	}
}

/*
Exercício: Escreva um programa que simule um menu de opções usando o when. As opções podem ser:
1 -> "Iniciar jogo"
2 -> "Carregar jogo"
3 -> "Sair"
Dica: Caso o usuário informe uma opção inválida, mostre “Opção inválida”.
*/
fun main() {
    println("Escolha uma opção:")
    println("1 -> Iniciar jogo")
    println("2 -> Carregar jogo")
    println("3 -> Sair")
    val opcao = readLine()?.toIntOrNull() ?: 0
    when (opcao) {
        1 -> println("Iniciar jogo")
        2 -> println("Carregar jogo")
        3 -> println("Sair")
        else -> println("Opção inválida")
    }
}
