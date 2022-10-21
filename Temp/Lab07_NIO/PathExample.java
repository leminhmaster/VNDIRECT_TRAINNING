import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

public class PathExample {
    public static void main(String[] args) throws IOException {
        String homedir = System.getProperty("user.home");
        File sourceFile = new File(homedir+File.separator+"Temp"+File.separator+"io_sample.txt");
        Path path  = Paths.get(homedir+File.separator+"Temp");
//        System.out.println("This is "+(Files.isDirectory(path)? "file":"folder")+"!");
//        System.out.println(Files.exists(path));
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
//        directoryStream.forEach(path1 -> {
//            System.out.println(path1.getFileName());
//        });

        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry);
            }
        };
//        directoryStream = Files.newDirectoryStream(path,filter);
//        directoryStream.forEach(path1 -> {
//            System.out.println(path1.getFileName());
//        });

//        directoryStream = Files.newDirectoryStream(path,"*.{java,txt}");
//        directoryStream.forEach(path1 -> {
//            System.out.println(path1.getFileName());
//        });
        Path path2 = path.resolve("hanoijava.txt");
        Charset charset = Charset.forName("utf8");
        BufferedReader reader = Files.newBufferedReader(path2,charset);

        String line = null;
        while ((line = reader.readLine())!=null){
            System.out.println(line);
        }
        Desktop.getDesktop().open(path2.toFile());


    }
}
