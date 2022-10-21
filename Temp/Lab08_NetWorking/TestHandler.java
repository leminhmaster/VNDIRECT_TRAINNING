import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

class TestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String message = "<html><h2>This is response</h2></html>";
        exchange.sendResponseHeaders(200,message.length());
        OutputStream out = exchange.getResponseBody();
        out.write(message.getBytes());
    }
}

class SecondHandler implements HttpHandler{

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String message = "<html><h2>HELLO LE DUC MINH!!!!!!!!</h2></html>";
        exchange.sendResponseHeaders(404,message.length());
        OutputStream out = exchange.getResponseBody();
        out.write(message.getBytes());

    }
}

class HttpServerExample{
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
        server.createContext("/test1",new TestHandler());
        server.setExecutor(Executors.newFixedThreadPool(5));
        server.start();
    }
}
