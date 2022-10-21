import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class DatagramServerExample implements Runnable {

    DatagramSocket socket;

    public DatagramServerExample() throws SocketException {
        socket = new DatagramSocket(4445);
        System.out.println("DATA SERVER listening ....");
    }

    public static void main(String[] args) throws SocketException {
        new Thread(new DatagramServerExample()).start();
    }

    @Override
    public void run() {
        try {
            byte[] bytes = new byte[1000];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);
            System.out.println("From client.Client.Client: " + new String(packet.getData(), 0, packet.getLength()));
            bytes = "client.Server say hello".getBytes();
            socket.send(new DatagramPacket(bytes, bytes.length, packet.getAddress(), packet.getPort()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
