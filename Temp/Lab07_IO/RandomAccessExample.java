import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class RandomAccessExample {
    public static void main(String[] args) throws Exception {
        String homedir = System.getProperty("user.home");
        File file = new File(homedir+File.separator+"Temp"+File.separator+"io_sample.txt");
        RandomAccessFile randomAccess = new RandomAccessFile(file,"rw");
        randomAccess.seek(9);
        byte[] bytes = new byte[4*102];
        //bytes = "Hello Minh".getBytes();
        int read = randomAccess.read(bytes);
        //System.out.println(read);
        System.out.println(new String(bytes,0,read,"utf8"));

        randomAccess.seek(file.length());
        randomAccess.write("\r\n".getBytes());
        randomAccess.writeChars("Hello Co Can");

        Desktop.getDesktop().open(file);
    }
}
