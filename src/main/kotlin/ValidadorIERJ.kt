class ValidadorIERJ  : ValidadorIE{
    override fun validate(ie: String): Boolean {
        if(ie.length != 8) {
            return false
        }
        val peso = intArrayOf(2, 7, 6, 5, 4, 3, 2)

        val deslocamentoPeso = calcularDeslocamentoPeso(ie.substring(0, 7), peso)
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

        return ie == ie.substring(0, 7) + digito.toString()
    }
}