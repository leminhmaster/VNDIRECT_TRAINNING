package edu.java.web.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/html");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("Accept-Encoding", "gzip");

        int responseCode = con.getResponseCode();
        System.out.println("Response code: " + responseCode);

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line="";
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }
}
