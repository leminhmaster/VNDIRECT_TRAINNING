
import java.rmi.RemoteException;

class Server implements RMIMethod {

    @Override
    public String say(String name) throws RemoteException {
        return "client.Hello: " + name;
    }


}
