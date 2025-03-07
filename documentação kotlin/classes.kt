// CLASSES
/*
- Kotlin suporta programação orientada a objetos com classes e objetos.
- Objetos são úteis para armazenar dados no seu programa.
- Classes permitem que você declare um conjunto de características para um objeto.
- Quando você cria objetos a partir de uma classe, você pode economizar tempo e esforço, pois não precisa declarar essas características toda vez.
 */

// Para declarar uma classe, use a palavra-chave class:
class Customer

// PROPRIEDADES
// As características de um objeto de uma classe podem ser declaradas como propriedades. Você pode declarar propriedades para uma classe:
// Dentro de parênteses () após o nome da classe.
class Contact(val id: Int, var email: String)

// Dentro do corpo da classe, definido por chaves {}.
class Contact(val id: Int, var email: String) {
    val category: String = ""
}

/*
- Recomendamos que você declare propriedades como somente leitura (val), a menos que elas precisem ser alteradas depois que uma instância da classe for criada.
- Você pode declarar propriedades sem val ou var dentro dos parênteses, mas essas propriedades não serão acessíveis depois que a instância for criada.
- O conteúdo dentro dos parênteses () é chamado de cabeçalho da classe.
- Você pode usar uma vírgula final ao declarar propriedades da classe.
- Assim como com parâmetros de função, as propriedades da classe podem ter valores padrão:
 */

class Contact(val id: Int, var email: String = "example@gmail.com") {
    val category: String = "work"
}

// CRIAR INSTÂNCIAS
/*
- Para criar um objeto a partir de uma classe, você declara uma instância da classe usando um construtor.
- Por padrão, o Kotlin cria automaticamente um construtor com os parâmetros declarados no cabeçalho da classe.
 */
*/

// Por exemplo:
class Contact(val id: Int, var email: String)

fun main() {
    val contact = Contact(1, "mary@gmail.com")
}

/*
No exemplo:
- Contact é uma classe.
- contact é uma instância da classe Contact.
- id e email são propriedades.
- id e email são usados com o construtor padrão para criar contact.
- As classes Kotlin podem ter muitos construtores, incluindo aqueles que você define.
- Para aprender mais sobre como declarar múltiplos construtores, consulte a seção sobre Construtores.
*/

// ACESSAR PROPRIEDADES
// Para acessar uma propriedade de uma instância, escreva o nome da propriedade após o nome da instância, seguido por um ponto .:

class Contact(val id: Int, var email: String)

fun main() {
    val contact = Contact(1, "mary@gmail.com")

    // Imprime o valor da propriedade: email
    println(contact.email)  // mary@gmail.com

    // Atualiza o valor da propriedade: email
    contact.email = "jane@gmail.com"

    // Imprime o novo valor da propriedade: email
    println(contact.email)  // jane@gmail.com
}

// Para concatenar o valor de uma propriedade como parte de uma string, você pode usar templates de string ($). Por exemplo:
println("O endereço de email deles é: ${contact.email}")

// FUNÇÕES MEMBROS
/*
- Além de declarar propriedades como parte das características de um objeto, você também pode definir o comportamento de um objeto com funções membros.
- No Kotlin, as funções membros devem ser declaradas dentro do corpo da classe.
- Para chamar uma função membro em uma instância, escreva o nome da função após o nome da instância, seguido por um ponto ..
Por exemplo:
*/

class Contact(val id: Int, var email: String) {
    fun printId() {
        println(id)
    }
}

fun main() {
    val contact = Contact(1, "mary@gmail.com")

    // Chama a função membro printId()
    contact.printId()  // 1
}

// CLASSES DE DADOS
/*
- Kotlin possui classes de dados, que são particularmente úteis para armazenar dados.
- As classes de dados têm a mesma funcionalidade das classes, mas vêm automaticamente com funções membros adicionais.
- Essas funções membros permitem imprimir a instância em um formato legível, comparar instâncias de uma classe, copiar instâncias e mais.
- Como essas funções estão automaticamente disponíveis, você não precisa gastar tempo escrevendo o mesmo código repetitivo para cada uma de suas classes.
 */

// Para declarar uma classe de dados, use a palavra-chave data:
data class User(val name: String, val id: Int)

/*
As funções membros predefinidas mais úteis das classes de dados são:
Função	                Descrição
toString()	            Imprime uma string legível da instância da classe e suas propriedades.
equals() ou ==	        Compara instâncias de uma classe.
copy()	                Cria uma instância da classe copiando outra, potencialmente com algumas propriedades diferentes.

Veja as seções seguintes para exemplos de como usar cada função:
- Imprimir como string
- Comparar instâncias
- Copiar instância
*/

// IMPRIMIR COMO STRING
/*
- Para imprimir uma string legível de uma instância de uma classe, você pode chamar explicitamente a função toString(), ou usar funções de impressão
(como println() e print()), que automaticamente chamam o toString() para você:
 */

data class User(val name: String, val id: Int)

fun main() {
    val user = User("Alex", 1)

    // Usa automaticamente a função toString(), tornando a saída legível
    println(user)  // User(name=Alex, id=1)
}

// Isso é particularmente útil quando você está depurando ou criando logs.

// COMPARAR INSTÂNCIAS
// Para comparar instâncias de uma classe de dados, use o operador de igualdade ==:
data class User(val name: String, val id: Int)

fun main() {
    val user = User("Alex", 1)
    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    // Compara user com secondUser
    // Compara user com thirdUser
    println("user == secondUser: ${user == secondUser}")  // user == secondUser: true
    println("user == thirdUser: ${user == thirdUser}")    // user == thirdUser: false
}

// COPIAR INSTÂNCIAS
/*
- Para criar uma cópia exata de uma instância de uma classe de dados, chame a função copy() na instância.
- Para criar uma cópia de uma instância de uma classe de dados e alterar algumas propriedades, chame a função copy() na instância e adicione valores de substituição 
para as propriedades como parâmetros da função.
Por exemplo:
 */
data class User(val name: String, val id: Int)

fun main() {
    val user = User("Alex", 1)
    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    // Cria uma cópia exata de user
    println(user.copy())  // User(name=Alex, id=1)

    // Cria uma cópia de user com o nome: "Max"
    println(user.copy("Max"))  // User(name=Max, id=1)

    // Cria uma cópia de user com id: 3
    println(user.copy(id = 3))  // User(name=Alex, id=3)
}

/*
- Criar uma cópia de uma instância é mais seguro do que modificar a instância original, pois qualquer código que dependa da instância original não será afetado pela 
cópia e pelo que você fizer com ela.
*/

// EXERCÍCIOS 
// 1 - Defina uma data class chamada Funcionario com duas propriedades:
// nome: Representa o nome do funcionário.
// salario: Representa o salário do funcionário e deve ser mutável para permitir aumentos.
// A função main() deve demonstrar o uso dessa classe, criando um funcionário chamado "Mary" com salário 20, aumentando seu salário em 10 e imprimindo os resultados.
/*
 //	Write	your	code	here
 fun	main()	{
 val	emp	=	Employee("Mary",	20)
 println(emp)
 emp.salary	+=	10
 println(emp)
 }
 */

 // Definição da data class Funcionario com nome imutável e salário mutável
data class Funcionario(val nome: String, var salario: Int)

fun main() {
    val emp = Funcionario("Mary", 20) // Cria um funcionário chamado Mary com salário 20
    println(emp) // Exibe os detalhes iniciais do funcionário

    emp.salario += 10 // Aumenta o salário em 10

    println(emp) // Exibe os detalhes do funcionário após o aumento
}






