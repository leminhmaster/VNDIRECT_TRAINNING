import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

public class RandomAccessFileExample {
    public static void main(String[] args) throws IOException {
        String homedir = System.getProperty("user.home");
        File sourceFile = new File(homedir+File.separator+"Temp"+File.separator+"hanoijava2.txt");
        Path path  = Paths.get(homedir+File.separator+"Temp"+File.separator+"hanoijava2.txt");
        ByteBuffer buffer = ByteBuffer.allocate(4);
        FileChannel fc = FileChannel.open(path,READ,WRITE);
        fc.read(buffer);
        System.out.println(new String(buffer.array()));

//        fc.position(0);
//        byte[] bytes = "Trần".getBytes();
//        fc.write(ByteBuffer.wrap(bytes));

        fc.close();
    }
}
