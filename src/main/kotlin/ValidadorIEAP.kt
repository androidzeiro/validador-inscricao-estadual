class ValidadorIEAP  : ValidadorIE{
    override fun validate(ie: String): Boolean {
        if(ie.length != 9) {
            return false
        }
        val peso = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2)

        var p = 0
        var d = 0

        if(ie.substring(0, 8).toInt() in 3000001..3017000){
            d = 0
            p = 5
        } else if(ie.substring(0, 8).toInt() in 3017001..3019022){
            d = 1
            p = 9
        } else if(ie.substring(0, 8).toInt() > 3019023){
            d = 0
            p = 0
        }

        val deslocamentoPeso = calcularDeslocamentoPeso(ie.substring(0, 8), peso) + p

        val resto = deslocamentoPeso % 11
        var digito = 11 - resto
        if (digito == 10) {
            digito = 0
        } else if(digito == 11) {
            digito = d
        }
        return ie == ie.substring(0, 8) + digito.toString()
    }
}