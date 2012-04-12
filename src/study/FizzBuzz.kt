package fizzbuzz

fun main(args : Array<String>) {
  (0..100).forEach {
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
