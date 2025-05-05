/*
AULA 15 

COMO USAR CAMERA NO ANDROID?
Passo a passo para usar cameras no Android:
1) Citar as dependências no libs.versions.toml 
- camerax = "1.5.0-alpha06"

Porque camerax? 
- Porque se tornou a ultima implementação de camera sobre a versão camera 2 
- Se tornou a definição de camera definitiva no Android (compatível)
- Na versão camera 01: foi criada desda versão 1,0 da versão Android e funcionava mais ou menos bem até a versão 5, 
funcionava a camera em um determinado dispositivo e outro n, n tinha padrão pq quem implementava os drivers das cameras eram os
fabricantes dos sensores de camera
- Camera 02: uma tentativa de melhorar o problema
- Dps houve uma tentativa de padronização, para funcionar em tds os aparelhos 
- Camerax foi foi feita pelo google, para funcionar em qualquer dispositivo baseada na camera 2 

- Na camera 1 dava mto problema pq os fabricantes n seguiam oq a google mandava, ou seja, funciona em alguns celulares (ou aplicativos????) e 
outros n


*/

/*
accompanist = "0.37.2" -> biblioteca facilitadora para permissões

BIBLIOTECAS PARA TRABALHAR COM CAMERA DE QUALQUER VERSÃO
1) androidx-camera-core -> se o sistema operacional pede para fechar o app o app fecha 
- núcleo de recursos básicos de sistema operacional para gerenciar a camera corretamente e implementação da camerax de fato 

2) androidx-camera-camera2 - base para o camerax funcionar (implementação base para o camera core funcionar) 
- biblioteca base para a camerax funcionar (a camerax é construida sobre a camera 2)

3) androidx-camera-lifecycle -> serve para q a sua camera consiga acompanahr o ciclo de vida da tela 
- bibliotecas que comandam o ciclo de vida tanto da camera quanto das activitys que contem as view de camera 

4) androidx-camera-compose 
- adaptações das view para funcionar no compose 

5) androix-camera-view - são as view espe cíficas de camera para acompanhar o compose (é a base para o compose)
- view originais para os componentes de cameras: preview e serface. 
O que é o preview?

Serface? 
- camada de superficie que posso colocar em cia do preview para rodar coisas 
- Surface é um componente que funciona junto com o preview

6) androix-camera-extensions - capacidade da camera, ex compartilhar arquivos, guardar a foto na galeria 

BIBLIOTECA PARA TRATAR PERMISSÕES RESTRITAS E INTEGRATIVAS 
1) accompanist-permissions - temos q pedir para o usuário se ele deseja abrir realemnte a camera
- permissão que o usuário tem q permitir manualmente 

permissão restita x permissão aberta (ou de base)

- Os aplicativos podem escutar os seus microfones por lei 
- Porque alguns aparelos n pedem permissões e outras n? 

https://github.com/tdcolvin/CameraXWorkshop.git

o que é um contrato de permissão?
- solicita a permissão de camera, se permitiu continua se n permitiu fecha o app 
- contract = ActivityResultConstracts.RequestPermission()

O que é o context? 
- Ele guarda as informações (mas n é para mudança de tela)

composable pode ser codigo puro com nada visual 
*/
