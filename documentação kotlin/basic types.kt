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

// EXERCÍCIOS FEITOS POR MIM 
/*
Questão: O que são operadores de atribuição composta em Kotlin? Cite pelo menos três exemplos e explique o que eles fazem.
- Os operadores de atribuição composta em Kotlin combinam uma operação matemática com a atribuição de valor a uma variável.

Questão: Explique a diferença entre as principais categorias de tipos numéricos em Kotlin, como Byte, Int, Long e Double e FLoat.
Dica: Aborde quais são usados para números inteiros, quais suportam números decimais e como eles diferem em tamanho ou capacidade.
- Byte → Armazena números inteiros pequenos (-128 a 127).
- Int → Armazena números inteiros maiores (até cerca de ±2 bilhões).
- Long → Usado para números inteiros ainda maiores (até ±9 quintilhões).
- Double → Armazena números com casas decimais (ponto flutuante de precisão dupla).

Float X Double
- Use Float se precisar economizar memória e não precisa de muita precisão (6 - 7 dígitos)
- Use Double para cálculos mais precisos e científicos (15 - 16 dígitos)

Principais diferenças:
- Byte, Int e Long são para números inteiros.
- Double é para números com decimais.
- Long suporta números inteiros maiores que Int.


Questão: Qual é a diferença entre variáveis assinadas (por exemplo, Int) e não assinadas (por exemplo, UInt) em Kotlin? 
Quando poderíamos usar tipos não assinados?
- Variáveis assinadas (Int, Long) podem armazenar valores positivos e negativos.
- Variáveis não assinadas (UInt, ULong) armazenam apenas valores positivos e têm uma faixa maior de valores positivos.
- Podemos usar variáveis não assinado quando tivermos certeza de que um valor nunca será negativo

Questão: O que acontece se você declarar uma variável em Kotlin sem inicializá-la e tentar utilizá-la antes de atribuir um valor?
Dica: Descreva o tipo de erro que ocorre e o motivo.
- Se a variável não for inicializada, o compilador dará erro, pois o Kotlin exige que variáveis tenham um valor antes de serem usadas.
fun main() {
    var age: Int
    println(age) // Erro: Variável não inicializada
}

- Devemos inicializar a variável antes de usa-lá
fun main() {
    var age: Int = 25
    println(age) // 25
}

Exercício: Dado o trecho de código abaixo, o que será impresso na saída padrão?
fun main() {
    var total = 5
    total += 2   // total = total + 2
    total -= 1   // total = total - 1
    total *= 3   // total = total * 3
    total /= 2   // total = total / 2
    println(total)
}
Dica: Calcule passo a passo.
- O resultado será 9

Exercício: Crie um programa que declare duas variáveis:
a) Uma variável imutável do tipo Double para o valor de um produto, por exemplo 19.99.
b) Uma variável mutável do tipo Int para quantidade de produtos em estoque, por exemplo 10. 

Em seguida:
c) Altere a quantidade em estoque para um novo valor.
d) Imprima no console o resultado da multiplicação do preço pela quantidade atualizada.
*/
fun main() {
    val valor: Double = 19.99
    var quantidade: Int = 10
    quantidade = 12
    println("O resultado da multiplicação do preço pela quantidade é ${valor * quantidade}")
}

/*
Exercício: Declare uma variável de nível superior chamada hoursWorked do tipo Int, mas não a inicialize imediatamente.
- Dentro da função main(), atribua o valor 8 a hoursWorked.
- Depois, imprima a frase: “Você trabalhou X horas hoje.” usando a variável.
*/
var hoursWorked: Int
            
fun main() {
    hoursWorked = 8 
    println("Você trabalhou $hoursWorked horas hoje")
}

/*
Exercício: Complete o código abaixo fazendo a declaração de tipos apropriados para cada variável:
fun main() {
    val x: ___ = 42
    val y: ___ = 3.1415
    val z: ___ = "Aprendendo Kotlin"
    val w: ___ = true
    // Imprima todos os valores
}
Dica: Lembre-se de usar Int para números inteiros, Double para números com ponto decimal, String para textos e Boolean para 
valores verdadeiro/falso.
*/
fun main() {
    val x: Int = 42
    val y: Double = 3.1415
    val z: String = "Aprendendo Kotlin"
    val w: Boolean = true
    println("$x, $y, $z, $w")
}
