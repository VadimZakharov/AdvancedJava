package JavaCollectionsFramework.HashMap;

// Сопоставление элементов одного множества другому множеству
// HashMap не гарантирует вывод информации в том порядке, что её записали, когда не важен порядок ключ=значение

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
      Map<Integer,String> map = new HashMap<>();  //Указывается тип ключа и значение
      map.put(1,"Один");                          //Добавление
      map.put(2,"Два");
      map.put(3,"Три");

      System.out.println(map);
      map.put(3,"Другое три");
      System.out.println(map);                     //Изменение значения

      System.out.println(map.get(2));              //Получение значения по ключу


        for (Map.Entry<Integer,String> entry : map.entrySet()) {            //Все значения
            System.out.println(entry.getKey() + ":" + entry.getValue());

        }

    }

}
