class ValidadorIEAL  : ValidadorIE{
    override fun validate(ie: String): Boolean {
        if (ie.length != 9) {
            return false
        }
        if(ie.substring(0, 2) != "24"){
            return false
        }

        var tipoEmpresa = ie.substring(2, 3)
        if(tipoEmpresa != "0" && tipoEmpresa != "3" && tipoEmpresa != "5" && tipoEmpresa != "7" && tipoEmpresa != "8"){
            return false
        }

        val peso = intArrayOf(9, 8, 7, 6, 5, 4, 3, 2)

        var deslocamentoPeso = calcularDeslocamentoPeso(ie.substring(0, 8), peso)
        val resto = deslocamentoPeso % 11
        var digito = (deslocamentoPeso * 10) % 11

        if (resto == 10) {
            digito = 0
        }


        return ie == ie.substring(0, 8) + digito.toString()
    }
}