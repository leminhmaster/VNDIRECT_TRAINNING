import java.util.Properties;

public class SystemExample {
    public static void main(String[] args) {
        System.out.println("JAVA_HOME = "+System.getProperty("java.home"));
        System.out.println("User = "+ System.getProperty("user.name"));
        //System.setProperty("java.home","C:\\Program Files\\Java\\jre19");
        //System.out.println("Java home = "+System.getProperty("java.home"));
        System.out.println("jre vendor name"+System.getProperty("java.vendor"));

    }
}
