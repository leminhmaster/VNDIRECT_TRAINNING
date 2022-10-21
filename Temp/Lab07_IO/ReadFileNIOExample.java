import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileNIOExample {
    public static void main(String[] args) throws Exception {
        String homedir = System.getProperty("user.home");
        File file = new File(homedir+File.separator+"Temp"+File.separator+"io_sample.txt");
        FileInputStream fileInput = null;
        FileChannel fileChannel = null;
        try{
            fileInput = new FileInputStream(file);
            fileChannel = fileInput.getChannel();
            long size = fileChannel.size();
            ByteBuffer buff = ByteBuffer.allocate((int)size);
            fileChannel.read(buff);
            buff.rewind();
            System.out.println(new String(buff.array(),"utf8"));
        }finally {
            if (fileChannel != null)fileChannel.close();
            if (fileInput != null)fileInput.close();
        }




    }
}
