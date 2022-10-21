import java.util.Vector;

public class VectoExample {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(1);
        vector.add(14);
        vector.add(8);
        vector.add(3);
        vector.add(12);
        vector.add(13);

        System.out.println("Size of vector: "+vector.size());
        System.out.println("Element at 2: " + vector.get(2));


    }
}
