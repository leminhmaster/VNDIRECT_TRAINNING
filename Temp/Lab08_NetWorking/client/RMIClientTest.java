package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClientTest {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("120.0.0.1",8000);
        Object stub = registry.lookup("Hello");
        System.out.println("reponse: ");
    }
}
