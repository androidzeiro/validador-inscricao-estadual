object Validador {

    fun validar(uf: String, ie: String): Boolean {

        val factory = ValidadorFactory()
        val validador = factory.criar(uf)

        return validador.validate(ie)

    }

}