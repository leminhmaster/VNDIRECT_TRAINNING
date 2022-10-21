import java.net.*;

//
public class DatagramClientExample {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        byte [] bytes = "client.Client.Client say Xin chao".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,address,4445);
        socket.send(packet);

        packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);
        System.out.println("FROM SERVER: "+new String(packet.getData(),0, packet.getLength()));
        socket.close();
    }
}
