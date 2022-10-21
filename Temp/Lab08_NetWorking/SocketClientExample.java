import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClientExample {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9245);
        System.out.println("client.Client.Client start sending");
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        output.writeUTF("client.Hello client.Server");
        System.out.println("client.Server Say: "+input.readUTF());
        socket.close();
    }
}
