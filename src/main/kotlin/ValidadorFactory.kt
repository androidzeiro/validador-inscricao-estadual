class ValidadorFactory {

    fun criar(uf: String): ValidadorIE {

        return when (uf) {
            "AC" -> ValidadorIEAC()
            "AL" -> ValidadorIEAL()
            "AP" -> ValidadorIEAP()
            "AM" -> ValidadorIEAM()
//            "BA" -> ValidadorIEBA()
            "CE" -> ValidadorIECE()
            "DF" -> ValidadorIEDF()
            "ES" -> ValidadorIEES()
//            "GO" -> ValidadorIEGO()
            "MA" -> ValidadorIEMA()
            "MT" -> ValidadorIEMT()
            "MS" -> ValidadorIEMS()
//            "MG" -> ValidadorIEMG()
            "PA" -> ValidadorIEPA()
            "PB" -> ValidadorIEPB()
//            "PR" -> ValidadorIEPR()
//            "PE" -> ValidadorIEPE()
            "PI" -> ValidadorIEPI()
            "RJ" -> ValidadorIERJ()
//            "RN" -> ValidadorIERN()
            "RS" -> ValidadorIERS()
//            "RO" -> ValidadorIERO()
//            "RR" -> ValidadorIERR()
            "SC" -> ValidadorIESC()
//            "SP" -> ValidadorIESP()
            "SE" -> ValidadorIESE()
            "TO" -> ValidadorIETO()
            else -> TODO()
        }
    }
}