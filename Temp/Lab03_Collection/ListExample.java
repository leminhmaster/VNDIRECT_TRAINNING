import java.util.*;
import java.util.stream.IntStream;

public class ListExample {
    public static void main(String[] args) {
        String [] l = {"1234","2345","sdfniusd","2345"};
        //ArrayList
        List<String> list = new ArrayList<>();
        Collections.addAll(list,l);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element at "+ i+" is "+list.get(i));
        }
        IntStream.range(0,list.size()).forEach(i->{
            System.out.println("Element at "+i+" is "+list.get(i));
        });
        //LinkedList
        List<String> list1 = new LinkedList<>();
        for (String ele: l) {
            list1.add(ele);
        }
        Iterator<String> iterator = list1.iterator();
        while (iterator.hasNext()){
            System.out.println("=====>"+iterator.next());
        }
        List<String> list2 = new LinkedList<>(Arrays.asList(l));
        list2.forEach(value -> {
            System.out.println(value);
        });
    }
}
