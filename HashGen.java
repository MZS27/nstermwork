public class HashGen
{
    private static String[] passwords = {"NS","admin","password","pizza"};
    public static void main(String args[])
    {
        for(int i=0;i<passwords.length;i++)
        {
            System.out.println(passwords[i].hashCode());
        }
    }
}
