// Site de estudo: https://developer.android.com/codelabs/basic-android-kotlin-compose-build-a-dice-roller-app?hl=pt-br#6

package br.com.puc.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.puc.diceroller.ui.theme.DiceRollerTheme

// Definindo a minha MainActivity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Ponto de entrada do Compose na Activity
        setContent {
            // Aplica o tema do app (tema, tipografia, formas)
            DiceRollerTheme {
                // Chama a função composable raiz que define a UI
                DiceRollerApp()
            }
        }
    }
}

// Permite visualizar esse composable no Android Studio sem rodar o app
@Preview
// Indica que essa função monta UI.
@Composable
fun DiceRollerApp() {
    // Chamamos a outra função composable e passamos um Modifier para que o conteúdo ocupe toda a tela e centralize seu conteúdo 
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

// Função para definir a lógica e o layout do dado
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    
    /*
    - remember faz o Compose “lembrar” o valor entre recomposições.
    - mutableIntStateOf(1) inicializa em 1; toda vez que result muda, o Compose refaz a UI.
    */
    var result by remember { mutableIntStateOf( 1) }
    
    // Seleção da imagem -  escolhe qual recurso/imagem da pasta res/drawable usar
    val imageResource = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    
    // Define um Layout em forma de coluna 
    /*
    - modifier recebido do chamador, que já centraliza e estica a tela.
    - horizontalAlignment = Alignment.CenterHorizontally centraliza filhos na horizontal.
    */
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        
        // Exibição da face 
        /*
        - Image(painter = painterResource(imageResource), ...) busca o drawable correto.
		- contentDescription usa result.toString() para acessibilidade.
        */
        Image(painter = painterResource(imageResource), contentDescription = result.toString())
		
        // Botão para rolar o dado 
        /*
        - Button(onClick = { result = (1..6).random() }) gera um número aleatório de 1 a 6 e atribui a result.
        - Ao mudar result, o Compose redesenha Image, mostrando a nova face.
        - Dentro do botão, Text(text = stringResource(R.string.roll), fontSize = 24.sp) exibe o texto “Roll” (provavelmente “Jogar” no seu strings.xml), com fonte de 24 sp.
        */
        Button(
            onClick = {
                result = (1..6).random()
            },
        ) {
            Text(text = stringResource(R.string.roll), fontSize = 24.sp)
        }
    }
}
