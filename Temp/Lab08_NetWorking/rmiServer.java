import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class rmiServer {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        MethodRMI obj = new MethodRMI();
        RMIMethod stub = (RMIMethod) UnicastRemoteObject.exportObject(obj,0);
        Registry registry = LocateRegistry.getRegistry("127.0.0.1",8000);
        registry.bind("Hello",stub);
        System.out.println("SERVER READY________________________________________________________________");
    }
}
