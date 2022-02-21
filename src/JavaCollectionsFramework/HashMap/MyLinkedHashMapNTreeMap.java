package JavaCollectionsFramework.HashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyLinkedHashMapNTreeMap {
    public static void main(String[] args) {
        Map<Integer,String> hashMap = new HashMap<>();             // Внутри не гарантируется порядок
        Map<Integer,String> linkedHashMap = new LinkedHashMap<>(); // Гарантируется порядок
                                                                   // (В каком порядке добавлены пары в таком и вернуться)
        Map<Integer,String> treeMap = new TreeMap<>();             // Гарантирует что пары будут отсортированы по ключу
        testMap(hashMap);
        System.out.println();
        testMap(linkedHashMap);
        System.out.println();
        testMap(treeMap);
    }

    public static void testMap(Map<Integer,String>map){
        map.put(26,"Ivan");
        map.put(88,"Mike");
        map.put(99,"Tima");
        map.put(1,"Toha");
        map.put(9,"Sima");

        for (Map.Entry<Integer,String> entry: map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
