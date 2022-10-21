import java.io.File;
import java.sql.*;

public class UpdateDataExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = SingeltonPatern.getSingeltonPatern().getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE student set name = ? WHERE id = ? ");
        try {
            statement.setString(1,"Le Thi Z");
            statement.setInt(2,2);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            statement.close();
            connection.close();
        }
    }
}
