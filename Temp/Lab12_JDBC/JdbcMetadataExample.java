import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcMetadataExample {
    public static void main(String[] args) throws Exception {
        Connection connection = SingeltonPatern.getSingeltonPatern().getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println("db version : "+metaData.getDatabaseMajorVersion());
        System.out.println("driver name : "+metaData.getDriverName());
        connection.close();
    }
}
