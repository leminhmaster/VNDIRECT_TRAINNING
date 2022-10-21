import java.util.concurrent.*;

public class FeatureExample {
    public static void main(String[] args) {
        CallableSample callableSample = new CallableSample();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future future = executor.submit(callableSample);
        System.out.println("Future Done ?"+future.isDone());
        Object o = 0;
        try {
             o = future.get(3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Future done ? "+future.isDone()+" - result " +o.toString());

    }
}
