package es.ies.ejercicios.u6.ej61.especializacion

class Coche(marca : String,
            modelo : String,
            capacidadTanque : Int,
            combustibleActual : Int,
            val numeroPuertas : Int) : Vehiculo(marca, modelo, capacidadTanque, combustibleActual) {

    fun realizarDerrape() {
        combustibleActual -= 10

        if (combustibleActual < 0) {
            combustibleActual = 0
        }

        logger.info("Se realizó derrape, tanque actual: $combustibleActual")
    }

}