import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = SingeltonPatern.getSingeltonPatern().getConnection();
        Statement statement = connection.createStatement();
        try {
            for (int i = 0; i < 20; i++) {
                String name = "Le Duc "+i;
                int age = 11+i;
                String sql = "insert into student(name,age) values ('"+name+"' , "+age+")";
                statement.addBatch(sql);
            }
            statement.executeBatch();
            ResultSet rs = statement.executeQuery("select count(*) from student");
            if (rs.next()) {
                System.out.println(" total results: " + rs.getInt(1));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            statement.close();
            connection.close();
        }

    }
}
