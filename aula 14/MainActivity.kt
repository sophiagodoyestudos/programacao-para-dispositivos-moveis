package br.com.ibm.aulatema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.ibm.aulatema.ui.theme.AulaTemaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Estou aplicando o tema do meu aplicativo aqui
            AulaTemaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Button (
        onClick = {

        }
    ) {
        Text("Clique-me")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AulaTemaTheme {
        Greeting("Android")
    }
}

/*
1) APLICANDO UM TEMA NO APP
- Um tema é um “padrão de visual” que o app segue: cores, fontes, formatos dos botões, etc.

2) POSSO TER VÁRIOS TEMAS E TROCAR ENTRE ELES
- Posso criar vários estilos diferentes (por exemplo, um tema claro e um tema escuro) e fazer o aplicativo mudar sozinho, dependendo da situação ou do gosto do usuário

3) O QUE É CARREGAMENTO DINÂMICO DE TEMA?
- É quando o próprio aplicativo escolhe automaticamente qual tema usar, sem precisar você mexer manualmente

4) SE O APP TIVER 70 TELAS, PORQUE USAR TEMAS?
- Padronização: Todas as telas ficam iguais no estilo, sem precisar configurar uma por uma.
- Menos trabalho: Você escreve menos código e economiza tempo.
- Se não tivesse tema, você teria que colocar a cor certa em cada botão, cada texto, cada título...

5) USAR TEMAS AJUDA NA ACESSIBILIDADE?
- Quando você usa temas, consegue controlar o visual para ajudar pessoas que:
a) Têm dificuldade com telas muito claras ou escuras.
b) Precisam de letras maiores, cores com mais contraste, etc.

6) MAS SÓ TEMA NÃO É SUFICIENTE PARA SER ACESSÍVEL?
- Porque o tema só muda o que a pessoa vê (cores, formas).
- Quem é cego, por exemplo, não vai se beneficiar apenas da cor: precisa que o app fale o que está na tela, que tenha botões com descrição e outros cuidados especiais.

7) IMPORTANTE
- Os temas tratam apenas do cortamento visual, não tratam do comportamento não visual
- Para pessoas que precisam de autocontrate o tema resolve essa situação, mas não resolve o problema de um cego
*/
