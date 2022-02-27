package JavaCollectionsFramework.HashCodeNEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//
public class Test {
    public static void main(String[] args) {
        Map<Person, String> hashMap = new HashMap<>();
        Set<Person> hashSet = new HashSet<>();




        Person person1 = new Person(1,"Dora");
        Person person2 = new Person(1,"Dora");

       hashMap.put(person1,"123");
       hashMap.put(person2,"123");

       hashSet.add(person1);
       hashSet.add(person2);

        System.out.println(hashMap);
        System.out.println(hashSet);


    }

    static class Person {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (id != person.id) return false;
            return name != null ? name.equals(person.name) : person.name == null;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }


}