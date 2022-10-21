
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        Server obj = new Server();
        RMIMethod stub = (RMIMethod) UnicastRemoteObject.exportObject(obj, 0);
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8000);
        registry.bind("client.Hello", stub);
        System.out.println("client.Server ready");
    }
}
