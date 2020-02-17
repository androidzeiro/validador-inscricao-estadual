
fun String.validar(uf: String) : Boolean{
    return when(uf){
        "AC" -> validarAC(this)
//        "AL" -> validarAL(this)
//        "AM" -> validarAM(this)
//        "AP" -> validarAP(this)
//        "BA" -> validarBA(this)
//        "CE" -> validarCE(this)
//        "DF" -> validarDF(this)
//        "ES" -> validarES(this)
//        "GO" -> validarGO(this)
//        "MA" -> validarMA(this)
        "MT" -> validarMT(this)
//        "MS" -> validarMS(this)
//        "MG" -> validarMG(this)
//        "PA" -> validarPA(this)
//        "PB" -> validarPB(this)
//        "PR" -> validarPR(this)
//        "PE" -> validarPE(this)
//        "PI" -> validarPI(this)
//        "RJ" -> validarRJ(this)
//        "RN" -> validarRN(this)
//        "RO" -> validarRO(this)
//        "RS" -> validarRS(this)
//        "RR" -> validarRR(this)
//        "SC" -> validarSC(this)
//        "SE" -> validarSE(this)
//        "SP" -> validarSP(this)
//        "TO" -> validarTO(this)
        else -> false
    }
}

// Validar Inscrição Estadual do estado do Acre
fun validarAC(ie: String) : Boolean{
    if(ie.length != 13) {
        return false
    }
    val primeiroPeso = intArrayOf(4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
    val segundoPeso = intArrayOf(5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)

    var primeiroDigito = calcularDigito(ie.substring(0, 11), primeiroPeso)
    primeiroDigito = if (primeiroDigito == 10 || primeiroDigito == 11) 0 else primeiroDigito

    if(ie.substring(0, 12) != ie.substring(0, 11) + primeiroDigito.toString()){
        return false
    }

    var segundoDigito = calcularDigito(ie.substring(0, 12), segundoPeso)
    segundoDigito = if (segundoDigito == 10 || segundoDigito == 11) 0 else segundoDigito

    return ie == ie.substring(0, 12) + segundoDigito.toString()
}

// Validar Inscrição Estadual do estado do Mato Grosso
fun validarMT(ie: String) : Boolean{
    if(ie.length != 11) {
        return false
    }
    val peso = intArrayOf(3, 2, 9, 8, 7, 6, 5, 4, 3, 2)

    var digito = calcularDigito(ie.substring(0, 10), peso)
    digito = if (digito == 0 || digito == 1) 0 else digito
    return ie == ie.substring(0, 10) + digito.toString()
}

// Função de Módulo 11
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
    return deslocamentoPeso
}