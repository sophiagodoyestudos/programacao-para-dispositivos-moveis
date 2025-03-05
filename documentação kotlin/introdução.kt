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
