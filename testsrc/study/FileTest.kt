package file.test

import file.*
import junit.framework.TestCase
import java.io.BufferedWriter
import kotlin.test.assertEquals

class FileTest() : TestCase() {

  override fun setUp() {
    // Create Test File
    val testFile : File = File("./temp/testFile.txt")
    testFile.write({
    })
  }

  fun testRead() : Unit {
    val file : File = File("./temp/testFile.txt")
    var lineNo : Int = 0
    file.read {
      lineNo++
      assertEquals("line = [${lineNo}]", "line${lineNo}", it)
    }
  }

  fun testReadAll() : Unit {
    val file : File = File("./temp/testFile.txt")
    val lines = file.readAll()
    assertEquals(6, lines.size(), "line count")
    assertEquals("line 1", "line1", lines.get(0))
    assertEquals("line 2", "line1", lines.get(0))
    assertEquals("line 3", "line1", lines.get(0))
    assertEquals("line 4", "line1", lines.get(0))
    assertEquals("line 5", "line1", lines.get(0))
    assertEquals("line 6", "line1", lines.get(0))
  }

  fun testName() {
    val file : File = File("./temp/testFile.txt")
    assertEquals("testFile.txt", file.name)
  }
}
