public class MethodExample {
    private static int add(int number1,int number2){
        return number1 + number2;
    }
    private static int add(int ...values){
        int total =0;
        for (int element:values) {
            total += element;
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println("4 + 7 = " + add(4,7));
        int value1 = Integer.parseInt(args[0]);
        int value2 = Integer.parseInt(args[1]);
        System.out.println(value1 + " + " + value2 + " = " + add(value1,value2));
        System.out.println("SUM = "+ add(1,2,3,4,5,6,7,8,9));
    }
}