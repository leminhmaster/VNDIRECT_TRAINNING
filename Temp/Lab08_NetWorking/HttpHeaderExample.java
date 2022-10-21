import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class HttpHeaderExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.google.com.vn/");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        System.out.println("https method "+ connection.getRequestMethod());
        Map<String, List<String>> headers = connection.getHeaderFields();
        BiConsumer<String,List<String>> header = new BiConsumer<String, List<String>>() {
            @Override
            public void accept(String s, List<String> strings) {
                System.out.println("Key : "+s+" Values: "+strings);
            }
        };
        headers.forEach(header);
    }
}
