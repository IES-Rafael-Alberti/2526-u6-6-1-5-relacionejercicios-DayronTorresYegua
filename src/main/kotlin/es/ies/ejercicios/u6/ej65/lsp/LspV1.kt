package es.ies.ejercicios.u6.ej65.lsp

import es.ies.ejercicios.u6.ej64.Persona
import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("Principio Solid LSP")

/**
 * Contrato: un repositorio que permite guardar y buscar personas.
 */

interface RepositorioEscritura {
    fun guardar(persona: Persona)
}


interface RepositorioLectura {
    fun buscar(nombre: String): Persona?

}

class RepositorioPersonasV1 : RepositorioEscritura, RepositorioLectura {
    private val map = mutableMapOf<String, Persona>()

    override fun guardar(persona: Persona) {
        map[persona.nombre] = persona
    }
    override fun buscar(nombre: String): Persona? = map[nombre]
}

class RepositorioSoloLecturaV1 : RepositorioLectura {
    private val map = mutableMapOf<String, Persona>()

    override fun buscar(nombre: String): Persona? = map[nombre]
}

fun cliente(repoEscritura: RepositorioEscritura, repoLectura : RepositorioLectura) {
    repoEscritura.guardar(Persona("Ana", 20))
    logger.info("Buscar Ana -> ${repoLectura.buscar("Ana")?.resumen()}")
}

fun main() {
    logger.info("[LSP:v1] Repositorio normal (ok)")
    val repo = RepositorioPersonasV1()
    cliente(repo, repo)

    logger.info("[LSP:v1] Repositorio solo lectura (sustitución válida, solo puede leer)")
    val repoSoloLectura = RepositorioSoloLecturaV1()

    logger.info("[LSP:v1] Buscar Ana en solo lectura -> ${repoSoloLectura.buscar("Ana")?.resumen()}")

}