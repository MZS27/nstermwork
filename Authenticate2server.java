import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Authenticate2server
{

    //private static String[] passwords = {"abc123","admin","password","7dec1997"};
    private static int[] hashcodes = {3333,92668751, 1216985755,106683528};
    private static int key = 3;

    public static void main(String args[]) throws SocketException, IOException
    {
        DatagramSocket DSocket = new DatagramSocket(44000);
        byte []recieveMessage = new byte[200];

        DatagramPacket packetRecieve = new DatagramPacket(recieveMessage, recieveMessage.length);

        DSocket.receive(packetRecieve);

        String checkPassword = (new String(recieveMessage)).trim();

        String result = validatePassword(checkPassword);

        InetAddress ip = InetAddress.getLocalHost();

        byte []resultBytes = result.getBytes();

        DatagramPacket packetSend = new DatagramPacket(resultBytes,resultBytes.length,ip,packetRecieve.getPort());


        DSocket.send(packetSend);

    }

    private static String validatePassword(String check)
    {
        String decPassword = decrypt(check);
        int hashedPassword = decPassword.hashCode();
        System.out.println(hashedPassword);
        for(int i=0;i<hashcodes.length;i++)
        {
            if(hashedPassword==hashcodes[i])
                return "Success";
        }
        return "Failure";
    }

    private static String decrypt(String encString)
    {
        StringBuilder decString = new StringBuilder();
        for(int i=0;i<encString.length();i++)
        {
            char prevVal = encString.charAt(i) ;
            if(prevVal == ' ')
            {
                decString.append(' ');
                continue;
            }

            char newVal = (char) (prevVal - key);
            if(newVal>'z')
            {
                decString.append((char)(newVal-26));
            }
            else if(newVal<'a')
            {
                decString.append((char)(newVal+26));
            }
            else
            {
                decString.append(newVal);
            }
        }
        return decString.toString();
    }
}
