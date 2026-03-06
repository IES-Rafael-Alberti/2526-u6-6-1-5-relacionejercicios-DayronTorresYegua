package es.ies.ejercicios.u6.ej61.extension

class AutenticadorPatron() : Autenticador() {

    fun verificarPatron() {
        logger.info("Verificando patron")
    }

    override fun controlarAutenticacion() {
        verificarPatron()
        super.controlarAutenticacion()
    }
}