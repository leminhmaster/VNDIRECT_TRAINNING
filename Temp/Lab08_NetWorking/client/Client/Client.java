package Client;


import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception, RemoteException {
        Registry registry = LocateRegistry.getRegistry("localhost",8000);
        Hello stub = (Hello) registry.lookup("client.Hello");
        System.out.println("response: "+ stub.say("MINH"));
    }
}
