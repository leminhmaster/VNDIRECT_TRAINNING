import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4,6,7,8,9,3,4,5,10));
        Comparator<Integer> comparator = Integer::compare;
        Collections.sort(list,comparator);

        list.stream().filter(v->v>5).forEach(v-> System.out.println(v));
        Integer [] values = list.stream().filter(v->v>5).toArray(size -> new Integer[size]);
        Arrays.stream(values).forEach(v-> System.out.println(v));

        Collector<Integer,?, IntSummaryStatistics> collector = Collectors.summarizingInt(Integer::intValue);
        IntSummaryStatistics summaryStatistics = list.stream().collect(collector);
        System.out.println("total = "+summaryStatistics.getSum());
        System.out.println("overage = "+summaryStatistics.getAverage());

        Consumer<Integer> myconsumer = n->{
            System.out.println("user input value = "+n);
            if(n<5){
                System.out.println("Invalid value!");
                return;
            }
            list.add(n);
            System.out.println("values : ");
            list.forEach(x-> System.out.print(
                    x+"-"
            ));
        };
        myconsumer.accept(12);

        Scanner scanner = new Scanner(System.in);
//        while (true){
//
//            System.out.println("Please input a number");
//            int value = scanner.nextInt();
////            myconsumer.accept(value);
//            System.out.println();
//            if (value < 0) break;
//            //if (tester.test(value)) myconsumer.accept(value);
//        }
        Predicate<Integer> tester = v->v>5;
//        Consumer<Integer> myConsumer = n->list.add(n);
//        while(true){
//            System.out.println("Please input a number : ");
//            int value = scanner.nextInt();
//            if (value<0) break;
//            if (tester.test(value)) myConsumer.accept(value);
//            list.forEach(x-> System.out.print(
//                    x+"-"
//            ));
//        }

    }
}
