public class StringExample1 {
    public static void main(String[] args) {
        String text = "say hello to everyone ";
        System.out.println("length of text is" + text.length());
        System.out.println("vi tri cua tu hello la : " + text.indexOf("hello"));
        System.out.println("cat tu = "+ text.substring(4,8));
        char [] chars = {'h','e','l','l','o'};
        String text1 = new String(chars);
        System.out.println(text);
        text1 = text1.concat(" lala");
        text1 = text1.concat(" minh");
        System.out.println("new value is "+ text1);
        System.out.println("hello java".equals("say hello java"));
        String text2 = "Absolute value";
        byte [] bytes = text2.getBytes();
        System.out.println("Byte value are ");
        for (int i = 0; i < bytes.length; i++) {
            System.out.print((int)bytes[i]+" , ");
        }
        String text3 ="say hello to everyone";
        System.out.println("length of text is " + text.length());

        int i =0;
        while (i< text3.length()){
            char c = text3.charAt(i);
            if(c == ' '){
                i++;
                continue;
            }
            System.out.println("Character at "+i+" is "+c);
            i++;
        }
        byte [] bytes1 = {
                99,-58,-80,-31,-69,-101,112,44,32,104,105,-31,-70,-65,112,44,32,103,105,-31,-70,-65,116
        };
        try {
            System.out.println(new String(bytes1,"utf8"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}