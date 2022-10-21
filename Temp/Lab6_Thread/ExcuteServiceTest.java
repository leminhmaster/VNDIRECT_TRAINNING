import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class ExcuteServiceTest {
    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();
        Callable<Object> value = Executors.callable(number);
        System.out.println(" main say hello you");
        try {
            value.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("main say good bye");
    }
}
