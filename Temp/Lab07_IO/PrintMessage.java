import java.io.Serializable;

public class PrintMessage implements  Runnable, Serializable {

    private String message;

    public PrintMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Message: "+message);
    }
}
