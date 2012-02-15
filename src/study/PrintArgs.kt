package printargs

fun main(args : Array<String>) {

    // join
    val join = args.join(",")
    println("args.join(\",\") = ${join}")

    // find
    val find = args.find({it == "2"})
    println("args.find({it == \"2\"}) = ${find}")
}

