import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class readWriteLockExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Map<String,String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("start writting");
                lock.writeLock().lock();
                try {
                    //TimeUnit.SECONDS.sleep(10);
                    map.put("foo","bar");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.writeLock().unlock();
                    System.out.println("End Writting");
                }
            }
        });
        Runnable readTask = ()->{
            System.out.println("start reading");
            lock.readLock().lock();
            try {
                System.out.println(map.get("foo"));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.readLock().unlock();
                System.out.println("end reading");
            }
        };
        executor.submit(readTask);
        executor.submit(readTask);
    }
}
