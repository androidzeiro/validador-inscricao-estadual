class ValidadorIEAC  : ValidadorIE{
    override fun validate(ie: String): Boolean {
        if (ie.length != 13) {
            return false
        }

        val primeiroPeso = intArrayOf(4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
        val segundoPeso = intArrayOf(5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)

        var primeiroDeslocamentoPeso = calcularDeslocamentoPeso(ie.substring(0, 11), primeiroPeso)
        val primeiroResto = primeiroDeslocamentoPeso % 11
        var primeiroDigito = 11 - primeiroResto

        if (primeiroDigito == 10 || primeiroDigito == 11) {
            primeiroDigito = 0
        }

        if (ie.substring(0, 12) != ie.substring(0, 11) + primeiroDigito.toString()) {
            return false
        }

        var segundoDeslocamentoPeso = calcularDeslocamentoPeso(ie.substring(0, 12), segundoPeso)
        val segundoResto = segundoDeslocamentoPeso % 11
        var segundoDigito = 11 - segundoResto
        if (segundoDigito == 10 || segundoDigito == 11) {
            segundoDigito = 0
        }
        return ie == ie.substring(0, 12) + segundoDigito.toString()
    }
}