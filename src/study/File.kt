package file

import java.io.*
import java.util.ArrayList
import java.util.Collection
import java.util.List

/** line separator */
private val LINE_SEPARATOR = System.getProperty("line.separator")

/**
* write file
*/
inline fun java.io.BufferedWriter.puts(line : String) {
  this.write(line.toString())
  this.write(LINE_SEPARATOR)
  this.flush()
}

inline fun java.io.BufferedWriter.plusAssign(line : String) {
  puts(line)
}

inline fun File.eachLine(callback : (line : String) -> Unit) {
  val br = BufferedReader(InputStreamReader(FileInputStream(this)))
  try {
    while (true) {
      val line : String? = br.readLine()
      if (line == null) {
        break
      }
      callback(line)
    }
  } finally {
    br.close()
  }
}

inline fun File.eachLineWithLineNo(callback : (lineNo : Int, line : String) -> Unit) {
  var lineNo : Int = 0
  eachLine({
    callback(++lineNo, it)
  })
}

inline fun File.write(writer : (bw : BufferedWriter) -> Unit) : Unit {
  var bw = BufferedWriter(OutputStreamWriter(FileOutputStream(this)))
  try {
    writer(bw)
  } finally {
    bw.close()
  }
}

inline fun File.readAll(filter : (line : String) -> Boolean = {true}) : Collection<String> {
  val lines : List<String> = ArrayList<String>()
  this.eachLine({
    if (filter(it))
      lines.add(it)
  })
  return lines
}

