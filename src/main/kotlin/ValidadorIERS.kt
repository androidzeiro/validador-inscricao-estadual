class ValidadorIERS  : ValidadorIE{
    override fun validate(ie: String): Boolean {
        if(ie.length != 10) {
            return false
        }
        val peso = intArrayOf(2, 9, 8, 7, 6, 5, 4, 3, 2)

        val deslocamentoPeso = calcularDeslocamentoPeso(ie.substring(0, 9), peso)
        var digito = 0
        if(deslocamentoPeso < 11) {
            digito = 11 - deslocamentoPeso
        } else {
            val resto = deslocamentoPeso % 11
            digito = 11 - resto
            if (digito == 10 || digito == 11) {
                digito = 0
            }
        }

        return ie == ie.substring(0, 9) + digito.toString()
    }
}