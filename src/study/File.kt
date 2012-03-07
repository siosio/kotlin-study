package file

import java.io.*
import java.util.Collection
import java.util.ArrayList

val lineSeparator = System.getProperty("line.separator")

fun BufferedWriter.plusAssign(line:String) {
    this.write(line)
    this.write(lineSeparator)
    this.flush()
}

class File(val filePath : String) {

    inline fun read(func : (line:String) -> Unit) {
        val br = BufferedReader(InputStreamReader(FileInputStream(filePath)))
        try {
            while (true) {
                val line = br.readLine()
                if (line == null) {
                    break
                }
                func(line)
            }
        } finally {
            br.close()
        }
    }

    inline fun write(writer:(bw:BufferedWriter) -> Unit) {
        var bw = BufferedWriter(OutputStreamWriter(FileOutputStream(filePath)))
        try {
            writer(bw)
        } finally {
            bw.close()
        }
    }

    inline fun filter(filter:(line:String) -> Boolean):Collection<String> {
        val result:Collection<String> = ArrayList()
        read({
            if (filter(it)) result.add(it)
        })
        return result
    }
}

fun main(args : Array<String>) {
    val file1 = File(args[0])
    file1.read{println(it)}
    val file2 = File(args[0])
    file2.write({
        it += "1"
        it += "2"
        it += "3"
        it += "4"
    })
    val file3 = File(args[0])
    val filter = file3.filter {it <= "3"}
    println("filter = ${filter}")
}


