package es.ies.ejercicios.u6.ej63

/**
 * Ejercicio 6.3 — Incidencia de constructores en la herencia (RA7.c).
 *
 * Punto de partida: revisa `Figuras.kt` y completa lo indicado en `docs/ejercicios/6.3.md`.
 */
object Ej63

fun main() {
    println("Ejercicio 6.3 (plantilla)")
    println("- Completa la jerarquía y los constructores en `es.ies.ejercicios.u6.ej63`")
    println("- Añade logs en init/constructores para ver el orden de inicialización")
    println("- Actualiza este main para instanciar usando distintos constructores")

    val r1 = Rectangulo(color = "rojo", etiqueta = "rect", ancho = 5, alto = 3)
    val r2 = Rectangulo(ancho = 5, alto = 3)
    val r3 = Rectangulo(lado = 5)

    val c1 = Circulo(color = "azul", etiqueta = "circ", radio = 4)
    val c2 = Circulo(radio = 4)

    val t1 = Triangulo(base = 6, altura = 4)
    val t2 = Triangulo(lado = 5)
}
