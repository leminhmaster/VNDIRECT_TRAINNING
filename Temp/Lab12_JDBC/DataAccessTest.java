import java.sql.SQLException;
import java.util.List;
import java.util.stream.IntStream;

public class DataAccessTest {
    public static void main(String[] args) throws Exception {
        DataAccessLogic dataAccessLogic = new DataAccessLogic();
//        List<String> names = dataAccessLogic.loadNames(1);
//        names.forEach(name -> System.out.println(name));
        System.out.println("total pages = "+dataAccessLogic.numberofPages());
        IntStream.range(1, dataAccessLogic.numberofPages()).forEach(page->{
            System.out.println("================================"+page);
            try {
                List<String> names1 = dataAccessLogic.loadNames(page);
                names1.stream().forEach(name1->System.out.println(name1));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
