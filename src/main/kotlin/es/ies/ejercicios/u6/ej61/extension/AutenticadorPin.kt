package es.ies.ejercicios.u6.ej61.extension

class AutenticadorPin() : Autenticador() {

    fun verificarPin() {
        logger.info("Verificando pin")
    }

    override fun controlarAutenticacion() {
        verificarPin()
        super.controlarAutenticacion()
    }
}