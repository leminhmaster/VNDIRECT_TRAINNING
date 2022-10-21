import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(3,"Nguyen Van A");
        map.put(1,"Nguyen Van B");
        map.put(2,"Nguyen Van C");
        map.put(4,"Nguyen Van D");
        map.put(5,"Nguyen Van E");
        System.out.println(map.get(3));
        map.put(3, "Nguyen Thi A");
        System.out.println(map.get(3));
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        System.out.println(set);

        TreeMap<Integer,String> map1 = new TreeMap<>();
        map1.put(3,"Nguyen Van A");
        map1.put(1,"Nguyen Van B");
        map1.put(2,"Nguyen Van C");
        map1.put(4,"Nguyen Van D");
        map1.put(5,"Nguyen Van E");
        Iterator<Map.Entry<Integer,String>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey() + " : "+entry.getValue());
        }
        System.out.println("==================================");
        map1.descendingKeySet().forEach((Integer key) ->
        {
            System.out.println(key + " : " + map.get(key));
        });
    }
}
