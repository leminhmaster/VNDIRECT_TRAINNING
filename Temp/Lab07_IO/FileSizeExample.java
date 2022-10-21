import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileSizeExample {
    static long getSize(File file){
        if (file.isFile()) return file.length();
        AtomicLong length = new AtomicLong(0);
        Arrays.stream(file.listFiles()).forEach(f->{
            length.getAndSet(length.longValue()+(f.isFile()? f.length():getSize(f)));
        });
        return length.longValue();
    }
    public static void main(String[] args) {
        String homedir = System.getProperty("user.home");
        File file = new File(homedir+"/Temp/Lab01_Basic");
        System.out.println("Size: "+ getSize(file)+" byte");
    }
}
