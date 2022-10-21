package DongBoTrongJava;

import Entity.Customer;
import Entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class TestSyn {
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer("Minh",13,0);
        Order order1 = new Order("SP1",1,12);
        Order order2 = new Order("SP2",1,12);
        Order order3 = new Order("SP3",1,12);
        Order order4 = new Order("SP4",1,12);
        CustomerMethod cm1 = new CustomerMethod(customer);
//        new Thread(()->cm1.addOrder2(order1)).start();
//        new Thread(()->cm1.addOrder2(order2)).start();
//        new Thread(()->cm1.addOrder(order2)).start();
//        new Thread(()->cm1.addOrder(order1)).start();
//        new Thread(()->cm1.addOrder(order4)).start();
//        List<Order> orders = new ArrayList<Order>();
//        Callable<List<Order>> listCallable = Executors.callable(()->cm1.addOrder(order1),cm1.getOrders());
//
//        orders = listCallable.call();
//        listCallable.call();
//        listCallable.call();
//        listCallable.call();
//        listCallable.call();
//        System.out.println(orders.size());

    }
}
