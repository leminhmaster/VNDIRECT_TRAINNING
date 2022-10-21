package edu.java.web;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet(asyncSupported = true,name = "asynch",urlPatterns = {"/synch"})
public class AsynchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext ctx = req.startAsync();
        ctx.setTimeout(60*1000);
        ctx.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3*1000l);
                    Writer writer = ctx.getResponse().getWriter();
                    writer.write("Hello Async");
                    URL url = new URL("https://www.google.com.vn");

                    HttpURLConnection coc = (HttpURLConnection) url.openConnection();
                    coc.setRequestMethod("GET");
                    coc.addRequestProperty("Accept-Encoding", "gzip");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(coc.getInputStream()));
                    String line="";
                    while ((line = reader.readLine()) != null){
                        writer.write(line);
                    }
                    reader.close();
                    ctx.complete();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
