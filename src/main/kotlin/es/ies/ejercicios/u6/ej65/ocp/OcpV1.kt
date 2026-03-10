package es.ies.ejercicios.u6.ej65.ocp

import es.ies.ejercicios.u6.ej64.Resumible
import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("Principio Solid OCP")

interface GeneradorInformeV1 {
    fun generar(titulo: String, items: List<Resumible>): String
}

class GeneradorMarkdown : GeneradorInformeV1 {
    override fun generar(titulo: String, items: List<Resumible>): String =
        buildString {
            appendLine("# $titulo")
            for (item in items) appendLine("- ${item.resumen()}")
        }
}

class GeneradorCsv : GeneradorInformeV1 {
    override fun generar(titulo: String, items: List<Resumible>): String =
        buildString {
            appendLine("titulo,$titulo")
            appendLine("item")
            for (item in items) appendLine(item.resumen().replace(",", ";"))
        }
}

class GeneradorHtml : GeneradorInformeV1 {
    override fun generar(titulo: String, items: List<Resumible>): String =
        buildString {
            appendLine("<h1>$titulo</h1>")
            appendLine("<ul>")
            for (item in items) appendLine("  <li>${item.resumen()}</li>")
            appendLine("</ul>")
        }
}

fun main() {
    val items = listOf<Resumible>(
        object : Resumible { override fun resumen(): String = "Elemento A" },
        object : Resumible { override fun resumen(): String = "Elemento B" },
    )

    val generadores: List<GeneradorInformeV1> = listOf(
        GeneradorMarkdown(),
        GeneradorCsv(),
        GeneradorHtml(),
    )

    for (generador in generadores) {
        logger.info(generador.generar("Demo OCP", items))
        logger.info("---")
    }
}