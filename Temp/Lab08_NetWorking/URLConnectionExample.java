import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.stream.Stream;

public class URLConnectionExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.google.com.vn/");
        URLConnection connection = url.openConnection();
        InputStream stream = connection.getInputStream();
        int read =0;
        byte[] bytes = new byte[1000];
        while ((read = stream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,read));
        }
    }
}
