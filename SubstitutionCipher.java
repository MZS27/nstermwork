import java.util.Scanner;

public class SubstitutionCipher
{
    static String originalKey = "abcdefghijklmnopqrstuvwxyz";
    static String newKey;
    public static void main(String[] args)
    {
        Scanner s1 = new Scanner(System.in);

        System.out.print("SUBSTITUTION CIPHER");
        System.out.print("\nEnter string to be encrypted(lowercase): ");
        String userString = s1.nextLine();
        System.out.print("Enter key(example: qwertyuiopasdfghjklzxcvbnm): ");
        newKey = s1.nextLine();

        String encString = encrypt(userString);
        System.out.print("\nEncrypted String: " + encString);

        String decString = decrypt(encString);
        System.out.println("\nDecrypted String: "+ decString);
    }

    public static String encrypt(String userString)
    {
        StringBuilder encString = new StringBuilder();
        for(int i=0;i<userString.length();i++)
        {
            char c = userString.charAt(i);
            if(c == ' ')
            {
                encString.append(' ');
                continue;
            }
            encString.append(newKey.charAt(originalKey.indexOf(c)));
        }
        return encString.toString();
    }

    public static String decrypt(String userString)
    {
        StringBuilder decString = new StringBuilder();
        for(int i=0;i<userString.length();i++)
        {
            char c = userString.charAt(i);
            if(c == ' ')
            {
                decString.append(' ');
                continue;
            }
            decString.append(originalKey.charAt(newKey.indexOf(c)));
        }
        return decString.toString();
    }
}
