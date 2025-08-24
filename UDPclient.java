import java.io.*;
import java.net.*;
public class UDPclient {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientsocket= new DatagramSocket();
        InetAddress ipAddress;
        if(args.length==0)
        
            ipAddress= InetAddress.getLocalHost();

        
        else
            ipAddress= InetAddress.getByName(args[0]);
 
        byte[]sendData= new byte[1024];
        byte[]receiveData= new byte[1024];
        int portable= 1362;
        System.out.println("Enter the Host-Name:");
        String sentence= br.readLine();
        sendData= sentence.getBytes();
        DatagramPacket pack= new DatagramPacket(sendData,sendData.length,ipAddress,portable);
        clientsocket.send(pack);
        DatagramPacket recvpack= new DatagramPacket(receiveData,receiveData.length);
        clientsocket.receive(recvpack);
        String modified= new String(recvpack.getData());
        System.out.println("IP Address:" + modified);
        clientsocket.close();

    }
}
