import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClientExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/servlet-sample2/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Accept-Endcoding","gzip");
        int rescode = con.getResponseCode();
        System.out.println("Response Code = "+rescode);
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line = "";
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }
}
