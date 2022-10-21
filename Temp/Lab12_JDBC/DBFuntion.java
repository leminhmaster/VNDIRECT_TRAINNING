import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBFuntion {
    public static void getAge(String name, int [] age){
        Connection connection = SingeltonPatern.getSingeltonPatern().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select max(age) from student where name like '%"+name+"%'");
            age[0] = rs.next()? rs.getInt(1):-1;
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int [] ages = new int[1];
        getAge("Le",ages);
        System.out.println(ages[0]);
    }
}
