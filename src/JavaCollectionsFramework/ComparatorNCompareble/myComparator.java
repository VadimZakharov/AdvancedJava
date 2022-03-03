package JavaCollectionsFramework.ComparatorNCompareble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class myComparator {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();

        animals.add("Birddy");
        animals.add("Cat");
        animals.add("Dogo");
        animals.add("Frogo");


        Collections.sort(animals, new StringLenghtComparator()); // по умолчанию в алфовитном порядке // natural oder
        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();

        numbers.add(100);
        numbers.add(20);
        numbers.add(36);
        numbers.add(0);

        Collections.sort(numbers, new NumbersComparator());
        System.out.println(numbers);

        Collections.sort(animals, new Comparator<String>() {  //без создания класса
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        Collections.sort(animals, (o1, o2) -> 0);           // без создания класса, лямбда функцией

        List<Person> people = new ArrayList<>();
        people.add(new Person(01,"Doja"));
        people.add(new Person(04,"Boba"));
        people.add(new Person(03,"Ziza"));
        people.add(new Person(02,"Zoza"));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() > o2.getId()){
                    return 1;
                }
                else if (o1.getId() < o2.getId()){
                    return -1;
                }
                else return 0;
            }
        });
        System.out.println(people);


            }

    }



class StringLenghtComparator implements Comparator <String>{

    @Override
    public int compare(String o1, String o2) {
        // о1 > o2 => 1
        // o1 < o2 => -1
        // o1 == o2 => 0

        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()){
            return -1;
        }else {
            return 0;
        }

    }
}
class NumbersComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {

        if (o1 > o2){
            return -1;
        }else if (o1<o2){
            return 1;
        }else return 0;
    }
}

class Person{
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
