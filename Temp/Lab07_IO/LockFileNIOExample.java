import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockFileNIOExample {
    public static void main(String[] args) throws Exception {
        String homedir = System.getProperty("user.home");
        File file = new File(homedir+File.separator+"Temp"+File.separator+"io_sample.txt");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        FileChannel channel = raf.getChannel();
        FileLock lock = channel.tryLock(0,channel.size(),false);

        Desktop.getDesktop().edit(file);
        Thread.sleep(15*1000);
        lock.release();

    }
}
