class ValidadorIEMT  : ValidadorIE{
    override fun validate(ie: String): Boolean {
        if(ie.length != 11) {
            return false
        }
        val peso = intArrayOf(3, 2, 9, 8, 7, 6, 5, 4, 3, 2)

        val deslocamentoPeso = calcularDeslocamentoPeso(ie.substring(0, 10), peso)
        val resto = deslocamentoPeso % 11
        if (resto == 0 || resto == 1) {
            return ie == ie.substring(0, 10) + "0"
        }
        var digito = 11 - resto
        return ie == ie.substring(0, 10) + digito.toString()
    }
}