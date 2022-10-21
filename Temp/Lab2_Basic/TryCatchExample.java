public class TryCatchExample {

    private static int toNumber( String value ){
        try {
            Integer integer = Integer.parseInt(value);
            return integer;
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args) {

        int number = toNumber("34");
        System.out.println("number =" + number);
        number = toNumber("as");
        System.out.println("number ="+number);
    }
}
