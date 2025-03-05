/*
FUNDAMENTOS DE ORIENTAÇÃO A OBJETOS (OO)

*** O que é a Orientação a Objetos?
- È um paradigma de programação que organiza o código em objetos, que representam entidades do mundo real.
- Esses objetos possuem atributos (dados) e métodos (comportamentos).


*** O que é uma Classe?
CLASSE: É a especificação de um objeto.
- Classe é um molde para criar objetos. Ela define atributos (dados) e métodos (ações).

Pense em uma classe como uma receita de bolo:
- A receita contém os ingredientes (atributos) e o modo de preparo (métodos).
- Mas a receita sozinha não é um bolo de verdade.
- Para ter um bolo real, precisamos criar (instanciar) um objeto dessa receita.

class Carro {
    var cor: String = ""  // Atributo
    fun buzinar() {        // Método
        println("Bii Bii!")
    }
}

- A classe Carro define que todo carro terá uma cor e poderá buzinar().

Tal como: FORMA = MOLDE = ESPECIFICAÇÃO DO QUE AQUELE OBJETO É E FAZ

*** O que é uma Instância?
- Instanciar um objeto significa criar um exemplar (cópia real) de uma classe.
- È a criação de um objeto a partir de uma classe. Ou seja, quando você cria um objeto a partir de uma classe, está criando uma instância dessa classe.

Seguindo a analogia do bolo:
- A classe é a receita.
- A instância é um bolo pronto, feito a partir da receita.
- Podemos fazer vários bolos (objetos) diferentes usando a mesma receita (classe).

fun main() {
    val meuCarro = Carro()  // Criando um objeto (uma instância) da classe Carro
    meuCarro.cor = "Vermelho"
    meuCarro.buzinar()  // Saída: Bii Bii!
}

INSTÂNCIA: É a realização de um objeto (dar vida a um objeto de uma classe)

*** C é uma linguagem ESTRUTURADA.
- Isso significa que quando resolvemos os problemas usando C, criamos programas estruturados que usam funções e bibliotecas DE funções Kotlin, Java, C++ são
linguagens orientadas a objetos. Isso significa que a abordagem de construção de software é baseada em dividir os problemas em objetos e responsabilidades
com foco no REAPROVEITAMENTO posterior dessas classes ou COMPONENTES.
*/

// CRIANDO A CLASSE ANIMAL
open class Animal{ // Animal é uma classe aberta (open), o que significa que pode ser herdada por outras classes.
    var peso: Double = 0.0 // A classe Animal tem um atributo peso, mas não possui métodos no momento.
}

// CLASSE CACHORRO E GATO
// Cachorro é subclasse da classe animal que é superclasse da classe cachorro
// Cachorro e Gato são subclasses de Animal, o que significa que herdam o atributo peso da classe Animal
// A classe Cachorro tem um método latir(), e a classe Gato tem um método miar(). Esses métodos representam os comportamentos específicos de cada animal.

/*
Ao ler a declaração de classe abaixo, podemos dizer as frases:
- Cachorro É Animal
- Cachorro herda de animal
- Cachorro é subclasse da superclasse Animal.
*/

class Cachorro: Animal(){
    fun latir(){
        println("Au Au...")
    }
}
class Gato: Animal(){
    fun miar(){
        println("Miau...")
    }
}

// CRIANDO A CLASSE BOLA
// A classe Bola tem atributos como peso, parada (que indica se a bola está parada), e posicaoAtualX e posicaoAtualY (as coordenadas da bola no campo).
// Ela também tem um método chamado deslocar(), que simula o movimento da bola, movendo-a para uma nova posição, considerando velocidade e aceleração.
class Bola{
    var peso: Double = 0.0
    var parada: Boolean = true
    var posicaoAtualX: Int = 0
    var posicaoAtualY: Int = 0
    fun deslocar(posicaoDestinoX: Int,
                 posicaoDestinoY: Int,
                 velocidade: Double,
                 aceleracao: Double) {
        println("Bola se deslocou, "
                + "para:($posicaoDestinoX, $posicaoDestinoY) "
                + "velocidade: $velocidade e aceleração: $aceleracao")
    }
}

// CRIANDO A CLASSE JOGADOR
// A classe Jogador representa um jogador de futebol. Ela possui atributos como peso, nome, idade, posicaoAtualX, posicaoAtualY, e parado (indica se o jogador está parado).
// O método chutar() simula um jogador chutando a bola. Se o jogador estiver na mesma posição que a bola (posicaoAtualX e posicaoAtualY forem iguais), ele chuta a bola para uma nova posição usando o método deslocar() da classe Bola.
class Jogador{
    var peso: Double = 0.0
    var nome: String = ""
    var idade: Int = 0
    var posicaoAtualX: Int = 0
    var posicaoAtualY: Int = 0
    var parado: Boolean = false
    fun chutar(b:Bola, forca: Int, direcao: String) {
        if(this.posicaoAtualX == b.posicaoAtualX &&
            this.posicaoAtualY == b.posicaoAtualY){
            b.deslocar(500,500, 0.5, 0.2)
            println("Chute realizado")
        }else {
            println("Chute falhou")
        }
    }
}

// CRIANDO CLASSE ENDEREÇO DO TIPO "DATA"
/**
 * Quando temos uma classe do tipo "data" significa que ao instanciar um objeto endereço ele terá apenas os "dados" e não terá comportamentos.
 * Note que temos um construtor onde carregamos com as informações iniciais.
 */

// O que é uma classe do tipo "data"?
// A classe Endereco é uma data class. Em Kotlin, as data classes são usadas para representar dados, ou seja, elas são usadas quando a classe se destina a armazenar valores e não precisa de muitos comportamentos.

// A classe Endereco tem atributos como logradouro, numero, bairro, cidade, uf, e cep.
data class Endereco(
    var logradouro: String,
    var numero: Int,
    var complemento: String?,
    var bairro: String,
    var cidade: String,
    var uf: String,
    var cep: String
)

// EXEMPLO NO MÉTODO MAIN
fun main(){
    // Exemplo dos animais
    // O código cria um Cachorro e um Gato, define o peso de cada um e chama os métodos latir() e miar().
    var c1 = Cachorro()
    c1.peso = 1.0
    c1.latir()

    var g1 = Gato()
    g1.peso = 0.7
    g1.miar()

    // Exemplo jogo de futebol...
    // A bola é criada com uma posição específica, e dois jogadores, Neymar e Cristiano Ronaldo, têm suas posições definidas no campo. Neymar tenta chutar a bola (o chute só é realizado se o jogador e a bola estiverem na mesma posição).
    var b = Bola()
    b.parada = true
    b.peso = 0.410
    b.posicaoAtualX = 700
    b.posicaoAtualY = 500

    var j1 = Jogador()
    j1.peso = 75.0
    j1.nome = "Neymar"
    j1.idade = 32
    j1.posicaoAtualX = 700
    j1.posicaoAtualY = 500

    var j2 = Jogador()
    j2.peso = 75.0
    j2.nome = "Cristiano Ronaldo"
    j2.idade = 32
    j2.posicaoAtualX = 700
    j2.posicaoAtualY = 450
    j1.chutar(b,1,"NORTE")

    // Exemplo de endereço
    //  É criado um objeto Endereco com informações sobre um endereço e depois é impresso na tela.
    val e1 = Endereco("Av. Brasil", 500, null,
        "Centro","Campinas", "SP", "12345-123")
    println(e1)
}
