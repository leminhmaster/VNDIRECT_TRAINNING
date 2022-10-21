package DongBoTrongJava;

import Entity.Customer;
import Entity.Order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomerMethod {
    private Customer customer;
    private List<Order> orders;

    public CustomerMethod(Customer customer) {
        this.customer = customer;
        orders = new LinkedList<>();
    }

    public void addOrder(Order order) {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Adding to order in "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        orders.add(order);
        Collector<Order,?,Integer> collector = Collectors.summingInt(new ToIntFunction<Order>() {
            @Override
            public int applyAsInt(Order value) {

                return value.getPrice()* value.getQuantity();
            }
        });
        int total = orders.stream().mapToInt(new ToIntFunction<Order>() {
            @Override
            public int applyAsInt(Order value) {
                return value.getPrice()*value.getQuantity();
            }
        }).sum();
        this.customer.setTotal(total);
        System.out.println(customer);
    }
    public synchronized void removeOrder(Order orderd) {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(3000);
                System.out.println("Removing order in "+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        orders.removeIf(new Predicate<Order>() {
            @Override
            public boolean test(Order order) {
                return order.getName().compareTo(orderd.getName())==0;
            }
        });
        System.out.println(customer);
    }

    public void addOrder2(Order order) {
        synchronized (orders){
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(3000);
                    System.out.println("Adding to order in "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            orders.add(order);
            Collector<Order,?,Integer> collector = Collectors.summingInt(new ToIntFunction<Order>() {
                @Override
                public int applyAsInt(Order value) {

                    return value.getPrice()* value.getQuantity();
                }
            });
            int total = orders.stream().mapToInt(new ToIntFunction<Order>() {
                @Override
                public int applyAsInt(Order value) {
                    return value.getPrice()*value.getQuantity();
                }
            }).sum();
            this.customer.setTotal(total);
            System.out.println(customer);
        }
    }

     public List<Order> getOrders (){
        for (int i = 0; i < 3; i++) {
            System.out.println("Getting orders... in "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
         System.out.println("total order count: "+orders.size());

        return orders;
    }

}
