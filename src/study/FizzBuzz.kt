class FizzBuzz {
    fun main(args : Array<String>) {
        (0..100).foreach {
            println(
            when (#(it % 5, it % 3)) {
                is #(0, 0) -> "FizzBuzz"
                is #(0, *) -> "Fizz"
                is #(*, 0) -> "Buzz"
                else -> it
            }
            )
        }
    }
}
