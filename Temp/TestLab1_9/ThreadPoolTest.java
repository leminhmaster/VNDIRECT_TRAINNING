import DongBoTrongJava.CustomerMethod;
import Entity.Customer;
import Entity.Order;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Customer customer = new Customer("Minh",13,0);
        Order order1 = new Order("SP1",1,12);
        Order order2 = new Order("SP2",1,12);
        Order order3 = new Order("SP3",1,12);
        Order order4 = new Order("SP4",1,12);
        CustomerMethod cm1 = new CustomerMethod(customer);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<List<Order>> callable1 = Executors.callable(()->cm1.addOrder(order1),cm1.getOrders());
        Callable<List<Order>> callable2 = Executors.callable(()->cm1.addOrder(order2),cm1.getOrders());
        Callable<List<Order>> callable3 = Executors.callable(()->cm1.addOrder(order3),cm1.getOrders());
        Callable<List<Order>> callable4 = Executors.callable(()->cm1.addOrder(order4),cm1.getOrders());
        List<Callable<List<Order>>> calls =Arrays.asList(callable1,callable2,callable3,callable4);
        List<Future<List<Order>>> dslistlisto = executor.invokeAll(calls);
        for (Future<List<Order>> future : dslistlisto) {
            System.out.println(future.get().size());
        }


    }
}
