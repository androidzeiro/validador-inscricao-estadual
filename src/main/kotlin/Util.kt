
//// Validar Inscrição Estadual do estado do Alagoas
//fun validarAL(ie: String) : Boolean{
//    if(ie.length != 9) {
//        return false
//    }
//    val peso = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2)
//
//    var digito = calcularDigito(ie.substring(0, 8), peso)
//    digito = if (digito == 10) 0 else digito
//    return ie == ie.substring(0, 8) + digito.toString()
//}
//
//// Validar Inscrição Estadual do estado do Ceará
//fun validarCE(ie: String) : Boolean{
//    if(ie.length != 9) {
//        return false
//    }
//    val peso = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2)
//
//    var digito = calcularDigito(ie.substring(0, 8), peso)
//    digito = if (digito == 10 || digito == 11) 0 else digito
//    return ie == ie.substring(0, 8) + digito.toString()
//}
//
//// Validar Inscrição Estadual do estado do Maranhão
//fun validarMA(ie: String) : Boolean{
//    if(ie.length != 9) {
//        return false
//    }
//    val peso = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2)
//
//    var digito = calcularDigito(ie.substring(0, 8), peso)
//    digito = if (digito == 0 || digito == 1) 0 else digito
//    return ie == ie.substring(0, 8) + digito.toString()
//}
//
//// Validar Inscrição Estadual do estado do Mato Grosso
//fun validarMT(ie: String) : Boolean{
//    if(ie.length != 11) {
//        return false
//    }
//    val peso = intArrayOf(3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
//
//    var digito = calcularDigito(ie.substring(0, 10), peso)
//    digito = if (digito == 0 || digito == 1) 0 else digito
//    return ie == ie.substring(0, 10) + digito.toString()
//}
//
//// Validar Inscrição Estadual do estado do Mato Grosso do Sul
//fun validarMS(ie: String) : Boolean{
//    if(ie.length != 9) {
//        return false
//    }
//    val peso = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2)
//
//    var digito = calcularDigito(ie.substring(0, 8), peso)
//    digito = if (digito > 9) 0 else digito
//    return ie == ie.substring(0, 8) + digito.toString()
//}
//

fun calcularDeslocamentoPeso(str: String, peso: IntArray): Int {
    var deslocamentoPeso = 0
    var indice = str.length - 1
    var digito: Int
    while (indice >= 0) {
        digito = Integer.parseInt(str.substring(indice, indice + 1))
        deslocamentoPeso += digito * peso[peso.size - str.length + indice]
        indice--
    }
    return deslocamentoPeso
}