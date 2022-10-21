import java.awt.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class HttpConnectionExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.google.com.vn/");
        URLConnection connection = url.openConnection();
        Path path = Paths.get("test.html");
        InputStream inputStream = connection.getInputStream();
        OutputStream outputStream = Files.newOutputStream(path,CREATE,APPEND);
        int read =0;
        byte[] bytes = new byte[10000000];
        while ((read = inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,read);
        }

        Desktop.getDesktop().open(path.toFile());

    }
}
