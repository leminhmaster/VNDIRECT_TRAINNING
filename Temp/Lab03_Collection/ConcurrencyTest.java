import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class ConcurrencyTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,3,4,2,3,6,3,3,8);
        //Xoa khong het
        System.out.println("Before remove : size of list ="+list.size());
        //remove with for Khong xoa dc het
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i)==3) list.remove(i);
//        }
        //remove with foreach khong xos dc
//        list.forEach(v->{
//            if (v==3) list.remove(v);
//        });
        for (Integer v:list) {
            if (v == 3){
                list.remove(v);
            }
        }
        //remove with iterator xoa dc
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            if (iterator.next() == 3) iterator.remove();
//        }
        //remove with remove if || XOA DC
//        list.removeIf(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer==3;
//            }
//        });
//        list.removeAll(Collections.singleton(3));
        System.out.println("After remove : size of list = "+list.size());

    }
}
