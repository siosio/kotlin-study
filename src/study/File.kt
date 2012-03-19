package file

import java.io.*
import java.util.*

/**
* write file
*/
fun java.io.BufferedWriter.puts(line : String) {
  this.write(line.toString())
  this.write(lineSeparator)
  this.flush()
}

/** line separator */
private val lineSeparator = System.getProperty("line.separator")

class File(val filePath : String) : java.io.File(filePath) {

  private val file = java.io.File(filePath)

  val name : String
  get() = file.getName().sure()

  inline fun read(func : (line : String) -> Unit) {
    val br = BufferedReader(InputStreamReader(FileInputStream(filePath)))
    try {
      while (true) {
        val line : String? = br.readLine()
        if (line == null) {
          break
        }
        func(line)
      }
    } finally {
      br.close()
    }
  }

  fun readAll() : List<String> {
    val lines : List<String> = ArrayList<String>
    read({
      lines.add(it)
    })
    return lines
  }

  inline fun write(writer : (bw : BufferedWriter) -> Unit) : Unit {
    var bw = BufferedWriter(OutputStreamWriter(FileOutputStream(filePath)))
    try {
      writer(bw)
    } finally {
      bw.close()
    }
  }

  inline fun filter(filter : (line : String) -> Boolean) : Collection<String> {
    val result : Collection<String> = ArrayList()
    read({
      if (filter(it)) result.add(it)
    })
    return result
  }
}

