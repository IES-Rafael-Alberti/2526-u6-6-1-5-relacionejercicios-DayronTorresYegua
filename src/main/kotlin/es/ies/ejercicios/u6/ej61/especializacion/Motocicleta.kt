package es.ies.ejercicios.u6.ej61.especializacion

class Motocicleta(marca : String,
                  modelo : String,
                  capacidadTanque : Int,
                  combustibleActual : Int,
                  val cilindrada : Int) : Vehiculo(marca, modelo, capacidadTanque, combustibleActual) {


    fun realizarCaballito() {
        combustibleActual -= 5

        if (combustibleActual < 0) {
            combustibleActual = 0
        }

        logger.info("Se realizó caballito, tanque actual: $combustibleActual")

    }

}