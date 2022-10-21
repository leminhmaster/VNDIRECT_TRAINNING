package RMI_example;

import java.util.ArrayList;
import java.util.List;

public class BankImpl implements Bank{
    @Override
    public List<Customer> getCustomer() throws Exception {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(1, "MINH"));
        customers.add(new Customer(2, "MAXH"));
        customers.add(new Customer(3, "MINH"));
        return customers;
    }
}
