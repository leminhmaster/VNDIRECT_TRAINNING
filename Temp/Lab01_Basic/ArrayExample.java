public class ArrayExample {
    public static void main(String[] args) {
        float [] values = {4.5f,5.5f,6.6f};
        float total = 0;
        int count = 0;
        for (float value: values) {
            total += value;
            count ++;
        }
        System.out.println("The total of array is "+ total);
        System.out.println("The average of array is "+ (total / (float)count ));
        float max = values[0];
        for (int i = 0; i < values.length; i++) {
            if (max < values[i]) max = values[i];
        }
        System.out.println("Gia tri lon nhat = "+ max);
    }
}