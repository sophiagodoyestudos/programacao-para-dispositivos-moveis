fun WeatherScreen() {
   Box (modifier = Modifier.fillMaxSize()) {
    
       Image (
       	painter = painterRecsource (id = R.drawavble.mars)
        contentDescription = stringResource(id = R.string.app_name)
        contentScale = ContentScale.FillHeight,
        modifier = Modifier.matchParentSize()
       )
       
	
       Column (horizontalAligment = Aligment.CenterHorizontally)
   		Spacer(Modifier.height(50.dp)) // Ver o que é esse Spacer 
        Text ( 
              "Mandalore",
              fontSize = 25.sp,
              fontFamilly = helveticaNeue,
              fontWeight
              color = Color(225, )
             )
        Text (
        	"27",
        )
        
        
        Row (
        	verticalAligment = Aligment=CenterVertically,
            horizontallyArrangment 
            modifier = Modifier
        )
        Card (
        	modifier = Modifier.weight(1f)
            colors = CardDefaults.cardColor
            containerC
        )
        
   }
}

// O que são modificadores - comporatmentos q seus layouts tem dee comportamento da tela
// usar fonts costumisadas requer o arquivo.ttf - res/font

// 1) precisamos criar um bom (uma caixa com uma imagem de fundo) - q representa no caso o planeta
// quando vc adiciona um box os elementos vizuais podem se sobrepor
// O que é agregação de composable? 
// Podemos e devemos separar uma tela complexa em composable agregados como exemplo do professor HerderINfo e no layout completo ficará mais fácil
// compreender as partes da tela 
// quanto mais eu dimiunuo a cor do alpha mais transparente fica 
// quando tempo um composable row  podemos definir o peso dos elementos na linha 
// Porque tem q ter o f quando é flout? 
// Qualquer composable q estuver dentro da row vc pode informar o peso pq ele é um modificador - modifier - Modifier.padding(20.dp, 10.dp) 
// // quanto menor o peso o que acontece? e quanto mais o peso? 
// O que é o HorizontalDivider (color = Color.White, thickness = 10.dp)
// O que é o FlowRow ?
// FlowRow e Row qual é a diferença?
// O que é o @DrawbleRes
// Escolher uma interface e clonar a interface escolhida no composable (ex: pegar a interface do banco da nubank e clonar)

FlowRow (
	maxLines = 1,
    overflow = FlowOverFlow.Clip
    modifier = Modifier.horizontalScroll(rememberScrolState()) // ver essa linha - vai manter o estado da rolagem 
) {
    HourVariationInfo("Agora", R.drawble.icon_sunser, "21")
    HourVariationInfo("18h", R.drawble.icon_sunset, "21")

}


@composable 
fun HeaderInfo(location: String, currentTemp: Double, min: Double, max: Double) {
    
    val helveticaNeu
}
