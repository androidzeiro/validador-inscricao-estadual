class ValidadorFactory {

    fun criar(uf: String): ValidadorIE {

        return when (uf) {
            "AC" -> ValidadorIEAC()
            "AL" -> ValidadorIEAL()
//            "AM" -> ValidadorIEAM()
//            "AP" -> ValidadorIEAP()
//            "BA" -> ValidadorIEBA()
//            "CE" -> ValidadorIECE()
//            "DF" -> ValidadorIEDF()
//            "ES" -> ValidadorIEES()
//            "GO" -> ValidadorIEGO()
//            "MA" -> ValidadorIEMA()
            "MT" -> ValidadorIEMT()
//            "MS" -> ValidadorIEMS()
//            "MG" -> ValidadorIEMG()
//            "PA" -> ValidadorIEPA()
//            "PB" -> ValidadorIEPB()
//            "PR" -> ValidadorIEPR()
//            "PE" -> ValidadorIEPE()
//            "PI" -> ValidadorIEPI()
//            "RJ" -> ValidadorIERJ()
//            "RN" -> ValidadorIERN()
//            "RO" -> ValidadorIERO()
//            "RS" -> ValidadorIERS()
//            "RR" -> ValidadorIERR()
//            "SC" -> ValidadorIESC()
//            "SE" -> ValidadorIESE()
//            "SP" -> ValidadorIESP()
//            "TO" -> ValidadorIETO()
            else -> TODO()
        }
    }
}