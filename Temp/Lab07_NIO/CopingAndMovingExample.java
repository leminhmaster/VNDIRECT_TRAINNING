import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopingAndMovingExample {
    public static void main(String[] args) throws IOException {
        String homedir = System.getProperty("user.home");
        File sourceFile = new File(homedir+File.separator+"Temp");
        Path source  = Paths.get(homedir+File.separator+"Temp"+File.separator+"hanoijava.txt");
        Path target  = Paths.get(homedir+File.separator+"Temp"+File.separator+"test"+File.separator+"hanoijava.txt");
//link file là liên kết file sang một thư mục khác không phải là copy
        Files.createLink(target,source);
//        Files.delete(target);
//        Files.copy(source,target,REPLACE_EXISTING);

        Desktop.getDesktop().open(source.getParent().toFile());
    }
}
