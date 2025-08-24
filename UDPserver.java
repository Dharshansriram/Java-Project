import java.io.IOException;
import java.net.*;
public class UDPserver {
     private static int indexOf(String[]array,String str)
     {
        str=str.trim();
        for(int i=0;i<array.length;i++)
        {
            if(array[i].equals(str))
            return i;
        }
        return -1;
     }
     public static void main(String[] args)throws IOException {
        String[]hosts={"H&M.com","LeoDas&Co.com","Flipkart.com"};
        String[]ip={"172.28.251.59","172.217.11.6","172.217.11.4"};
        System.out.println("Press Ctrl+C to Quit");
        while(true)
        {
            DatagramSocket serversocket= new DatagramSocket(1362);
            byte[]sendData= new byte[1021];
            byte[]receiveData= new byte[1021];
            DatagramPacket recvpack= new DatagramPacket(receiveData,receiveData.length);
            serversocket.receive(recvpack);
            String sen= new String(recvpack.getData());
            InetAddress ipaddress= recvpack.getAddress();
            int port= recvpack.getPort();
            String capsent;
            System.out.println("Request for Host:"+ sen);
            if(indexOf(hosts,sen)!=-1)
            
                capsent=ip[indexOf(hosts,sen)];
            
            else
            
                capsent= "Host Not Found";sendData= capsent.getBytes();

            
            DatagramPacket pack= new DatagramPacket(sendData, sendData.length,ipaddress,port);
            serversocket.send(pack);
            serversocket.close();


        }
        
     }
}
