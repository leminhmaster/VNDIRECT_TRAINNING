import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFileNIOExample {
    public static void main(String[] args) throws Exception {
        Charset charset = Charset.forName("utf8");
        Pattern pattern = Pattern.compile("s\\S",Pattern.CASE_INSENSITIVE);
        String homedir = System.getProperty("user.home");
        File file = new File(homedir+File.separator+"Temp"+File.separator+"io_sample.txt");
        FileInputStream stream = new FileInputStream(file);
        FileChannel channel = stream.getChannel();
        ByteBuffer bytes = channel.map(
                FileChannel.MapMode.READ_ONLY,0,channel.size()
        );
        CharBuffer chars = charset.decode(bytes);
        Matcher matcher = pattern.matcher(chars);
        if (matcher.find()){
            System.out.println("Found at "+Integer.toString(matcher.start()));
            System.out.println("Value '"+chars.subSequence(matcher.start(),matcher.end()) +"'");
        }else {
            System.out.println("Not Found");
        }
        Desktop.getDesktop().open(file);
    }

}
