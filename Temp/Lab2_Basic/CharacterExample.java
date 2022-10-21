import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CharacterExample {
    private static int countDigit(String value){
        int i=0;
        int count =0;
        while (i<value.length()){
            char c = value.charAt(i);
            if (Character.isDigit(c)) count++;
            i++;
        }
        return count;
    }
    private static int countWhiteSpace(String value){
        int i=0;
        int count =0;
        while (i<value.length()){
            char c = value.charAt(i);
            if (Character.isWhitespace(c)) count++;
            i++;
        }
        return count;
    }
    static int  countDigitStream(String value){
        AtomicInteger counter = new AtomicInteger();
        IntStream stream = value.chars();
        stream.forEach(c -> {
            if (Character.isDigit(c)) counter.incrementAndGet();
        });
        return  counter.get();
    }
    public static void main(String[] args) {
        System.out.println("There are "+countDigit(args[0])+" digits in the text.");
        System.out.println("There are "+countWhiteSpace(args[0])+" digits in the text.");
        System.out.println("There are "+countDigitStream(args[0])+" digits in the text.");
    }
}
