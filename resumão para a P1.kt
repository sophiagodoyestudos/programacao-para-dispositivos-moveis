// RESUMÃO PARA A P1

// VARIÁVEIS 
/*
-> val - imutável 
- > var - mutável
*/

fun main() {
    val pi = 3.1415 
    var r = 10 
    r = 11 // posso mudar a variável r, pq ela foi definida como var 
    println(pi)
    println(r)
}


// Tentando mudar uma variável "val"
fun main() {
    val pi = 3.1415
    pi = 3.14 // não posso mudar o valor de pi, pq ele foi definido como val (imutável) - isso vai gerar um erro 
}

// INFERÊNCIA DE TIPOS
// Kotlin consegue entender sozinho os tipos das variáveis 
fun main() {
    var nome = "Daniel" // Kotlin entende que é uma String
	// Tentando mudar o tipo da variável 
    nome = true // isso gera um erro, pois o Kotlin interpretou nome como uma String
}

// TIPAGEM EXPLÍCITA
// Quando você especifica o tipo da variável diretamente
fun main() {
    var sucesso: Boolean // declarando a variável 
    sucesso = true // inicializando a variável

    // TIPO ANY
    // define que que pode ser atribuito qualquer coisa para ela, podendo assim mudar seu valor 
    var xpto: Any  
    xpto = "Joao" 
    xpto = 2.31 
    xpto = true 
}

// FUNÇÕES
fun calcCompCircunf(pi: Double, r: Double): Double {
    return (2 * pi * r)
}
// pi: Double e r: Double → parâmetros de entrada são Double
// : Double no final → significa que a função retorna um Double

fun main() {
    val pi = 3.1415
    val r = 10
    val comp = calcCompCircunf(pi,r) 
    // essa função é atribuida como val porque esse valor não muda depois de atribuido, 
    //se o valor que saí da função mudar dps ela teria q ser var
    println(comp)
}

// FUNÇÃO ONE-LINE 
fun calcCompCircunf(pi: Double, r: Double): Double = 2 * pi * r

// IMPRIMINDO E CHAMANDO A FUNÇÃO 
fun main() {
    val pi = 3.14
    val r = 3
    println("O valor do comprimento da circunferência é: ${calcCompCircunf(pi, r)}")
}

/*
List (listas): 
- As listas armazenam valores ordenados e podem conter elementos repetidos. 
- Elementos vão sempre para o final da lista e posso aplicar ordenacao nos elementos  
- listOf() - lista imutável - não é possível adicionar e remolver elementos, apenas apontar para outra lista se for var 
- mutableListOf - lista mutável - consigo adicionar, remolver elementos e apontar para outra lista se for var 
- Listas polimórficas - são listas que podem armazenar elementos de diferentes tipo (String com Int com Double com Char)

Sets (conjuntos):
- Os Sets armazenam elementos únicos e não garantem ordem.  
- setOf(): conjuntos imutáveis - não permite adicionar, remolver e nem valores repetidos 
- mutableSetOf() - conjuntos mutáveis - permite adicionar e remover elementos, mas continua sem aceitar valores repetidos

Maps (dicionários): 
- Os Maps armazenam dados em pares chave-valor, onde:
- A chave (Key) é um identificador único. 
- O valor (Value) é a informação associada a essa chave. 
- mapOf(): mapa imutável - não pode ser alterado após a criação (não é possível adicionar e remolver elemetos) 
- mutableMapOf()): mapa mutável - pode ser modificado, permitindo adicionar ou remover pares. 

- Se a lista, set ou maps for definida como var é possível apontar para outra lista, set ou maps, mas
se for definida como val não é possível 
- Ser list, set e maps val e mutable não impede de adicionar e remolver elementos
*/

// LISTAS 
// LISTOF()
// Se a lista for declara como:
    val exemplo1 = listOf(2, 4, 5) // não consigo fazer nada com essa lista
    var exemplo2 = listOf(2, 4, 5) // consigo apontar para outra lista 

// EX - apontando uma listOf definida como var
    exemplo2 = exemplo1
    println(exemplo2) // 2, 4, 5

// não é possível apontar exemplo1 = exemplo2, pois exemplo 1 foi definido como val 

// LISTAS POLIMÓTFICAS
// l3 aponta para uma lista mutável contendo ["Joaquim", "Renata", "Pedro"] 
   var l3: MutableList <Any> = mutableListOf ("Joaquim", "Renata", "Pedro") 

// l4 aponta para outra lista mutável contendo [1, 2, 3, "Pamela"]
   val l4 : MutableList <Any> = mutableListOf(1, 2,3, "Pamela")  

// Podemos atribuir l3 = l4, pois l3 foi definida como var
   l3 = l4 
   println (l3) // Output: [1, 2, 3, Pamela] 
   
// Não é possível atribuir l4 = l3, pois l4 foi definida como val, mas por ser uma lista mutável, é possível adicionar e 
// remolver elementos dela

// MUTABLELISTOF()  
   val lista: MutableList<String> = mutableListOf("A", "B", "C") 
   
   // ADICIONANDO UM ELEMENTO NA POSIÇÃO 0 DA LISTA 
   lista[0] = "X"   
   
   // ADICIONANDO UM ELEMENTO A LISTA 
   lista.add("D")   
   println(lista) // Output: ["X", "B", "C", "D"] 

   // Não podemos trocar essa lista inteira por outra, porque ela foi definida como val que impede a mudança de referência 
   lista = mutableListOf("1", "2", "3") // Erro: Val cannot be reassigned  

   // Como essa lista é var podemos mudar a referência
   var lista: MutableList<String> = mutableListOf("A", "B", "C") 
   lista = mutableListOf("1", "2", "3") 
   println(lista)
} 

// SETS
// SETOF()
    val setExemplo = setOf(1, 2, 3, 3, 4) 
    println(setExemplo) // Saída: [1, 2, 3, 4] 
    
// MUTABLESETOF()
    val setMutavel = mutableSetOf("A", "B", "C") 
    // ADICIONANDO ELEMENTOS AO CONJUNTO
    setMutavel.add("D")  
    setMutavel.add("B") // Não será adicionado, pois já existe 
    println(setMutavel) // Saída: [A, B, C, D] 

// MAPS
// MAP0F()
    val mapaImutavel = mapOf("nome" to "Sophia", "idade" to 25) 
    println(mapaImutavel["nome"]) // Saída: Sophia 

// MUTABLEMAPOF()
    val mapaMutavel = mutableMapOf("A" to 1, "B" to 2)
    // ADICIONANDO UM NOVO ELEMENTO
    mapaMutavel["C"] = 3 
	// REMOLVENDO UM ELEMENTO
    mapaMutavel.remove("A")
    // IMPRIMINDO 
    println(mapaMutavel) // Saída: {B=2, C=3} 

// PASSANDO VARIÁVEIS COMO STRING
fun main() { 
    val nome = "Joao"  
    val qtde = 10  
    val fruta = " Maca" 
	println("$nome comprou $qtde frutas do tipo $fruta") 
} 

// NULL SAFETY
/*
PONTO DE ? EM STRING -> "String?"
- O kotlin não aceita String nulas se não especificarmos 
- String → Não pode ser nulo (null).
- String? → Pode ser nulo. 
*/

// Exemplo 01:
// SEM !
	var nome: String = "Carlos" // Sempre terá um valor e não pode ser nulo
 	var nome: String = null (não funciona)
 
// COM !
	var sobrenome: String? = null // Pode ser nulo
	var nome: String? = "Carlos"
	nome = null // permitido, pois 'nome' aceita valores nulos
// Usamos ? para evitar erros com valores nulos.

/*
SAFE CALL OPERATOR "?."
- O operador ?. é chamado de Safe Call Operator porque ele verifica se a variável é null antes de acessar propriedades ou 
chamar métodos.
- Se for null, ele não executa a operação e apenas retorna null em vez de dar erro.
*/
 
// Exemplo 01:
 fun main() {
    val nome: String? = null
    println(nome?.length) // Retorna "null" em vez de dar erro
 }
 // Aqui, nome?.length só acessa length se nome não for null.
 // Se nome for null, ele simplesmente retorna null, sem erro.

// Exemplo 02:
 fun main() {
    val nome: String? = "Kotlin"
    println(nome?.uppercase()) // Saída: "KOTLIN"
 }
 // Como nome não é null, .uppercase() é chamado normalmente.

/*
NOT-NULL ASSESTION "!!"
- O operador !! força o Kotlin a tratar uma variável nullable (String?, por exemplo) como se nunca fosse nula
- Se a variável for null, ele lança um erro NullPointerException (NPE).
*/

// Exemplo onde !! não funciona:
 fun main() {
    val nome: String? = null
    println(nome!!.length) // ERRO: NullPointerException (NPE)
 }
// Como nome é null, o !! força a execução, e o programa quebra com um erro.

// Exemplo onde !! funciona:
 fun main() {
    val nome: String? = "Kotlin"
    println(nome!!.length) // Funciona porque nome NÃO é null
 }

/*
SMART CAST
- È um recurso do Kotlin que automaticamente reconhece o tipo de uma variável após uma verificação
- O Kotlin detecta automaticamente o tipo após uma verificação)
- Quando funciona?	Quando a variável não pode ser alterada (val)
- Quando NÃO funciona?	Se a variável puder mudar (var)
*/

// Exemplo 01 - Com Smart Cast
 fun imprimirComprimento(texto: Any) {
    if (texto is String) { // O if (texto is String) verifica se texto é realmente uma String.
        println(texto.length) // Aqui o Kotlin já trata 'texto' como String automaticamente
    }
 }
// Dentro do if, Kotlin já entende que texto é uma String, então podemos acessar .length sem precisar converter (as String).
// Isso é o Smart Cast, porque o Kotlin faz a conversão automática do tipo

// Exemplo 02 - Sem Smart Cast
 fun imprimirComprimento(texto: Any) {
    if (texto is String) {
        println((texto as String).length) // Precisamos fazer um "cast" manual
    }
 }

// Exemplo 03 - Quando o Smart Cast não funciona
 fun verificar(texto: Any) {
    if (texto is String) {
        texto = 42 // Erro! Kotlin não pode garantir que texto continua sendo String
        println(texto.length) // Não compila
    }
 }
// Se a variável pode ser alterada (var), o Kotlin não pode garantir que o tipo não mudou.

// Corrigindo o erro:
 fun verificar(texto: Any) {
    if (texto is String) {
        val tamanho = texto.length // Agora funciona porque texto não pode mudar!
        println(tamanho)
    }
 }

/*
PROGRAMAÇÃO ORIENTADA A OBJETOS - POO
- È um paradigma de programação que organiza o código em torno de objetos, que são representações do mundo real dentro do programa.

CLASSES 
- Data Class: Apenas armazena dados, sem lógica interna.
- Classe Tradicional: Pode ter atributos e métodos com lógica de negócio.

DATA CLASS
- A data class é usada para armazenar apenas dados, sem lógica interna - Data Class: Um objeto que só tem dados
- Quando criamos uma classe, estamos definindo um molde para criar objetos. 
- Esse molde especifica quais atributos e comportamentos um objeto terá.
- Classe → Molde: Define as características (atributos) e ações (métodos) que os objetos terão.
- Objeto → Instância: É uma cópia concreta da classe com valores específicos.

CLASSE TRADICIONAL
- Atributos e métodos são definidos manualmente - pode ter lógica de negócio
- Uma classe pode ter atributos e funções. O nome de uma função que está dentro de uma classe se chama método
*/

// CRIANDO UMA DATA CLASS - Class Endereço
// A classe Endereco é um molde para armazenar dados de endereços
data class Endereco (
    var logradouro: String,
    var numero: Int,
    var complemento: String,
    var bairro: String,
    var cidade: String,
    var uf: String,
    var cep: String
)

// CRIANDO UMA INSTÂNCIAS (OBJETOS) DA CLASSE ENDERECO
fun main() {
    val e1: Endereco = Endereco("Av. Brasil",
        400,
        "",
        "Centro",
        "Campinas",
        "SP",
        "123123-111")
}

// CLASSE TRADICIONAL
class Veiculo(
    val marca: String,
    val modelo: String,
    var ano: Int
) {
    fun exibirInfo() {
        println("Veículo: $marca $modelo, Ano: $ano")
    }

    fun atualizarAno(novoAno: Int) {
        ano = novoAno
        println("Ano atualizado para: $ano")
    }
}

fun main() {
    val meuCarro = Veiculo("Toyota", "Corolla", 2020)
    meuCarro.exibirInfo()

    meuCarro.atualizarAno(2023)
    meuCarro.exibirInfo()
}

/*
- HERANÇA E ESPECIFICAÇÃO  
- Herança permite que uma classe herde atributos e métodos de outra classe
- Permite criar especializações de classes e reaproveitar código
*/ 

// Criamos uma classe Animal, e depois especializamos Leão 
abstract class Animal{
    // peso e idade são atributos comuns a todos os animais.
    var peso: Double = 0.0
    var idade: Int = 0
    // caminhar() é um método abstrato → Ele deve ser implementado pelas subclasses (Leao, Cachorro).
    abstract fun caminhar()
}

// Leao herda de Animal → Ou seja, possui peso, idade e deve implementar caminhar().
class Leao: Animal() {
    // O método fugir() foi adicionado apenas para Leões, pois outros animais não precisam dele.
    fun fugir() {
        println("Leão rugindo...")
    }
    override fun caminhar() {
    }
}

/*
HERANÇAS EM PESSOAS
- Pessoa contém atributos comuns a todas as pessoas
- A palavra-chave open permite que outras classes herdem dela
*/
// CRIANDO A CLASSE PESSOA
open class Pessoa {
    var nome: String = ""
    var idade: String = ""
    var cpf: String = ""
    var rg: String = ""
}

// CRIANDO A CLASSE FUNCIONÁRIO QUE VAI HERDAR DE PESSOA 
/*
- Funcionario herda os atributos de Pessoa (nome, idade, cpf, rg).
- Funcionario tem um novo atributo, matricula, que é exclusivo de funcionários.
- A palavra open indica que essa classe pode ser herdada por outras classes.
*/
open class Funcionario: Pessoa() {
    var matricula: String = ""
}
