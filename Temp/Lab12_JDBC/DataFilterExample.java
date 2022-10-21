import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.File;
import java.sql.SQLException;

public class DataFilterExample {
    public static void main(String[] args) throws SQLException {
        FilteredRowSet frs = RowSetProvider.newFactory().createFilteredRowSet();
        File file = new File("sampledb");
        frs.setUrl("jdbc:derby:"+file);
        frs.setCommand("select * from student");
        frs.setFilter(new DataFilter());
        frs.execute();
        System.out.println("ID\tName\tAGE");
        while (frs.next()){
            System.out.println(frs.getString(1)+"\t"+frs.getString(2)+"\t"+frs.getString(3));
        }
    }
}
