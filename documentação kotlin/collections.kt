// COLEÇÕES
/*
- Ao programar, é útil agrupar dados em estruturas para processamento posterior. O Kotlin fornece coleções exatamente para esse propósito.
- Kotlin possui os seguintes tipos de coleções para agrupar itens:

Tipo de Coleção	e Descrição
- Listas (Lists): Coleções ordenadas de itens.
- Conjuntos (Sets): Coleções de itens únicos e não ordenados.
- Mapas (Maps): Conjuntos de pares chave-valor, onde as chaves são únicas e mapeiam para apenas um valor.
*/

// LISTAS
/*
- As listas armazenam itens na ordem em que são adicionados e permitem itens duplicados.
- Para criar uma lista somente leitura (List), use a função listOf() - não é possível modifica - lá depois
- Para criar uma lista mutável (MutableList), use a função mutableListOf() - é possível modifica - lá depois
- Kotlin pode inferir o tipo dos itens armazenados, mas você pode declarar explicitamente o tipo usando <> após a declaração da lista.
 */

fun main() {
    // Lista somente leitura
    val readOnlyShapes = listOf("triângulo", "quadrado", "círculo")
    println(readOnlyShapes)
    // [triângulo, quadrado, círculo]

    // Lista mutável com declaração explícita de tipo
    val shapes: MutableList<String> = mutableListOf("triângulo", "quadrado", "círculo")
    println(shapes)
    // [triângulo, quadrado, círculo]
}

// TORNANDO UMA LISTA MUTÁVEL SOMENTE LEITURA
// Para evitar modificações indesejadas, você pode criar uma visão somente leitura de uma lista mutável atribuindo-a a uma List:
val shapes: MutableList<String> = mutableListOf("triângulo", "quadrado", "círculo")
val shapesLocked: List<String> = shapes // Lista somente leitura
// Isso também é chamado de casting.

// ACESSANDO ELEMENTOS DE UMA LISTA
// Como as listas são ordenadas, você pode acessar um item usando o operador de índice []:
fun main() {
    val readOnlyShapes = listOf("triângulo", "quadrado", "círculo")
    println("O primeiro item da lista é: ${readOnlyShapes[0]}")
    // O primeiro item da lista é: triângulo
}

// Também é possível obter o primeiro ou último item com as funções .first() e .last():
fun main() {
    val readOnlyShapes = listOf("triângulo", "quadrado", "círculo")
    println("O primeiro item da lista é: ${readOnlyShapes.first()}")
    // O primeiro item da lista é: triângulo
}

// CONTANDO ELEMENTOS
// Para obter o número de itens em uma lista, use .count():
fun main() {
    val readOnlyShapes = listOf("triângulo", "quadrado", "círculo")
    println("Esta lista tem ${readOnlyShapes.count()} itens")
    // Esta lista tem 3 itens
}

// VERIFICANDO SE UM ITEM ESTÁ NA LISTA
// Para verificar se um item existe na lista, use o operador in:
fun main() {
    val readOnlyShapes = listOf("triângulo", "quadrado", "círculo")
    println("círculo" in readOnlyShapes)
    // true
}

// ADICIONANDO EM REMOLVENDO ITENS DE UMA LISTA MUTÁVEL
// Para adicionar ou remover elementos de uma lista mutável, use .add() e .remove():
fun main() {
    val shapes: MutableList<String> = mutableListOf("triângulo", "quadrado", "círculo")

    // Adiciona "pentágono" à lista
    shapes.add("pentágono")
    println(shapes)
    // [triângulo, quadrado, círculo, pentágono]

    // Remove o primeiro "pentágono" da lista
    shapes.remove("pentágono")
    println(shapes)
    // [triângulo, quadrado, círculo]
}

// CONJUNTOS
/*
- Enquanto as listas são ordenadas e permitem itens duplicados, os conjuntos são desordenados e armazenam apenas itens exclusivos (não armazenam itens repetidos)
- Para criar um conjunto somente leitura (Set), use a função setOf().
- Para criar um conjunto mutável (MutableSet), use a função mutableSetOf().
- Ao criar conjuntos, o Kotlin pode inferir o tipo dos itens armazenados.
- Para declarar o tipo explicitamente, adicione o tipo dentro dos sinais de menor e maior < > após a declaração do conjunto:
 */

fun main() {
    // Conjunto somente leitura
    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    // Conjunto mutável com declaração explícita de tipo
    val fruit: MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")
    println(readOnlyFruit)
    // [apple, banana, cherry]
}

/*
- Você pode ver no exemplo anterior que, como os conjuntos contêm apenas elementos únicos, o item duplicado "cherry" foi removido.
- Para evitar modificações indesejadas, você pode criar uma visualização somente leitura de um conjunto mutável, atribuindo-o a um Set:
*/

val fruit: MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")
val fruitLocked: Set<String> = fruit

/*
- Como os conjuntos são desordenados, você não pode acessar um item em um índice específico.
- Para obter o número de itens em um conjunto, use a função .count():
*/

fun main() {
    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    println("Este conjunto tem ${readOnlyFruit.count()} itens")
    // Este conjunto tem 3 itens
}

// Para verificar se um item está em um conjunto, use o operador in:
fun main() {
    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    println("banana" in readOnlyFruit)
    // true
}

// Para adicionar ou remover itens de um conjunto mutável, use as funções .add() e .remove(), respectivamente:
fun main() {
    val fruit: MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")
    fruit.add("dragonfruit")
    // Adiciona "dragonfruit" ao conjunto
    // [apple, banana, cherry, dragonfruit]
    fruit.remove("dragonfruit")	// Remove "dragonfruit" do conjunto
    println(fruit)
    // [apple, banana, cherry]
}

// MAPAS
/*
- Mapas armazenam itens como pares de chave-valor. Você acessa o valor referenciando a chave.
- Você pode imaginar um mapa como um cardápio de alimentos. Você pode encontrar o preço (valor) procurando pelo alimento (chave) que você deseja comer.
- Os mapas são úteis quando você quer procurar um valor sem usar um índice numerado, como em uma lista.
- Cada chave em um mapa deve ser única para que o Kotlin entenda qual valor você deseja obter. Você pode ter valores duplicados em um mapa.
- Para criar um mapa somente leitura (Map), use a função mapOf().
- Para criar um mapa mutável (MutableMap), use a função mutableMapOf().
- Ao criar mapas, o Kotlin pode inferir o tipo dos itens armazenados. Para declarar o tipo explicitamente, adicione os tipos das chaves e dos valores dentro dos sinais de menor e maior < > após a declaração do mapa. Por exemplo: MutableMap<String, Int>. As chaves têm o tipo String e os valores têm o tipo Int.
- A maneira mais fácil de criar mapas é usar to entre cada chave e seu valor relacionado:
*/

fun main() {
    // Mapa somente leitura
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(readOnlyJuiceMenu)
    // {apple=100, kiwi=190, orange=100}
}

// Mapa mutável com declaração explícita de tipo
val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
println(juiceMenu)
// {apple=100, kiwi=190, orange=100}

// Para evitar modificações indesejadas, você pode criar uma visualização somente leitura de um mapa mutável, atribuindo-o a um Map:
val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
val juiceMenuLocked: Map<String, Int> = juiceMenu

// Para acessar um valor em um mapa, use o operador de acesso indexado [] com sua chave:
fun main() {
    // Mapa somente leitura
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println("O valor do suco de apple é: ${readOnlyJuiceMenu["apple"]}")
    // O valor do suco de apple é: 100
}

// Se você tentar acessar um par chave-valor com uma chave que não existe no mapa, você verá um valor nulo:
fun main() {
    // Mapa somente leitura
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println("O valor do suco de pineapple é: ${readOnlyJuiceMenu["pineapple"]}")
    // O valor do suco de pineapple é: null
}

// Você também pode usar o operador de acesso indexado [] para adicionar itens a um mapa mutável:
fun main() {
    val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    juiceMenu["coconut"] = 150  // Adiciona a chave "coconut" com valor 150 ao mapa
    println(juiceMenu)
    // {apple=100, kiwi=190, orange=100, coconut=150}
}

// Para remover itens de um mapa mutável, use a função .remove():
fun main() {
    val juiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    juiceMenu.remove("orange")  // Remove a chave "orange" do mapa
    println(juiceMenu)
    // {apple=100, kiwi=190}
}

// Para obter o número de itens em um mapa, use a função .count():
fun main() {
    // Mapa somente leitura
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println("Este mapa tem ${readOnlyJuiceMenu.count()} pares chave-valor")
    // Este mapa tem 3 pares chave-valor
}

// Para verificar se uma chave específica já está incluída em um mapa, use a função .containsKey():
fun main() {
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(readOnlyJuiceMenu.containsKey("kiwi"))
    // true
}

// Para obter uma coleção das chaves ou valores de um mapa, use as propriedades keys e values, respectivamente:
fun main() {
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(readOnlyJuiceMenu.keys)
    // [apple, kiwi, orange]
    println(readOnlyJuiceMenu.values)
    // [100, 190, 100]
}

// keys e values são exemplos de propriedades de um objeto. Para acessar a propriedade de um objeto, escreva o nome da propriedade após o objeto.

// Para verificar se uma chave ou valor está em um mapa, use o operador in:
fun main() {
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println("orange" in readOnlyJuiceMenu.keys)
    // true
    // Alternativamente, você não precisa usar a propriedade keys
    println("orange" in readOnlyJuiceMenu)
    // true
    println(200 in readOnlyJuiceMenu.values)
    // false
}

// EXERCÍCIOS
/*
1 - Você tem uma lista de números "verdes" e uma lista de números "vermelhos". Complete o código para imprimir o número total de elementos.

fun main() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    // Escreva seu código aqui
}
*/

fun main() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    val totalCount = greenNumbers.count() + redNumbers.count()
    println(totalCount)
}

// Outro jeito que daria certo:
fun main() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    println("${greenNumbers.count() + redNumbers.count()}")
}

/*
2- Você tem um conjunto de protocolos suportados pelo seu servidor. Um usuário solicita o uso de um protocolo específico. Complete o programa para verificar se o
protocolo solicitado é suportado ou não (a variável isSupported deve ser um valor booleano).
Dica: Certifique-se de verificar o protocolo solicitado em maiúsculas. Você pode usar a função .uppercase() para ajudá-lo com isso.

O problema:
- Você tem um conjunto de protocolos suportados e um usuário solicita um protocolo específico. Seu programa deve verificar se esse protocolo está na lista de suportados.

fun main() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP") // Conjunto de protocolos suportados
    val requested = "smtp" // Protocolo solicitado pelo usuário (em minúsculas)
    val isSupported = // Escreva seu código aqui
    println("Suporte para $requested: $isSupported")
}
 */

fun main() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    // Verifica se o protocolo solicitado, convertido para maiúsculas, está no conjunto SUPPORTED
    // Devo passar para maisúscula porque os "SUPPORTED" estão todos em maiúsculas - para garantir que a comparação seja justa
    val isSupported = requested.uppercase() in SUPPORTED
    println("Suporte para $requested: $isSupported")
}

/*
3 - Defina um mapa que relacione os números inteiros de 1 a 3 com sua respectiva grafia. Use esse mapa para soletrar o número fornecido.

fun main() {
    val number2word = // Escreva seu código aqui
    val n = 2
    println("$n é soletrado como '${<Escreva seu código aqui>}'")
}
 */

fun main() {
    val number2word = mapOf(1 to "um", 2 to "dois", 3 to "três")
    val n = 2 // Isso significa que queremos encontrar a grafia do número 2 no mapa
    println("$n é soletrado como '${number2word[n]}'") // Utilizamos number2word[n] para obter a grafia correspondente ao número n.
}

// EXERCÍCIOS FEITOS POR MIM 
/*
Questão: Qual a diferença entre listas somente leitura (List) e listas mutáveis (MutableList) em Kotlin?
Dica: Explique como cada uma armazena valores, se é possível ou não adicionar e remover itens após a criação.
- List: É uma coleção somente leitura, ou seja, não é possível modificar seus elementos após a criação (adicionar, remover ou alterar).
- MutableList: É uma coleção mutável, ou seja, permite que seus elementos sejam alterados, com a capacidade de adicionar, remover ou alterar itens após a criação.

Questão: Para que serve a função .count() em listas, conjuntos e mapas?
Dica: Mencione o que ela retorna e em que tipo de coleções pode ser utilizada.
- A função .count() retorna o número de elementos em uma coleção. Pode ser usada em listas, conjuntos e mapas. Para listas e conjuntos, retorna o número de elementos, enquanto em um mapa, retorna o número de pares chave-valor.

Questão: Explique a diferença entre listOf(), setOf() e mapOf() em Kotlin.
Dica: Cite as principais características de cada tipo de coleção.
- listOf(): Cria uma lista, que pode ter elementos duplicados e é ordenada.
- setOf(): Cria um conjunto, que não permite elementos duplicados e não garante a ordem dos elementos.
- mapOf(): Cria um mapa de chave-valor, onde cada chave é única, e os valores podem ser acessados pelas chaves.

Questão: Como podemos transformar uma lista mutável em uma “visão somente leitura”?
Dica: Mencione o uso de List, Set ou Map em vez de suas versões mutáveis.
- Para transformar uma lista mutável em somente leitura, podemos usar a função .toList() para obter uma cópia imutável da lista original.

Questão: Se quisermos verificar se um valor existe em um mapa, como podemos fazer isso?
Dica: Explique o uso de .containsKey() e o operador in.
- Usamos o método .containsKey() para verificar se uma chave existe no mapa, ou o operador in, que também pode ser usado para verificar a existência de uma chave no mapa.

Exercício: Crie uma lista somente leitura com os nomes de três cidades e imprima na tela o primeiro e o último nome dessa lista.
fun main() {
    // Crie aqui sua lista somente leitura (listOf())
    // Imprima o primeiro e o último nome
}
Dica: Use as funções .first() e .last().
*/
fun main() {
    val listaLeitura = listOf("Sophia", "Joao", "Alicia")
    println("O primeiro nome é ${listaLeitura.first()} e o último nome é ${listaLeitura.last()}")
}

/*
Exercício: Declare uma lista mutável de inteiros com cinco números e:
a) Adicione mais dois números a essa lista.
b) Remova um número qualquer.
c) Imprima a lista final.

fun main() {
    // Declare a lista mutável
    // Adicione e remova números
    // Imprima a lista atualizada
}
*/
fun main() {
    val listaMutavel: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    listaMutavel.add(6)  
    listaMutavel.add(7)  
    listaMutavel.remove(5)  
    println(listaMutavel)  
}

/*
Exercício: Crie um conjunto somente leitura (setOf) com três nomes de frutas.
a) Imprima quantos itens ele tem usando .count().
b) Verifique se uma determinada fruta está presente no conjunto usando o operador in.
fun main() {
    // Crie o conjunto
    // Imprima o total de itens
    // Verifique a presença de uma fruta
}
*/
fun main() {
    val lendoFruta = setOf("laranja", "maca", "uva")
    println("Existem ${lendoFruta.count()} nessa lista")
    println("maca" in lendoFruta)
}

/*
Exercício: Declare um conjunto mutável com pelo menos quatro cores (strings).
a) Adicione uma nova cor.
b) Remova outra cor.
c) Imprima o conjunto final.

fun main() {
    // Conjunto mutável
    // Adicione e remova cores
    // Imprima o resultado
}
*/
fun main() {
    val listaCores = mutableSetOf("rosa", "azul", "branco", "preto")
    listaCores.add("verde")
    listaCores.remove("azul")
    println(listaCores)
}

/*
Exercício: Crie um mapa somente leitura que relacione três marcas de carro a seus respectivos valores (inteiros).
a) Imprima todos os valores usando 
b) Verifique se existe uma certa chave (marca) no mapa 
fun main() {
    // Crie o mapa
    // Imprima os valores
    // Verifique se existe uma chave específica
}
*/
fun main() {
    val mapaCarros = mapOf("corolla" to 1000, "renagade" to 2000, "nissan" to 3000)
    println(mapaCarros)
    println("corolla" in mapaCarros)
}

/*
Exercício: Declare um mapa mutável em que as chaves sejam nomes de produtos e os valores sejam seus preços (inteiros).
a) Adicione um novo produto ao mapa.
b) Remova um produto existente.
c) Imprima a quantidade de pares chave-valor usando .count().
fun main() {
    // Mapa mutável
    // Adicione e remova produtos
    // Imprima a quantidade total
}
*/
fun main() {
    val produtos: MutableMap<String, Int> = mutableMapOf("roupa" to 40, "sapato" to 60, "maquiagem" to 100) 
    produtos["computador"] = 500
    produtos.remove("roupa")
    println("A quantidade total de elementos é: ${produtos.count()}")
}
