public class PrintNumber implements Runnable{
    private Integer number =0;
    private boolean alive = true;
    public int getNumber(){
        return number;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    @Override
    public void run() {
        Thread current = Thread.currentThread();
//        while (alive){
//            number++;
//            System.out.println(current.getName()+" number is \'"+number+"\'");
//            try {
//                Thread.sleep(800);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        synchronized (number){
            while (number <= 30){
                number++;
                System.out.println(current.getName()+" number is \'"+number+"\'");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
//        while (true){
//            number++;
//            System.out.println(current.getName()+" number is \'"+number+"\'");
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            if (number%10 == 0) break;
//
//        }

        System.out.println(current.getName() + " is stoped!");
    }
}
