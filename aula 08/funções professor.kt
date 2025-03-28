// Primeira função - usando add(docImc) 
// Define uma função chamada gardarIMCnoFirestore que recebe um parâmetro imc do tipo Double
fun gardarIMCnoFirestore(imc: Double) {
    
  // Constante que representa o banco
    val db = Firebase.firestore

    // Cria um mapa (HashMap) chamado docImc que contém um par chave-valor. 
    // Aqui, a chave é a string "valor" e o valor é o parâmetro imc passado para a função.
    // Observação: Essa estrutura serve para representar os dados que serão salvos.
    val docImc = hashMapOf (
        "valor" to imc
    )

    // Acessa a coleção "imcs" dentro do Firestore e utiliza o método add(docImc). Esse método cria um novo documento com um ID gerado 
    // automaticamente e insere nele o conteúdo de docImc
    db.collection(collectionsPath:"imcs").add(docImc)
}

// Segunda função - usando document("HENRY").set(docImc)
// Define uma função chamada gardarIMCnoFirestore que recebe um parâmetro imc do tipo Double.
fun gardarIMCnoFirestore(imc: Double) {
    
    // Constante que representa o banco
    val db = Firebase.firestore
  
    // Cria um mapa chamado docImc com um par chave-valor, onde a chave é "valor" e o valor é o imc passado para a função.
    val docImc = hashMapOf (
        "valor" to imc
    )

    db.collection(collectionsPath:"imcs").document("HENRY").set(docImc)
    /*
    - db.collection(collectionsPath:"imcs"): Acessa a coleção "imcs" no Firestore.
    - .document("HENRY"): Seleciona o documento com ID "HENRY" dentro da coleção. Se esse documento não existir, ele será criado.
    - .set(docImc): Define ou sobrescreve os dados do documento selecionado com o conteúdo do mapa docImc.
    */
}
