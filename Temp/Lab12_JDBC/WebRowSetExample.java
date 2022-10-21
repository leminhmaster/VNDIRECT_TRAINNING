import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WebRowSetExample {
    public static void main(String[] args) {
        Connection connection = SingeltonPatern.getSingeltonPatern().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from student");
            File file = new File("output.xml");
            FileWriter writer = new FileWriter(file);
            WebRowSet wrs = RowSetProvider.newFactory().createWebRowSet();
            wrs.writeXml(rs,writer);
            Desktop.getDesktop().open(file);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
