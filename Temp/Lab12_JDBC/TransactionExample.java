import java.sql.*;

public class TransactionExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = SingeltonPatern.getSingeltonPatern().getConnection();
        Statement statement = connection.createStatement();
        try {
            connection.setAutoCommit(false);
            for (int i = 0; i < 10; i++) {
                String name = "Tran Van "+i;
                int age = 10 + i;
                statement.executeUpdate("insert into student(name,age) values ('"+name+"' , "+age+")");

            }
            connection.rollback();
            connection.setAutoCommit(true);
            ResultSet rs = statement.executeQuery("select count(*) from student");
            if (rs.next()) {
                System.out.println(" total results: " + rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            statement.close();
            connection.close();
        }

    }
}
