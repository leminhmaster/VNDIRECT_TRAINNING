import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool(4);
        CallableSample sample = new CallableSample();
        List<CallableSample> callable = Arrays.asList(sample,sample,sample,sample,sample);
        try {
            executor.invokeAll(callable);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
