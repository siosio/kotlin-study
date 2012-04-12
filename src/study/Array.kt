package printargs

fun main(args : Array<String>) {

  //val arr = array("1", "2", "3", "4")

  // 各要素を連結
  // カンマで連結
  //arr.join(",")    // -> 1,2,3,4

  // プレフィックス、サフィックスを指定して連結
  //arr.join(",", "<", ">")    // <1,2,3,4>

  all()
  any()
  find()
  filter()
  filterNot()
  foreach()
  flatMap()
}

fun all() : Unit {
  var arr1 = array(1, 1, 1, 0)
  arr1.all {it == 1}
  println(arr1.all {it == 1 || it == 0})

  var arr2 = array(1, 1, 1, 1)
  arr2.all {it == 1}
  println(arr2.all {it == 1})

  var str = array("1", "2", "3")
  str.all {it <= "3"}
  println(str.all {it <= "2"})
}

fun any() : Unit {
  println("-------------------- any --------------------")
  var arr1 = array(1, 0, 2, 0)
  arr1.any {it == 1}    // -> true

  var arr2 = array("1", "2", "3")
  arr2.any{it > "3"}
  println(arr2.any{it > "3"})

}

fun find() : Unit {
  println("-------------------- find --------------------")
  var arr1 = array(1, 0, 2, 0)
  arr1.find {it == 0}    // -> 0
  println(arr1.find {it == 0})

  arr1.find {it == 2}    // 2
  println(arr1.find {it == 2})

  arr1.find {it == - 1}
  println(arr1.find {it == - 1})
}

fun filter() : Unit {
  println("-------------------- filter --------------------")
  var arr1 = array(1, 0, 2, 0)
  arr1.filter {it % 2 == 0}    // -> [0, 2, 0]
  println(arr1.filter {it % 2 == 0})

  var arr2 = array("1", "2", "3")
  arr2.filter {it.length() == 1}    // -> ["1", "2", "3"]

  // -> ["1", "2", "3"]
  println(arr2.filter {it.length() == 1})
  arr2.filter {it.length() != 1}    // -> []
  println(arr2.filter {it.length() != 1})
}

fun filterNot() : Unit {
  println("-------------------- filterNot --------------------")
  var arr1 = array(1, 0, 2, 0)
  arr1.filterNot {it % 2 == 0}    // -> [1]
  println(arr1.filterNot {it % 2 == 0})

  var arr2 = array("1", "2", "3")
  arr2.filterNot {it.length() != 1}    // -> ["1", "2", "3"]
  println(arr2.filterNot {it.length() != 1})
  arr2.filterNot {it.length() == 1}    // -> []
  println(arr2.filterNot {it.length() == 1})
}

fun foreach() : Unit {
  println("-------------------- foreach --------------------")
  var arr1 = array(1, 2, 3, 4)
  arr1.forEach {println(it)}
  arr1.forEach {}
}

fun flatMap() : Unit {
  println("-------------------- flatMap --------------------")
  // 各要素の値を2倍にする。
  var arr1 = array(1, 2, 3)
  arr1.flatMap<Int, Int> {(n) -> arrayList(n * 2)}
  println(arr1.flatMap<Int, Int> {(n) -> arrayList(n * 2)})

  // 各要素先頭にstr =を加える。
  var arr2 = array("1", "2", "3")
  arr2.flatMap<String, String>{(s) -> linkedList("str = ${s}")}
  println(arr2.flatMap<String, String>{(s) -> linkedList("str = ${s}")})
}

