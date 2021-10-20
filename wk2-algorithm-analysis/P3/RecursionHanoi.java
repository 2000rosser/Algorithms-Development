package P3;

public class RecursionHanoi {
    public static void towersOfHanoi(int n, char source,
                                     char dest, char aux)
    {
        if (n == 1)
        {
            System.out.println("Move disk 1 from rod "+
                    source+" to rod "+dest);
            return;
        }
        towersOfHanoi(n - 1, source, aux, dest);
        System.out.println("Move disk "+ n + " from rod " +
                source +" to rod " + dest );
        towersOfHanoi(n - 1, aux, dest, source);
    }


    public static void  main(String args[])
    {
        int n = 4;
        towersOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
    }

}

