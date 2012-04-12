package test.file

import java.io.File
import kotlin.test.assertEquals
import org.junit.Before
import org.junit.Test
import file.*

class FileTest() {

  private val testFile:File = File("./temp/testFile.txt")

  Before fun setUp() {
    // Create Test File
    testFile.write({
      it += "line1"
      it += "line2"
      it += "line3"
      it += "line4"
      it += "line5"
      it += "line6"
      it += "line7"
    })
  }

  Test fun testRead() : Unit {
    val file : File = File("./temp/testFile.txt")
    var lineNo : Int = 0
    file.eachLine() {
      lineNo++
      println("it = ${it}")
      assertEquals("line${lineNo}", it, "line = [${lineNo}]")
    }
  }

  fun testReadWithLineNo() : Unit {
    val file : File = File("./temp/testFile.txt")
    file.eachLineWithLineNo{lineNo, line ->
      println("it = ${line}")
      assertEquals("line${lineNo}", line, "line = [${lineNo}]")
    }
  }

  fun testReadAll() : Unit {
    val file : File = File("./temp/testFile.txt")
    val lines = file.readAll()
    assertEquals(7, lines.size(), "line count")
  }

  fun testReadAllFilter() : Unit {
    val file : File = File("./temp/testFile.txt")
    val lines = file.readAll({it.matches("(.*1|.*7)")})
    assertEquals(7, lines.size(), "line count")
  }
}

