public class RunnableTest {
    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"say hello Java class");
//            }
//        };
        ////////////////////////////
//        Runnable runnable = ()->{
//            System.out.println(Thread.currentThread().getName()+"say hello Java class");
//        };
//        new Thread(runnable).start();
        ///////////////////////////////////////
//        new Thread(()->System.out.println(Thread.currentThread().getName()+"say hello Java class")).start();
        //////////////////////
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"say hello Java class");
            System.out.println("1+1 = "+(1+1));
        });
    }
}
