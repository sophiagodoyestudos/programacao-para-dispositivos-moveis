// TIPOS BÁSICOS
/*
- Toda variável e estrutura de dados em Kotlin possui um tipo.
- Os tipos são importantes porque dizem ao compilador o que pode ser feito com aquela variável ou estrutura de dados, ou seja, quais funções e propriedades ela possui.
- O Kotlin possui a capacidade de determinar automaticamente o tipo de uma variável isso é chamado de inferência de tipo.
*/

fun main() {
    var customers = 10
    // Alguns clientes saem da fila
    customers = 8
    customers = customers + 3  // Exemplo de adição: 11
    customers += 7  // Exemplo de adição: 18
    customers -= 3  // Exemplo de subtração: 15
    customers *= 2  // Exemplo de multiplicação: 30
    customers /= 3  // Exemplo de divisão: 10
    println(customers)  // 10
}

// Os operadores +=, -=, *=, /=, e %= são chamados de operadores de atribuição composta.

// PRINCIPAIS TIPOS BÁSICOS EM KOTLIN
/*
Categoria	                    Tipos Básicos	                Exemplo de Código
Números Inteiros	            Byte, Short, Int, Long	        val year: Int = 2020
Números Inteiros sem Sinal	    UByte, UShort, UInt, ULong	    val score: UInt = 100u
Números Decimais	            Float, Double	                val price: Double = 19.99
Booleanos	                    Boolean	                        val isEnabled: Boolean = true
Caracteres	                    Char	                        val separator: Char = ','
Strings	                        String	                        val message: String = "Olá, mundo!"
*/

// DECLARANDO VARIÁVEIS SEM INICIALIZÁ-LAS
/*
- Com esse conhecimento, agora você pode declarar variáveis e inicializá-las posteriormente.
- O Kotlin permite isso desde que as variáveis sejam inicializadas antes da primeira leitura.
 */

fun main() {
    // Variável declarada sem inicialização
    val d: Int
    // Variável inicializada
    d = 3

    // Variável explicitamente tipada e inicializada
    val e: String = "olá"

    // As variáveis podem ser lidas porque foram inicializadas
    println(d)  // 3
    println(e)  // olá
}

// Se uma variável não for inicializada antes de ser lida, um erro será gerado:
fun main() {
    // Variável declarada sem inicialização
    val d: Int
    println(d)  // ERRO: a variável 'd' deve ser inicializada
}

// EXERCÍCIO
/*
Declare explicitamente o tipo correto para cada variável:

fun main() {
    val a: Int = 1000
    val b = "log message"
    val c = 3.14
    val d = 100_000_000_000_000
    val e = false
    val f = '\n'
}
*/

fun main() {
    val a: Int = 1000
    val b: String = "log message"
    val c: Double = 3.14
    val d: Long = 100_000_000_000_000
    val e: Boolean = false
    val f: Char = '\n'
}
