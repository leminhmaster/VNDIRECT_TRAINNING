import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PrintMessage implements Runnable{
    private String message;


    public PrintMessage(String message) {
        this.message = message;
    }

    @Override
    public synchronized void run() {
        String [] elements = message.split(" ");
        Arrays.stream(elements).forEach(ele->{
            System.out.println(Thread.currentThread().getName() + " print "+ele);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        try {
//
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
