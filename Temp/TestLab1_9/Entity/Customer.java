package Entity;

public class Customer {
    private String name;
    private Integer age;
    private Integer total;

    public Customer(String name, Integer age, Integer total) {
        this.name = name;
        this.age = age;
        this.total = total;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.total = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", total=" + total +
                '}';
    }
}
