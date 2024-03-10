package utils.io

import solutions.BaseSolution
import java.io.BufferedReader
import java.io.File

class FileUtils {
    companion object {
        private const val resourcesSubPath = "src/main/resources"
    }
    fun loadResourceFile(solutionFile: BaseSolution, fileName: String): List<String> {
        val packageName = solutionFile.javaClass.packageName.split(".").drop(1).joinToString("/")
        val file = File(File("${resourcesSubPath}/${packageName}/${fileName}").canonicalPath)
        return BufferedReader(file.reader()).readLines()
    }
}
