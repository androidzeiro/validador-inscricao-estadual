class ValidadorIEAL  : ValidadorIE{
    override fun validate(ie: String): Boolean {
        if (ie.length != 9) {
            return false
        }
        val peso = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2)

        var deslocamentoPeso = calcularDeslocamentoPeso(ie.substring(0, 8), peso)
        val resto = deslocamentoPeso % 11
        var digito = 11 - resto
        if (resto == 10) {
            digito = 0
        }
        return ie == ie.substring(0, 8) + digito.toString()
    }
}