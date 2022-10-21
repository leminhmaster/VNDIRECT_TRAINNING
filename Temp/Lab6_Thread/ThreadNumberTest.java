import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThreadNumberTest {
    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();

        Thread thread = new Thread(number);
        thread.setName("HaNoi_Thread_1");
        //thread.setDaemon(true);
        thread.start();

        Thread thread1 = new Thread(number);
        thread1.setName("HaNoi_Thread_2");
        thread1.start();

//        try {
//            //System.out.println(Thread.currentThread().getName());
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        while (thread.isAlive()){
//            System.out.println(Thread.currentThread().getName());
//            if (number.getNumber()%10 == 0) number.setAlive(false);
//            try {
//                //Thread.sleep(1000);
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        //System.out.println("Main Thread say hello");
        //System.out.println("Main Thread say goodbye");

    }
}
