class ValidadorFactory {

    fun criar(uf: String) :  ValidadorIE {

        return when(uf){
            "MT" -> ValidadorIEMT()
            else -> TODO()
        }
    }
}