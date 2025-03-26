// OLHAR AULA 08 NO ONE DRIVE

package br.com.puc.imc

// Importações de bibliotecas necessárias para o funcionamento do código
/*
Algumas dessas bibliotecas são específicas para o Firebase (para salvar dados no banco de dados),
e outras são para criar a interface do aplicativo (como botões, campos de texto e a tela em si)
 */

import android.os.Bundle

// Essa biblioteca import android.util.Log é usado para exibir mensagens de log (útil para debugar)
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Essas outras duas import com.google.firebase.firestore.ktx.firestore e import com.google.firebase.ktx.Firebase
// são para trabalhar com o Firestore, o banco de dados que vai armazenar o IMC.
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

// Definição da classe IMCActivity
// Aqui estamos definindo uma classe chamada IMCActivity, que é a tela onde o cálculo do IMC será feito
class IMCActivity : AppCompatActivity() {

    // Declaração das variáveis
    lateinit var btnCalcularImc: Button // Variável para o botão que o usuário vai clicar para calcular o IMC
    lateinit var etPeso: EditText // Variável para o campo onde o usuário vai inserir seu peso
    lateinit var etAltura: EditText // Variável para o campo onde o usuário vai inserir sua altura
    lateinit var tvResultado: TextView // Variável para o campo de texto onde o resultado do IMC será exibido

    // Criando a função onCreate (inicialização da tela)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Essa linha faz com que a interface se ajuste para ocupar toda a tela (sem espaços extras nas bordas)
        setContentView(R.layout.activity_imc) // define qual layout será mostrado na tela. activity_imc é um arquivo de layout (um XML) que define a estrutura visual da tela

        // Inicializando as views (componentes da interface)
        /*
        Aqui, estamos associando as variáveis de interface (como o botão, os campos de texto, etc.) aos elementos reais do layout que estão definidos no arquivo
        activity_imc.xml. As funções findViewById são usadas para buscar esses componentes pela referência de ID
         */
        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)
        btnCalcularImc = findViewById(R.id.btnCalcularIMC)
        tvResultado = findViewById(R.id.tvResultado)

        // Definição do comportamento do botão
        // Aqui, estamos configurando o que vai acontecer quando o botão for clicado
        btnCalcularImc.setOnClickListener {
            // Calculando o IMC
            val peso = etPeso.text.toString().toDouble()
            val altura = etAltura.text.toString().toDouble()
            val imc = peso / Math.pow(altura, 2.0)

            // Exibir o resultado do IMC na tela
            tvResultado.text = "Seu IMC é $imc"

            // Função para guardar o IMC no Firebase
            guardarIMCFirestore(imc)
        }

        // Ajustes na interface para telas com bordas
        /*
        Esse bloco de código ajusta a interface para funcionar bem em dispositivos com bordas finas ou displays que exigem um ajuste no layout para que o
        conteúdo não seja coberto pela barra do sistema (como a barra de status ou de navegação).
         */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Função para guardar o IMC no Firestore
    fun guardarIMCFirestore(imc: Double) {
        val db = Firebase.firestore // Cria o acesso ao banco de dados

        // Criar um documento com o IMC e salvar no Firestore
        /*
        Aqui, criamos um documento (registro) para salvar no Firestore. O documento é um mapa (hash map) que contém o valor do IMC
         */
        val docIMC = hashMapOf(
            "valor" to imc
        )

        // Salvar o IMC na coleção "imcs"
        db.collection("imcs") // Salvará na coleção "imcs"
            .add(docIMC) // Adiciona o documento contendo o IMC calculado à coleção
            // Se o IMC for salvo com sucesso no Firestore, uma mensagem de sucesso será registrada nos logs.
            .addOnSuccessListener {
                Log.d("FIREBASE", "IMC salvo com sucesso")
            }
            // Se ocorrer um erro ao salvar o IMC, uma mensagem de erro será registrada nos logs.
            .addOnFailureListener { e ->
                Log.e("FIREBASE", "Erro ao salvar IMC", e)
            }
    } 
} 
