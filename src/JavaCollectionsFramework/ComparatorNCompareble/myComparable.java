package JavaCollectionsFramework.ComparatorNCompareble;

import java.util.*;

public class myComparable {
    public static void main(String[] args) {
        List<Persone> peopleList = new ArrayList<>();
        Set<Person> peopleSet = new TreeSet<>();

        addElements(peopleList);
        addElements(peopleSet);

        Collections.sort(peopleList);

        System.out.println(peopleList);
        System.out.println(peopleSet);
    }
    private static void addElements(Collection collection){
        collection.add(new Persone(01,"Bonni"));
        collection.add(new Persone(03,"Toni"));
        collection.add(new Persone(04,"Sonni"));
        collection.add(new Persone(02,"Anthoni"));

    }
}

class Persone implements Comparable<Persone> {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public Persone(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persone persone = (Persone) o;

        if (id != persone.id) return false;
        return name != null ? name.equals(persone.name) : persone.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Persone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Persone o) {
        if (this.id > o.getId()) {
            return 1;
        } else if (this.id < o.getId()) {
            return -1;
        } else return 0;
    }

}