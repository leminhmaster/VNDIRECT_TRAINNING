public class MyProgram {
    public static void main(String [] args){
        //System.out.println("Say hello to java");
        //System.out.println("Total = "+5+7);
//        System.out.println("The number of argument is " + args.length);
//        for (int i = 0; i < args.length; i++) {
//            System.out.println("Value at "+i+" is " + args[i]);
//        }
        for (String value: args) {
            System.out.println("Value is "+ value);
        }
    }
}