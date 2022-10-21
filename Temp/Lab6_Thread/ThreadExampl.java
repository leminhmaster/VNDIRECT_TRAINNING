import java.util.Arrays;
import java.util.stream.Stream;

public class ThreadExampl {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Arrays.stream(args).forEach(ele-> System.out.println(ele));
            }
        }).start();
        Runnable message = new PrintMessage("Say hello to everyone");
        new Thread(message).start();
        new Thread(message).start();
        System.out.println("Xong");
    }
}
