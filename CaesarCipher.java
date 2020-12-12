import java.util.Scanner;

public class CaesarCipher
{
    public static void main(String[] args)
    {
        Scanner s1 = new Scanner(System.in);

        System.out.print("CAESAR CIPHER");
        System.out.print("\nEnter string to be encrypted(lowercase): ");
        String userString = s1.nextLine();
        System.out.print("Enter offset value: ");
        int offset = Integer.parseInt(s1.nextLine());

        String encString = encrypt(userString,offset);
        System.out.print("\nEncrypted String: " + encString);

        String decString = decrypt(encString,offset);
        System.out.println("\nDecrypted String: "+ decString);
    }

    public static String encrypt(String originalString, int offset)
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

            char newVal = (char) (prevVal + offset);
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

    public static String decrypt(String encString, int offset)
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

            char newVal = (char) (prevVal - offset);
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
