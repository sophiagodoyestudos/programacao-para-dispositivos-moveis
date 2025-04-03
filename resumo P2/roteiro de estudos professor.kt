/*
1) O QUE É O @COMPOSABLE? 
- Jetpack Compose é um framework moderno do Android para criar interfaces usando apenas a linguagem Kotlin 
- Ele é declarativo, ou seja, eu escrevo o que quero que apareça na tela e o Compose monta pra mim. É mais simples, rápido e fácil de manter.
- Com funções marcadas com @Composable, eu monto a interface como blocos de código. Se o estado mudar, o Compose atualiza só o que precisa na tela.
- Compose: forma nova, tudo no Kotlin, mais simples.

- O QUE É XML? 
- XML é a forma tradicional de criar interfaces no Android. 
- É uma linguagem de marcação usada pra montar a tela separada do código Kotlin/Java. 
- Cada componente da interface (como botão, texto, imagem) é definido como uma tag XML.
- No XML, a interface é declarada num arquivo separado (como activity_main.xml) e o código Kotlin usa findViewById pra acessar os elementos. 
- Já no Jetpack Compose, tudo é feito direto no Kotlin, sem XML.
- XML: forma antiga, usa arquivos separados, XML + Kotlin

2) QUAIS SÃO OS CONCEITOS BÁSICOS DE UM COMPOSE?
2.1) @COMPOSABLE 
- Função que desenha algo na tela 
- Tudo no Compose é feito dentro de funções marcadas com @Composable.

O QUE É UM MÉTODO (FUNÇÃO) ANOTADO COM @COMPOSABLE?
- É uma função especial no Jetpack Compose que serve para desenhar elementos da interface na tela.
Ela é anotada com @Composable para o sistema saber que essa função monta UI (interface gráfica).
*/
@Composable
fun Saudacao() {
    Text(text = "Olá, mundo!")
}

/*
2.2) COMPOSABLE FUNCTIONS ANINHADAS
- Você pode usar uma composable dentro da outra, como se fossem blocos LEGO.
*/
@Composable
fun Tela() {
    Column {
        Text("Bem-vindo")
        Button(onClick = { /* ação */ }) {
            Text("Clique aqui")
        }
    }
}

/*
2.3) LAYOUTS: COLUMN, ROW, BOX
O QUE É UM GERENCIADOR DE LAYOUT DO @COMPOSE?
- É um componente que organiza os elementos na tela.
- No Jetpack Compose, usamos Column, Row e Box como gerenciadores de layout — eles controlam posição e alinhamento dos itens filhos.
a) COLUMN 
- Column é um gerenciador de layout que organiza os elementos um embaixo do outro (verticalmente).
- Pensa como uma coluna de textos empilhados de cima pra baixo.
*/
Column {
    Text("Linha 1")
    Text("Linha 2")
}

/*
b) ROW
- Organiza os elementos lado a lado (horizontalmente), da esquerda para a direita.package- 
- Pensa como uma linha de itens na mesma fileira.
*/
Row {
    Text("Item A")
    Text("Item B")
    Text("Item C")
}

/*
c) BOX
- Coloca os elementos sobrepostos, um em cima do outro (como camadas).
- Útil pra colocar elementos um por cima do outro, tipo um texto em cima de uma imagem.
*/
Box {
    Text("Fundo")
    Text("Topo")
}

/*
2.4) MODIFIER
- Modifier é um componente do Compose usado para modificar a aparência e o comportamento de um elemento da interface.
Com ele, você pode aplicar tamanho, espaçamento, alinhamento, cor, clique, bordas e muito mais.
*/
// Esse Modifier.padding(16.dp) aplica um espaçamento interno de 16 pixels ao redor do texto.
Text(
    text = "Exemplo",
    modifier = Modifier.padding(16.dp)
)

/*
2.5) STATE
- Usado para mudar a interface com base em variáveis (como cliques, textos digitados, etc.)
- Usa remember e mutableStateOf.

O QUE É UMA VARIÁVEL COM REMEMBER?
- Uma variável com remember é usada no Jetpack Compose para manter o valor dela na memória enquanto a tela estiver visível.
- Serve para guardar o estado da interface, como o número de cliques, o texto digitado, se um botão foi pressionado, etc.
- Uma variável com remember é usada em funções @Composable para guardar dados temporários da interface enquanto a tela está sendo exibida.
- Ela mantém o valor entre recomposições (redesenhos da UI) e é muito usada para controlar o estado de botões, campos de texto, contadores, etc.

Resposta para prova:
- Uma variável com remember dentro de um Composable é usada para manter o estado da interface durante o uso da tela.
- Mesmo se a função for redesenhada (recomposta), o valor da variável continua o mesmo.
- É ideal para guardar valores temporários como texto digitado, botão clicado, contador, etc.
*/
@Composable
fun Contador() {
    // mutableStateOf(0) cria uma variável reativa — quando ela muda, a UI se atualiza automaticamente
    var contador by remember { mutableStateOf(0) }

    Button(onClick = { contador++ }) {
        Text("Cliquei $contador vezes")
    }
}
/*
Nesse exemplo:
a) contador é uma variável com remember
b) Ela guarda o número de cliques
c) Mesmo que a tela seja redesenhada (recomposição), o valor continua igual
*/

/*
3) O QUE SÃO OS ARQUIVOS GRADLE E A FUNÇÃO DE CADA UM?
- Os arquivos Gradle são usados para configurar e automatizar a construção (build) de um projeto Android. 
- Eles definem quais dependências o app precisa, como ele será compilado e outras configurações importantes para o projeto funcionar corretamente.

Resumindo:
- Os arquivos Gradle são responsáveis por configurar o projeto Android. 
- Eles definem quais bibliotecas o app usa, quais versões do Android ele suporta, e como ele deve ser construído. 
- Eles servem para dizer ao Android Studio como montar (compilar) o app. Por exemplo:
a) Qual versão do Android vai usar.
b) Quais bibliotecas (como Firebase, Compose, etc) seu app precisa.
c) Qual é o nome e a versão do seu app.
d) Como o app será empacotado (debug ou lançamento).

- No Android, usamos principalmente dois arquivos Gradle:

3.1) BUILD.GRADLE (PROJECT)
- Fica fora da pasta app
- É o arquivo que cuida do projeto inteiro.
- Ele define plugins e repositórios onde o Gradle vai buscar bibliotecas.
- Define coisas que todos os módulos vão usar juntos.
- Ex: qual plugin de Kotlin todos vão usar, onde baixar bibliotecas (Google, Maven, etc).

3.2) BUILD.GRADLE (APP OU MÓDULO)
- É o que cuida do seu aplicativo em si.
- Fica dentro da pasta app. Aqui você diz:
a) Qual SDK Android vai usar.
b) Qual a versão mínima e alvo do Android.
c) Qual o ID do app, nome da versão e código da versão.
d) Quais dependências o app precisa para funcionar.
- Define coisas só do app Android.
- Ex: qual SDK usar, quais bibliotecas específicas esse app vai ter (ex: Firebase, Retrofit, etc).

Resumindo:
- Project = configurações globais (pra todo o projeto).
- App = configurações locais (só do app em si).
- O build.gradle (Project) controla o projeto inteiro e configurações que afetam todos os módulos.
- O build.gradle (App) cuida do que é só do aplicativo, como SDK, nome e bibliotecas usadas no app.
*/

// O QUE TEM DENTRO DO ARQUIVO BUILD.GRADLE (APP OU MÓDULO - dentro da pasta app)
/*
- Este é o arquivo de configuração específico do seu aplicativo Android, ou de um módulo individual. 
- Aqui é onde você configura o que o app vai fazer, qual é o SDK alvo, dependências específicas, etc.
*/
// Declara o plugin principal para esse módulo (ex: app Android ou biblioteca).
plugins {...}

// Define informações do Android
android {...}

// Onde você declara todas as bibliotecas que seu app vai usar:
dependencies{...}

// O QUE TEM DENTRO DO ARQUIVO BUILD.GRADLE (PROJECT - fora da pasta app)
/*
- Este é o arquivo de configuração do projeto inteiro. 
- Ele cuida de configurações que valem para todos os módulos do projeto (por exemplo: o módulo app, ou outros módulos de biblioteca que você crie).
- Define os plugins usados no projeto como um todo.
*/
plugins{...}

/*
4) O QUE É O FIREBASE, FIRESTORE, FIREBASE AUTH?
4.1) FIREBASE
- Firebase é uma plataforma do Google para desenvolvimento de aplicativos (Android, iOS e web).
- Ele oferece várias ferramentas para facilitar sua vida como dev, como:
a) Banco de dados na nuvem
b) Autenticação de usuários
c) Notificações push
d) Hospedagem
e) Analytics
- Ou seja, é como um "kit completo" para backend e infraestrutura sem precisar criar tudo do zero (ele já vem pronto, você só precisa se preocupar 
com a lógica de programação)

4.2) FIRESTORE (BANCO DE DADOS)
- Firestore é o banco de dados em tempo real baseado em documentos do Firebase (não usa tabelas, mas sim coleções e documentos).
- É em tempo real: se os dados mudarem, o app pode ser atualizado automaticamente.

A) O QUE SÃO OS DOCUMENTOS?
- No Firestore, documentos são como registros de dados individuais.
- Cada documento tem um ID único
- Dentro dele, ficam os campos com os dados (como nome, email, telefone, etc.)

B) O QUE SÃO AS COLEÇÕES?
- Coleções são conjuntos de documentos.
- É como se fosse uma "pasta" que guarda vários documentos relacionados.

Exemplo:
- Uma coleção chamada usuários, vai guardar as informações de todos os usuários (esses usuários vão estar separados em documentos)

4.3) FIREBASE AUTH (AUTENTICAÇÃO)
- É o serviço de autenticação de usuários do Firebase.
- Com ele, você consegue logar e registrar usuários com:
a) E-mail e senha
b) Google, Facebook, Apple, GitHub, etc.
c) Telefone com SMS
d) Anonimamente (modo guest)
- Ele cuida de toda a parte chata da autenticação (criação de conta, login, tokens, segurança).

QUAL A DIFERENÇA PARA O AUTENTICAÇÃO DO ANONIMO PARA OS OUTROS? 
- A autenticação anônima no Firebase Auth cria um usuário temporário sem precisar de e-mail, senha, Google, etc
- Deixar o usuário explorar o app sem se cadastrar ainda
- Depois ele pode vincular esse login a um e-mail ou conta Google (sem perder os dados)

MAS E A LÓGICA DE VERIFICAÇÃO ELE FAZ AUTOMATICAMENTE? 
- O Firebase Auth faz a autenticação dos usuários automaticamente. 
Ele verifica e-mail e senha, cuida do login com Google ou telefone, mantém a sessão do usuário e gera um UID e tokens seguros.
- Eu preciso programar o envio e verificação de e-mail (sendEmailVerification()), validar se o perfil está completo, controlar permissões 
(como admin ou usuário comum) e criar as telas de login e cadastro.

5) ANDROID MANIFEST.XML
5.1) O QUE É O ARQUIVO ANDROIDMANIFEST.XML? 
- É um arquivo de configuração que descreve informações essenciais sobre o app para o sistema Android.
Tudo que o sistema precisa saber sobre seu app (como nome, permissões e atividades) fica aqui.

COMO É O ARQUIVO ANDROIDMANIFEST.XML:
*/

// Explicação do seu AndroidManifest.xml
<?xml version="1.0" encoding="utf-8"?> 
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
	
    /*
    <application>
    - Define a aplicação inteira: nome, ícone, tema, etc.
    - representa o app inteiro
    */
    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Prova02"
        tools:targetApi="31">
        
    	/*
    	<activity>
        - Declara cada tela do seu app
        - representa uma tela do app
        */
    	<activity
            android:name=".MainActivity"
            android:exported="true"
            android:label="@string/app_name"
            android:theme="@style/Theme.Prova02">
    		
    		/*
    		<intent-filter>
            - define a tela que abre quando o app é iniciado
            - nesse caso -  Diz que MainActivity é a tela inicial do app (ícone no menu do celular).
            */
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>

/*
6) QUAIS SÃO OS PROCEDIMENTOS PARA FAZER O SEU PROJETO ANDROID FUNCIONAR COM O FIREBASE?
A) Criar o projeto no Firebase Console
B) Registrar o app Android - nome do meu pacote 
C) Baixar o arquivo google-services.json (ele deve ser colocado dentro da pasta app)
D) Modificar o arquivo build.gradle (nível do projeto)
E) Modificar o arquivo build.gradle (nível do app)
F) Sincronizar o projeto (Sync Now)
G) Usar os serviços Firebase no código

7) O QUE É O ARQUIVO GOOGLE-SERVICES.JSON
- É um arquivo gerado pelo Firebase que contém as configurações do seu app Android.
- Ele conecta seu projeto Android ao projeto criado no Firebase Console.
- Ele tem que ser colocado dentro da pasta app do seu aplicativo Android

8) O QUE ACONTECE QUANDO EU APERTO O SYNC NOW
- Ao clicar em Sync Now, o Android Studio sincroniza o Gradle com os arquivos build.gradle, baixando e aplicando todas as dependências e configurações atualizadas.
Isso garante que o projeto esteja pronto para compilar com as bibliotecas e plugins configurados.

9) USO BÁSICO DO FIRESTORE (SEM REGRAS DE SEGURANÇA) 
*/
// OPÇÃO 01:
fun guardarIMCFirestore(imc: Double) {
        // Obtendo a instância db (singleton)
    	// Pegamos o “acesso” ao banco de dados na nuvem (Firestore), para que possamos enviar dados para ele
        val db = Firebase.firestore 

        // Criar um documento com o IMC e salvar no Firestore
        /*
        Aqui, criamos um documento (registro) para salvar no Firestore. O documento é um mapa (hash map) que contém o valor do IMC
         */
        val docIMC = hashMapOf(
            "valor" to imc
        )

        // Enviando para o banco de dados
        db.collection("imcs").add(docIMC) 
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

// OPÇÃO 02
fun saveNewTask(name: String, description: String) {
    val db = Firebase.firestore
    val newTask = hashMapOf(
        "name" to name,
        "description" to description
    )
    
    // Enviando para o banco de dados
    db.collection("tasks").add(newTask)
}

// USO BÁSICO DO FIREBASE AUTH 
// OPÇÃO 01
fun createNewAccount(email: String, password: String) {
    // Inicialização do FirebaseAuth
    val auth = Firebase.auth
	
    // Criar uma nova conta (cadastro)
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                Log.i("AUTH-TESTE", "Usuário criado com sucesso. UID: ${user!!.uid}")
            } else {
                Log.i("AUTH-TESTE", "Falha ao criar o usuário.")
            }
        }
}

// OPÇÃO 02
// Fazer login com e-mail e senha
fun loginTestAuth() {
    val auth = Firebase.auth
    auth.signInWithEmailAndPassword("sophia@exemplo.com", "743274")
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = task.result.user
                Log.i("AUTH-TESTE", "Login realizado com sucesso. UID: ${user!!.uid}")
            } else {
                Log.i("AUTH-TESTE", "Falha no login.")
            }
        }
}

// Isso conecta a interface ao Firebase Auth
// Ao clicar, o app faz login com dados fixos usando o Firebase
Button(
    onClick = {
        loginTestAuth()
        // ou createNewAccount(...) se quiser testar cadastro
    }
)

/*
10) O QUE É UM PACOTE? 
- Um pacote é uma pasta organizadora que agrupa os arquivos do seu app, como atividades (Activities), telas, funções, classes e componentes.
- Ele ajuda a manter o código organizado e evita conflitos entre nomes de arquivos.

Exemplo:
package br.com.puc.imc
- Esse trecho diz que o arquivo faz parte do pacote br.com.puc.imc

Resposta para a prova:
- Um pacote (package) é uma estrutura que agrupa e organiza os arquivos do app, como telas (Activities), classes de lógica, funções e componentes visuais.
- Ele é definido no início do arquivo com package nome.do.pacote e ajuda a manter o projeto organizado e evitar conflitos de nomes.

11) USER AUTHENTICATION X USER PERMISSIONS 
- User Authentication serve para identificar o usuário dentro do app, usando login com e-mail, senha ou redes sociais.
- Já as User Permissions são permissões declaradas no AndroidManifest.xml que controlam o acesso do app a recursos do sistema, 
como câmera e localização.
- Ou seja, Auth controla quem usa, e Permissions controlam o que o app pode usar no celular.

12) QUAL A DIFERENÇA DE COMPOSE PARA XML VANTAGENS E DESVANTAGENS?
a) XML (modo antigo)
- Usa arquivos .xml pra montar a interface da tela (layouts separados do código).

b) COMPOSE (modo moderno)
- Cria a interface direto no código Kotlin, com funções @Composable.

Resposta para a prova:
- Jetpack Compose é uma forma moderna de construir interfaces diretamente com código Kotlin, usando funções @Composable.
- Já o XML é o método tradicional, onde os layouts são definidos em arquivos separados.
- Compose oferece vantagens como código mais limpo, reatividade automática e maior flexibilidade.
- No entanto, o XML ainda é mais consolidado, com mais recursos online e suporte total em projetos legados.

13) QUAL É A DIFERENÇA DO FIREBASE vs GOOGLE CLOUD 
- Firebase é uma plataforma voltada para criar apps móveis e web rapidamente, com ferramentas prontas como login, banco de dados e notificações.
- Já o Google Cloud é uma plataforma completa de computação em nuvem, usada para montar sistemas maiores e personalizados, como servidores, bancos 
de dados, inteligência artificial e APIs.

- Em resumo: Firebase é mais simples e pronto, enquanto o Google Cloud é mais poderoso e flexível.

13) QUAL É A ESTRUTURA DE UM PROJETO ANDROID? O QUE VAI EM CADA DIRETÓRIO?
- A estrutura de um projeto Android é organizada em dois níveis: o projeto e o módulo app.
- O projeto contém arquivos globais como build.gradle, settings.gradle e gradle.properties.
- O módulo app contém o código do aplicativo, dividido em java/ para a lógica, res/ para recursos visuais (como layouts, imagens e textos) e o 
AndroidManifest.xml, que declara o nome do app, permissões e tela inicial.
*/

/*
O QUE MAIS REVISAR?
1) REVISAR CONHECIMENTOS DE KOTLIN (PROVA O1 - refazer)
2) ONDE FICA UM ARQUIVO? - PODE PERGUNTAR 
3) PARA QUE SERVE UMA LINHA DE UM ARQUIVO? PARA QUE SERVE ESSE ARQUIVO? - PODE PERGUNTAR 
4) PODE PEDIR PARA COMPLETAR O CÓDIGO, ARRUMAR O CÓDIGO, POR REMEMBER SE PRECISAR
5) ESTUDAR PELA DOCUMENTAÇÃO DO FIREBASE (Get started Firebase) E CODLABS DO DICEROLLER)
6) VER MONTAGEM DE TELA COMPLEXA
*/
