import java.io.*;

public class FileOutputExample {
    public static void main(String[] args) throws IOException {
        String homedir = System.getProperty("user.home");
        File file = new File(homedir+File.separator+"Temp"+File.separator+"hanoijava.txt");
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            byte[] bytes = "Hello Ha Noi Java Class".getBytes();
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (outputStream != null) outputStream.close();
        }

        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes1= new byte[124];
        inputStream.read(bytes1);
        System.out.println("["+new String(bytes1)+"]");

        inputStream = new FileInputStream(file);
        byte[] bytes2 = new byte[4*1024];
        int read = -1;
        StringBuilder builder = new StringBuilder();
        while ((read = inputStream.read(bytes2)) != -1){
            builder.append(new String(bytes2,0,read));
        }

        System.out.println("[["+builder.toString()+"]]");
    }
}
