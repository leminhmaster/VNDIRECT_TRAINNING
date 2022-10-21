import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;

public class LinkFileExample {
    public static void main(String[] args) {
        String homedir = System.getProperty("user.home");
        //File sourceFile = new File(homedir+File.separator+"Temp");
        Path source  = Paths.get(homedir+File.separator+"Temp"+File.separator+"hanoijava.txt");
        Path target  = Paths.get(homedir+File.separator+"Temp"+File.separator+"test"+File.separator+"hanoijava.txt");
        Charset charset = Charset.forName("utf8");
        try (BufferedWriter writer = Files.newBufferedWriter(source,charset,APPEND)){
            writer.write("Java NIO 2 Example");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        try (BufferedReader reader = Files.newBufferedReader(target,charset)){
            String line = null;
            while ((line= reader.readLine())!=null){
                System.out.println(line);
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
