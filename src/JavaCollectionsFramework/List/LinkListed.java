package JavaCollectionsFramework.List;

// Методы одинаковые у ArrayList и LinkList, потому что оба имплементяться от List

//****************************************//

//** Основные отличия LinkList и ArrayList **\\
// Добавление объектов в LinkList занимает больше времени (метод .ad, но это команда добавляет в конец листа,
// а если добавить к методу индекс места добавления то LinkList справляется быстрее)
// Чтение объектов объектов занимает значительно больше времени (в 1000 раз)
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkListed {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();

        measureTime(linkedList);
        measureTime(arrayList);

            }
    private static void  measureTime(List<Integer>list){


        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++){
            list.add(0,i);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


}
