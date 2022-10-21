import java.io.File;
import java.sql.*;

public class SelectDataExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        File file = new File("sampledb");
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby:"+file.getAbsolutePath()+"; create=true");
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from app.student");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt(3);
                System.out.println(id+"\t"+name+"\t"+age);
            }
            rs.close();
        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }finally {

            statement.close();
            connection.close();
        }

    }
}
