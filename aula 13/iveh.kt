// https://medium.com/@alexruskovski/jetpack-compose-custom-views-c5fe3d6cbb03
 
// https://www.ikmultimedia.com/products/amplitubeios/?srsltid=AfmBOoqtydLOXWMYaIRqxdxEtI3us6OixxP3XFecl_4y6HEeAkuj1UH3

/*
O que é uma Custom View? 
Qual a diferença do Custom View para o Material Design? 
*/

/*
CRIPTOGRAFIA SIMÉTRICA
- A mesma chave que cifra é usada para decifrar e vice-versa 
Key (chave)
"Olá Maria" (K) => "4381b8xwnef984"
"4381b8xwnef984" (K) => "Olá Maria"

-> Não é muito seguro
-> A chave é COMPARTILHADA 

CRIPTOGRAFIA ASSIMÉTRICA 
Problema: 
- Bob que falar com a Alice de maneira criptografada P2P 

App do Bob:
- 2 chaves (K - priv - bob) e (K - pub - bob)

App da Alice:
- 2 chaves (K - priv - alice) e (K - pub - alice)

Cenário:
- Alice clica no nome do bob, abre a tela de mensagens, escreve oi e aperta enviar 
1) Quando a Alicia abriu a conversa com o Bob, o aplicativo fez o download da chave publica do Bob (destino)

2) Quando a Alicia apertou o botão enviar o app CIFROU a mensagem assim: 
-> "Oi" (k - pub - bob) = "bcew3678vienvro0978"

3) Quando o smartphone do Bob recebeu a mensagem da Alice ("bcew3678vienvro0978"), o app, decifrou a mensagem vinda da Alice com a chave PRIVADA DO BOB 

-> Esse método é mais seguro 
-> Chave é PRIVADA e só do usuário 

PESQUISAR SOBRE:
Ciptografia simetrica 
PBE - AES - PKCS5 Kotlin 
*/
