public class BoundedArrayListTest
{
    public static void main(String args[])
    {
        ConsoleReader cr = new ConsoleReader();
        int k = cr.readInt("Enter an integer : ");
        int l = cr.readInt("Enter a second integer : ");
        BoundedArrayList b = new BoundedArrayList(k);
        try
        {
            for (int i = 0; i < l; i++)
            {
                b.add("test");
            }
            System.out.println("Remplissage termine avec succes");
        }
        catch (BoundedArrayList.BoundedOutreachedException e)
        {
            System.out.println("Echec du remplissage : borne depassee");
        }
    }
}
