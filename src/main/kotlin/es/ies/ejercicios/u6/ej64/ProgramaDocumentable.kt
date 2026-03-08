package es.ies.ejercicios.u6.ej64

/**
 * Representa un elemento que puede generar un resumen en texto.
 */
interface Resumible {
    fun resumen(): String
}

/**
 * Plantilla para generar un informe en distintos formatos.
 *
 * Relación con el resto del ejercicio:
 * - [Persona] y [Alumno] implementan [Resumible] y se pueden incluir como elementos del informe.
 *
 * Nota: el método [generar] está bloqueado (no es `open`) para forzar un flujo común
 * y permitir que las subclases solo personalicen las partes variables.
 */
abstract class PlantillaInforme : Resumible {
    fun generar(titulo: String, items: List<Resumible>): String {

        val sb = StringBuilder()

        sb.appendLine(cabecera(titulo))

        for (item in items) {
            sb.appendLine(formatearItem(item))
        }

        sb.appendLine(pie())
        return sb.toString()
    }

    protected open fun cabecera(titulo: String): String = titulo

    protected abstract fun formatearItem(item: Resumible): String

    protected open fun pie(): String = "-- fin --"

    override fun resumen(): String = "PlantillaInforme"
}
/**
 * Genera un informe en formato Markdown
 *
 * - La cabecera se forma con un titulo de nivel 1 usando #
 * - El formateo del iten se hace en formato elemento de lista usando -
 *
 */
class InformeMarkdown : PlantillaInforme() {
    override fun cabecera(titulo: String): String = "# $titulo"

    override fun formatearItem(item: Resumible): String = "- ${item.resumen()}"
}

/**
 * Genera un informe en formato CSV
 *
 * Las comas en los resúmenes se sustituyen por punto y coma para no
 * romper la estructura del CSV.
 *
 */
class InformeCsv : PlantillaInforme() {
    override fun cabecera(titulo: String): String = "titulo,$titulo\nitem"

    override fun formatearItem(item: Resumible): String = item.resumen().replace(",", ";")
}

/**
 * Representa una persona con un nombre y una edad
 *
 * @property nombre nombre de la persona
 * @property edad edad de la persona, por defecto 0 si no se indica
 */
open class Persona(
    val nombre: String,
    val edad: Int,
) : Resumible {
    init {
        println("[Persona:init] nombre=$nombre edad=$edad")
    }

    constructor(nombre: String) : this(nombre, edad = 0) {
        println("[Persona:secondary] constructor(nombre)")
    }

    override fun resumen(): String = "$nombre ($edad)"
}

/**
 * Representa un alumno con nombre, edad y curso
 * Extiende a Persona añadiendo el curso
 *
 * @property curso curso en el que está matriculado
 */
class Alumno : Persona {
    val curso: String

    constructor(nombre: String, edad: Int, curso: String) : super(nombre, edad) {

        this.curso = curso
        println("[Alumno:secondary] nombre=$nombre edad=$edad curso=$curso")
    }

    /**
     * Constructor sin edad que pone por defecto la edad a 0
     *
     * @param nombre nombre del alumno
     * @param curso curso del alumno
     */
    constructor(nombre: String, curso: String) : this(nombre, edad = 0, curso = curso) {
        println("[Alumno:secondary] constructor(nombre, curso)")
    }

    override fun resumen(): String = "Alumno: ${super.resumen()} curso=$curso"
}

/**
 * Registro de personas indexadas por nombres
 *
 * Se normaliza el nombre para evitar registros duplicados por diferencias de espacios o mayúsculas/minúsculas.
 */
class RegistroPersonas {
    private val personasPorNombre = mutableMapOf<String, Persona>()
    /**
     * Registra una persona, si ya existe con el mismo nombre se sobreescribe
     *
     * @param persona persona a registrar
     */
    fun registrar(persona: Persona) {
        val clave = normalizarNombre(persona.nombre)
        personasPorNombre[clave] = persona
    }

    /**
     * Busca persona por el nombre
     *
     * @param nombre nombre a buscar
     * @return la persona encontrada o null si no existe
     */
    fun buscar(nombre: String): Persona? = personasPorNombre[normalizarNombre(nombre)]

    /**
     * Elimina espacios y convierte a minúsculas para normalizar el nombre
     *
     * @param nombre nombre a normalizar
     * @return nombre normalizado
     */
    private fun normalizarNombre(nombre: String): String {
        return nombre.trim().lowercase()
    }
}
