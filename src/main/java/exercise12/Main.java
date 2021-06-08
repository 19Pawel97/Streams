package exercise12;

import java.util.*;
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
//    g)** znajdź nastarszą osobę w liście

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
        List<Person> people = (Arrays.asList(person1, person2, person3, person4, person5, person6, person7, person8, person9));
        List<String> languages1 = Arrays.asList("Java;Cobol;Cpp;Lisp".split(";"));
        List<String> languages2 = Arrays.asList("Java;Lisp".split(";"));
        List<String> languages3 = Arrays.asList("Java;Cobol;Cpp;Lisp;C#".split(";"));
        List<String> languages4 = Arrays.asList("C#;C;Cpp".split(";"));
        List<String> languages5 = Arrays.asList("Java;Assembler;Scala;Cobol".split(";"));
        List<String> languages6 = Arrays.asList("Java;Scala".split(";"));
        List<String> languages7 = Arrays.asList("C#;C".split(";"));
        List<String> languages8 = Collections.emptyList();
        List<String> languages9 = Arrays.asList("Java;Python".split(";"));
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

        // 2a
        System.out.println(getMenFromProgrammers(programmers));

        System.out.println();

        // 1a
        System.out.println(getMenFromPeople(people));

        System.out.println();

        //1b
        System.out.println(getAdultWomenFromPeople(people));

        System.out.println();

        //1c
        if (getAdultJacek(people).isPresent()) {
            System.out.println(getAdultJacek(people));
        }

        System.out.println();

        //1d
        System.out.println(getSurnamesOfPeopleBetween15And19(people));

        System.out.println();

        //1e
        System.out.println(getSumOfAgeOfAll(people));

        System.out.println();

        //1f
        if (getAvgOfAgeOfAllMen(people).isPresent()) {
            Double average = getAvgOfAgeOfAllMen(people).getAsDouble();
            System.out.println(average);
        }

        System.out.println();

        //1g
        if (getTheOldestPerson(people).isPresent()) {
            System.out.println(getTheOldestPerson(people).get());
        } else {
            System.out.println("No people.");
        }        System.out.println();

        //2a
        System.out.println(getMenFromProgrammers1(programmers));

        System.out.println();

        //2b
        System.out.println(getNotAdultsKnowingCobolFromProgrammers(programmers));

        System.out.println();

        //2c
        System.out.println(getProgrammersKnowingMoreThanOneLanguage(programmers));

        System.out.println();

        //2d
        System.out.println(getProgrammersFemaleKnowingJavaAndCpp(programmers));

        System.out.println();

        //2e
        System.out.println(getProgrammersMaleNames(programmers));

        System.out.println();

        //2f
        System.out.println(getAllLanguages(programmers));

        System.out.println();

        //2g
        System.out.println(getSurnamesMoreThanTwoLanguages(programmers));

        System.out.println();

        //2h
        Optional<Programmer> personNotKnowingAnyLanguage = getPersonNotKnowingAnyLanguage(programmers);
        if (isPresent(personNotKnowingAnyLanguage)) {
            System.out.println("There is a person not knowing any language");
        } else {
            System.out.println("There is no person not knowing any language");
        }

        System.out.println();

        //2i
        System.out.println(getNumberOfAllLanguagesFemaleProgrammers(programmers));
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

    public static List<Programmer> getMenFromProgrammers(List<Programmer> programmers) {
        List<Programmer> programmersMen = programmers.stream()
                .filter(programmer -> programmer.getPerson().isMale())
                .collect(Collectors.toList());
        return programmersMen;
    }

    public static List<Person> getMenFromPeople(List<Person> people) {
        List<Person> peopleMen = people.stream()
                .filter(person -> person.isMale())
                .collect(Collectors.toList());
        return peopleMen;
    }

    public static List<Person> getAdultWomenFromPeople(List<Person> people) {
        List<Person> peopleAdultWomen = people.stream()
                .filter(person -> !person.isMale() && person.getAge() >= 18)
                .collect(Collectors.toList());
        return peopleAdultWomen;
    }

    public static Optional<Person> getAdultJacek(List<Person> people) {
        Optional<Person> jacek = people.stream()
                .filter(person -> person.getFirstName().equals("Jacek") && person.getAge() >= 18)
                .findFirst();
        return jacek;
    }

    public static List<String> getSurnamesOfPeopleBetween15And19(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() >= 15 && person.getAge() <= 19)
                .map(person -> person.getLastName())
                .collect(Collectors.toList());
    }

    public static Integer getSumOfAgeOfAll(List<Person> people) {
        int sum = people.stream()
                .mapToInt(person -> person.getAge())
                .sum();
        return sum;
    }

    public static OptionalDouble getAvgOfAgeOfAllMen(List<Person> people) {
        OptionalDouble average = people.stream()
                .filter(person -> person.isMale())
                .mapToInt(person -> person.getAge())
                .average();
        return average;
    }

    public static Optional<Person> getTheOldestPerson(List<Person> people) {
        Optional<Person> theOldestPerson = people.stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);

        return theOldestPerson;
    }

    public static List<Programmer> getMenFromProgrammers1(List<Programmer> programmers) {
        List<Programmer> programmersMen = programmers.stream()
                .filter(programmer -> programmer.getPerson().isMale())
                .collect(Collectors.toList());
        return programmersMen;
    }

    public static List<Programmer> getNotAdultsKnowingCobolFromProgrammers(List<Programmer> programmers) {
        return programmers.stream()
                .filter(programmer -> programmer.getPerson().getAge() < 18 && programmer.getLanguages().contains("Cobol"))
                .collect(Collectors.toList());
    }

    public static List<Programmer> getProgrammersKnowingMoreThanOneLanguage(List<Programmer> programmers) {
        return programmers.stream()
                .filter(programmer -> programmer.getLanguages().size() > 1)
                .collect(Collectors.toList());
    }

    public static List<Programmer> getProgrammersFemaleKnowingJavaAndCpp(List<Programmer> programmers) {
        return programmers.stream()
                .filter(programmer -> !programmer.getPerson().isMale())
                .filter(programmer -> programmer.getLanguages().contains("Java") && programmer.getLanguages().contains("Cpp"))
                .collect(Collectors.toList());
    }

    public static List<String> getProgrammersMaleNames(List<Programmer> programmers) {
        return programmers.stream()
                .filter(programmer -> programmer.getPerson().isMale())
                .map(programmer -> programmer.getPerson().getFirstName())
                .collect(Collectors.toList());
    }

    public static Set<String> getAllLanguages(List<Programmer> programmers) {
        Set<String> set = programmers.stream()
                .map(programmer -> programmer.getLanguages())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.toSet());
        return set;
    }

    public static List<String> getSurnamesMoreThanTwoLanguages(List<Programmer> programmers) {
        return programmers.stream()
                .filter(programmer -> programmer.getLanguages().size() > 2)
                .map(programmer -> programmer.getPerson().getLastName())
                .collect(Collectors.toList());
    }

    public static Optional<Programmer> getPersonNotKnowingAnyLanguage(List<Programmer> programmers) {
        Optional<Programmer> personNotKnowing = programmers.stream()
                .filter(programmer -> !(programmer.getLanguages().size() > 0))
                .findAny();
        return personNotKnowing;
    }

    public static boolean isPresent(Optional<Programmer> personNotKnowing) {
        if (personNotKnowing.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public static Integer getNumberOfAllLanguagesFemaleProgrammers(List<Programmer> programmers) {
        Set<String> set = programmers.stream()
                .filter(programmer -> !programmer.getPerson().isMale())
                .map(programmer -> programmer.getLanguages())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.toSet());
        Integer numberOfLanguages = set.size();

        return numberOfLanguages;
    }
}
