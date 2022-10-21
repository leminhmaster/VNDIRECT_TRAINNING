import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(1);
        numbers.add(14);
        numbers.add(8);
        numbers.add(12);
        numbers.add(3);
        numbers.add(8);

        System.out.println("Size of set: "+numbers.size());
        System.out.println(numbers);
        SortedSet<Integer> list = new TreeSet<>();
        list.add(1);
        list.add(14);
        list.add(8);
        list.add(12);
        list.add(3);
        list.add(8);
        list.add(99);
        list.add(38);

        System.out.println(list);
    }
}
