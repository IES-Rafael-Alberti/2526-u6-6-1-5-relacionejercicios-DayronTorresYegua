package es.ies.ejercicios.u6.ej65.srp

import es.ies.ejercicios.u6.ej64.Alumno
import es.ies.ejercicios.u6.ej64.InformeMarkdown
import es.ies.ejercicios.u6.ej64.Persona
import es.ies.ejercicios.u6.ej64.RegistroPersonas
import es.ies.ejercicios.u6.ej64.Resumible
import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("Principio Solid SRP")

/**
 * v1 (mejorado): responsabilidades en su respectiva clase:
 * - DatosService: prepara datos
 * - RegistroService: normaliza y registra personas
 * - InformeService: genera informe
 * - LogService: hace logs
 */

class DatosService {
    fun obtenerItems() : List<Resumible> = listOf(
        Persona(" Ana ", 20),
        Alumno("Luis", 19, "1DAM"),
        Persona("Marta", 18),
    )
}

class RegistroService {
    private val registro = RegistroPersonas()

    fun registrar(items: List<Resumible>) {
        for (item in items) {
            if (item is Persona) registro.registrar(item)
        }
    }

    fun buscar(nombre : String) = registro.buscar(nombre)
}

class InformeService {
    fun generar(titulo : String, items : List<Resumible>) : String {
        return InformeMarkdown().generar(titulo, items)
    }
}

class LogService {
    fun log(mensaje : String) = logger.info(mensaje)
}

class InformeAppServiceV0 {

    private val logService = LogService()
    private val datosService = DatosService()
    private val informeService = InformeService()
    private val registroService = RegistroService()

    fun ejecutar() {
        logService.log("[SRP:v1] Preparando datos...")
        val items = datosService.obtenerItems()

        logService.log("[SRP:v1] Registrando personas...")
        registroService.registrar(items)

        logService.log("[SRP:v1] Generando informe Markdown...")
        val salida = informeService.generar("Listado", items)

        logService.log("[SRP:v1] Resultado:")
        logService.log(salida)

        logService.log("[SRP:v1] Buscar 'ana' -> ${registroService.buscar("ana")?.resumen()}")
    }
}

fun main() {
    InformeAppServiceV0().ejecutar()
}

