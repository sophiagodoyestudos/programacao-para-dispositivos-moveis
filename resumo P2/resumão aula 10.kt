// RESUMÃO AULA 10 PARA A PROVA 02

package br.com.ibm.authexemplo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.ibm.authexemplo.ui.theme.AuthExemploTheme

// Importações do Firebase Auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuthExemploTheme { // Nome que defini o meu aplicativo 
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					// Chamando a função Greeting
                    Greeting(
                        
                        /*
                        - A função Greeting está esperando um parâmetro chamado name.
                        - Esse parâmetro é usado para passar um valor para dentro da função. 
                        - No caso, você está passando a string "Android" como o valor para o parâmetro name.
                        */
                        name = "Android", 
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// Função para criar um novo usuário no Firebase Authentication 
// Ela recebe um e-mail e uma senha como entrada e cria o usuário com esses dados.
fun createNewAccount(email: String, password: String) {
    
    // Obtém a instância do Firebase Authentication para gerenciar a criação e autenticação de usuários.
    val auth = Firebase.auth
	
    // Obtém a instância do Firebase Authentication para gerenciar a criação e autenticação de usuários.
    auth.createUserWithEmailAndPassword(email, password)
    	
    	//  Quando o processo de criação do usuário é concluído, ele verifica se foi bem-sucedido:
        /*
        PARA QUE SERVE ESSE TASK?
        - O task é um objeto que contém o resultado da operação assíncrona (a criação do usuário ou o login). 
        - Ele informa se a operação foi bem-sucedida ou falhou.
        */
        .addOnCompleteListener { task -> 
            
            // Se sim, imprime o ID do usuário no console.
            if (task.isSuccessful) {
                
                /*
                - auth.currentUser retorna o usuário atual que está autenticado no Firebase. 
                Ou seja, ele pega o usuário que fez login ou foi criado com sucesso.
                - user é uma variável que armazena esse usuário para poder acessar suas informações, como o ID (UID) ou outros dados.
                */
                val user = auth.currentUser 
                
                // Log.i é uma função de log que imprime uma mensagem no console para depuração.
                Log.i("AUTH-TESTE", "Usuário criado com sucesso. UID: ${user!!.uid}")
            	
            // Se não, imprime uma mensagem de erro.
            } else {
                Log.i("AUTH-TESTE", "Falha ao criar o usuário.")
            }
        }
}

// Essa função tenta fazer o login de um usuário usando um e-mail e senha fixos.
fun loginTestAuth() {
    
    // Obtém a instância do Firebase Authentication para gerenciar a criação e autenticação de usuários.
    val auth = Firebase.auth

    // Tenta fazer o login com as credenciais fornecidas (no caso, um e-mail e senha de teste).
    auth.signInWithEmailAndPassword("sophia@exemplo.com", "743274")
        
    	// Quando o processo de login é concluído:
        .addOnCompleteListener { task ->
            
            // Se o login for bem-sucedido, o ID do usuário é impresso no console.
            if (task.isSuccessful) {
                val user = task.result.user
                Log.i("AUTH-TESTE", "Login realizado com sucesso. UID: ${user!!.uid}")
            } 
            
            // Se o login falhar, uma mensagem de erro será exibida.
            else {
                Log.i("AUTH-TESTE", "Falha no login.")
            }
        }
}

// Função que cria um botão. Quando o botão é clicado, ele chama a função loginTestAuth para testar o login.
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Button(
        onClick = {
            // Para testar criação de conta, descomente a linha abaixo:
            // createNewAccount("novousuario@exemplo.com", "123456")

            // Testa o login com credenciais fixas
            loginTestAuth()
        },
        modifier = modifier
    ) {
        Text(text = "Testar login")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AuthExemploTheme {
        Greeting("Android")
    }
}

/*
RESUMO AULA 10 NO ONEDRIVE

1) O QUE É O PROCESSO DE AUTENTICAÇÃO? 
- Autenticação é o processo de verificar a identidade de um usuário para garantir que ele é quem diz ser. 
No contexto de aplicativos, isso geralmente envolve pedir informações como nome de usuário e senha para garantir que o usuário tem acesso à sua 
conta.

2) O QUE O FIREBASE AUTHENTICATION FAZ? 
- O Firebase Authentication é uma ferramenta do Firebase que facilita o processo de autenticar usuários em seu aplicativo. 
Ele oferece várias opções, como login por e-mail e senha, login com redes sociais (Google, Facebook, etc.), e login anônimo. 
Ele também cuida da criação, login, verificação e gerenciamento de usuários para você, sem precisar implementar tudo manualmente.

3) MAS E A VERIFICAÇÃO? 
- o Firebase só autentica, ou seja, só confirma que a pessoa é quem ela disse que é. 
Verificar se essa pessoa PODE fazer tal coisa (tipo: ela é motorista? ela é gerente?) é você quem precisa programar.

Exemplo:
- Firebase: "Sim, esse é o João." 
- Você: "Beleza, agora vou ver se o João tem permissão pra aprovar cadastros, por exemplo." 

- Firebase authentication é somente o processo de autenticação, o processo de verificação você que fica responsável  

4) O QUE ACONTECE QUANDO EU ATIVO O PROVIDER DO FIREBASE? 
- Quando você ativa um provider (como e-mail/senha, Google, Facebook, etc.) no Firebase Authentication, você está habilitando a opção de 
autenticação para o seu aplicativo usar essas formas de login. Isso permite que seus usuários façam login usando esses métodos.

5) QUAL É A DIFERENÇA DO LOGIN ANONIMO PARA OS OUTROS?  
- O login anônimo permite que o usuário acesse seu aplicativo sem criar uma conta ou fornecer informações de login (como e-mail e senha). 
Ele recebe um ID único temporário, e você pode usar isso para oferecer acesso a funcionalidades do aplicativo. 
No entanto, ao contrário de outros métodos, ele não tem acesso a dados permanentes, como e-mails ou informações de conta, a menos que o 
usuário decida fazer login de forma tradicional mais tarde.

6) O QUE É CRASHLYTICS? 
- Crashlytics é uma ferramenta do Firebase que ajuda a monitorar e relatar falhas (crashes) do aplicativo. 
Ele coleta informações detalhadas sobre os erros que ocorrem, como onde o erro aconteceu e qual foi a causa, permitindo que você corrija 
problemas de forma mais eficiente. Ele também ajuda a priorizar falhas, focando nas mais críticas.package

7) QUAL É O PRIMEIRO PASSO QUE TEM QUE FAZER NO SEU CÓDIGO PARA UTILIZAR QUALQUER DEPENDÊNCIA DO FIREBASE? 
- O primeiro passo para usar qualquer dependência do Firebase em seu código é adicionar o Firebase ao seu projeto. 
Isso é feito através do firebase-bom, um arquivo de dependências no build.gradle do seu aplicativo. 
Você também precisa configurar o Firebase no console do Firebase, e adicionar o arquivo google-services.json ao seu projeto.package

8) O QUE ACONTECE SE APERTAR O SYNC NOW? 
- Sync Now é uma opção no Android Studio que permite sincronizar seu projeto com as últimas mudanças feitas nas dependências ou no arquivo 
build.gradle. Quando você aperta Sync Now, o Android Studio baixa ou atualiza as dependências do seu projeto, garantindo que o código e as 
bibliotecas que você está usando estejam atualizados e funcionando corretamente.

9) O QUE É O LOG CAT DO ANDROID STUDIO?
- O Logcat é uma ferramenta do Android Studio que exibe os logs de execução do seu aplicativo. 
Ele mostra mensagens detalhadas sobre o que está acontecendo no seu código, como mensagens de erro (crashes), mensagens de depuração 
(com Log.d(), por exemplo) e outros eventos importantes. Logcat é muito útil para debugar e entender o que está acontecendo enquanto seu 
aplicativo está rodando no dispositivo ou emulador.
*/
