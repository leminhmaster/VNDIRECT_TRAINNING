import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class SingeltonPatern {
    static SingeltonPatern singeltonPatern;
    private static Connection connection;
    public SingeltonPatern() {
        File file = new File("sampledb");
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby:"+file.getAbsolutePath()+"; create=false");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SingeltonPatern getSingeltonPatern() {
        if (singeltonPatern == null) {
            singeltonPatern = new SingeltonPatern();
        }
        return singeltonPatern;
    }
    public Connection getConnection() {
        return connection;
    }
}
