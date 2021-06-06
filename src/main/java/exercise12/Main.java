package exercise12;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

//    1.Napisz klasę person, która ma pola: firstName, lastName, age oraz isMale.
//    Mając listę osób i korzystając ze streamów:
//    a) uzyskaj listę mężczyzn
//    b) uzyskaj listę dorosłych kobiet ​(filter)
//    c) uzyskaj Optional<Person> z dorosłym Jackiem ​findAny/findfirst
//    d) uzyskaj listę wszystkich nazwisk osób, które są w przedziale wiekowym: 15-19 ​(filter)
//    e)* uzyskaj sumę wieku wszystkich osób ​(sum)
//    f)* uzyskaj średnią wieku wszystkich mężczyzn ​(average)
//    g)** znajdź nastarszą osobę w liście ​(findFirst)

    //2. Stwórz klasę Programmer, która ma klasę Person jako pole. Poza tym, posiada listę
    //języków, którymi się posługuje. Mogą być one reprezentowane przez klasę String.
    //Mając listę programistów i korzystając ze streamów:
    //a) uzyskaj listę programistów, którzy są mężczyznami
    //b) uzyskaj listę niepełnoletnich programistów (obydwóch płci), którzy piszą w Cobolu
    //c) uzyskaj listę programistów, którzy znają więcej, niż jeden język programowania
    //d) uzyskaj listę programistek, które piszą w Javie i Cpp
    //e) uzyskaj listę męskich imion
    //f) uzyskaj set wszystkich języków opanowanych przez programistów
    //g) uzyskaj listę nazwisk programistów, którzy znają więcej, niż dwa języki
    //h) sprawdź, czy istnieje chociaż jedna osoba, która nie zna żadnego języka
    //i)* uzyskaj ilość wszystkich języków opanowanych przez programistki
    //3*.Używając streamów znajdź długość najdłuższej linii w wybranym przez ciebie pliku.
    //Zauważ, że klasa BufferedReader ma metodę stream().
    //4*. Zamien poniższy kod:
    //List<Album> favs = new ArrayList<>();
    //for (Album a : albums) {
    //boolean hasFavorite = false;
    //for (Track t : a.tracks) {
    //if (t.rating >= 4) {
    //hasFavorite = true;
    //break;
    //}
    //}if
    //(hasFavorite)
    //favs.add(a);
    //}C
    //ollections.sort(favs, new Comparator<Album>() {
    //public int compare(Album a1, Album a2) {
    //return a1.name.compareTo(a2.name);
    //}});
    //..na kod z wykorzystaniem streamów.


    public static void main(String[] args) {
        Person person1 = new Person("Jacek", "Kowalski", 18, true);
        Person person2 = new Person("Jacek", "Górski", 15, true);
        Person person3 = new Person("Andżelika", "Dżoli", 25, false);
        Person person4 = new Person("Wanda", "Ibanda", 12, false);
        Person person5 = new Person("Marek", "Marecki", 17, true);
        Person person6 = new Person("Johny", "Brawo", 25, true);
        Person person7 = new Person("Stary", "Pan", 80, true);
        Person person8 = new Person("Newbie", "Noob", 12, true);
        Person person9 = new Person("Newbies", "Sister", 19, false);
        List<String> languages1 = Arrays.asList("Java;Cobol;Cpp;Lisp".split(";"));
        List<String> languages2 = Arrays.asList("Java;Lisp".split(";"));
        List<String> languages3 = Arrays.asList("Java;Cobol;Cpp;Lisp;C#".split(";"));
        List<String> languages4 = Arrays.asList("C#;C;Cpp".split(";"));
        List<String> languages5 = Arrays.asList("Java;Assembler;Scala;Cobol".split(";"));
        List<String> languages6 = Arrays.asList("Java;Scala".split(";"));
        List<String> languages7 = Arrays.asList("C#;C".split(";"));
        List<String> languages8 = Collections.emptyList();
        List<String> languages9 = Arrays.asList("Java");
        Programmer programmer1 = new Programmer(person1, languages1);
        Programmer programmer2 = new Programmer(person2, languages2);
        Programmer programmer3 = new Programmer(person3, languages3);
        Programmer programmer4 = new Programmer(person4, languages4);
        Programmer programmer5 = new Programmer(person5, languages5);
        Programmer programmer6 = new Programmer(person6, languages6);
        Programmer programmer7 = new Programmer(person7, languages7);
        Programmer programmer8 = new Programmer(person8, languages8);
        Programmer programmer9 = new Programmer(person9, languages9);
        List<Programmer> programmers =
                Arrays.asList(programmer1, programmer2, programmer3, programmer4,
                        programmer5, programmer6, programmer7, programmer8, programmer9);
        System.out.println(programmers);
    }

//    public List<Programmer> getMenFromProgrammers(List<Programmer> programmers) {
//        List<Programmer> programmersMen = programmers.stream()
//                .filter(new Predicate<Programmer>() {
//                    @Override
//                    public boolean test(Programmer programmer) {
//                        return programmer.getPerson().isMale();
//                    }
//                })
//                .collect(Collectors.toList());
//        return programmersMen;

    // alt + enter after new Predicate<Programmer> converts to lambda

    public List<Programmer> getMenFromProgrammers(List<Programmer> programmers) {
        List<Programmer> programmersMen = programmers.stream()
                .filter(programmer -> programmer.getPerson().isMale())
                .collect(Collectors.toList());
        return programmersMen;
    }
}
