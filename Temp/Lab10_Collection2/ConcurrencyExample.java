import java.util.LinkedList;
import java.util.List;

public class ConcurrencyExample {
    public static void addData(List<Integer> list) throws InterruptedException {
        while (true) {
            int random = (int) (Math.random() * 100);
            list.add(random);
            System.out.println("add new data " + random);
            Thread.sleep(1000);
        }
    }

    public static void printData(List<Integer> list) {
        while (true) {
            System.out.println("===================");
            list.stream().forEach(v -> {
                System.out.println("value = " + v);
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            });

        }
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        new Thread(() -> {
            try {
                addData(list);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{printData(list);}).start();
    }
}
