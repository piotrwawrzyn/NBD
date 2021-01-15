# Nierelacyjne bazy danych (NBD)

## NBD Ćwiczenia 1 - Scala

1. Stwórz 7 elementową listę zawierającą nazwy dni tygodnia. Napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami korzystając z:
   - Pętli for
   - Pętli for wypisując tylko dni z nazwami zaczynającymi się na „P”
   - Pętli while
2. Dla listy z ćwiczenia 1 napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami korzystając z:
   - Funkcji rekurencyjnej
   - Funkcji rekurencyjnej wypisując elementy listy od końca
3. Stwórz funkcję korzystającą z rekurencji ogonowej do zwrócenia oddzielonego przecinkami stringa zawierającego elementy listy z ćwiczenia 1
4. Dla listy z ćwiczenia 1 napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami korzystając z:
   - Metody foldl
   - Metody foldr
   - Metody foldl wypisując tylko dni z nazwami zaczynającymi się na „P”
5. Stwórz mapę z nazwami produktów i cenami. Na jej podstawie wygeneruj drugą, z 10% obniżką cen. Wykorzystaj mechanizm mapowania kolekcji.
6. Zdefiniuj funkcję przyjmującą krotkę z 3 wartościami różnych typów i wypisującą je
7. Zaprezentuj działanie Option na dowolnym przykładzie (np. mapy, w której wyszukujemy wartości po kluczu)
8. Napisz funkcję usuwającą zera z listy wartości całkowitych (tzn. zwracającą listę elementów mających wartości różne od 0). Wykorzystaj rekurencję.
9. Zdefiniuj funkcję, przyjmującą listę liczb całkowitych i zwracającą wygenerowaną na jej podstawie listę, w której wszystkie liczby zostały zwiększone o 1. Wykorzystaj mechanizm mapowania kolekcji.
10. Stwórz funkcję przyjmującą listę liczb rzeczywistych i zwracającą stworzoną na jej podstawie listę zawierającą wartości bezwzględne elementów z oryginalnej listy należących do przedziału <-5,12>. Wykorzystaj filtrowanie.

## NBD Ćwiczenia 2 - Scala

1. Wykorzystaj Pattern Matching w funkcji przyjmującej parametr typu String. Dla stringów odpowiadających nazwom dni tygodnia funkcja ma zwrócić „Praca” i „Weekend” (odpowiednio dla dni roboczych i wolnych), dla pozostałych napisów „Nie ma takiego dnia”.
2. Zdefiniuj klasę KontoBankowe z metodami wplata i wyplata oraz własnością stanKonta - własność ma być tylko do odczytu. Klasa powinna udostępniać konstruktor przyjmujący początkowy stan konta oraz drugi, ustawiający początkowy stan konta na 0.
3. Zdefiniuj klasę Osoba z własnościami imie i nazwisko. Stwórz kilka instancji tej klasy. Zdefiniuj funkcję, która przyjmuje obiekt klasy osoba i przy pomocy Pattern Matching wybiera i zwraca napis zawierający przywitanie danej osoby. Zdefiniuj 2-3 różne przywitania dla konkretnych osób (z określonym imionami lub nazwiskami) oraz jedno domyślne.
4. Zdefiniuj funkcję przyjmującą dwa parametry - wartość całkowitą i funkcję operującą na wartości całkowitej. Zastosuj przekazaną jako parametr funkcję trzykrotnie do wartości całkowitej i zwróć wynik.
5. Zdefiniuj klasę Osoba i trzy traity: Student, Nauczyciel, Pracownik. Osoba powinna mieć własności read only: imie, nazwisko, podatek. Pracownik powinien mieć własność pensja (z getterem i seterem). Student i Pracownik powinni przesłaniać własność podatek – dla Studenta zwracamy 0, dla Pracownika 20% pensji. Nauczyciel powinien dziedziczyć z Pracownika, dla niego podatek zwraca 10% pensji. Stwórz obiekty z każdym z traitów, pokaż jak podatek działa dla każdego z nich. Stwórz obiekty z traitami Student i Pracownik, pokaż jak podatek zadziała w zależności od kolejności w jakiej te traity zostały dodane przy tworzeniu obiektu.

## NBD Ćwiczenia 3 - MongoDB

Zaimportuj plik _cwiczenia3.json_. W jednej konsoli odpal serwer bazy poleceniem

```
mongod
```

W drugiej konsoli zaimportuj dane do MongoDB przy pomocy następującego polecenia:

```
mongoimport --file ./cwiczenia3.json --db nbd --collection people --jsonArray
```

Czasem MongoDB odrzuci niektóre dokumenty – nie przejmuj się tym, pozostałe zostaną zaimportowane prawidłowo. Uruchom shell mongo przy pomocy polecenia

```
mongo
```

Wskaż bazę danych do użycia przy pomocy

```
use nbd
```

**Zbuduj następujące zapytania:**

1. Jedna osoba znajdująca się w bazie;
2. Jedna kobieta narodowości chińskiej;
3. Lista mężczyzn narodowości niemieckiej;
4. Lista wszystkich osób znajdujących się w bazie o wadze z przedziału <68, 71.5);
5. Lista imion i nazwisk wszystkich osób znajdujących się w bazie oraz miast, w których mieszkają, ale tylko dla osób urodzonych w XXI wieku;
6. Dodaj siebie do bazy, zgodnie z formatem danych użytych dla innych osób (dane dotyczące karty kredytowej, adresu zamieszkania i wagi mogą być fikcyjne);
7. Usuń z bazy osoby o wzroście przekraczającym 190;
8. Zastąp nazwę miasta „Moscow” przez „Moskwa” u wszystkich osób w bazie;
9. Dodaj do wszystkich osób o imieniu Antonio własność „hobby” o wartości „pingpong”;
10. Usuń u wszystkich osób o zawodzie „Editor” własność „email”.

## NBD Ćwiczenia 4 - MongoDB

Skorzystaj z bazy z poprzednich ćwiczeń. Przy pomocy operacji map-reduce i frameworku do agregacji znajdź następujące informacje:

1. Średnią wagę i wzrost osób w bazie z podziałem na płeć (tzn. osobno mężczyzn, osobno kobiet);
2. Łączną ilość środków pozostałych na kartach kredytowych osób w bazie, w podziale na waluty;
3. Listę unikalnych zawodów;
4. Średnie, minimalne i maksymalne BMI (waga/wzrost^2) dla osób w bazie, w podziale na narodowości;
5. Średnia i łączna ilość środków na kartach kredytowych kobiet narodowości polskiej w podziale na waluty.

## NBD Ćwiczenia 5 - Neo4j

**Zbuduj następujące zapytania:**

1. Wszystkie filmy
2. Wszystkie filmy, w których grał Hugo Weaving
3. Reżyserzy filmów, w których grał Hugo Weaving
4. Wszystkie osoby, z którymi Hugo Weaving grał w tych samych filmach
5. Wszystkie filmy osób, które grały w Matrix
6. Listę aktorów (aktor = osoba, która grała przynajmniej w jednym filmie) wraz z
   ilością filmów, w których grali
7. Listę osób, które napisały scenariusz filmu, które wyreżyserowały wraz z tytułami
   takich filmów (koniunkcja – ten sam autor scenariusza i reżyser)
8. Listę filmów, w których grał zarówno Hugo Weaving jak i Keanu Reeves
9. (za 0.2pkt) Zestaw zapytań powodujących uzupełnienie bazy danych o film Captain
   America: The First Avenger wraz z uzupełnieniem informacji o reżyserze,
   scenarzystach i odtwórcach głównych ról (w oparciu o skrócone informacje z IMDB -
   http://www.imdb.com/title/tt0458339/) + zapytanie pokazujące dodany do bazy
   film wraz odtwórcami głównych ról, scenarzystą i reżyserem. Plik SVG ma
   pokazywać wynik ostatniego zapytania.

## NBD Ćwiczenia 6 - Neo4J

Ćwiczenie należy oddać w formie pliku tekstowego zawierającego ponumerowane zapytania (zgodnie z numeracją zapytań w tekście ćwiczenia) oraz zestawu plików z wynikami w postaci graficznej i tekstowej (np. SVG i JSON – niestety dostępne opcje eksportu regularnie ulegają zmianie) o nazwach wynikX.svg i wynikX.json, gdzie X to numer zapytania (pliki graficzny i tekstowy należy wyeksportować z pomocą webowego interfejsu bazy, rozszerzenia zależą od wybranych formatów)

**Część 1 – Wycieczki górskie**

Zaimportuj dane uruchamiając skrypt task2.cypher. Napisz następujące zapytania:

1. Znajdź trasy którymi można dostać się z Darjeeling na Sandakphu, mające najmniejszą ilość etapów
2. Znajdź mające najmniej etapów trasy którymi można dostać się z Darjeeling na Sandakphu i które mogą być wykorzystywane zimą
3. Uszereguj trasy którymi można dostać się z Darjeeling na Sandakphu według dystansu Znajdź wszystkie miejsca do których można dotrzeć przy pomocy roweru (twowheeler) z Darjeeling latem

**Część 2 – Połączenia lotnicze**

Zaimportuj dane uruchamiając skrypt task3.cypher. Napisz następujące zapytania:

4. Uszereguj porty lotnicze według ilości rozpoczynających się w nich lotów
5. Znajdź wszystkie porty lotnicze, do których da się dolecieć (bezpośrednio lub z przesiadkami) z Los Angeles (LAX) wydając mniej niż 3000
6. Uszereguj połączenia, którymi można dotrzeć z Los Angeles (LAX) do Dayton (DAY) według ceny biletów
7. Znajdź najtańsze połączenie z Los Angeles (LAX) do Dayton (DAY)
8. Znajdź najtańsze połączenie z Los Angeles (LAX) do Dayton (DAY) w klasie biznes
9. Uszereguj linie lotnicze według ilości miast, pomiędzy którymi oferują połączenia (unikalnych miast biorących udział w relacjach :ORIGIN i :DESTINATION węzłów typu Flight obsługiwanych przez daną linię)
10. Znajdź najtańszą trasę łączącą 3 różne porty lotnicze

## NBD Ćwiczenia 7 - Riak

Na maszynie wirtualnej Riak uruchamia się automatycznie (pojedyncza instancja), dostępny jest na porcie 8098
Jako rozwiązanie należy wysłać jeden plik tekstowy zawierający ponumerowane polecenia curl i dodatkowo do każdego z zadań tekstowy plik wynikowy zawierający odpowiedź z serwera (wraz z nagłówkami, więc należy w curl użyć switcha -i)

1. Umieść w bazie (nazwa bucketa ma być Twoim numerem indeksu poprzedzonym literą „s”) 5 wartości, gdzie każda z nich ma być dokumentem json mającym 4 pola co najmniej dwóch różnych typów.
2. Pobierz z bazy jedną z dodanych przez Ciebie wartości.
3. Zmodyfikuj jedną z wartości – dodając dodatkowe pole do dokumentu.
4. Zmodyfikuj jedną z wartości – usuwając jedną pole z wybranego dokumentu.
5. Zmodyfikuj jedną z wartości – zmieniając wartość jednego z pól.
6. Usuń jeden z dokumentów z bazy.
7. Spróbuj pobrać z bazy wartość, która nie istnieje w tej bazie.
8. Dodaj do bazy 1 dokument json (zawierający 1 pole), ale nie specyfikuj klucza.
9. Pobierz z bazy element z zadania 8.
10. Usuń z bazy element z zadania 8.
