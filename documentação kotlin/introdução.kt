// HELLO WORLD
fun main() {
    println("Hello, world!")
    // Hello, world!
}

// EM KOTLIN
/*
- fun é usado para declarar uma função.
- A função main() é onde seu programa começa.
- O corpo de uma função é escrito dentro de chaves {}.
- As funções println() e print() exibem seus argumentos na saída padrão.
- Uma função é um conjunto de instruções que executa uma tarefa específica.
- Uma vez que você cria uma função, pode usá-la sempre que precisar realizar essa tarefa, sem precisar escrever as instruções novamente.
- As funções serão discutidas com mais detalhes em alguns capítulos. Até lá, todos os exemplos usarão a função main().
 */

// VARIÁVEIS
/*
- Todos os programas precisam armazenar dados, e as variáveis ajudam você a fazer exatamente isso.
- Em Kotlin, você pode declarar:
- Variáveis imutáveis com val - não posso mudar ao longo do programa
- Variáveis mutáveis com var - posso modificar ao longo do programa

- Você não pode alterar uma variável imutável depois que atribuir um valor a ela.
- Para atribuir um valor, use o operador de atribuição =.
*/

fun main() {
    val popcorn = 5
    val hotdog = 7
    // Existem 5 caixas de pipoca
    // Existem 7 cachorros-quentes

    var customers = 10 // Existem 10 clientes na fila - Como customers é uma variável mutável, seu valor pode ser reatribuído após a declaração.
    // Alguns clientes saem da fila
    customers = 8
    println(customers) // 8
}

// Variáveis podem ser declaradas fora da função main(), no início do programa. Variáveis declaradas dessa forma são chamadas de variáveis de nível superior.
// Recomendamos que você declare todas as variáveis como imutáveis (val) por padrão. Use var apenas se necessário.

// TEMPLATES DE STRINGS
/*
- É útil saber como imprimir o conteúdo de variáveis na saída padrão. Você pode fazer isso com templates de strings.
- Os expressões de template permitem acessar dados armazenados em variáveis e outros objetos, convertendo-os em strings.
- Um valor do tipo string é uma sequência de caracteres delimitada por aspas duplas "
- As expressões de template sempre começam com um cifrão $
- Para avaliar um trecho de código dentro de um template, coloque o código entre chaves {} após o $
 */

fun main() {
    val customers = 10
    println("Existem $customers clientes")
    // Existem 10 clientes

    println("Existem ${customers + 1} clientes")
    // Existem 11 clientes
}

// EXERCÍCIO
/*
Complete o código para que o programa imprima "Mary tem 20 anos" na saída padrão:

fun main() {
    val name = "Mary"
    val age = 20
    // Escreva seu código aqui
}
 */

fun main() {
    val name = "Mary"
    val age = 20
    println("$name tem $age anos")
}

// EXERCÍCIOS FEITOS POR MIM 
// INTRODUÇÃO 
/*
Questão 1: Qual é a função inicial de um programa Kotlin? Explique o que ela faz.
Dica: Lembre-se de qual função é chamada primeiro quando o programa é executado.
- A função inicial de um programa Kotlin é a main(). Ela é o ponto de entrada do programa, ou seja, o local onde a execução começa. 
- Seu código é escrito dentro de chaves {} e pode conter instruções como a exibição de mensagens na tela.

Questão 2: Explique a diferença entre val e var em Kotlin.
Dica: Foque em dizer se o valor pode ou não ser alterado depois de declarado.
- val (imutável) é usado para declarar variáveis cujo valor não pode ser alterado após a atribuição inicial.
- var (mutável) é usado para declarar variáveis cujo valor pode ser modificado ao longo do programa.

Questão 3: Dado o código abaixo, o que será impresso na saída padrão?
fun main() {
    var dogs = 3
    val cats = 2
    dogs = 5
    println(dogs)
    println(cats)
}
Dica: Identifique qual variável é mutável e qual é imutável.
- Vai sair Dogs = 5, já que é uma variável definida como var e ela está sendo modificada, e cats = 2, já que é uma variável val e não
pode ser modificada durante o programa

Questão 3: Para que servem os “templates de strings” em Kotlin? Como podemos usá-los para exibir o valor de uma variável em uma frase?
- Os templates de strings permitem inserir valores de variáveis dentro de uma string de maneira simples e legível, 
utilizando o caractere $. 
- Se for necessário avaliar uma expressão, usamos ${}.- EX: 
fun main() {
    var dogs = 3
    val cats = 2
    dogs = 5
    println("Existem $dogs cachorros e $cats gatos em casa")
    printl("Ano que vem, eu terei %dogs cachorros e ${cats + 1} gatos")
}

Exercício: Complete o seguinte código para imprimir na tela: “O preço total é 15 reais”.
fun main() {
    val itemPrice = 5
    val quantity = 3
    // Escreva seu código aqui
}
Dica: Use um template de string para calcular o resultado dentro da própria instrução de impressão.
*/ 
fun main() {
    val itemPrice = 5
    val quantity = 3
    println("O preço total é ${itemPrice * quantity} reais")
}

/*
Exercício: Crie uma variável de nível superior chamada greeting para armazenar a mensagem “Bem-vindo(a) à loja!”. 
Em seguida, no corpo da função main, imprima o valor dessa variável.
Dica: Lembre-se de que variáveis de nível superior podem ser declaradas fora de qualquer função.
*/ 
// - variáveis de nível superior são aquelas que são declaradas fora da função main
val greeting = "bem-vindo(a) á Loja!

fun main () {
    println(greeting)
}


/*
Questão: Por que se recomenda usar val por padrão e só utilizar var quando necessário?
Dica: Pense em boas práticas de programação e segurança de dados.
- O uso de val é recomendado por padrão porque garante que os valores não sejam modificados acidentalmente, aumentando a segurança 
e previsibilidade do código. Usar var apenas quando necessário evita bugs causados por alterações inesperadas de valores.

Exercício: Escreva um programa que declare:
a) Uma variável imutável chamada name com seu nome.
b) Uma variável mutável chamada age com sua idade atual.
c) Imprima: “Meu nome é X e tenho Y anos”.
d) Depois, simule um ano se passando, atualize sua idade e imprima novamente na tela.
*/

fun main() {
    val name = "Sophia"
    var age = 18 
    println("Meu nome é $name e tenho $age anos")
    age = 19
    println("Meu nome é $name e tenho $age anos")
}
