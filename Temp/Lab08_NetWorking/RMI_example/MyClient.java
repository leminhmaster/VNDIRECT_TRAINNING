package RMI_example;

import RMI_example.Bank;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1",6666);
        Bank stub = (Bank) registry.lookup("Customer");
        System.out.println("response: ");
        stub.getCustomer().parallelStream().forEach(customer -> {
            System.out.println(customer.name);
        });
    }
}
