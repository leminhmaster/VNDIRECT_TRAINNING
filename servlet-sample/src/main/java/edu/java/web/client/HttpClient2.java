package edu.java.web.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpClient2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(()->{
            try {
                URL obj = new URL("http://localhost:8080/synch");
                HttpURLConnection coc = (HttpURLConnection) obj.openConnection();
                coc.setRequestMethod("GET");
                coc.addRequestProperty("Accept-Encoding", "gzip");
                BufferedReader reader = new BufferedReader(new InputStreamReader(coc.getInputStream()));
                String line="";
                while ((line = reader.readLine()) != null){
                    System.out.println(line);
                }
                reader.close();
                executor.shutdown();
                Thread.sleep(5000);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
