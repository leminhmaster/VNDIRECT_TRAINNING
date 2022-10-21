public class ConcatenateStringTest {
    public static void main(String[] args) {
        int max = 1000000;
        StringBuilder builder = new StringBuilder();
        long start = System.currentTimeMillis();
        String temp;
        for (int i = 0; i < max; i++) {
            builder.append(String.valueOf(i));
        }
        System.out.println("time 1 = "+(System.currentTimeMillis()-start));
        String temp2;
        StringBuffer buffer = new StringBuffer();
        start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            buffer.append(i);
        }
        System.out.println("time 2 = "+(System.currentTimeMillis()-start));

        String text ="";
        start = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            text += String.valueOf(i);
        }
        System.out.println("time 3 = "+(System.currentTimeMillis()-start));
    }
}
