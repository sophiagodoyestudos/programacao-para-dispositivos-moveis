// FUNÇÕES
// Você pode declarar suas próprias funções em Kotlin usando a palavra-chave fun.
fun hello() {
    return println("Hello, world!")
}

fun main() {
    hello()
    // Hello, world!
}

/*
Em Kotlin:
- Os parâmetros da função são escritos dentro de parênteses ().
- Cada parâmetro deve ter um tipo, e múltiplos parâmetros devem ser separados por vírgulas ,.
- O tipo de retorno é escrito após os parênteses (), separado por dois pontos :.
- O corpo de uma função é escrito dentro de chaves {}.
- A palavra-chave return é usada para sair ou retornar algo de uma função.
*/

// Se uma função não retorna nada útil, o tipo de retorno e a palavra-chave return podem ser omitidos

/*
No exemplo a seguir:
- x e y são parâmetros da função.
- x e y têm o tipo Int.
- O tipo de retorno da função é Int.
- A função retorna a soma de x e y quando chamada.
*/

fun sum(x: Int, y: Int): Int {
    return x + y
}

fun main() {
    println(sum(1, 2))
    // 3
}

// Recomendamos, conforme nossas convenções de codificação, que você nomeie funções começando com uma letra minúscula e use o camelCase, sem sublinhados (_).

// ARGUMENTOS NOMEADOS
/*
- Para um código mais conciso, ao chamar sua função, não é necessário incluir os nomes dos parâmetros.
- No entanto, incluí-los torna o código mais fácil de ler. Isso é chamado de uso de argumentos nomeados.
- Se você incluir os nomes dos parâmetros, poderá escrevê-los em qualquer ordem.
*/

/*
No exemplo a seguir:
- Templates de string ($) são usados para acessar os valores dos parâmetros, convertê-los para o tipo String e concatená-los em uma única string para impressão.
*/
fun printMessageWithPrefix(message: String, prefix: String) {
    println("[$prefix] $message")
}

fun main() {
    // Usa argumentos nomeados com ordem trocada dos parâmetros
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    // [Log] Hello
}

// VALORES PADRÃO PARA PARÂMETROS
/*
- Você pode definir valores padrão para os parâmetros da sua função.
- Qualquer parâmetro com um valor padrão pode ser omitido ao chamar a função.
- Para declarar um valor padrão, use o operador de atribuição = após o tipo do parâmetro.
 */
fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun main() {
    // Função chamada com ambos os parâmetros
    printMessageWithPrefix("Hello", "Log")
    // [Log] Hello

    // Função chamada apenas com o parâmetro message
    printMessageWithPrefix("Hello")
    // [Info] Hello

    printMessageWithPrefix(prefix = "Log", message = "Hello")
    // [Log] Hello
}

// FUNÇÕES SEM RETORNO
/*
Funções sem Retorno
- Você pode pular parâmetros específicos que possuem valores padrão, em vez de omitir todos.
- No entanto, após pular o primeiro parâmetro, é obrigatório nomear todos os parâmetros subsequentes.
 */

// FUNÇÕES SEM RETORNO
/*
- Você pode pular parâmetros específicos que possuem valores padrão, em vez de omitir todos.
- No entanto, após pular o primeiro parâmetro, é obrigatório nomear todos os parâmetros subsequentes.
- Se sua função não retorna um valor útil, seu tipo de retorno é Unit. O Unit é um tipo que possui apenas um valor – Unit.
- Não é necessário declarar explicitamente que a função retorna Unit, ou seja, não é obrigatório usar a palavra-chave return nem declarar um tipo de retorno.
 */

fun printMessage(message: String) {
    println(message)
    // `return Unit` ou `return` é opcional
}

fun main() {
    printMessage("Hello")
    // Hello
}

// FUNÇÕES DE EXPRESSÃO ÚNICA
// Para tornar seu código mais conciso, você pode usar funções de expressão única.
//Por exemplo, a função sum() pode ser reduzida:
fun sum(x: Int, y: Int): Int {
    return x + y
}

fun main() {
    println(sum(1, 2))
    // 3
}

// A mesma função pode ser escrita de forma mais compacta:
fun sum(x: Int, y: Int) = x + y

fun main() {
    println(sum(1, 2))
    // 3
}

/*
Como funciona?
- Você pode remover as chaves {} e declarar o corpo da função usando o operador de atribuição =.
- Quando você usa =, o Kotlin aplica inferência de tipo, então o tipo de retorno pode ser omitido.
- A função sum() pode ser escrita em uma única linha.
- No entanto, para facilitar o entendimento do código por outros desenvolvedores, é uma boa prática definir explicitamente o tipo de retorno, mesmo ao usar =.
- Importante: Se você usar {} para declarar o corpo da função, é obrigatório declarar o tipo de retorno, a menos que ele seja Unit.
 */

// RETORNOS ANTECIPADOS EM FUNÇÕES
/*
- Para interromper a execução do código em um determinado ponto dentro de uma função, utilize a palavra-chave return.
- No exemplo abaixo, if é usado para retornar antecipadamente da função caso uma condição seja verdadeira:
 */
// Lista de nomes de usuário já registrados
val registeredUsernames = mutableListOf("john_doe", "jane_smith")

// Lista de e-mails já registrados
val registeredEmails = mutableListOf("john@example.com", "jane@example.com")

fun registerUser(username: String, email: String): String {
    // Retorno antecipado se o nome de usuário já estiver em uso
    if (username in registeredUsernames) {
        return "Nome de usuário já existe. Escolha um nome diferente."
    }

    // Retorno antecipado se o e-mail já estiver registrado
    if (email in registeredEmails) {
        return "E-mail já registrado. Use um e-mail diferente."
    }

    // Prossegue com o registro caso o nome de usuário e o e-mail não estejam em uso
    registeredUsernames.add(username)
    registeredEmails.add(email)

    return "Usuário registrado com sucesso: $username"
}

fun main() {
    println(registerUser("john_doe", "newjohn@example.com"))
    // Nome de usuário já existe. Escolha um nome diferente.

    println(registerUser("new_user", "newuser@example.com"))
    // Usuário registrado com sucesso: new_user
}

// EXERCÍCIOS
/*
1 - Escreva uma função chamada circleArea que recebe o raio de um círculo como um inteiro e retorna a área desse círculo.
- Neste exercício, importamos um pacote para acessar o valor de π (PI).

import	kotlin.math.PI
 //	Write	your	code	here
 fun	main()	{
    println(circleArea(2))
 }
 */

import	kotlin.math.PI
fun	circleArea(radius:	Int):	Double	{
    return	PI	*	radius	*	radius
}
fun	main()	{
    println(circleArea(2))	//	12.566370614359172
}

/*
2 - Reescreva a função circleArea do exercício anterior como uma função de expressão única.
*/

import	kotlin.math.PI
fun	circleArea(radius:	Int):	Double	=	PI	*	radius	*	radius

fun	main()	{
    println(circleArea(2))	//	12.566370614359172
}

/*
3 - Você tem uma função que converte um intervalo de tempo, dado em horas, minutos e segundos, para segundos.
- Na maioria dos casos, apenas um ou dois parâmetros são passados, enquanto o restante é igual a 0.
- Melhore a função usando valores padrão para os parâmetros e argumentos nomeados, tornando o código mais legível.

 fun	intervalInSeconds(hours:	Int,	minutes:	Int,	seconds:	Int)	=
        ((hours	*	60)	+	minutes)	*	60	+	seconds


fun main () {
     println(intervalInSeconds(1,	20,	15))
     println(intervalInSeconds(0,	1,	25))
     println(intervalInSeconds(2,	0,	0))
     println(intervalInSeconds(0,	10,	0))
     println(intervalInSeconds(1,	0,	1))
 }
*/

// A função original recebia três parâmetros obrigatórios: hours, minutes e seconds. 
// Isso significa que toda vez que a função era chamada, era necessário fornecer os três valores, mesmo que fossem 0.
// Agora, os parâmetros hours, minutes e seconds têm valores padrão (0).
// Se um valor não for fornecido na chamada da função, ele automaticamente será 0.
fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) =
    ((hours * 60) + minutes) * 60 + seconds

// Na versão original, a função precisava receber todos os parâmetros sempre, mesmo que alguns fossem 0. 
// Agora, com valores padrão, podemos chamar a função de forma mais legível e flexível.
fun main() {
    println(intervalInSeconds(1, 20, 15)) // 4815 segundos
    println(intervalInSeconds(minutes = 1, seconds = 25)) // 85 segundos
    println(intervalInSeconds(hours = 2)) // 7200 segundos
    println(intervalInSeconds(minutes = 10)) // 600 segundos
    println(intervalInSeconds(hours = 1, seconds = 1)) // 3601 segundos
}

// EXPRESSÕES LAMBDA
/*
- O Kotlin permite escrever código ainda mais conciso para funções usando expressões lambda.
- Por exemplo, a seguinte função uppercaseString():
 */
fun uppercaseString(text: String): String {
    return text.uppercase()
}

fun main() {
    println(uppercaseString("hello"))
    // HELLO
}

// Também pode ser escrita como uma expressão lambda:
fun main() {
    val upperCaseString = { text: String -> text.uppercase() }
    println(upperCaseString("hello"))
    // HELLO
}

/*
As expressões lambda podem ser difíceis de entender à primeira vista, então vamos analisá-las:
- As expressões lambda são escritas dentro de chaves {}.
- Dentro da expressão lambda, você escreve:
- Os parâmetros seguidos de ->.
- O corpo da função após o ->.

No exemplo anterior:
- text é um parâmetro da função.
- text tem o tipo String.
- A função retorna o resultado da chamada de .uppercase() em text.

- Toda a expressão lambda é atribuída à variável upperCaseString usando o operador de atribuição =.
- A expressão lambda é chamada usando a variável upperCaseString como uma função, passando a string "hello" como parâmetro.
- A função println() imprime o resultado.
 */

// Se você declarar uma lambda sem parâmetros, não há necessidade de usar ->.
// Por exemplo:

{ println("Log message") }

/*
- As expressões lambda podem ser usadas de várias maneiras. Você pode:
- Passar uma expressão lambda como parâmetro para outra função.
- Retornar uma expressão lambda de uma função.
- Invocar uma expressão lambda por conta própria.
 */

// PASSANDO PARA OUTRA FUNÇÃO
// Um ótimo exemplo de quando é útil passar uma expressão lambda para uma função é ao usar o .filter().
fun main() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)

    val positives = numbers.filter({ x -> x > 0 })
    val isNegative = { x: Int -> x < 0 }
    val negatives = numbers.filter(isNegative)

    println(positives)
    // [1, 3, 5]
    println(negatives)
    // [-2, -4, -6]
}

/*
A função .filter() aceita uma expressão lambda como um predicado:
- { x -> x > 0 } percorre cada elemento da lista e retorna apenas os que são positivos.
- { x -> x < 0 } percorre cada elemento da lista e retorna apenas os que são negativos.

Este exemplo demonstra duas maneiras de passar uma expressão lambda para uma função:
- Para números positivos, a expressão lambda é passada diretamente na função .filter().
- Para números negativos, a expressão lambda é atribuída à variável isNegative.
- Depois, a variável isNegative é usada como parâmetro na função .filter(). Nesse caso, é necessário especificar o tipo do parâmetro (x) na expressão lambda.
*/

// Se a expressão lambda for o único parâmetro da função, você pode remover os parênteses:
val positives = numbers.filter { x -> x > 0 }
// Isso é um exemplo de trailing lambda, um conceito discutido mais detalhadamente no final deste capítulo.

// Outro bom exemplo é o uso da função .map(), que transforma itens dentro de uma coleção:
fun main() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)

    val doubled = numbers.map { x -> x * 2 }
    val isTripled = { x: Int -> x * 3 }
    val tripled = numbers.map(isTripled)

    println(doubled)
    // [2, -4, 6, -8, 10, -12]
    println(tripled)
    // [3, -6, 9, -12, 15, -18]
}
/*
A função .map() aceita uma expressão lambda como uma função de transformação:
- { x -> x * 2 } percorre cada elemento da lista e retorna o valor multiplicado por 2.
- { x -> x * 3 } percorre cada elemento da lista e retorna o valor multiplicado por 3.
*/

// TIPOS DE FUNÇÃO
/*
- Antes de você poder retornar uma expressão lambda de uma função, é necessário entender os tipos de funções.
- Você já aprendeu sobre os tipos básicos, mas as funções também possuem um tipo.
- A inferência de tipos do Kotlin pode deduzir o tipo de uma função a partir do tipo dos parâmetros.
- No entanto, pode haver situações em que você precisa especificar explicitamente o tipo da função.
- O compilador precisa do tipo da função para saber o que é e o que não é permitido para essa função.

A sintaxe para um tipo de função é:
- O tipo de cada parâmetro é escrito entre parênteses () e separado por vírgulas ,.
- O tipo de retorno é escrito após o ->.
 */

// Por exemplo: (String) -> String ou (Int, Int) -> Int.
// É assim que uma expressão lambda se parece quando um tipo de função para upperCaseString() é definido:
val upperCaseString: (String) -> String = { text -> text.uppercase() }
fun main() {
    println(upperCaseString("hello"))
    // HELLO
}

/*
- Se a sua expressão lambda não tiver parâmetros, então os parênteses () são deixados vazios. Por exemplo: () -> Unit.
- Você deve declarar os tipos dos parâmetros e do retorno, seja na expressão lambda ou como um tipo de função.
- Caso contrário, o compilador não será capaz de saber qual é o tipo da sua expressão lambda.
- Por exemplo, o seguinte não funcionará:
*/

val upperCaseString = { str -> str.uppercase() }

// RETORNO DE UMA FUNÇÃO
/*
- Expressões lambda podem ser retornadas de uma função.
- Para que o compilador entenda qual tipo a expressão lambda retornada tem, você deve declarar um tipo de função.
- No exemplo a seguir, a função toSeconds() tem o tipo de função (Int) -> Int porque ela sempre retorna uma expressão lambda que recebe um parâmetro do
tipo Int e retorna um valor Int.
- Este exemplo utiliza uma expressão when para determinar qual expressão lambda é retornada quando toSeconds() é chamada:
*/

fun toSeconds(time: String): (Int) -> Int = when (time) {
    "hour" -> { value -> value * 60 * 60 }
    "minute" -> { value -> value * 60 }
    "second" -> { value -> value }
    else -> { value -> value }
}

fun main() {
    val timesInMinutes = listOf(2, 10, 15, 1)
    val min2sec = toSeconds("minute")
    val totalTimeInSeconds = timesInMinutes.map(min2sec).sum()
    println("Total time is $totalTimeInSeconds secs")
    // Total time is 1680 secs
}

// INVOCAR SEPARADAMENTE
// Expressões lambda podem ser invocadas por conta própria, adicionando parênteses () após as chaves {} e incluindo quaisquer parâmetros dentro dos parênteses:
fun main() {
    println({ text: String -> text.uppercase() }("hello"))
    // HELLO
}

// LAMBDAS COM PARÂMETROS FINAIS (TRAILING LAMBDAS)
/*
- Como você já viu, se uma expressão lambda for o único parâmetro de uma função, você pode omitir os parênteses da função ().
- Se uma expressão lambda for passada como o último parâmetro de uma função, a expressão pode ser escrita fora dos parênteses da função.
- Em ambos os casos, essa sintaxe é chamada de "trailing lambda".
 */

// Por exemplo, a função .fold() aceita um valor inicial e uma operação:
fun main() {
    // O valor inicial é zero.
    // A operação soma o valor inicial com cada item na lista de forma cumulativa.
    println(listOf(1, 2, 3).fold(0, { x, item -> x + item }))  // 6
    // Alternativamente, na forma de uma trailing lambda
    println(listOf(1, 2, 3).fold(0) { x, item -> x + item })    // 6
}

// EXERCÍCIOS
// 1 - Você tem uma lista de ações suportadas por um serviço web, um prefixo comum para todas as requisições e um ID de um recurso específico. 
// Para solicitar o título de uma ação sobre o recurso com ID: 5, você precisa criar a seguinte URL:
/*
fun main() {
    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5
    val urls = // Escreva seu código aqui
    println(urls)
}
*/

fun main() {
    val actions = listOf("title", "year", "author") // Lista de ações suportadas
    val prefix = "https://example.com/book-info"  // Prefixo base da URL
    val id = 5  // ID do recurso específico

    // Usando map() para transformar cada ação em uma URL completa
    // O método map percorre a lista actions e para cada elemento (action), cria uma string no formato:
    // EX: "https://example.com/book-info/5/author"
    val urls = actions.map { action -> "$prefix/$id/$action" }

    println(urls)  // Exibe a lista de URLs geradas
}

// 2 - Escreva uma função que receba um valor do tipo Int e uma ação (uma função do tipo () -> Unit), que então repete a ação o número especificado de vezes.
// Em seguida, use essa função para imprimir "Hello" 5 vezes.
/*
fun repetirN(vezes: Int, acao: () -> Unit) {
    // Escreva seu código aqui
}

fun main() {
    // Escreva seu código aqui
}
*/

// Função que repete uma ação 'vezes' vezes
fun repetirN(vezes: Int, acao: () -> Unit) {
    for (i in 1..vezes) { // Repete a ação 'vezes' vezes
        acao() // Executa a ação recebida como parâmetro
    }
}

fun main() {
    // Chama a função repetirN passando 5 e uma ação que imprime "Hello"
    repetirN(5) {
        println("Hello")
    }
}

// EXERCÍCIOS FEITOS POR MIM 
/*
Questão: Qual é a sintaxe básica para declarar uma função em Kotlin e como se especifica o tipo de retorno?
Dica: Explique o uso de fun, parâmetros entre parênteses e o : TipoRetorno.
- A sintaxe básica para declarar uma função em Kotlin usa a palavra-chave fun, seguida pelo nome da função, os parâmetros entre parênteses e o tipo de retorno após :.

Questão: O que são argumentos nomeados em Kotlin? Dê um exemplo de como eles podem tornar o código mais legível.
Dica: Mostre como chamar a função, invertendo a ordem dos parâmetros e especificando explicitamente nomeDoParametro = valor.
- Os argumentos nomeados permitem especificar o nome do parâmetro ao chamar uma função, tornando o código mais legível.

Questão: Explique o que são valores padrão de parâmetros em uma função. Em que casos eles podem ser úteis?
Dica: Destaque como isso evita sobrecarga (overload) de funções e torna as chamadas mais claras.
- Os valores padrão permitem definir um valor para um parâmetro caso ele não seja informado.

Questão: O que são funções de expressão única em Kotlin? Em que situações elas podem ser vantajosas?
Dica: Fale sobre concisão do código e inferência de tipo de retorno.
- São funções escritas em uma única linha usando a sintaxe =, sem {} e return.

Questão: Qual é a diferença entre declarar explicitamente o retorno de uma função como Unit e não declarar o tipo de retorno em Kotlin?
Dica: Lembre-se de que Unit é o análogo a “nenhum valor útil” e que especificar ou não é opcional.
- Ambos indicam que a função não retorna um valor útil, mas Unit pode ser especificado explicitamente.

Questão: Explique o que são expressões lambda em Kotlin e dê um exemplo simples.
Dica: Descreva a sintaxe básica { parametros -> corpo } e como invocar.
- Uma lambda é uma função anônima com a sintaxe { parâmetros -> corpo }.

Questão: O que são tipos de função em Kotlin? Dê um exemplo de declaração de variável que aceite uma função como valor.
Dica: Mostre algo como val nomeVariavel: (TipoParametro) -> TipoRetorno = { parametro -> ... }.
- Tipos de função permitem armazenar funções em variáveis.

Questão: Como funciona o retorno antecipado de uma função em Kotlin? Por que isso pode ser útil?
Dica: Fale sobre o uso de return dentro do corpo da função para sair antes de completar todas as instruções.
- O return pode ser usado para sair de uma função antes da execução completa.

Questão: O que é a sintaxe de trailing lambda e em que casos ela pode ser aplicada?
Dica: Mostre quando a expressão lambda é passada como último parâmetro de uma função e pode ser movida para fora dos parênteses.
- Quando uma função recebe uma lambda como último parâmetro, pode-se movê-la para fora dos parênteses.

Exercício: Crie uma função chamada multiply que receba dois valores inteiros x e y, e retorne o produto (multiplicação) deles.
- Chame a função no main imprimindo o resultado de multiply(3, 4)
*/
fun multiply (x: Int, y: Int): Int {
    return x * y
}

fun main(){
    println(multiply(3,4))
}


/*
Exercício: Reescreva a função multiply do exercício anterior como uma função de expressão única.
- Mantenha a assinatura fun multiply(x: Int, y: Int): Int.
*/
fun multiply (x: Int, y: Int): Int = x * y

fun main(){
    println(multiply(3,4))
}

/*
Exercício: Crie uma função introduceYourself com dois parâmetros: name (String) e age (Int, com valor padrão igual a 0).
- Se age não for especificado, imprima “Meu nome é X e eu prefiro não dizer minha idade.”
- Caso contrário, imprima “Meu nome é X e eu tenho Y anos.”
*/
fun introduceYourself(name: String, age: Int = 0) {
    if (age == 0) {
        println("Meu nome é $name e prefiro não dizer minha idade.")
    } else {
        println("Meu nome é $name e tenho $age anos.")
    }
}

fun main() {
    introduceYourself("Ana")
    introduceYourself("Carlos", 25)
}

/*
Exercício: Converta a função abaixo em uma expressão lambda armazenada em uma variável:
fun doubleString(text: String): String {
    return text.repeat(2)
}
Use a sintaxe { text: String -> ... } e teste chamando a lambda diretamente.
*/
val doubleString: (String) -> String = { text -> text.repeat(2) }

fun main() {
    println(doubleString("Kotlin")) // KotlinKotlin
}

/*
Exercício: Crie uma função chamada executeNTimes que receba dois parâmetros:
- n: quantidade de vezes que uma ação será executada (Int)
- action: uma função do tipo () -> Unit
- Dentro de executeNTimes, repita action() exatamente n vezes.
- No main, invoque executeNTimes(3) { println("Hello!") }.
*/
fun executeNTimes(n: Int, action: () -> Unit) {
    repeat(n) { action() }
}

fun main() {
    executeNTimes(3) { println("Hello!") }
}

/*
Exercício: Implemente uma função maxValueOperation que retorna uma lambda:
fun maxValueOperation(condition: String): (Int, Int) -> Int {
    // ...
}
Se condition for "sum", retorne uma lambda que receba dois valores e retorne a soma deles.
Se condition for "mul", retorne uma lambda que receba dois valores e retorne a multiplicação.
Caso contrário, retorne uma lambda que retorne sempre 0.
Teste chamando algo como val operation = maxValueOperation("sum"); println(operation(3, 5)).
*/
fun maxValueOperation(condition: String): (Int, Int) -> Int {
    return when (condition) {
        "sum" -> { a, b -> a + b }
        "mul" -> { a, b -> a * b }
        else -> { _, _ -> 0 }
    }
}

fun main() {
    val operation = maxValueOperation("sum")
    println(operation(3, 5)) // 8
}

/*
Exercício: Dada a lista de números val nums = listOf(1, 3, -2, 5, -1, 7), use as funções filter e map com expressões lambda para:
- Obter apenas os valores negativos e imprimir a lista resultante.
- Dobrar todos os valores positivos e imprimir a lista resultante.
*/
fun main() {
    val nums = listOf(1, 3, -2, 5, -1, 7)

    val negativos = nums.filter { it < 0 }
    println(negativos) 

    val dobrados = nums.map { if (it > 0) it * 2 else it }
    println(dobrados) 
}

/*
Exercício (Desafio): Crie uma função buildGreeting que receba um langCode: String e retorne uma lambda do tipo (String) -> String.
- Se langCode for "pt", retorne uma lambda que receba um nome e retorne “Olá, NOME!”.
- Se langCode for "en", retorne uma lambda que receba um nome e retorne “Hello, NAME!”.
- Caso contrário, retorne uma lambda que receba um nome e retorne “Hi, NAME!”.
- No main, teste essa função chamando algo como:
val greetPT = buildGreeting("pt")
println(greetPT("Carlos"))

val greetEN = buildGreeting("en")
println(greetEN("Jane"))
*/
fun buildGreeting(langCode: String): (String) -> String {
    return when (langCode) {
        "pt" -> { name -> "Olá, $name!" }
        "en" -> { name -> "Hello, $name!" }
        else -> { name -> "Hi, $name!" }
    }
}

fun main() {
    val greetPT = buildGreeting("pt")
    println(greetPT("Carlos")) // Olá, Carlos!

    val greetEN = buildGreeting("en")
    println(greetEN("Jane")) // Hello, Jane!
}
