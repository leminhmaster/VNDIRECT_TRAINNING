import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsExample {
    public static void main(String[] args) {
        Short [] values = {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9};
        List<Short> list = new LinkedList<>();
        Collections.addAll(list,values);
        //System.out.println(list);
        Collections.reverse(list);
        Collections.sort(list);
        //System.out.println(list);
        list.toArray(values);
        for (Short s: values) {
            System.out.print(s);
        }
        Object o = Collections.max(list);
        System.out.println("max : "+o.toString());
        Object om = Collections.min(list);
        System.out.println("min : "+om.toString());

        List<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"Tu","An","Hoa","Binh");
        Collections.sort(list1);
        for (String t : list1) {
            System.out.print(t + " , ");
        }
        System.out.println("Vi tri thu " + Collections.binarySearch(list1,"Hoa"));
        Integer t = 9;
        System.out.println("Vi tri thu " + Collections.binarySearch(list , (short) 4 ));
    }
}
