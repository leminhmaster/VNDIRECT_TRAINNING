package RMI_example;

import java.io.Serializable;

public class Customer implements Serializable {
    public int acc_no;
    public String name;

    public Customer(int acc_no, String name) {
        this.acc_no = acc_no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "acc_no=" + acc_no +
                ", name='" + name + '\'' +
                '}';
    }
}
