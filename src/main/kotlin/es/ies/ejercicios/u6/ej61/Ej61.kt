package es.ies.ejercicios.u6.ej61

import es.ies.ejercicios.u6.ej61.especializacion.Coche
import es.ies.ejercicios.u6.ej61.especializacion.Motocicleta
import es.ies.ejercicios.u6.ej61.extension.Autenticador
import es.ies.ejercicios.u6.ej61.extension.AutenticadorPin
import es.ies.ejercicios.u6.ej61.extension.AutenticadorPatron


import org.slf4j.LoggerFactory

/**
 * Ejercicio 6.1 — Tipos de herencia, clases y subclases (RA7.a).
 *
 * TODO: Implementa aquí las clases del ejercicio.
 * Recomendación: crea subpaquetes (p. ej. `especializacion`, `extension`, etc.)
 * y añade un `main` de ejemplo que muestre polimorfismo.
 */
object Ej61

val logger = LoggerFactory.getLogger("Relacion de ejercicios")


fun main() {


    val motocicleta = Motocicleta("Yamaha", "Pacifica", 100, 50, 125)
    val coche = Coche("Seat", "Ibiza", 300, 100, 4)

    motocicleta.realizarCaballito()
    coche.realizarDerrape()
    motocicleta.llenarTanque()
    coche.llenarTanque()

    val autenticador = Autenticador()
    val autenticadorPin = AutenticadorPin()
    val autenticadorPatron = AutenticadorPatron()

    autenticador.controlarAutenticacion()
    autenticadorPin.controlarAutenticacion()
    autenticadorPatron.controlarAutenticacion()


}
