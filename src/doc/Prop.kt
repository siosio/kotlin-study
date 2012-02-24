import java.util.Date

public class Properties(var id:String, var name:String) {
    var kanaName : String? = null
    val lastUpdateTime : Date = Date()
}

fun main(args : Array<String>) {
    val prop = Properties("001", "なまえ")
    prop.kanaName = "カナ"
    println("prop.kanaName = ${prop.kanaName}")

    println("prop.lastUpdateTime = ${prop.lastUpdateTime}")
}

