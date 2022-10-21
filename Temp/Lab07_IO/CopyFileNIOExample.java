import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class CopyFileNIOExample {
    public static void main(String[] args) throws Exception {
        String homedir = System.getProperty("user.home");
        File sourceFile = new File(homedir+File.separator+"Temp"+File.separator+"io_sample.txt");
        File desFile = new File(sourceFile.getParentFile(),"sample2.txt");
        FileChannel srcChannel = null;
        FileChannel desChannel = null;
        srcChannel = new FileInputStream(sourceFile).getChannel();
        desChannel = new FileOutputStream(desFile).getChannel();
        srcChannel.transferTo(0,srcChannel.size(),desChannel);
        Desktop.getDesktop().open(sourceFile.getParentFile());
    }
}
