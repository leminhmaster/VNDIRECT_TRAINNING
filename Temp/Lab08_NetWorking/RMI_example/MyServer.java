package RMI_example;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Remote r = new BankImpl();
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        Bank stub= (Bank) UnicastRemoteObject.exportObject(r,0);
        Registry registry = LocateRegistry.getRegistry("127.0.0.1",6666);
        registry.bind("Customer", stub);
        System.out.println("SERVER READY_______");

    }
}
