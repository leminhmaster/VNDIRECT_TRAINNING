import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessLogic {
    private final static Logger logger = Logger.getLogger(DataAccessLogic.class.getName());
    Connection connection = null;
    CachedRowSet rowSet;
    public DataAccessLogic() throws Exception {
        this.connection = SingeltonPatern.getSingeltonPatern().getConnection();
        rowSet = RowSetProvider.newFactory().createCachedRowSet();
        rowSet.setCommand("select * from student");
        rowSet.execute(connection);
    }
    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        }catch (Exception e) {
            logger.log(Level.WARNING,e.toString());
        }
    }
    int pageSize = 10;
    List<String> loadNames(int page) throws SQLException {
        List<String> names = new ArrayList<String>();
        rowSet.setPageSize(pageSize);
        int start = (page-1)*pageSize+1;
        if (!rowSet.absolute(start))return names;
        rowSet.previous();
        while (rowSet.next()){
            names.add(rowSet.getString("name"));
            if (names.size() >= pageSize) break;
        }
        return names;
    }

    int numberofPages() throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(*) from student");
            if (!rs.next()) return 0;
            int total = rs.getInt(1);
            int totalPages = total/pageSize;
            if (total%pageSize != 0) totalPages++;
            return totalPages;
        }finally {
            statement.close();
        }
    }
}
