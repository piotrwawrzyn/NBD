object Main {

  def main(args: Array[String]): Unit = {
    /**
     * 1. Wykorzystaj Pattern Matching w funkcji przyjmującej parametr typu String.
     * Dla stringów odpowiadających nazwom dni tygodnia funkcja ma zwrócić „Praca” i „Weekend” (odpowiednio dla dni roboczych i wolnych),
     * dla pozostałych napisów „Nie ma takiego dnia”.
     * */

    println("> 1")
    println(task1("Poniedziałek"))
    println(task1("Sobota"))
    println(task1("Rampapapam"))

    /**
     * 2. Zdefiniuj klasę KontoBankowe z metodami wplata i wyplata oraz własnością stanKonta - własność ma być tylko do odczytu.
     * Klasa powinna udostępniać konstruktor przyjmujący początkowy stan konta oraz drugi, ustawiający początkowy stan konta na 0.
     */

    println("> 2")
    val konto1 = new KontoBankowe(100)
    println(konto1.stanKonta)

    val konto2 = new KontoBankowe()
    println(konto2.stanKonta)
    println(konto2.wplac(12))
    println(konto2.wyplac(10))

    /**
     * 3. Zdefiniuj klasę Osoba z własnościami imie i nazwisko. Stwórz kilka instancji tej klasy.
     * Zdefiniuj funkcję, która przyjmuje obiekt klasy osoba i przy pomocy Pattern Matching wybiera i zwraca napis zawierający przywitanie danej osoby.
     * Zdefiniuj 2-3 różne przywitania dla konkretnych osób (z określonym imionami lub nazwiskami) oraz jedno domyślne.
     * */

    println("> 3")

    val osoba1 = Osoba("Jan", "Kowalski")
    val osoba2 = Osoba("Piotr", "Piotrowski")
    val osoba3 = Osoba("Ewa", "Ewak")
    val osoba4 = Osoba("Andrzej", "Andrzejowski")

    sayHello(osoba1)
    sayHello(osoba2)
    sayHello(osoba3)
    sayHello(osoba4)

    /**
     * 4. Zdefiniuj funkcję przyjmującą dwa parametry - wartość całkowitą i funkcję operującą na wartości całkowitej.
     * Zastosuj przekazaną jako parametr funkcję trzykrotnie do wartości całkowitej i zwróć wynik.
     */

    println("> 4")

    val number = 32
    def minusOne(num: Int): Int = num - 1
    println(task4(number, minusOne))

    /**
     * 5. Zdefiniuj klasę Osoba i trzy traity: Student, Nauczyciel, Pracownik.
     * Osoba powinna mieć własności read only: imie, nazwisko, podatek.
     * Pracownik powinien mieć własność pensja (z getterem i seterem).
     * Student i Pracownik powinni przesłaniać własność podatek – dla Studenta zwracamy 0, dla Pracownika 20% pensji.
     * Nauczyciel powinien dziedziczyć z Pracownika, dla niego podatek zwraca 10% pensji.
     * Stwórz obiekty z każdym z traitów, pokaż jak podatek działa dla każdego z nich.
     * Stwórz obiekty z traitami Student i Pracownik, pokaż jak podatek zadziała w zależności od kolejności
     * w jakiej te traity zostały dodane przy tworzeniu obiektu.
     * */

    println("> 5")

    val osoba5 = new Osoba("Krzysztof", "Krzysztofowski") with Student
    println(s"Podatek studenta wynosi: ${osoba5.podatek}%")

    val osoba6 = new Osoba("Anka", "Ankowska") with Pracownik
    println(s"Podatek pracownika wynosi ${osoba6.podatek}%")

    val osoba7 = new Osoba("Alicja", "Alicjowska") with Nauczyciel
    println(s"Podatek nauczyciela wynosi ${osoba7.podatek}%")

    val osoba8 = new Osoba("Artur", "Arturowski") with Student with Pracownik
    println(s"Podatek studenta, który pracuje wynosi ${osoba8.podatek}%")

    val osoba9 = new Osoba("Roman", "Romanowski") with Pracownik with Student
    println(s"Podatek pracownika, który studiuje wynosi ${osoba9.podatek}%")
  }

  def task1(str: String): String = {
    val workingDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek")
    val weekendDays = List("Sobota", "Niedziela")

    str match {
      case a if (workingDays.contains(a)) => "Praca"
      case b if (weekendDays.contains(b)) => "Weekend"
      case _ => "Nie ma takiego dnia"
    }
  }

  def sayHello(osoba: Osoba) = {
    val greeting = osoba match {
      case Osoba("Jan", "Kowalski") => "Cześć, jestem Jan!"
      case Osoba("Piotr", "Piotrowski") => "Hej, jestem Piotrek!!!"
      case Osoba("Ewa", "Ewak") => "Siema, jestem Ewka."
      case _ => "Dzień dobry."
    }

    println(greeting)
    greeting
  }

  def task4(number: Int, fun: (Int) => Int): Int = {
    fun(fun(fun(number)))
  }
}
