// NULL SAFETY
/*
- Em Kotlin, é possível ter um valor nulo (null). O Kotlin usa valores nulos quando algo está faltando ou ainda não foi definido.
- Você já viu um exemplo de Kotlin retornando um valor nulo no capítulo de Coleções, quando tentou acessar um par chave-valor em um mapa usando uma chave que não existe.
- Embora seja útil usar valores nulos dessa forma, você pode se deparar com problemas se o seu código não estiver preparado para lidar com eles.
- Para evitar esses problemas com valores nulos, Kotlin possui Null Safety (Segurança contra Nulos).
- A segurança contra nulos detecta potenciais problemas com valores nulos no tempo de compilação, em vez de no tempo de execução.
 */

/*
*** O QUE É NULL SAFETY?
- A Null Safety é uma combinação de recursos que permite:
- Declarar explicitamente quando valores nulos são permitidos no seu programa.
- Verificar valores nulos.
- Usar chamadas seguras para propriedades ou funções que podem conter valores nulos.
- Declarar ações a serem tomadas caso valores nulos sejam detectados.
 */

// TIPOS NULOS (NULLABLE TYPES)
/*
- Kotlin suporta tipos nulos, o que significa que é possível declarar variáveis que podem ter valores nulos.
- Por padrão, tipos não aceitam valores nulos. Para declarar um tipo que possa ser nulo, você deve adicionar ? após o tipo na declaração.
 */

// Exemplo
fun main() {
    // TIPO NÃO NULO (STRING)
    // Tipos não nulos não aceitam valores null
    var neverNull: String = "Isso não pode ser nulo"
    // A variável neverNull é do tipo String e não pode ser nula. Tentar atribuir null a essa variável causa um erro de compilação.
    // neverNull = null // // Erro de compilação

    // TIPO NULO (STRING?)
    // Tipos nulos (tipos com ? após o tipo) podem conter valores null.
    var nullable: String? = "Você pode manter um null aqui"
    nullable = null // Funciona, está certo
    // A variável nullable é do tipo String? (nullable), o que significa que ela pode ser null. Portanto, a atribuição de null a essa variável é permitida.

    // INFERÊNCIA DE TIPO NÃO NULO
    // Por padrão, valores nulos não são aceitos
    // Quando o tipo não é explicitamente declarado, o compilador do Kotlin assume que a variável não pode ser nula, como é o caso da variável inferredNonNull. Assim, tentar atribuir null a ela gera um erro de compilação.
    var inferredNonNull = "O compilador assume que não é nulo"
    // inferredNonNull = null  // Erro de compilação

    // FUNÇÃO COM PARÂMETRO NÃO NULO
    // A função strLength recebe um parâmetro do tipo String, que não aceita valores null. Portanto, passar uma variável do tipo String? (que pode ser null) para essa função gera um erro de compilação.
    // strLenght é uma função que não aceita valores nulos
    fun strLength(notNull: String): Int {  // 'notNull' não pode ser nulo
        return notNull.length
    }

    println(strLength(neverNull))  // Saída: 18
}

// VERIFICANDO VALORES NULOS (CHECK FOR NULL VALUES)
/*
- Você pode verificar a presença de valores nulos dentro de expressões condicionais.
- No exemplo a seguir, a função describeString() contém uma instrução if que verifica se maybeString não é nulo e se o seu comprimento é maior que zero:
 */

// Exemplo
fun describeString(maybeString: String?): String { // A função describeString() recebe um parâmetro do tipo String? (nullable)
    /*
    Dentro da função, há um if que verifica duas condições:
    - Se maybeString não é nulo (maybeString != null)
    - Se o comprimento da string (maybeString.length) é maior que 0
    - Se ambas as condições forem verdadeiras, a função retorna uma string que descreve o comprimento da string.
    - Caso contrário, ela retorna uma mensagem indicando que a string é vazia ou nula.
     */
    if (maybeString != null && maybeString.length > 0) {
        return "String de comprimento ${maybeString.length}"
    } else {
        return "String vazia ou nula"
    }
}

fun main() {
    val nullString: String? = null // A variável nullString é declarada como null e passada para a função describeString().
    println(describeString(nullString)) // Como nullString é nula, a função retorna "String vazia ou nula"
}

// USO DE CHAMADAS SEGURAS (SAFE CALLS)
/*
- Para acessar propriedades de um objeto que pode conter um valor nulo de forma segura, use o operador de chamada segura (?.).
- O operador de chamada segura retorna null se o objeto ou qualquer uma das suas propriedades acessadas for nula.
- Isso é útil para evitar que a presença de valores nulos gere erros no seu código.
 */
/*
- Chamadas seguras (usando ?.) ajudam a evitar erros de null pointer exceptions, permitindo que você acesse propriedades ou chame métodos de objetos que podem ser
nulos, sem que o programa falhe.
- Se o valor for nulo em qualquer ponto, a chamada segura retorna null e o programa continua sem erro.
*/

// Exemplo 1: Usando Chamada Segura para Acessar o Comprimento da String
// A função lengthString() recebe uma variável do tipo String? (nullable).
// Dentro da função, usamos a chamada segura maybeString?.length para tentar acessar o comprimento da string.
// Se maybeString for nulo, a expressão retorna null, sem ocorrer problemas durante a execusão do código
// Caso contrário, ela retorna o comprimento da string
fun lengthString(maybeString: String?): Int? = maybeString?.length

fun main() {
    // Como nullString é nulo, a função retorna null
    val nullString: String? = null
    println(lengthString(nullString))  // Saída: null
}

// Exemplo 2: Chamada Segura em Cadeia
/*
- As chamadas seguras podem ser encadeadas para que, se qualquer propriedade de um objeto contiver um valor nulo, null seja retornado sem que um erro seja lançado.
 */

person.company?.address?.country // Se person.company for nulo, ou se person.company.address for nulo, o resultado será null sem que ocorra um erro.

// Exemplo 3: Usando a Chamada Segura para Funções de Extensão
/*
- O operador de chamada segura também pode ser usado para chamar funções de extensão ou membros de forma segura.
- Nesse caso, uma verificação de nulo é realizada antes que a função seja chamada. Se a verificação detectar um valor nulo, a chamada é ignorada e null é retornado.
 */

fun main() {
    // A variável nullString é nula, então quando tentamos chamar o método .uppercase(), ele é ignorando, e a função retorna null.
    val nullString: String? = null
    println(nullString?.uppercase())  // Saída: null
}

// USO DO OPERADOR ELVIS
// Você pode fornecer um valor padrão a ser retornado se um valor nulo for detectado, utilizando o operador Elvis (?:).
/*
Como funciona?
- Escreva do lado esquerdo do operador Elvis o que deve ser verificado quanto a um valor nulo.
- Escreva do lado direito o valor que deve ser retornado se um valor nulo for detectado.

- O operador Elvis é útil para fornecer um valor padrão quando uma expressão retorna null.
- Se o valor à esquerda for não nulo, ele será retornado normalmente. Caso contrário, o valor à direita do operador Elvis será retornado.
 */


fun main() {
    // nullString?.length tenta acessar o comprimento da string. Como nullString é nulo, a chamada segura (?.) retorna null.
    // O operador Elvis (?:) entra em ação e retorna o valor à direita dele (que neste caso é o 0) porque a expressão à esquerda resultou em null.
    val nullString: String? = null
    println(nullString?.length ?: 0)  // Saída: 0
}

// EXERCÍCIO
/*
- Você tem a função employeeById que dá acesso a um banco de dados de funcionários de uma empresa.
- Infelizmente, essa função retorna um valor do tipo Employee?, o que significa que o resultado pode ser nulo.
- Seu objetivo é escrever uma função que retorne o salário de um funcionário quando seu ID for fornecido, ou 0 se o funcionário não for encontrado no banco de dados.
*/

/*
data	class	Employee	(val	name:	String,	var	salary:	Int)

fun	employeeById(id:	Int)	=	when(id)	{
    1	->	Employee("Mary",	20)
    2	->	null
    3	->	Employee("John",	21)
    4	->	Employee("Ann",	23)
    else	->	null
}
fun	salaryById(id:	Int)	=	//	Write	your	code	here

fun	main()	{
    println((1..5).sumOf	{	id	->	salaryById(id)	})
*/

// Resolução
// Classe Employee: Define a estrutura de um funcionário, com name e salary.
data	class	Employee	(val	name:	String,	var	salary:	Int)

// Simula um banco de dados que retorna um funcionário baseado no ID. Se o ID não existir, retorna null.
fun	employeeById(id:	Int)	=	when(id)	{
    1	->	Employee("Mary",	20)
    2	->	null
    3	->	Employee("John",	21)
    4	->	Employee("Ann",	23)
    else	->	null
}

// Tenta acessar o salário do funcionário. Se o funcionário for null, o Elvis (?:) retorna 0
fun	salaryById(id:	Int)	=	employeeById(id)?.salary	?:	0

fun	main()	{
    // Calcula a soma dos salários dos funcionários com IDs de 1 a 5.
    println((1..5).sumOf	{	id	->	salaryById(id)	})
}
