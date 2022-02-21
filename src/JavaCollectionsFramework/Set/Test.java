package JavaCollectionsFramework.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// Коллекция, которая хранит в себе только уникальные элементы
// Имеет те же свойства что и linked и tree
public class Test {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        hashSet.add("Monika");
        hashSet.add("Emma");
        hashSet.add("Gerakl");
        hashSet.add("Rambo");

        hashSet.add("Rambo");
        hashSet.add("Rambo");



        //Создаётся временная переменная name
        for (String name : hashSet) {
            System.out.println(name);
        }

        System.out.println(hashSet.contains("Emma"));
        System.out.println(hashSet);

        //объединение множеств union

        Set<Integer> union1 = new HashSet<>();
        Set<Integer> union2 = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            union1.add(i);
        }
        for (int i = 5; i < 15 ; i++) {
            union2.add(i);

        }

        Set<Integer> union = new HashSet<>(union1);
        union.addAll(union2);

        // пересечение множеств  intersection (оставляет только общие для двух множеств значения)
        // [1,2,3,4,5] -> .retainAll -> [3,4,5,6,7] = [3,4,5]

        Set<Integer> intersection = new HashSet<>(union1);
        intersection.retainAll(union2);

        // разность множеств difference
        //[1,2,3,4,5] -> .removeAll -> [3,4,5,6,7] = [1,2]

        Set<Integer> difference = new HashSet<>(union1);
        difference.removeAll(union2);



    }

}
