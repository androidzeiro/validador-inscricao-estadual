class ValidadorIETO  : ValidadorIE{
    override fun validate(ie: String): Boolean {
        if(ie.length != 11) {
            return false
        }

        var inicio = ie.substring(0, 2)
        var tipoEmpresa = ie.substring(2, 4)
        var final = ie.substring(4, 11)

        if(tipoEmpresa != "01" && tipoEmpresa != "02" && tipoEmpresa != "03" && tipoEmpresa != "99"){
            return false
        }

        val peso = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2)

        val deslocamentoPeso = calcularDeslocamentoPeso(inicio + final.substring(0, 6), peso)
        val resto = deslocamentoPeso % 11
        var digito = 11 - resto
        if (resto == 0 || resto == 1) {
            digito = 0
        }
        return ie == ie.substring(0, 10) + digito.toString()
    }
}