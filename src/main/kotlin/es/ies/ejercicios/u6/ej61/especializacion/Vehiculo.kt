package es.ies.ejercicios.u6.ej61.especializacion

abstract class Vehiculo(val marca : String,
                        val modelo : String,
                        val capacidadTanque : Int,
                        var combustibleActual : Int) {

    fun llenarTanque() {
        combustibleActual = capacidadTanque
        logger.info("Tanque lleno")
    }

}