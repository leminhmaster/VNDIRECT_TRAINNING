import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.File;
import java.sql.SQLException;

public class JdbcRowSetExample {
    public static void main(String[] args) throws SQLException {
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        File file = new File("sampledb");
        jdbcRowSet.setUrl("jdbc:derby:"+file);
        jdbcRowSet.setCommand("select * from student");
        jdbcRowSet.execute();
        while (jdbcRowSet.next()){
            System.out.println(jdbcRowSet.getInt(1)+jdbcRowSet.getString("name"));
        }
        //jdbcRowSet.close();
        jdbcRowSet.first();
        jdbcRowSet.updateString("name","Hoang Van X");
        jdbcRowSet.updateRow();
        jdbcRowSet.commit();
        jdbcRowSet.first();
        System.out.println(jdbcRowSet.getInt("id")+"\t"+jdbcRowSet.getString(2));
        jdbcRowSet.absolute(8);
        System.out.println(jdbcRowSet.getString("name")+" : "+jdbcRowSet.getInt("age"));

        jdbcRowSet.close();
    }
}
