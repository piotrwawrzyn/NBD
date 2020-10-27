import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Main {
  def main(args: Array[String]) = {
    // 1.	Stwórz 7 elementową listę zawierającą nazwy dni tygodnia. Napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami korzystając z:
    val daysOfTheWeek = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

    // a) Pętli for
    println("> 1 a)")
    task1a(daysOfTheWeek)

    // b) Pętli for wypisując tylko dni z nazwami zaczynającymi się na „P”
    println("> 1 b)")
    println(task1b(daysOfTheWeek))

    // c)	Pętli while
    println("> 1 c)")
    println(task1c(daysOfTheWeek))

    // 2. Dla listy z ćwiczenia 1 napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami korzystając z:
    // a)	Funkcji rekurencyjnej
    println("> 2 a)")
    println(task2a(daysOfTheWeek))
    // b) Funkcji rekurencyjnej wypisując elementy listy od końca
    println("> 2 b)")
    println(task2b(daysOfTheWeek))

    // 3.	Stwórz funkcję korzystającą z rekurencji ogonowej do zwrócenia oddzielonego przecinkami stringa zawierającego elementy listy z ćwiczenia 1
    println("> 3")
    println(task3(daysOfTheWeek))

    // 4.	Dla listy z ćwiczenia 1 napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami korzystając z:
    // a)	Metody foldl
    println("> 4 a)")
    println(task4a(daysOfTheWeek))

    // b)	Metody foldr
    println("> 4 b)")
    println(task4b(daysOfTheWeek))

    // c)	Metody foldl wypisując tylko dni z nazwami zaczynającymi się na „P”
    println("> 4 c)")
    println(task4c(daysOfTheWeek))

    // 5) Stwórz mapę z nazwami produktów i cenami. Na jej podstawie wygeneruj drugą, z 10% obniżką cen. Wykorzystaj mechanizm mapowania kolekcji.
    println("> 5")
    val products = Map("Jajka" -> 2, "Chleb" -> 3, "Pomidory" -> 4)
    val productsSale = products map { case (key, value) => (key, value * 1.1) }
    println(productsSale)

    // 6) Zdefiniuj funkcję przyjmującą krotkę z 3 wartościami różnych typów i wypisującą je
    println("> 6")
    task6("abc", 3, daysOfTheWeek)

    // 7) Zaprezentuj działanie Option na dowolnym przykładzie (np. mapy, w której wyszukujemy wartości po kluczu)
    println("> 7")
    // Some(2)
    val pricePerEgg = products.get("Jajka")
    println(pricePerEgg)
    // None
    val pricePerButter = products.get("Maslo")
    println(pricePerButter)

    // 8) Napisz funkcję usuwającą zera z listy wartości całkowitych (tzn. zwracającą listę elementów mających wartości różne od 0).  Wykorzystaj rekurencję.
    println("> 8")
    val intList = List(1, 0, 3, -3, 0, 8, 0, 9, 1, 1, 0)
    println(task8(intList))


    // 9)	Zdefiniuj funkcję, przyjmującą listę liczb całkowitych i zwracającą wygenerowaną na jej podstawie listę, w której wszystkie liczby zostały zwiększone o 1. Wykorzystaj mechanizm mapowania kolekcji.
    println("> 9")
    println(task9(intList))

    // 10) Stwórz funkcję przyjmującą listę liczb rzeczywistych i zwracającą stworzoną na jej podstawie listę zawierającą wartości bezwzględne elementów z oryginalnej listy należących do przedziału <-5,12>. Wykorzystaj filtrowanie.
    println("> 10")
    val biggerIntList = List(-100, -6, -5, -3, 2, 0, 1, 2, 3, 4, 5, 6, 8, 15, 20, 300)
    println(task10(biggerIntList))
  }

  def task1a(daysOfTheWeek: List[String]) = {
    var combinedString = "";
    for (i <- 0 until daysOfTheWeek.length) {
      if (combinedString != "")
        combinedString += ", " + daysOfTheWeek.get(i)
      else
        combinedString += daysOfTheWeek.get(i)
    }
    println(combinedString)

  }

  def task1b(daysOfTheWeek: List[String]) = {
    var combinedString = "";
    for (i <- 0 until daysOfTheWeek.length) {
      breakable {
        if (!daysOfTheWeek.get(i).startsWith("P")) break
        if (combinedString != "")
          combinedString += ", " + daysOfTheWeek.get(i)
        else
          combinedString += daysOfTheWeek.get(i)
      }


    }
    combinedString;
  }

  def task1c(daysOfTheWeek: List[String]) = {
    var combinedString = ""
    var index = 0;
    while (index < daysOfTheWeek.length) {
      if (combinedString != "")
        combinedString += ", " + daysOfTheWeek.get(index)
      else
        combinedString += daysOfTheWeek.get(index)

      index = index + 1;
    }

    combinedString
  }

  def task2a(daysOfTheWeek: List[String]) = {
    def addAnotherDay(i: Int): String = {
      if (i == daysOfTheWeek.length) return ""

      val currentDay = if (i == daysOfTheWeek.length - 1) daysOfTheWeek.get(i) else daysOfTheWeek.get(i) + ", "

     currentDay + addAnotherDay(i + 1)
    }

   addAnotherDay(0);
  }

  def task2b(daysOfTheWeek: List[String]): String = {
    def addAnotherDay(i: Int): String = {
      if (i == -1) return ""

      val currentDay = if (i == 0) daysOfTheWeek.get(i) else daysOfTheWeek.get(i) + ", "

      currentDay + addAnotherDay(i - 1)
    }

    addAnotherDay(daysOfTheWeek.length - 1)
  }

  def task3(daysOfTheWeek: List[String]) = {
    @tailrec
    def addAnotherDay(i: Int, combinedString: String) : String = {
      if (i == daysOfTheWeek.length) return combinedString

      val currentDay = if (i == daysOfTheWeek.length - 1) daysOfTheWeek.get(i) else daysOfTheWeek.get(i) + ", "

      addAnotherDay(i + 1, combinedString + currentDay)
    }
    addAnotherDay(0, "")
  }

  def task4a(daysOfTheWeek: List[String]) : String = {
    daysOfTheWeek.fold("") {(sum, curr) => {
      sum + curr + ", "
    }}.dropRight(2)
  }

  def task4b(daysOfTheWeek: List[String]) : String = {
    daysOfTheWeek.foldRight("") {(sum, curr) => {
      sum + ", " + curr
    }}.dropRight(2)
  }

  def task4c(daysOfTheWeek: List[String]) : String = {
    daysOfTheWeek.fold("") {(sum, curr) => {
     if (curr.startsWith("P"))
      sum + curr + ", "
     else sum

    }}.dropRight(2)
  }

  def task6(tup: (String, Int, Any)) = {
    println(tup._1)
    println(tup._2)
    println(tup._3)
  }

  def task8(intList: List[Int]): List[Int] = {
    def iter(index: Int, currentList: List[Int]): List[Int] = {
      if (index >= currentList.length) return currentList;

      val (part1, part2) = currentList.splitAt(index)

      if (currentList.get(index) == 0)
        iter(index + 1, part1 ++ part2.tail)
      else
        iter(index + 1, currentList)
    }


    iter(0, intList)
  }

  def task9(intList: List[Int]): List[Int] = {
    intList map (el => el + 1)
  }

  def task10(intList: List[Int]): List[Int] = {
    val filteredList = intList filter (el => el >= -5 && el <= 12)

    filteredList map (el => el.abs)
  }
}
