import java.awt.*;
import java.io.*;

public class ReaderWriterExample {
    public static void main(String[] args) throws IOException {
        String homedir = System.getProperty("user.home");
        File file = new File(homedir+File.separator+"Temp"+File.separator+"io_sample.txt");
        FileWriter writer = new FileWriter(file,true);
        writer.write("\r\n");
        writer.write("Le Duc Minh");
        writer.close();
        Desktop.getDesktop().open(file);

        FileReader reader = null;
        reader = new FileReader(file);
        char [] buffer = new char[4*1024];
        int read = -1;
        StringBuilder builder = new StringBuilder();
        while ((read = reader.read(buffer)) != -1){
            builder.append(buffer,0,read);
        }
        System.out.println("[["+builder.toString()+"]]");
    }
}
