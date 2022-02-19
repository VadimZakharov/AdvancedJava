package JavaCollectionsFramework.List;
import java.util.ArrayList;
import java.util.List;

public class ArrayListed {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {                 //заполнение массива
            list.add(i);
        }
        System.out.println(list);                      // вывод массива

        System.out.println(list.get(0));               //получение эллемента массива под индексом
        System.out.println(list.get(9));

        System.out.println(list.size());               // размер массива

        for (int i = 0; i < list.size(); i++) {        // получение эллементов
            System.out.print(list.get(i));

        }
        System.out.println();
        for (Integer x : list){                        // получение эллементов
            System.out.print(x);
        }
        System.out.println();

        list.remove(5);                           // удаление элементов массива
        System.out.println(list);


    }
}

