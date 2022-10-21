import Entity.Customer;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation {
    public static void main(String[] args) {
        Customer c1 = new Customer("MINH1",22);
        Customer c2 = new Customer("MAXH1",21);
        Customer c3 = new Customer("MINH2",24);
        Customer c4 = new Customer("MAXH2",25);
        List<Customer> integerList = new ArrayList<>(Arrays.asList(c1,c2,c3,c4));
        Comparator<Customer> comparator = (Customer o1, Customer o2)->{
            return o1.getAge()-o2.getAge();
        };
        Collections.sort(integerList,comparator);
        integerList.stream().forEach(System.out::println);
        Collector<Customer,?,IntSummaryStatistics> collector = Collectors.summarizingInt(new ToIntFunction<Customer>() {
            @Override
            public int applyAsInt(Customer value) {
                return value.getTotal().intValue();
            }
        });
        IntSummaryStatistics summaryStatistics = integerList.stream().collect(collector);

        System.out.println("total = "+summaryStatistics.getSum());
        System.out.println("overage = "+summaryStatistics.getAverage());

    }

}
