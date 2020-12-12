import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Authenticate2client
{
    private static int key = 3;
    public static void main(String[] args) throws SocketException, IOException
    {
        DatagramSocket DSocket = new DatagramSocket();

        Scanner s = new Scanner(System.in);

        InetAddress ip = InetAddress.getLocalHost();

        System.out.print("Enter password: ");
        String password = s.nextLine();

        String encPassword = encrypt(password);

        byte []sendMessage = encPassword.getBytes();;

        DatagramPacket packetSend = new DatagramPacket(sendMessage,sendMessage.length,ip,44000);

        DSocket.send(packetSend);

        byte[] recievedMessage = new byte[200];

        DatagramPacket packetReceive = new DatagramPacket(recievedMessage,recievedMessage.length);

        DSocket.receive(packetReceive);

        String receivedString = new String(recievedMessage);

        System.out.println("Result: "+ receivedString);
    }

    private static String encrypt(String originalString)
    {
        StringBuilder encString = new StringBuilder();
        for(int i=0;i<originalString.length();i++)
        {
            char prevVal = originalString.charAt(i) ;
            if(prevVal == ' ')
            {
                encString.append(' ');
                continue;
            }

            char newVal = (char) (prevVal + key);
            if(newVal>'z')
            {
                encString.append((char)(newVal-26));
            }
            else if(newVal<'a')
            {
                encString.append((char)(newVal+26));
            }
            else
            {
                encString.append(newVal);
            }
        }
        return encString.toString();
    }
}
