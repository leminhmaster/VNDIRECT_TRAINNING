import java.util.concurrent.locks.Lock;

public class DeadLockDemo extends Thread{
    private Lock lock1;
    private Lock lock2;

    public DeadLockDemo(Object lock1,Object lock2){

    }

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName()+": Holding "+lock1 +" .... ");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"----------->"+lock1+" : "+lock2+" ....");
        }
    }
}
