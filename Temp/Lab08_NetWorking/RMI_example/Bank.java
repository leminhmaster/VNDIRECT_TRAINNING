package RMI_example;

import java.rmi.Remote;
import java.util.List;

public interface Bank extends Remote {
    public List<Customer> getCustomer() throws Exception;
}
