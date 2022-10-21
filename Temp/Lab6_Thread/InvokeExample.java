import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class InvokeExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<CallableSample> callables =Arrays.asList(new CallableSample(),new CallableSample(),new CallableSample());
        Stream<Integer> resultStream;
        try {
            Stream<Future<Integer>> stream = executor.invokeAll(callables).stream();
            resultStream = stream.map(future->{
                try {
                    return future.get();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Integer [] results = resultStream.toArray(Integer[]::new);
        Arrays.stream(results).forEach(v-> System.out.println(v));
    }
}
