
fun String.validar(uf: String) : String{
    return when(uf){
        "MT" -> validarMT(this)
        else -> "{\"valido\": false, \"mensagem\": \"UF não encontrada\"}"
    }
}

// Validar Inscrição Estadual do estado do Mato Grosso
fun validarMT(ie: String) : String{
    if(ie.length != 11){
        return "{\"valido\": false, \"mensagem\": \"Inscrição estadual incorreta\"}"
    }
    val pesoMT = intArrayOf(3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
    fun calcularDigito(str: String, peso: IntArray): Int {
        var deslocamentoPeso = 0
        var indice = str.length - 1
        var digito: Int
        while (indice >= 0) {
            digito = Integer.parseInt(str.substring(indice, indice + 1))
            deslocamentoPeso += digito * peso[peso.size - str.length + indice]
            indice--
        }
        deslocamentoPeso %= 11
        deslocamentoPeso = 11 - deslocamentoPeso
        return if (deslocamentoPeso == 0 || deslocamentoPeso == 1) 0 else deslocamentoPeso
    }
    val digito = calcularDigito(ie.substring(0, 10), pesoMT)
    return if(ie == ie.substring(0, 10) + digito.toString()){
        "{\"valido\": true}"
    } else {
        "{\"valido\": false, \"mensagem\": \"Inscrição estadual inválida\"}"
    }
}