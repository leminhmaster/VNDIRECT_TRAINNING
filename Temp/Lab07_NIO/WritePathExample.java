import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class WritePathExample {
    public static void main(String[] args) throws IOException {
        String homedir = System.getProperty("user.home");
        File sourceFile = new File(homedir+File.separator+"Temp"+File.separator+"hanoijava2.txt");
        Path path  = Paths.get(homedir+File.separator+"Temp"+File.separator+"hanoijava2.txt");
        BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("utf8"),CREATE,APPEND);
        for (int i = 0; i < 10; i++) {
            writer.write("Le Duc "+i+"\r\n");
        }
        writer.close();
        Desktop.getDesktop().open(path.toFile());
    }
}
