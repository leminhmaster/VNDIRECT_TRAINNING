import java.io.Serializable;
import java.rmi.Remote;

public interface RMIMethod extends Remote {
    String writeMethod(String name) throws Exception;
}
