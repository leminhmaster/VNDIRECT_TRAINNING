import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStoreProcedureExample {
    public static void main(String[] args) {
        Connection connection = SingeltonPatern.getSingeltonPatern().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("create procedure GETAGE(STREAM_NAME VARCHAR(255),OUT AGE INT) PARAMETER STYLE JAVA READS SQL DATA LANGUAGE JAVA EXTERNAL NAME 'jdbc.DbFunction.getAge' ");
            System.out.println("done");
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
