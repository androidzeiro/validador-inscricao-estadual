class ValidadorIEES  : ValidadorIE{
    override fun validate(ie: String): Boolean {
        if(ie.length != 9) {
            return false
        }
        val peso = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2)

        val deslocamentoPeso = calcularDeslocamentoPeso(ie.substring(0, 8), peso)
        var digito = 0
        if(deslocamentoPeso < 11) {
            digito = 11 - deslocamentoPeso
        } else {
            val resto = deslocamentoPeso % 11
            digito = 11 - resto
            if (resto == 0 || resto == 1) {
                digito = 0
            }
        }

        return ie == ie.substring(0, 8) + digito.toString()
    }
}