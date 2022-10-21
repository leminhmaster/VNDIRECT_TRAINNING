public class MultidimentionalArrayExample {
    public static void main(String[] args) {
        String [][] values = {
                {"Doan","Van","A "},
                {"Tran","Thi","B "}
        };
        for (int i = 0; i < values.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < values[i].length; j++) {
                System.out.print(i + "," + j + "|");
            }
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < values[i].length; j++) {
                System.out.print(values[i][j] + "|");
            }
            System.out.println();
        }
        int i =4;
        int j =-8;
        double x = 47.1;
        double y = 1.79;
        System.out.println("|"+j+"| is "+Math.abs(j));
        System.out.println(x+" is approximately "+ Math.round(x));
        System.out.println("The Ceiling of "+i+"is"+Math.ceil(i));
        System.out.println("The Ceilling of "+y+"is"+Math.ceil(y));
        System.out.println("The floor of"+x+" is "+Math.floor(x));
        System.out.println("min(47.1, 1.79) is "+ Math.min(x,y));

    }
}